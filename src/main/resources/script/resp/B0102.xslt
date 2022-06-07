<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xalan="http://xml.apache.org/xalan">
	<xsl:output method="xml" version="1.0" encoding="gb2312"
		indent="no" />
	<xsl:strip-space elements="*" />
	<xsl:template match="/">
		<xsl:variable name="rows"
			select="//smParamNode[@id='DwBaseinfoTransCert']/smParamNode[not(@*)]" />
		<xsl:variable name="pageinfo" select="//smParamNode[@id='DwBaseinfoTransCert']/smParamNode[@id='pageinfo']"/>
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
				<vehicleInfo>
					<provinceCode>
						<xsl:value-of select=".//smParamNode[@key='provinceCode']/@value" />
					</provinceCode>
					<ownerId>
						<xsl:value-of select=".//smParamNode[@key='ownerId']/@value" />
					</ownerId>
					<mcuId>
						<xsl:value-of select=".//smParamNode[@key='mcuId']/@value" />
					</mcuId>
					<vehicleNo>
						<xsl:value-of select=".//smParamNode[@key='vehicleNo']/@value" />
					</vehicleNo>
					<plateColor>
						<xsl:value-of select=".//smParamNode[@key='plateColor']/@value" />
					</plateColor>
					<plateColorCode>
						<xsl:value-of select=".//smParamNode[@key='plateColorCode']/@value" />
					</plateColorCode>
					<brand>
						<xsl:value-of select=".//smParamNode[@key='brand']/@value" />
					</brand>
					<model>
						<xsl:value-of select=".//smParamNode[@key='model']/@value" />
					</model>
					<engineNo>
						<xsl:value-of select=".//smParamNode[@key='engineNo']/@value" />
					</engineNo>
					<vin>
						<xsl:value-of select=".//smParamNode[@key='vin']/@value" />
					</vin>
					<vehicleType>
						<xsl:value-of select=".//smParamNode[@key='vehicleType']/@value" />
					</vehicleType>
					<vehicleTypeCode>
						<xsl:value-of select=".//smParamNode[@key='vehicleTypeCode']/@value" />
					</vehicleTypeCode>
					<outFactoryDate>
						<xsl:value-of select=".//smParamNode[@key='outFactoryDate']/@value" />
					</outFactoryDate>
					<fuelType>
						<xsl:value-of select=".//smParamNode[@key='fuelType']/@value" />
					</fuelType>
					<wheelBase>
						<xsl:value-of select=".//smParamNode[@key='wheelBase']/@value" />
					</wheelBase>
					<vehicleLength>
						<xsl:value-of select=".//smParamNode[@key='vehicleLength']/@value" />
					</vehicleLength>
					<vehicleHigh>
						<xsl:value-of select=".//smParamNode[@key='vehicleHigh']/@value" />
					</vehicleHigh>
					<vehicleWidth>
						<xsl:value-of select=".//smParamNode[@key='vehicleWidth']/@value" />
					</vehicleWidth>
					<axlesAmount>
						<xsl:value-of select=".//smParamNode[@key='axlesAmount']/@value" />
					</axlesAmount>
					<tractionTonnage>
						<xsl:value-of select=".//smParamNode[@key='tractionTonnage']/@value" />
					</tractionTonnage>
					<enginePower>
						<xsl:value-of select=".//smParamNode[@key='enginePower']/@value" />
					</enginePower>
					<approveSeat>
						<xsl:value-of select=".//smParamNode[@key='approveSeat']/@value" />
					</approveSeat>
					<approveTon>
						<xsl:value-of select=".//smParamNode[@key='approveTon']/@value" />
					</approveTon>
					<satellitePlatformName>
						<xsl:value-of select=".//smParamNode[@key='satellitePlatformName']/@value" />
					</satellitePlatformName>
					<satellitePlatformCode>
						<xsl:value-of select=".//smParamNode[@key='satellitePlatformCode']/@value" />
					</satellitePlatformCode>
					<gpsTerminalModel>
						<xsl:value-of select=".//smParamNode[@key='gpsTerminalModel']/@value" />
					</gpsTerminalModel>
					<businessState>
						<xsl:value-of select=".//smParamNode[@key='businessState']/@value" />
					</businessState>
					<businessStateCode>
						<xsl:value-of select=".//smParamNode[@key='businessStateCode']/@value" />
					</businessStateCode>
					
					
					<certificateInfo>
						<transCertificateWord>
							<xsl:value-of select="./smParamNode[@key='transCertificateWord']/@value" />
						</transCertificateWord>
						<transCertificateCode>
							<xsl:value-of select="./smParamNode[@key='transCertificateCode']/@value" />
						</transCertificateCode>
						<transCertificateGrantOrgan>
							<xsl:value-of select="./smParamNode[@key='transCertificateGrantOrgan']/@value" />
						</transCertificateGrantOrgan>
						<certificateBeginDate>
							<xsl:value-of select="./smParamNode[@key='certificateBeginDate']/@value" />
						</certificateBeginDate>
						<certificateExpireDate>
							<xsl:value-of select="./smParamNode[@key='certificateExpireDate']/@value" />
						</certificateExpireDate>
						<businessScopeCode>
							<xsl:value-of select="./smParamNode[@key='businessScopeCode']/@value" />
						</businessScopeCode>
						<businessScopeDesc>
							<xsl:value-of select="./smParamNode[@key='businessScopeDesc']/@value" />
						</businessScopeDesc>
						<certificateType>
							<xsl:value-of select="./smParamNode[@key='certificateType']/@value" />
						</certificateType>
					</certificateInfo>
				</vehicleInfo>
			</xsl:for-each>
		</respInfo>
	</xsl:template>
</xsl:stylesheet>