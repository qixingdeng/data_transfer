<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:variable name="transCertificateWord" select="//transCertificateWord[text()]"/>
    <xsl:variable name="transCertificateCode" select="//transCertificateCode[text()]"/>
    <xsl:variable name="provinceCode" select="//provinceCode[text()]"/>
    
    <xsl:variable name="limit" select="//limit[text()]"/>
    <xsl:variable name="page" select="//page[text()]"/>
    <xsl:variable name="totalcount" select="//totalcount[text()]"/>
    <xsl:variable name="totalpages" select="//totalpages[text()]"/>

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
	        <column>mcuId</column>
	      </column>
      <xsl:if test="$transCertificateWord!=''">
        <wheres>
          <funcName>andTransCertificateWordEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$transCertificateWord"/>
          </paramList>
        </wheres>
      </xsl:if>
      <xsl:if test="$transCertificateCode != ''">
        <wheres>
          <funcName>andTransCertificateCodeEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$transCertificateCode"/>
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
      <mappername>DwBaseinfoTransCert</mappername>
      <tablename>dw_baseinfo_trans_cert</tablename>
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