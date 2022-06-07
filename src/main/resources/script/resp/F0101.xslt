<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="gb2312" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:variable name="rows" select="//smParamNode[@id='0000']/*"/>
    <respInfo>
      <resultconunt>
        <xsl:value-of select="count($rows)"/>
      </resultconunt>
        <xsl:for-each select="$rows">
          <caseInfo>
            <provinceCode>
              <xsl:value-of select="./smParamNode[@key='provinceCode']/@value"/>
            </provinceCode>
            <caseRegNo>
              <xsl:value-of select="./smParamNode[@key='caseRegNo']/@value"/>
            </caseRegNo>
            <caseSource>
              <xsl:value-of select="./smParamNode[@key='caseSource']/@value"/>
            </caseSource>
            <caseReason>
              <xsl:value-of select="./smParamNode[@key='caseReason']/@value"/>
            </caseReason>
            <caseSourceCode>
              <xsl:value-of select="./smParamNode[@key='caseSourceCode']/@value"/>
            </caseSourceCode>
            <casePunishProcess>
              <xsl:value-of select="./smParamNode[@key='casePunishProcess']/@value"/>
            </casePunishProcess>
            <punishParty>
              <xsl:value-of select="./smParamNode[@key='punishParty']/@value"/>
            </punishParty>
            <partyName>
              <xsl:value-of select="./smParamNode[@key='partyName']/@value"/>
            </partyName>
            <certificateCode>
              <xsl:value-of select="./smParamNode[@key='certificateCode']/@value"/>
            </certificateCode>
            <roadOwnerName>
              <xsl:value-of select="./smParamNode[@key='roadOwnerName']/@value"/>
            </roadOwnerName>
            <licenseCode>
              <xsl:value-of select="./smParamNode[@key='licenseCode']/@value"/>
            </licenseCode>
            <illegalDate>
              <xsl:value-of select="./smParamNode[@key='illegalDate']/@value"/>
            </illegalDate>
            <illegalSites>
              <xsl:value-of select="./smParamNode[@key='illegalSites']/@value"/>
            </illegalSites>
            <illegalType>
              <xsl:value-of select="./smParamNode[@key='illegalType']/@value"/>
            </illegalType>
            <illegalTypeCode>
              <xsl:value-of select="./smParamNode[@key='illegalTypeCode']/@value"/>
            </illegalTypeCode>
            <illegalContent>
              <xsl:value-of select="./smParamNode[@key='illegalContent']/@value"/>
            </illegalContent>
            <vehicleNo>
              <xsl:value-of select="./smParamNode[@key='vehicleNo']/@value"/>
            </vehicleNo>
            <plateColorId>
              <xsl:value-of select="./smParamNode[@key='plateColorId']/@value"/>
            </plateColorId>
            <vehicleNative>
              <xsl:value-of select="./smParamNode[@key='vehicleNative']/@value"/>
            </vehicleNative>
            <registerDate>
              <xsl:value-of select="./smParamNode[@key='registerDate']/@value"/>
            </registerDate>
            <punishInfo>
            <punishDate>
              <xsl:value-of select="./smParamNode[@key='punishDate']/@value"/>
            </punishDate>
            <punishType>
              <xsl:value-of select="./smParamNode[@key='punishType']/@value"/>
            </punishType>
            <punishTypeCode>
              <xsl:value-of select="./smParamNode[@key='punishTypeCode']/@value"/>
            </punishTypeCode>
            </punishInfo>
            <closingInfo>
            <fineAmount>
              <xsl:value-of select="./smParamNode[@key='fineAmount']/@value"/>
            </fineAmount>
            <scoring>
              <xsl:value-of select="./smParamNode[@key='scoring']/@value"/>
            </scoring>
            <closingReason>
              <xsl:value-of select="./smParamNode[@key='closingReason']/@value"/>
            </closingReason>
            <implementation>
              <xsl:value-of select="./smParamNode[@key='implementation']/@value"/>
            </implementation>
            <closingDate>
              <xsl:value-of select="./smParamNode[@key='closingDate']/@value"/>
            </closingDate>
            <closingInfo>
          </caseInfo>
        </xsl:for-each>
    </respInfo>
  </xsl:template>
</xsl:stylesheet>