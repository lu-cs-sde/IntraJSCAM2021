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

/* $Id: FromTableColumnFunction.java 592103 2007-11-05 17:42:37Z vhennebert $ */

package org.apache.fop.fo.expr;

import java.util.List;
import org.apache.fop.fo.Constants;
import org.apache.fop.fo.FObj;
import org.apache.fop.fo.FOPropertyMapping;
import org.apache.fop.fo.flow.table.ColumnNumberManager;
import org.apache.fop.fo.flow.table.Table;
import org.apache.fop.fo.flow.table.TableCell;
import org.apache.fop.fo.flow.table.TableColumn;
import org.apache.fop.fo.flow.table.TableFObj;
import org.apache.fop.fo.properties.Property;

/**
 * Class modelling the from-table-column Property Value function. See Sec.
 * 5.10.4 of the XSL-FO spec.
 */
public class FromTableColumnFunction extends FunctionBase {

    /**
     * @return 1 (maximum arguments for the from-table-column function)
     */
    public int nbArgs() {
        return 1;
    }

    /**
     * @return true (allow padding of arglist with property name)
     */
    public boolean padArgsWithPropertyName() {
        return true;
    }

    /**
     *
     * @param args array of arguments, which should either be empty, or the
     * first of which should contain an NCName corresponding to a property name
     * @param pInfo PropertyInfo object to be evaluated
     * @return the Property corresponding to the property name specified, or, if
     * none, for the property for which the expression is being evaluated
     * @throws PropertyException for incorrect arguments, and (for now) in all
     * cases, because this function is not implemented
     */
    public Property eval(Property[] args,
                         PropertyInfo pInfo) throws PropertyException {

        FObj fo = pInfo.getPropertyList().getFObj();

        /* obtain property Id for the property for which the function is being
         * evaluated */
        int propId = 0;
        if (args.length == 0) {
            propId = pInfo.getPropertyMaker().getPropId();
        } else {
            String propName = args[0].getString();
            propId = FOPropertyMapping.getPropertyId(propName);
        }

        /* make sure we have a correct property id ... */
        if (propId != -1) {
            /* obtain column number for which the function is being evaluated: */
            int columnNumber = -1;
            int span = 0;
            if (fo.getNameId() != Constants.FO_TABLE_CELL) {
                // climb up to the nearest cell
                do {
                    fo = (FObj) fo.getParent();
                } while (fo.getNameId() != Constants.FO_TABLE_CELL
                          && fo.getNameId() != Constants.FO_PAGE_SEQUENCE);
                if (fo.getNameId() == Constants.FO_TABLE_CELL) {
                    //column-number is available on the cell
                    columnNumber = ((TableCell) fo).getColumnNumber();
                    span = ((TableCell) fo).getNumberColumnsSpanned();
                } else {
                    //means no table-cell was found...
                    throw new PropertyException("from-table-column() may only be used on "
                            + "fo:table-cell or its descendants.");
                }
            } else {
                //column-number is only accurately available through the propertyList
                columnNumber = pInfo.getPropertyList().get(Constants.PR_COLUMN_NUMBER)
                                    .getNumeric().getValue();
                span = pInfo.getPropertyList().get(Constants.PR_NUMBER_COLUMNS_SPANNED)
                                    .getNumeric().getValue();
            }

            /* return the property from the column */
            Table t = ((TableFObj) fo).getTable();
            List cols = t.getColumns();
            ColumnNumberManager columnIndexManager = t.getColumnNumberManager();
            if (cols == null) {
                //no columns defined => no match: return default value
                return pInfo.getPropertyList().get(propId, false, true);
            } else {
                if (columnIndexManager.isColumnNumberUsed(columnNumber)) {
                    //easiest case: exact match
                    return ((TableColumn) cols.get(columnNumber - 1)).getProperty(propId);
                } else {
                    //no exact match: try all spans...
                    while (--span > 0 && !columnIndexManager.isColumnNumberUsed(++columnNumber)) {
                        //nop: just increment/decrement
                    }
                    if (columnIndexManager.isColumnNumberUsed(columnNumber)) {
                        return ((TableColumn) cols.get(columnNumber - 1)).getProperty(propId);
                    } else {
                        //no match: return default value
                        return pInfo.getPropertyList().get(propId, false, true);
                    }
                }
            }
        } else {
            throw new PropertyException("Incorrect parameter to from-table-column() function");
        }
    }

}
