<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:variable name="rows" select="//smParamNode[@id='DwBaseinfoRoadowner']/smParamNode[not(@*)]"/>
    <xsl:variable name="pageinfo" select="//smParamNode[@id='DwBaseinfoRoadowner']/smParamNode[@id='pageinfo']"/>
    <respInfo>
      <resultconunt>
        <xsl:value-of select="count($rows)"/>
      </resultconunt>
      <xsl:if test="count($pageinfo) !=0">
        <pageInfo>
          <limit>
            <xsl:value-of select="$pageinfo/smParamNode[@key='limit']/@value"/>
          </limit>
          <page>
            <xsl:value-of select="$pageinfo/smParamNode[@key='page']/@value"/>
          </page>
          <totalcount>
            <xsl:value-of select="$pageinfo/smParamNode[@key='totalcount']/@value"/>
          </totalcount>
          <totalpages>
            <xsl:value-of select="$pageinfo/smParamNode[@key='totalpages']/@value"/>
          </totalpages>
        </pageInfo>
      </xsl:if>
        <xsl:for-each select="$rows">
          <ownerInfo>
            <!--PROVINCE_CODE IS '省份';-->
            <provinceCode>
              <xsl:value-of select="./smParamNode[@key='provinceCode']/@value"/>
            </provinceCode>
            <!--OWNER_ID IS '省级系统经营业户ID';-->
            <ownerId>
              <xsl:value-of select="./smParamNode[@key='ownerId']/@value"/>
            </ownerId>
            <!--OWNER_NAME IS '经营业户名称';-->
            <ownerName>
              <xsl:value-of select="./smParamNode[@key='ownerName']/@value"/>
            </ownerName>
            <!--ORGANIZATION_CODE IS '企业组织机构代码证';-->
            <organizationCode>
              <xsl:value-of select="./smParamNode[@key='organizationCode']/@value"/>
            </organizationCode>
            <!--PARENT_OWNERNAME IS '上级企业名称';-->
            <parentOwnername>
              <xsl:value-of select="./smParamNode[@key='parentOwnername']/@value"/>
            </parentOwnername>
            <!--NATIVE_AREA_CODE IS '经营业户所在地行政区划代码';-->
            <nativeAreaCode>
              <xsl:value-of select="./smParamNode[@key='nativeAreaCode']/@value"/>
            </nativeAreaCode>
            <!--PRINCIPAL_NAME IS '经营业户负责人姓名';-->
            <principalName>
              <xsl:value-of select="./smParamNode[@key='principalName']/@value"/>
            </principalName>
            <!--PRINCIPAL_TELEPHONE IS '经营业户负责人电话号码';-->
            <principalTelephone>
              <xsl:value-of select="./smParamNode[@key='principalTelephone']/@value"/>
            </principalTelephone>
            <!--PRINCIPAL_CELLPHONE IS '经营业户电话号码';-->
            <principalCellphone>
              <xsl:value-of select="./smParamNode[@key='principalCellphone']/@value"/>
            </principalCellphone>
            <!--OPERATING_STATUS IS '经营状态';-->
            <operatingStatus>
              <xsl:value-of select="./smParamNode[@key='operatingStatus']/@value"/>
            </operatingStatus>
            <!-- OPERATING_CODE IS '经营状态代码';-->
            <operatingCode>
              <xsl:value-of select="./smParamNode[@key='operatingCode']/@value"/>
            </operatingCode>
          </ownerInfo>
        </xsl:for-each>
    </respInfo>
  </xsl:template>
</xsl:stylesheet>