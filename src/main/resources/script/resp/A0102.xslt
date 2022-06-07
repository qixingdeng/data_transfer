<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xalan="http://xml.apache.org/xalan">
    <xsl:output method="xml" version="1.0" encoding="gb2312"
        indent="no" />
    <xsl:strip-space elements="*" />
    <xsl:template match="/">
        <xsl:variable name="rows"
            select="//smParamNode[@id='DwInfoBusinessLicense']/smParamNode[not(@*)]" />
        <xsl:variable name="pageinfo" select="//smParamNode[@id='DwInfoBusinessLicense']/smParamNode[@id='pageinfo']"/>
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
                    <provinceCode>
                        <xsl:value-of select="./smParamNode[@key='provinceCode']/@value" />
                    </provinceCode>
                    <ownerId>
                        <xsl:value-of select="./smParamNode[@key='ownerId']/@value" />
                    </ownerId>
                    <ownerName>
                        <xsl:value-of select="./smParamNode[@key='ownerName']/@value" />
                    </ownerName>
                    <organizationCode>
                        <xsl:value-of select="./smParamNode[@key='organizationCode']/@value" />
                    </organizationCode>
                    <parentOwnername>
                        <xsl:value-of select="./smParamNode[@key='parentOwnername']/@value" />
                    </parentOwnername>
                    <nativeAreaCode>
                        <xsl:value-of select="./smParamNode[@key='nativeAreaCode']/@value" />
                    </nativeAreaCode>
                    <principalName>
                        <xsl:value-of select="./smParamNode[@key='principalName']/@value" />
                    </principalName>
                    <principalTelephone>
                        <xsl:value-of select="./smParamNode[@key='principalTelephone']/@value" />
                    </principalTelephone>
                    <principalCellphone>
                        <xsl:value-of select="./smParamNode[@key='principalCellphone']/@value" />
                    </principalCellphone>
                    <operatingStatus>
                        <xsl:value-of select="./smParamNode[@key='operatingStatus']/@value" />
                    </operatingStatus>
                    <operatingCode>
                        <xsl:value-of select="./smParamNode[@key='operatingCode']/@value" />
                    </operatingCode>
                    
                    <certificateInfo>
                        <businessScopeCode>
                            <xsl:value-of select=".//smParamNode[@key='businessScopeCode']/@value" />
                        </businessScopeCode>
                        <businessScopeDesc>
                            <xsl:value-of select=".//smParamNode[@key='businessScopeDesc']/@value" />
                        </businessScopeDesc>
                        <licenseWord>
                            <xsl:value-of select=".//smParamNode[@key='licenseWord']/@value" />
                        </licenseWord>
                        <licenseCode>
                            <xsl:value-of select=".//smParamNode[@key='licenseCode']/@value" />
                        </licenseCode>
                        <validBeginDate>
                            <xsl:value-of select=".//smParamNode[@key='validBeginDate']/@value" />
                        </validBeginDate>
                        <expireDate>
                            <xsl:value-of select=".//smParamNode[@key='expireDate']/@value" />
                        </expireDate>
                        <licenseIssueOrgan>
                            <xsl:value-of select=".//smParamNode[@key='licenseIssueOrgan']/@value" />
                        </licenseIssueOrgan>
                        <licenseIssueDate>
                            <xsl:value-of select=".//smParamNode[@key='licenseIssueDate']/@value" />
                        </licenseIssueDate>
                        <address>
                            <xsl:value-of select=".//smParamNode[@key='address']/@value" />
                        </address>
                        <operatingStatus>
                            <xsl:value-of select=".//smParamNode[@key='operatingStatus']/@value" />
                        </operatingStatus>
                        <certificateState>
                            <xsl:value-of select=".//smParamNode[@key='certificateState']/@value" />
                        </certificateState>
                    </certificateInfo>
                </ownerInfo>
            </xsl:for-each>
        </respInfo>
    </xsl:template>
</xsl:stylesheet>