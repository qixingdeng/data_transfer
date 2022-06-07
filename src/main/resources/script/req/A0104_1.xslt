<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:variable name="licenseWord" select="//licenseWord[text()]"/>
    <xsl:variable name="licenseCode" select="//licenseCode[text()]"/>
    <xsl:variable name="provinceCode" select="//provinceCode[text()]"/>
    
    <xsl:variable name="limit" select="//limit[text()]"/>
    <xsl:variable name="page" select="//page[text()]"/>
    <xsl:variable name="totalcount" select="//totalcount[text()]"/>
    <xsl:variable name="totalpages" select="//totalpages[text()]"/>

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
      <xsl:if test="$licenseWord!=''">
        <wheres>
          <funcName>andLicenseWordIsNotNull</funcName>
        </wheres>
        <wheres>
          <funcName>andLicenseWordEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$licenseWord"/>
          </paramList>
        </wheres>
      </xsl:if>
      <xsl:if test="$licenseCode != ''">
        <wheres>
          <funcName>andLicenseCodeEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$licenseCode"/>
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