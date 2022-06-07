<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:variable name="ownerName" select="//ownerName[text()]"/>
    <xsl:variable name="provinceCode" select="//provinceCode[text()]"/>
    <xsl:variable name="page" select="//page[text()]"/>

    <selectParamRoot>
      <column>
        <column>provinceCode</column>
        <column>ownerId</column>
        <column>ownerName</column>
        <column>organizationCode</column>
        <column>parentOwnername</column>
        <column>nativeAreaCode</column>
        <column>principalName</column>
        <column>principalTelephone</column>
        <column>principalCellphone</column>
        <column>operatingStatus</column>
        <column>operatingCode</column>
      </column>
      <xsl:if test="$ownerName!=''">
        <wheres>
          <funcName>andOwnerNameIsNotNull</funcName>
        </wheres>
        <wheres>
          <funcName>andOwnerNameEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$ownerName"/>
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
      <mappername>DwBaseinfoRoadowner</mappername>
      <tablename>DW_BASEINFO_ROADOWNER</tablename>
      <pageInfo>
        <xsl:if test="$page!=''">
          <page>
            <xsl:value-of select="$page"/>
          </page>
        </xsl:if>
      </pageInfo>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>