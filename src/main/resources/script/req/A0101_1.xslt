<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:param name="ownerName" select="ownerName"/>
    <xsl:param name="ownerId" select="ownerId"/>
    <xsl:param name="provinceCode" select="provinceCode"/>
    <selectParamRoot>
      <column>
        <column>provinceCode</column>
        <column>ownerId</column>
        <column>ownerName</column>
        <column>businessScopeCode</column>
        <column>businessScopeDesc</column>
        <column>licenseWord</column>
        <column>licenseCode</column>
        <column>validBeginDate</column>
        <column>expireDate</column>
        <column>licenseIssueOrgan</column>
        <column>licenseIssueDate</column>
        <column>address</column>
        <column>operatingStatus</column>
        <column>certificateState</column>
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
      <xsl:if test="$ownerId != ''">
        <wheres>
          <funcName>andOwnerIdEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$ownerId"/>
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
      <mappername>DwInfoBusinessLicense</mappername>
      <tablename>DW_INFO_BUSINESS_LICENSE</tablename>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>