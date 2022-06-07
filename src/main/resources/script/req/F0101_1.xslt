<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xalan="http://xml.apache.org/xalan">
	<xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
	<xsl:strip-space elements="*"/>
	<xsl:template match="/">
		<xsl:param name="caseRegNo" select="caseRegNo"/>
		<selectParamRoot>
			<column>
				<column>punishDate</column>
				<column>punishType</column>
				<column>punishTypeCode</column>
				<column>fineAmount</column>
				<column>roadOwnerName</column>
				<column>licenseCode</column>
				<column>partyName</column>
				<column>certificateCode</column>
				<column>scoring</column>
				<column>processDate</column>
			</column>
			<xsl:if test="$caseRegNo!=''">
				<wheres>
					<funcName>andCaseIdEqualTo</funcName>
					<paramList>
						<xsl:value-of select="$caseRegNo"/>
					</paramList>
				</wheres>
			</xsl:if>
			<mappername>DwInfoInspectionPunish</mappername>
			<tablename>dw_info_inspection_punish</tablename>
		</selectParamRoot>
	</xsl:template>
</xsl:stylesheet>