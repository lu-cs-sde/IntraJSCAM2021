/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id: TableAndCaption.java 669118 2008-06-18 09:02:45Z jeremias $ */

package org.apache.fop.fo.flow.table;

// XML
import org.xml.sax.Locator;

import org.apache.fop.apps.FOPException;
import org.apache.fop.fo.FONode;
import org.apache.fop.fo.FObj;
import org.apache.fop.fo.ValidationException;

/**
 * Class modelling the fo:table-and-caption property.
 * @todo needs implementation
 */
public class TableAndCaption extends FObj /*implements BreakPropertySet*/ {
    // The value of properties relevant for fo:table-and-caption.
    // Unused but valid items, commented out for performance:
    //     private CommonAccessibility commonAccessibility;
    //     private CommonAural commonAural;
    //     private CommonBorderPaddingBackground commonBorderPaddingBackground;
    //     private CommonMarginBlock commonMarginBlock;
    //     private CommonRelativePosition commonRelativePosition;
    //     private int breakAfter;
    //     private int breakBefore;
    //     private int captionSide;
    //     private int intrusionDisplace;
    //     private KeepProperty keepTogether;
    //     private KeepProperty keepWithNext;
    //     private KeepProperty keepWithPrevious;
    //     private int textAlign;
    // End of property values
    
    static boolean notImplementedWarningGiven = false;

    /** used for FO validation */
    private boolean tableCaptionFound = false;
    private boolean tableFound = false;

    /**
     * @param parent FONode that is the parent of this object
     */
    public TableAndCaption(FONode parent) {
        super(parent);

        if (!notImplementedWarningGiven) {
            log.warn("fo:table-and-caption is not yet implemented.");
            notImplementedWarningGiven = true;
        }
    }

    /**
     * Make sure content model satisfied, if so then tell the
     * FOEventHandler that we are at the end of the flow.
     * {@inheritDoc}
     */
    protected void endOfNode() throws FOPException {
        if (!tableFound) {
            missingChildElementError("marker* table-caption? table");
        }
    }

    /**
     * {@inheritDoc}
     * XSL Content Model: marker* table-caption? table
     */
    protected void validateChildNode(Locator loc, String nsURI, String localName) 
        throws ValidationException {

        if (FO_URI.equals(nsURI) && localName.equals("marker")) {
            if (tableCaptionFound) {
                nodesOutOfOrderError(loc, "fo:marker", "fo:table-caption");
            } else if (tableFound) {
                nodesOutOfOrderError(loc, "fo:marker", "fo:table");
            }
        } else if (FO_URI.equals(nsURI) && localName.equals("table-caption")) {
            if (tableCaptionFound) {
                tooManyNodesError(loc, "fo:table-caption");
            } else if (tableFound) {
                nodesOutOfOrderError(loc, "fo:table-caption", "fo:table");
            } else {
                tableCaptionFound = true;
            }
        } else if (FO_URI.equals(nsURI) && localName.equals("table")) {
            if (tableFound) {
                tooManyNodesError(loc, "fo:table");
            } else {
                tableFound = true;
            }
        } else {
            invalidChildError(loc, nsURI, localName);
        }
    }

    /** {@inheritDoc} */
    public String getLocalName() {
        return "table-and-caption";
    }

    /**
     * {@inheritDoc}
     */
    public int getNameId() {
        return FO_TABLE_AND_CAPTION;
    }
}

