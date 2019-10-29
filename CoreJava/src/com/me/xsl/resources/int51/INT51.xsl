<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" indent="yes" encoding="UTF-8"/>

<xsl:template match="Order">
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<Order>
 
 <xsl:attribute name="CampaignName"><xsl:value-of select="@CampaignName"/></xsl:attribute> 
 <xsl:attribute name="toEmail"><xsl:value-of select="@CustomerEMailID"/></xsl:attribute> 
 <xsl:attribute name="FirstName"><xsl:value-of select="@CustomerFirstName"/></xsl:attribute> 
 <xsl:attribute name="LastName"><xsl:value-of select="@CustomerLastName"/></xsl:attribute> 
 <xsl:attribute name="OrderId"><xsl:value-of select="@CustomerPONo"/></xsl:attribute>
 <xsl:attribute name="orderOrigineChannel"><xsl:value-of select="@EntryType"/></xsl:attribute>
 <xsl:attribute name="Language"><xsl:value-of select="@Language"/></xsl:attribute>
 <xsl:attribute name="OrderDate"><xsl:value-of select="@OrderDate"/></xsl:attribute>
 <xsl:attribute name="OriginatingCountry"><xsl:value-of select="@OriginatingCountry"/></xsl:attribute>
 <xsl:attribute name="OrganizationCode"><xsl:value-of select="@OrganizationCode"/></xsl:attribute>
 <xsl:attribute name="OrderNo"><xsl:value-of select="@OrderNo"/></xsl:attribute>
  <Promotions>
  <Promotion>
     <xsl:attribute name="PromotionId"><xsl:value-of select="@OrderNo"/></xsl:attribute>
	 <xsl:attribute name="PromotionCodeEndDate"><xsl:value-of select="@OrderDate"/></xsl:attribute>
   </Promotion> 
  </Promotions>
</Order>
   </soapenv:Body>
</soapenv:Envelope>
</xsl:template>
</xsl:stylesheet>