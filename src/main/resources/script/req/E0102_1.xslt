<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:param name="staffId" select="staffId"/>
    <selectParamRoot>
     <column>
        <column>provinceCode</column>
        <column>staffId</column>
        <column>staffName</column>
        <column>sex</column>
        <column>idType</column>
        <column>idCard</column>
        <column>nation</column>
        <column>telephone</column>
        <column>address</column>
        <column>culturalLevel</column>
        <column>technicalTitle</column>
        <column>staffStatus</column>
        <column>staffStatusCode</column>
      </column>
      <xsl:if test="$staffId!=''">
        <wheres>
          <funcName>andStaffIdEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$staffId"/>
          </paramList>
        </wheres>
      </xsl:if>
      <mappername>DwBaseinfoStaff</mappername>
      <tablename>Dw_Baseinfo_Staff</tablename>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>