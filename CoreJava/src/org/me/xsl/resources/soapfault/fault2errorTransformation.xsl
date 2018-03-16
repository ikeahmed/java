 <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:soap11="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope"> 

	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
    <xsl:strip-space elements="*"/>
  	<xsl:template match="/">	
   <xsl:choose>
      <xsl:when test="/soap11:Envelope">
  		<ErrorRS xmlns="http://www.opentravel.org/OTA/2002/08" Severity="ERROR">
			<TPA_Extensions>
				<ErrorInfo>
					<Code>
						<xsl:copy-of select="./soap11:Envelope/soap11:Body/soap11:Fault/faultcode/text()"/>
					</Code>
					<Message>
						<xsl:copy-of select="./soap11:Envelope/soap11:Body/soap11:Fault/faultstring/text()"/>
					</Message>
					<Info>SOAP Fault received from the supplier</Info>
				</ErrorInfo>
			</TPA_Extensions>
		</ErrorRS>		
      </xsl:when>
	  
      <xsl:when test="/soap12:Envelope">
         <ErrorRS xmlns="http://www.opentravel.org/OTA/2002/08" Severity="ERROR">
			<TPA_Extensions>
				<ErrorInfo>
					<Code>
						<xsl:copy-of select="/soap12:Envelope/soap12:Body/soap12:Fault/soap12:Code/soap12:Value/text()"/>
					</Code>
					<Message>
						<xsl:copy-of select="/soap12:Envelope/soap12:Body/soap12:Fault/soap12:Reason/soap12:Text/text()"/>
					</Message>
					<Info>SOAP Fault received from the supplier</Info>
				</ErrorInfo>
			</TPA_Extensions>
		</ErrorRS>	
		</xsl:when>
		
	    <xsl:otherwise>
	             <ErrorRS xmlns="http://www.opentravel.org/OTA/2002/08" Severity="ERROR">
			<TPA_Extensions>
				<ErrorInfo>
					<Code>CODE_NOT_FOUND</Code>
					<Message>SOAP Fault expected but received different Xml message (fault2errorTransformation.xsl)</Message>
					<Info>SOAP Fault expected but received different Xml message (fault2errorTransformation.xsl)</Info>
				</ErrorInfo>
			</TPA_Extensions>
		</ErrorRS>		
       </xsl:otherwise>
    </xsl:choose>
</xsl:template> 
	
</xsl:stylesheet>