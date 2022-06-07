<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:param name="caseId" select="caseId"/>
    <selectParamRoot>
     <column>
        <column>closingReason</column>
        <column>implementation</column>
        <column>closingDate</column>
      </column>
      <xsl:if test="$caseId!=''">
        <wheres>
          <funcName>andCaseIdEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$caseId"/>
          </paramList>
        </wheres>
      </xsl:if>
      <mappername>DwInfoInspectionClose</mappername>
      <tablename>dw_info_inspection_close</tablename>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>