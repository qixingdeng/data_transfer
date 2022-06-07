<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:param name="vehicleNo" select="vehicleNo"/>
    <xsl:param name="mcuId" select="mcuId"/>
    <selectParamRoot>
     <column>
        <column>transCertificateWord</column>
        <column>transCertificateCode</column>
        <column>transCertificateGrantOrgan</column>
        <column>certificateBeginDate</column>
        <column>certificateExpireDate</column>
        <column>businessScopeCode</column>
        <column>businessScopeDesc</column>
        <column>certificateType</column>
      </column>
      <xsl:if test="$vehicleNo!=''">
        <wheres>
          <funcName>andVehicleNoEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$vehicleNo"/>
          </paramList>
        </wheres>
      </xsl:if>
       <xsl:if test="$mcuId!=''">
        <wheres>
          <funcName>andMcuIdEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$mcuId"/>
          </paramList>
        </wheres>
      </xsl:if>
      <mappername>DwBaseinfoTransCert</mappername>
      <tablename>dw_baseinfo_trans_cert</tablename>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>