<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xalan="http://xml.apache.org/xalan">
	<xsl:output method="xml" version="1.0" encoding="gb2312"
		indent="no" />
	<xsl:strip-space elements="*" />
	<xsl:template match="/">
		<xsl:variable name="rows"
			select="//smParamNode[@id='DwBaseinfoManageOrgan']/smParamNode[not(@*)]" />
		<xsl:variable name="pageinfo" select="//smParamNode[@id='DwBaseinfoManageOrgan']/smParamNode[@id='pageinfo']"/>
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
				<organInfo>
					<provinceCode>
						<xsl:value-of select="./smParamNode[@key='provinceCode']/@value" />
					</provinceCode>
					<manageOrganName>
						<xsl:value-of select="./smParamNode[@key='manageOrganName']/@value" />
					</manageOrganName>
					<manageOrganCode>
						<xsl:value-of select="./smParamNode[@key='manageOrganCode']/@value" />
					</manageOrganCode>
					<address>
						<xsl:value-of select="./smParamNode[@key='address']/@value" />
					</address>
					<zone>
						<xsl:value-of select="./smParamNode[@key='zone']/@value" />
					</zone>
					<telephone>
						<xsl:value-of select="./smParamNode[@key='telephone']/@value" />
					</telephone>
					<fax>
						<xsl:value-of select="./smParamNode[@key='fax']/@value" />
					</fax>
					<emergencyCall>
						<xsl:value-of select="./smParamNode[@key='emergencyCall']/@value" />
					</emergencyCall>
					
					<complaintsCall>
						<xsl:value-of select="./smParamNode[@key='complaintsCall']/@value" />
					</complaintsCall>
					<principal>
						<xsl:value-of select="./smParamNode[@key='principal']/@value" />
					</principal>
				</organInfo>
			</xsl:for-each>
		</respInfo>
	</xsl:template>
</xsl:stylesheet>