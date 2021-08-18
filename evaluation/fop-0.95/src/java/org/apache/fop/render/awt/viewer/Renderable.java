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

/* $Id: Renderable.java 426576 2006-07-28 15:44:37Z jeremias $ */

package org.apache.fop.render.awt.viewer;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;

/**
 * The interface is used by the AWT preview dialog to reload a document.
 */
public interface Renderable {

    /**
     * Renders the pre-setup document.
     * @param userAgent the user agent
     * @param outputFormat the output format to generate (MIME type, see MimeConstants)
     * @exception FOPException if the FO processing fails
     */
    void renderTo(FOUserAgent userAgent, String outputFormat)
            throws FOPException;
    
}
