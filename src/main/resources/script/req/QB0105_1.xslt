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
    <xsl:param name="plateColor" select="plateColor"/>
    <xsl:param name="provinceCode" select="provinceCode"/>
    <selectParamRoot>
     <column>
        <column>checkYear</column>
        <column>checkState</column>
        <column>checkDate</column>
        <column>expireDate</column>
        <column>nextDate</column>
      </column>
      <xsl:if test="$vehicleNo!=''">
        <wheres>
          <funcName>andVehicleNoEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$vehicleNo"/>
          </paramList>
        </wheres>
      </xsl:if>
       <xsl:if test="$plateColor!=''">
        <wheres>
          <funcName>andPlateColorEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$plateColor"/>
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
      <mappername>DwInfoVehicleAnnulcheck</mappername>
      <tablename>DW_INFO_VEHICLE_ANNULCHECK</tablename>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>