<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:param name="mcuId" select="mcuId"/>
    <xsl:param name="provinceCode" select="provinceCode"/>
    <selectParamRoot>
     <column>
        <column>businessType</column>
        <column>provinceLeaveMark</column>
        <column>inAreaCode</column>
        <column>outAreaCode</column>
        <column>noter</column>
        <column>noteDate</column>
      </column>
       <xsl:if test="$mcuId!=''">
        <wheres>
          <funcName>andMcuIdEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$mcuId"/>
          </paramList>
        </wheres>
      </xsl:if>
       <xsl:if test="$provinceCode!=''">
        <wheres>
          <funcName>andProvinceCodeEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$provinceCode"/>
          </paramList>
        </wheres>
      </xsl:if>
      <mappername>DwChangeinfoVehicle</mappername>
      <tablename>DW_CHANGEINFO_VEHICLE</tablename>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>