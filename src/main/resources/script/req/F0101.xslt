<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:variable name="caseRegNo" select="//caseRegNo[text()]"/>
    <xsl:variable name="vehicleNo" select="//vehicleNo[text()]"/>
    <xsl:variable name="certificateCode" select="//certificateCode[text()]"/>
    <xsl:variable name="roadOwnerName" select="//roadOwnerName[text()]"/>
    <xsl:variable name="provinceCode" select="//provinceCode[text()]"/>
    
    <xsl:variable name="limit" select="//limit[text()]"/>
    <xsl:variable name="page" select="//page[text()]"/>
    <xsl:variable name="totalcount" select="//totalcount[text()]"/>
    <xsl:variable name="totalpages" select="//totalpages[text()]"/>

    <selectParamRoot>
       <column>
        <column>provinceCode</column>
        <column>caseRegNo</column>
        <column>caseSource</column>
        <column>caseReason</column>
        <column>caseSourceCode</column>
        <column>casePunishProcess</column>
        <column>punishParty</column>
        <column>partyName</column>
        <column>certificateCode</column>
        <column>roadOwnerName</column>
        <column>licenseCode</column>
        <column>illegalDate</column>
        <column>illegalSites</column>
        <column>illegalType</column>
        <column>illegalTypeCode</column>
        <column>illegalContent</column>
        <column>vehicleNo</column>
        <column>plateColorId</column>
        <column>vehicleNative</column>
        <column>registerDate</column>
        <column>processDate</column>
      </column>
      <xsl:if test="$caseRegNo!=''">
        <wheres>
          <funcName>andCaseRegNoEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$caseRegNo"/>
          </paramList>
        </wheres>
      </xsl:if>
      <xsl:if test="$vehicleNo != ''">
        <wheres>
          <funcName>andVehicleNoEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$vehicleNo"/>
          </paramList>
        </wheres>
      </xsl:if>
      <xsl:if test="$certificateCode!=''">
        <wheres>
          <funcName>andCertificateCodeEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$certificateCode"/>
          </paramList>
        </wheres>
      </xsl:if>
      <xsl:if test="$roadOwnerName!=''">
        <wheres>
          <funcName>andRoadOwnerNameEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$roadOwnerName"/>
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
      <mappername>DwInfoInspectionFile</mappername>
      <tablename>Dw_Info_Inspection_File</tablename>
      <pageInfo>
        <xsl:if test="$limit!=''">
          <limit>
            <xsl:value-of select="$limit"/>
          </limit>
        </xsl:if>
        <xsl:if test="$page!=''">
          <page>
            <xsl:value-of select="$page"/>
          </page>
        </xsl:if>
        <xsl:if test="$totalcount!=''">
          <totalcount>
            <xsl:value-of select="$totalcount"/>
          </totalcount>
        </xsl:if>
        <xsl:if test="$totalpages!=''">
          <totalpages>
            <xsl:value-of select="$totalpages"/>
          </totalpages>
        </xsl:if>
      </pageInfo>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>