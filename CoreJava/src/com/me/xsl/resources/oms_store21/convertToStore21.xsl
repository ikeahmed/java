<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:m="http://yantra.com/yantrawebservices" xmlns:apachesoap="http://xml.apache.org/xml-soap" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	
<!--  **************************************************   INT29   *********************************************************** -->	
	
		<xsl:template match="m:lookupAvailabilityResponse/m:return/Response">  <!--  INT29 -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="lookupAvailabilityResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>

        <xsl:element name="AvailableStatus">
			<xsl:value-of select="@AvailableStatus"/>
	 	</xsl:element>

        <xsl:element name="CrossSellSKU">
			<xsl:value-of select="@CrossSellSKU"/>
	 	</xsl:element>

        <xsl:element name="QuantityToSell">
			<xsl:value-of select="@QuantityToSell"/>
	 	</xsl:element>
	 </xsl:element>	
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>


	
<!--  *****************************************  INT29A   ******************************************************************* -->	
<xsl:template match="m:lookupPostalCodeResponse/m:return/Response">  <!--  INT29A -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="lookupPostalCodeResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>

        <xsl:element name="ShipStoreDestination">
			<xsl:value-of select="@ShipStoreDestination"/>
	 	</xsl:element>

        <xsl:element name="ShipStoreMall">
			<xsl:value-of select="@ShipStoreMall"/>
	 	</xsl:element>

        <xsl:element name="ShipStoreAddress">
			<xsl:value-of select="@ShipStoreAddress"/>
	 	</xsl:element>

 
	 		 	 <xsl:element name="City">
			<xsl:value-of select="@City"/>
	 	</xsl:element>
 <xsl:element name="StateID">
			<xsl:value-of select="@StateID"/>
	 	</xsl:element>
	 		 	 <xsl:element name="PostalCode">
			<xsl:value-of select="@PostalCode"/>
	 	</xsl:element>
 <xsl:element name="CountyName">
			<xsl:value-of select="@CountyName"/>
	 	</xsl:element>	 	
	 	
<xsl:element name="Country">
			<xsl:value-of select="@Country"/>
	 	</xsl:element>	 	
	 </xsl:element>
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>
	
<!--  **************************************************   INT29B   *********************************************************** -->	
	
		<xsl:template match="m:modifyShipAddressResponse/m:return/Response">  <!--  INT29B -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="modifyShipAddressResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>

        <xsl:element name="TaxLocationID">
			<xsl:value-of select="@TaxLocationID"/>
	 	</xsl:element>
</xsl:element>
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>	
	
<!--  **************************************************   INT29C   *********************************************************** -->	
	
		<xsl:template match="m:preConfirmOrderResponse/m:return/Response">  <!--  INT29C -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="preConfirmOrderResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>
  </xsl:element>
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>	
	
<!--  **************************************************   INT29D   *********************************************************** -->	
	
		<xsl:template match="m:confirmOrderResponse/m:return/Response">  <!--  INT29D -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="confirmOrderResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>
    </xsl:element>
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>	
	

<!--  **************************************************   INT29E_29G   *********************************************************** -->	
	
		<xsl:template match="m:modifyLineItemResponse/m:return/Response">  <!--  INT29E_29G -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="modifyLineItemResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>

  </xsl:element>
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>	
	
<!--  **************************************************   INT29F   *********************************************************** -->	
	
		<xsl:template match="m:cancelOrderResponse/m:return/Response">  <!--  INT29F -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="cancelOrderResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>

  </xsl:element>
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>	
	
<!--  **************************************************   INT43   *********************************************************** -->	
	
		<xsl:template match="m:RefundInitiationRequestResponse/m:return/Response">  <!--  INT43 -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="RefundInitiationRequestResponse" > 

    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>

        <xsl:element name="Unit_Price">
			<xsl:value-of select="@UnitPrice"/>
	 	</xsl:element>
	 	
     <xsl:element name="Unit_Tax_1">
			<xsl:value-of select="@Tax1"/>
	 	</xsl:element>
	 	
     <xsl:element name="Unit_Tax_2">
			<xsl:value-of select="@Tax2"/>
	 	</xsl:element>
     <xsl:element name="TAID">
			<xsl:value-of select="@TAID"/>
	 	</xsl:element>
     <xsl:element name="ClosestStoreID">
			<xsl:value-of select="@TaxLocationID"/>
	 	</xsl:element>

		 </xsl:element> 		 		 		 		 	

</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>	
	

<!--  **************************************************   INT43A   *********************************************************** -->	
	
		<xsl:template match="m:refundFinalConfirmationResponse/m:return/Response">  <!--  INT43A -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="refundFinalConfirmationResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>

        <xsl:element name="Unit_Price">
			<xsl:value-of select="@TaxLocationID"/>
	 	</xsl:element>
	 	
     <xsl:element name="Unit_Tax_1">
			<xsl:value-of select="@Tax1"/>
	 	</xsl:element>
	 	
     <xsl:element name="Unit_Tax_2">
			<xsl:value-of select="@Tax2"/>
	 	</xsl:element>
     <xsl:element name="TAID">
			<xsl:value-of select="@TAID"/>
	 	</xsl:element>
     <xsl:element name="ClosestStoreID">
			<xsl:value-of select="@TaxLocationID"/>
	 	</xsl:element>
    </xsl:element>
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>	
	

<!--  **************************************************   INT58   *********************************************************** -->	
	
		<xsl:template match="m:getNumberOfShipmentResponse/m:return/Response">  <!--  INT58 -->
	
	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.ws.services.responsys.com">
   <soapenv:Header/>
   <soapenv:Body>
<xsl:element name="getNumberOfShipmentResponse"> 
    <xsl:element name="Response" > 
        <xsl:element name="ResponseCode">
			<xsl:value-of select="@ResponseCode"/>
	 	</xsl:element>

        <xsl:element name="StoreNumber">
			<xsl:value-of select="@StoreNumber"/>
	 	</xsl:element>

        <xsl:element name="NewShipment">
			<xsl:value-of select="@NewShipment"/>
	 	</xsl:element>

        <xsl:element name="LateShipment">
			<xsl:value-of select="@LateShipment"/>
	 	</xsl:element>
	 	
        <xsl:element name="TotalShipment">
			<xsl:value-of select="@TotalShipment"/>
	 	</xsl:element>
     </xsl:element>
</xsl:element>
   	</soapenv:Body>
	</soapenv:Envelope>
	</xsl:template>	
	
</xsl:stylesheet>
