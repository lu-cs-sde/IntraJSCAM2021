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

/* $Id: DataURIResolver.java 627367 2008-02-13 12:03:30Z maxberger $ */

package org.apache.fop.util;

import java.io.ByteArrayInputStream;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

// base64 support for "data" urls
import org.apache.xmlgraphics.util.io.Base64DecodeStream;

/**
 * Resolves data URLs (described in RFC 2397) returning its data as a StreamSource.
 * 
 * @see javax.xml.transform.URIResolver
 * @see <a href="http://www.ietf.org/rfc/rfc2397">RFC 2397</a>
 */
public class DataURIResolver implements URIResolver {

    /**
     * {@inheritDoc}
     */
    public Source resolve(String href, String base) throws TransformerException {
        if (href.startsWith("data:")) {
            return parseDataURI(href);
        } else {
            return null;
        }
    }

    /**
     * Parses inline data URIs as generated by MS Word's XML export and FO
     * stylesheet.
     * 
     * @see <a href="http://www.ietf.org/rfc/rfc2397">RFC 2397</a>
     */
    private Source parseDataURI(String href) {
        int commaPos = href.indexOf(',');
        // header is of the form data:[<mediatype>][;base64]
        String header = href.substring(0, commaPos);
        String data = href.substring(commaPos + 1);
        if (header.endsWith(";base64")) {
            byte[] bytes = data.getBytes();
            ByteArrayInputStream encodedStream = new ByteArrayInputStream(bytes);
            Base64DecodeStream decodedStream = new Base64DecodeStream(
                    encodedStream);
            return new StreamSource(decodedStream);
        } else {
            // Note that this is not quite the full story here. But since we are
            // only interested
            // in base64-encoded binary data, the next line will probably never
            // be called.
            //TODO Handle un-escaping of special URL chars like %20
            return new StreamSource(new java.io.StringReader(data));
        }
    }

}
