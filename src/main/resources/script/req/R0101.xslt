<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:xs="http://www.w3.org/2001/XMLSchema"
   xmlns:fn="http://www.w3.org/2005/xpath-functions"
   xmlns:xalan="http://xml.apache.org/xalan">
  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="no"/>
  <xsl:strip-space elements="*"/>
  <xsl:template name="GetNode">
    <xsl:param name="node"/>
    <xsl:variable name="subnode" select="$node/*"></xsl:variable>
    <xsl:if  test="count($subnode) >0">
      <smParamNode>
        <xsl:choose>
          <xsl:when test="@class">
            <xsl:attribute name="id">
              <xsl:value-of select="@class"/>
            </xsl:attribute>
          </xsl:when>
          <xsl:otherwise>
            <xsl:attribute name="id">
              <xsl:value-of select="name($node)"/>
            </xsl:attribute>
          </xsl:otherwise>
        </xsl:choose>
        <xsl:for-each select="$subnode">
          <xsl:if test=" count(./*) = 0">
            <smParamNode>
              <xsl:attribute name="key">
                <xsl:value-of select="name()"/>
              </xsl:attribute>
              <xsl:attribute name="value">
                <xsl:value-of select="text()"/>
              </xsl:attribute>
            </smParamNode>
          </xsl:if>
        </xsl:for-each>
      </smParamNode>
    </xsl:if>
  </xsl:template>
  <xsl:template name="GetNodeOfRecursive">
    <xsl:param name="node"/>
    <xsl:call-template name="GetNode">
      <xsl:with-param name="node" select="$node" />
    </xsl:call-template>
      <xsl:for-each select="$node/*">
        <xsl:call-template name="GetNodeOfRecursive">
          <xsl:with-param name="node" select="." />
        </xsl:call-template>
      </xsl:for-each>
  </xsl:template>
  <xsl:template match="/">
    <roadWayServiceRoot>
      <smParamNode id="All">
        <xsl:call-template name="GetNodeOfRecursive">
          <xsl:with-param name="node" select="node()" />
        </xsl:call-template>
      </smParamNode>
    </roadWayServiceRoot>
  </xsl:template>
</xsl:stylesheet>