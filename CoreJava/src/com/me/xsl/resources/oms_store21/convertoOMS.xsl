<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:web="http://webservices" xmlns:yan="http://yantra.com/yantrawebservices" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	
	
	<xsl:template match="//web:lookupAvailability">  <!--  INT29 -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:lookupAvailability">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="lookupAvailability">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="SKULookupType">
								<xsl:value-of select="//SKULookupType"/>
							</xsl:element>
							<xsl:element name="ItemID">
								<xsl:value-of select="//SKU"/>
							</xsl:element>
							<xsl:element name="OrderedQty">
								<xsl:value-of select="//OrderQuantity"/>
							</xsl:element>
							<xsl:element name="OrderNo">
								<xsl:value-of select="//OrderID"/>
							</xsl:element>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>
	
	<xsl:template match="//web:lookupPostalCode"> <!-- INT29A -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:lookupPostalCode">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="lookupPostalCode">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//storeID"/>
							</xsl:element>
							<xsl:element name="ZipCode">
								<xsl:value-of select="//postalCode"/>
							</xsl:element>
							<xsl:element name="ShipToStore">
								<xsl:value-of select="//shipToStore"/>
							</xsl:element>
							<xsl:element name="ShipStoreDestination">
								<xsl:value-of select="//ShipStoreDestination"/>
							</xsl:element>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>
	
	
	<xsl:template match="//web:modifyShipAddress">  <!--  INT29B -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:modifyShipAddress">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="modifyShipAddress">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="ReceivingNode">ALDO <xsl:value-of select="//StoreID"/>						
							</xsl:element>
							<xsl:element name="OrderNo">
								<xsl:value-of select="//OrderID"/>
							</xsl:element>
							<xsl:element name="FirstName">
								<xsl:value-of select="//ShipFirstName"/>
							</xsl:element>
							<xsl:element name="LastName">
								<xsl:value-of select="//ShipLastName"/>
							</xsl:element>
							<xsl:element name="AddressLine1">
								<xsl:value-of select="//ShipAddress1"/>
							</xsl:element>
							<xsl:element name="AddressLine2">
								<xsl:value-of select="//ShipAddress2"/>
							</xsl:element>
							<xsl:element name="AddressLine3">
								<xsl:value-of select="//ShipAddress3"/>
							</xsl:element>
							<xsl:element name="City">
								<xsl:value-of select="//ShipCity"/>
							</xsl:element>																																			
							<xsl:element name="State">
								<xsl:value-of select="//ShipStateID"/>
							</xsl:element>																																			
							<xsl:element name="ShipCountyName">
								<xsl:value-of select="//ShipCountyName"/>
							</xsl:element>																																			
							<xsl:element name="ZipCode">
								<xsl:value-of select="//ShipPostalCode"/>
							</xsl:element>
							<xsl:element name="Country">
								<xsl:value-of select="//ShipCountryID"/>
							</xsl:element>							
							<xsl:element name="DayPhone">
								<xsl:value-of select="//Telephone"/>
							</xsl:element>							
							<xsl:element name="EMailID">
								<xsl:value-of select="//Email"/>
							</xsl:element>							
							<xsl:element name="EmailOptIn">
								<xsl:value-of select="//EmailOptIn"/>
							</xsl:element>
							<xsl:element name="ExtnPreferredLanguage">
								<xsl:value-of select="//languageID"/>
							</xsl:element>							
							<xsl:element name="PersonID">
								<xsl:value-of select="//CustomerID"/>
							</xsl:element>							
							<xsl:element name="addressBookID">
								<xsl:value-of select="//AddressBookID"/>
							</xsl:element>																																																																									</xsl:element>					
							<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>	
	
	
	<xsl:template match="//web:preConfirmOrder"> <!--  INT29C -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:preConfirmOrder">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="preConfirmOrder">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="OrderNo">
								<xsl:value-of select="//orderID"/>
							</xsl:element>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>	
	

	<xsl:template match="//web:confirmOrder">  <!-- INT29D -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:confirmOrder">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="confirmOrder">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="OrderNo">
								<xsl:value-of select="//orderID"/>
							</xsl:element>
							<xsl:element name="POSTransactionID">
								<xsl:value-of select="//POSTransactionID"/>
							</xsl:element>
							<xsl:element name="OrderLines">
								<xsl:for-each select="OrderLines/OrderLine">
									<xsl:element name="OrderLine">
										<xsl:attribute name="TransactionalLineId"><xsl:value-of select="@TransactionalLineId"></xsl:value-of></xsl:attribute>
										<xsl:element name="OrderLineTranQuantity">
											<xsl:attribute name="OrderedQty"><xsl:value-of select="OrderLineTranQuantity/@OrderedQty"></xsl:value-of></xsl:attribute>
										</xsl:element>								
										<xsl:element name="Item">
											<xsl:attribute name="ItemID"><xsl:value-of select="Item/@ItemID"></xsl:value-of></xsl:attribute>
										</xsl:element>								
										<xsl:element name="LinePriceInfo">
											<xsl:attribute name="ListPrice"><xsl:value-of select="LinePriceInfo/@ListPrice"></xsl:value-of></xsl:attribute>
											<xsl:attribute name="RetailPrice"><xsl:value-of select="LinePriceInfo/@RetailPrice"></xsl:value-of></xsl:attribute>										
										</xsl:element>
										<xsl:element name="LineTaxes">
										<xsl:for-each select="LineTaxes/LineTax">
											<xsl:element name="LineTax">
												<xsl:attribute name="TaxName"><xsl:value-of select="@TaxName"></xsl:value-of></xsl:attribute>
												<xsl:attribute name="TaxPercentage"><xsl:value-of select="@TaxPercentage"></xsl:value-of></xsl:attribute>
											</xsl:element>
										</xsl:for-each>
										</xsl:element>
									</xsl:element>										
								</xsl:for-each>
							</xsl:element>							
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>		
	

	
		<xsl:template match="//web:modifyLineItem"> <!--  INT29E, INT29G -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:modifyLineItem">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="cancelLineItem">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="OrderNo">
								<xsl:value-of select="//OrderID"/>
							</xsl:element>
							<xsl:element name="ItemID">
								<xsl:value-of select="//SKU"/>
							</xsl:element>
							<xsl:element name="OrderedQty">
								0
							</xsl:element>							
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>	
	
	
	<xsl:template match="//web:cancelOrder"> <!--  INT29F -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:cancelOrder">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="cancelOrder">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="OrderNo">
								<xsl:value-of select="//orderID"/>
							</xsl:element>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>	
	
		

	
	<xsl:template match="//web:RefundInitiationRequest"> <!--  INT43 -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:RefundInitiationRequest">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="RefundInitiationRequest">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="ItemID">
								<xsl:value-of select="//SKU"/>
							</xsl:element>							
							<xsl:element name="OrderNo">
								<xsl:value-of select="//orderID"/>
							</xsl:element>
							<xsl:element name="ExtnStyleDesc">
								<xsl:value-of select="//StyleName"/>
							</xsl:element>
							<xsl:element name="ColorCode">
								<xsl:value-of select="//Color"/>
							</xsl:element>
							<xsl:element name="ExtnStyleCode">
								<xsl:value-of select="//Size"/>
							</xsl:element>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>	
	
	<xsl:template match="//web:refundFinalConfirmation"> <!--  INT43A -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:refundFinalConfirmation">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="refundFinalConfirmation">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="ItemID">
								<xsl:value-of select="//SKU"/>
							</xsl:element>							
							<xsl:element name="OrderNo">
								<xsl:value-of select="//orderID"/>
							</xsl:element>
						</xsl:element>
							<xsl:element name="POSTransactionID">
								<xsl:value-of select="//POSTransactionID"/>
							</xsl:element>
							<xsl:element name="EmployeeID">
								<xsl:value-of select="//EmployeeID"/>
							</xsl:element>													
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>	
	
		<xsl:template match="//web:getNumberOfShipment"> <!--  INT58 -->
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Header"/>
			<xsl:element name="soapenv:Body">
				<xsl:element name="yan:getNumberOfShipment">
					<xsl:element name="yan:envString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="YFSEnvironment">
							<xsl:attribute name="userId">admin</xsl:attribute>
							<xsl:attribute name="progId">Store21</xsl:attribute>
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
					<xsl:element name="yan:apiString">
						<xsl:text disable-output-escaping="yes">
						 &lt;![CDATA[
					   </xsl:text>
						<xsl:element name="getNumberOfShipment">
							<xsl:element name="OrganizationCode">
								<xsl:value-of select="//StoreID"/>
							</xsl:element>
							<xsl:element name="dateVar">
								<xsl:value-of select="//dateVar"/>
							</xsl:element>
							<xsl:element name="timeVar">
								<xsl:value-of select="//timeVar"/>
							</xsl:element>							
						</xsl:element>
						<xsl:text disable-output-escaping="yes">
						 ]]&gt;
					</xsl:text>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>		
	
</xsl:stylesheet>
