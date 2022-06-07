<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xalan="http://xml.apache.org/xalan">
	<xsl:output method="xml" version="1.0" encoding="gb2312"
		indent="no" />
	<xsl:strip-space elements="*" />
	<xsl:template match="/">
		<xsl:variable name="rows"
			select="//smParamNode[@id='DwBaseinfoStaffCert']/smParamNode[not(@*)]" />
		<xsl:variable name="pageinfo" select="//smParamNode[@id='DwBaseinfoStaffCert']/smParamNode[@id='pageinfo']"/>
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
				<staffInfo>
					<provinceCode>
						<xsl:value-of select=".//smParamNode[@key='provinceCode']/@value" />
					</provinceCode>
					<staffId>
						<xsl:value-of select=".//smParamNode[@key='staffId']/@value" />
					</staffId>
					<staffName>
						<xsl:value-of select=".//smParamNode[@key='staffName']/@value" />
					</staffName>
					<sex>
						<xsl:value-of select=".//smParamNode[@key='sex']/@value" />
					</sex>
					<idType>
						<xsl:value-of select=".//smParamNode[@key='idType']/@value" />
					</idType>
					<idCard>
						<xsl:value-of select=".//smParamNode[@key='idCard']/@value" />
					</idCard>
					<nation>
						<xsl:value-of select=".//smParamNode[@key='nation']/@value" />
					</nation>
					<telephone>
						<xsl:value-of select=".//smParamNode[@key='telephone']/@value" />
					</telephone>
					<address>
						<xsl:value-of select=".//smParamNode[@key='address']/@value" />
					</address>
					<culturalLevel>
						<xsl:value-of select=".//smParamNode[@key='culturalLevel']/@value" />
					</culturalLevel>
					<technicalTitle>
						<xsl:value-of select=".//smParamNode[@key='technicalTitle']/@value" />
					</technicalTitle>
					<staffStatus>
						<xsl:value-of select=".//smParamNode[@key='staffStatus']/@value" />
					</staffStatus>
					<staffStatusCode>
						<xsl:value-of select=".//smParamNode[@key='staffStatusCode']/@value" />
					</staffStatusCode>
					
					<certificateInfo>
						<workTypeCode>
							<xsl:value-of select="./smParamNode[@key='workTypeCode']/@value" />
						</workTypeCode>
						<certificateCode>
							<xsl:value-of select="./smParamNode[@key='certificateCode']/@value" />
						</certificateCode>
						<certificateFirstIssueDate>
							<xsl:value-of select="./smParamNode[@key='certificateFirstIssueDate']/@value" />
						</certificateFirstIssueDate>
						<certificateIssueDate>
							<xsl:value-of select="./smParamNode[@key='certificateIssueDate']/@value" />
						</certificateIssueDate>
						<certificateExpireDate>
							<xsl:value-of select="./smParamNode[@key='certificateExpireDate']/@value" />
						</certificateExpireDate>
						<issueOrgan>
							<xsl:value-of select="./smParamNode[@key='issueOrgan']/@value" />
						</issueOrgan>
						<certificateState>
							<xsl:value-of select="./smParamNode[@key='certificateState']/@value" />
						</certificateState>
						<certificateType>
							<xsl:value-of select="./smParamNode[@key='certificateType']/@value" />
						</certificateType>
						<icCardCertificateCodeic>
							<xsl:value-of select="./smParamNode[@key='icCardCertificateCodeic']/@value" />
						</icCardCertificateCodeic>
					</certificateInfo>
					
					<ownerInfo>
						<ownerId>
							<xsl:value-of select=".//smParamNode[@key='ownerId']/@value" />
						</ownerId>
						<ownerName>
							<xsl:value-of select=".//smParamNode[@key='ownerName']/@value" />
						</ownerName>
						<archiveDate>
							<xsl:value-of select=".//smParamNode[@key='archiveDate']/@value" />
						</archiveDate>
					</ownerInfo>
				</staffInfo>
			</xsl:for-each>
		</respInfo>
	</xsl:template>
</xsl:stylesheet>