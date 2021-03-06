<?xml version="1.0"?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<!-- $Id: known-issues2document.xsl 493717 2007-01-07 13:19:45Z spepping $ -->
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">

  <xsl:template match="known-issues">
   <document>
    <header>
     <title>Known Issues</title>
    </header>
    <body>
      <xsl:choose>
        <xsl:when test="count(known-issue) &gt; 0">
          <ul>
            <xsl:apply-templates select="known-issue"/>
          </ul>
        </xsl:when>
        <xsl:otherwise>
          <p>Currently, there are no known issues to list here!</p>
        </xsl:otherwise>
      </xsl:choose>
    </body>
   </document>  
  </xsl:template>

  <xsl:template match="known-issue">
    <li>
      <xsl:apply-templates/>
    </li>
  </xsl:template>
  
</xsl:stylesheet>
