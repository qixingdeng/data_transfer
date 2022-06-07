<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="text" version="1.0" encoding="utf-8" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template match="/">
    <xsl:variable name="vin" select="//smParamNode[@key = 'vin']/@value"/>
    <xsl:variable name="color" select="//smParamNode[@key = 'color']/@value"/>
    <xsl:text><xsl:value-of select="concat($vin,'_',$color)"/></xsl:text> <xsl:value-of select="concat($vin,'_',$color)"/>
  </xsl:template>
</xsl:stylesheet>