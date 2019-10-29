<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" indent="yes" encoding="UTF-8"/>

<xsl:template match="Order">
<xsl:element name="lookupAvailabilityResponse">
  <xsl:element name="CustomerFirstName">
    <xsl:value-of select="@CustomerFirstName"/>
  </xsl:element>
  
  <xsl:element name="CustomerEmailID">  
    <xsl:value-of select="CustomerEMailID"/>
   </xsl:element>	
</xsl:element>

</xsl:template>
</xsl:stylesheet>