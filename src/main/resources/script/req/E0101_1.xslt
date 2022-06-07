<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:param name="staffId" select="staffId"/>
    <selectParamRoot>
     <column>
        <column>workTypeCode</column>
        <column>certificateCode</column>
        <column>certificateFirstIssueDate</column>
        <column>certificateIssueDate</column>
        <column>certificateExpireDate</column>
        <column>issueOrgan</column>
        <column>certificateState</column>
        <column>certificateType</column>
        <column>icCardCertificateCodeic</column>
      </column>
      <xsl:if test="$staffId!=''">
        <wheres>
          <funcName>andStaffIdEqualTo</funcName>
          <paramList>
            <xsl:value-of select="$staffId"/>
          </paramList>
        </wheres>
      </xsl:if>
      <mappername>DwBaseinfoStaffCert</mappername>
      <tablename>dw_baseinfo_staff_cert</tablename>
    </selectParamRoot>
  </xsl:template>
</xsl:stylesheet>