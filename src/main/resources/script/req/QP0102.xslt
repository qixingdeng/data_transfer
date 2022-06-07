<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:variable name="metadataQueryType" select="//metadataQueryType[text()]"/>
    
    <xsl:variable name="limit" select="//limit[text()]"/>
    <xsl:variable name="page" select="//page[text()]"/>
    <xsl:variable name="totalcount" select="//totalcount[text()]"/>
    <xsl:variable name="totalpages" select="//totalpages[text()]"/>

    <selectParamRoot>
       <column>
        <column>metadataCode</column>
        <column>metadataName</column>
        <column>typeCode</column>
      </column>
      <xsl:if test="$metadataQueryType!=''">
        <wheres>
          <funcName>andMetadataCodeEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$metadataQueryType"/>
          </paramList>
        </wheres>
      </xsl:if>
      <mappername>SmParamCatalog</mappername>
      <tablename>SM_PARAM_CATALOG</tablename>
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