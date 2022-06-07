<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:param name="idCard" select="idCard"/>
    <selectParamRoot>
     <column>
        <column>ownerId</column>
        <column>ownerName</column>
        <column>archiveDate</column>
      </column>
      <xsl:if test="$idCard!=''">
        <wheres>
          <funcName>andIdCardEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$idCard"/>
          </paramList>
        </wheres>
      </xsl:if>
      <mappername>DwInfoStaffUnit</mappername>
      <tablename>Dw_Info_Staff_Unit</tablename>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>