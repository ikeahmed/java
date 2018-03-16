<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="functions"
				xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://bene-ws.b-rail.be/rail1/2007-06-13/types"
				xmlns:STL="http://services.sabre.com/STL/v01"
				xmlns:msg="http://services.sabre.com/STL/Rail/Message/v01"
				exclude-result-prefixes="xs fn msg STL">

	<xsl:output method="xml"/>

	<xsl:variable name="mappingNotFound" select="'carrier mapping not found'" />
	<xsl:variable name="root" select="/"/>

	<xsl:key name="rail-segment-id-key" match="//Reservations/Reservation[1]/Itinerary/Journeys/Journey/Segments/RailSegment"
			 use="id"/>

	<xsl:template match="msg:RailBookingRequest">
		<xsl:element name="booking-request">
			<xsl:apply-templates select="Suppliers"/>
			<xsl:apply-templates select="Reservations/Reservation[1]/Status"/>
			<xsl:apply-templates select="Reservations/Reservation[1]"/>
			<xsl:apply-templates select="Reservations/Reservation[1]/Passengers"/>
			<xsl:element name="booking-request-list">
				<xsl:call-template name="CreateFares"/>
			</xsl:element>
		</xsl:element>
	</xsl:template>

	<xsl:template match="Reservations/Reservation/Itinerary/Journeys/Journey/Segments">
		<xsl:apply-templates select="RailSegment"/>
	</xsl:template>

	<xsl:template match="Ticket"></xsl:template>
	<xsl:template match="Price"></xsl:template>

	<xsl:template name="CreateFares">
		<xsl:for-each select="Reservations/Reservation[1]/Fares/AssociatedFares/Fare">
			<xsl:variable name="fare" select="."/>
			<xsl:variable name="allRailSegments" select="../../../Itinerary/Journeys/Journey/Segments/RailSegment"/>
			<xsl:variable name="firstRailSegment" select="../../../Itinerary/Journeys/Journey/Segments/RailSegment[@id = $fare/Scope/Segment[1]/@segmentId]"/>
			<xsl:variable name="journey-position" select="count($firstRailSegment/../../preceding-sibling::*) + 1"/>

			<xsl:variable name="journeyPositionCounter">
				<xsl:call-template name="JourneyForFare">
					<xsl:with-param name="fare" select="."/>
					<xsl:with-param name="startingJourneyPosition" select="$journey-position"/>
					<xsl:with-param name="startingFarePositionIndex" select="position()"/>
					<xsl:with-param name="journeyCounter" select="0"/>
				</xsl:call-template>
			</xsl:variable>

			<xsl:call-template name="Fare">
				<xsl:with-param name="farePosition" select="position()"/>
				<xsl:with-param name="allRailSegments" select="$allRailSegments"/>
				<xsl:with-param name="segmentId" select="$journeyPositionCounter"/>
			</xsl:call-template>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="JourneyForFare">
		<xsl:param name="fare"/>
		<xsl:param name="startingJourneyPosition"/>
		<xsl:param name="startingFarePositionIndex"/>
		<xsl:param name="journeyCounter"/>

		<xsl:variable name="firstRailSegment" select="../../../Itinerary/Journeys/Journey/Segments/RailSegment[@id = $fare/Scope/Segment[1]/@segmentId]"/>
		<xsl:variable name="journey-position" select="count($firstRailSegment/../../preceding-sibling::*) + 1"/>

		<xsl:choose>
			<xsl:when test="$startingFarePositionIndex = 0 and $startingJourneyPosition = $journey-position">
				<xsl:call-template name="JourneyForFare">
					<xsl:with-param name="fare" select="$fare/preceding-sibling::Fare"/>
					<xsl:with-param name="startingJourneyPosition" select="$journey-position"/>
					<xsl:with-param name="startingFarePositionIndex" select="$startingFarePositionIndex - 1"/>
					<xsl:with-param name="journeyCounter" select="$journeyCounter + 1"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:element name="numberOfTimesForSameJourney">
					<xsl:value-of select="$journeyCounter"/>
				</xsl:element>
			</xsl:otherwise>
		</xsl:choose>

	</xsl:template>

	<xsl:template name="Fare">
		<xsl:param name="farePosition"/>
		<xsl:param name="allRailSegments"/>
		<xsl:param name="segmentId"/>

		<xsl:variable name="temp" select="."/>
		<xsl:variable name="numberOfScopes" select="count($temp/Scope/Segment)"/>
		<xsl:variable name="firstRailSegment" select="../../../Itinerary/Journeys/Journey/Segments/RailSegment[@id = $temp/Scope/Segment[1]/@segmentId]"/>
		<xsl:variable name="lastRailSegment" select="../../../Itinerary/Journeys/Journey/Segments/RailSegment[@id = $temp/Scope/Segment[$numberOfScopes]/@segmentId]"/>
		<xsl:variable name="journey-position"
					  select="count($firstRailSegment/../../preceding-sibling::*) + 1"/>

		<xsl:variable name="segId" select="$firstRailSegment/@id"/>

		<xsl:element name="proposed-price">
			<xsl:element name="price-offer">
				<xsl:element name="used-tacos">
					<xsl:element name="taco">
						<xsl:attribute name="tic">
							<xsl:value-of select="$temp/Identificator/Code"/>
						</xsl:attribute>
						<xsl:apply-templates select="$temp/Identificator/AdditionalContent"/>
						<xsl:value-of select="$temp/Identificator/Name"/>
					</xsl:element>
					<xsl:element name="unit-price">
						<xsl:element name="amount">
							<xsl:value-of select="$temp/Price/TotalPrice"/>
						</xsl:element>
						<xsl:element name="currency">
							<xsl:value-of select="$temp/Price/TotalPrice/@currencyCode"/>
						</xsl:element>
					</xsl:element>
					<xsl:if test="$temp/SpecialFares/SpecialFare[1]/Type = 'NEGOTIATED'">
						<xsl:element name="corporate-contract">
							<xsl:element name="contract-type">
								<xsl:value-of select="$temp/SpecialFares/SpecialFare[1]/SubType"/>
							</xsl:element>
							<xsl:element name="contract-code">
								<xsl:attribute name="number">
									<xsl:value-of select="$temp/SpecialFares/SpecialFare[1]/SpecialFareCode"/>
								</xsl:attribute>
								<xsl:attribute name="distributor">
									<xsl:value-of select="//Suppliers/Supplier[1]/Credentials/AdditionalField[@Name='Distributor']"/>
								</xsl:attribute>
								<xsl:attribute name="supplier">
									<xsl:value-of select="$firstRailSegment/Train/Identifier/@carrier"/>
								</xsl:attribute>
								<!-- TODO: what value should be here? -->
								<xsl:attribute name="id">
									<xsl:value-of select="position()"/>
								</xsl:attribute>
							</xsl:element>
						</xsl:element>
					</xsl:if>
					<xsl:element name="number-of-passengers">
						<xsl:value-of select="count(//Passengers/Passenger)"/>
					</xsl:element>
					<xsl:element name="passenger-list">
						<xsl:for-each select="//Passengers/Passenger">
							<xsl:element name="passenger-id">
								<xsl:value-of select="fn:calculatePaxNumber(position())"/>
							</xsl:element>
						</xsl:for-each>
					</xsl:element>
				</xsl:element>
			</xsl:element>
			<xsl:element name="product-feature">
				<xsl:element name="comfort-class">
					<xsl:value-of select="if($temp/Classification/CabinClass='First') then '1' else '2'"/>
				</xsl:element>
				<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'refundable']">
					<xsl:element name="is-refundable">
						<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'refundable']"/>
					</xsl:element>
				</xsl:if>
				<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'changeable']">
					<xsl:element name="is-changeable">
						<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'changeable']"/>
					</xsl:element>
				</xsl:if>
				<xsl:element name="carrier-description">
					<xsl:attribute name="supplier">
						<xsl:value-of select="$firstRailSegment/Train/Identifier/@carrier"/>
					</xsl:attribute>
					<xsl:choose>
						<xsl:when test="fn:carrierNameFromCode($firstRailSegment/Train/Identifier/@carrier) eq $mappingNotFound">
							<xsl:value-of select="$firstRailSegment/Train/Identifier/@carrier"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="fn:carrierNameFromCode($firstRailSegment/Train/Identifier/@carrier)"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:element>
				<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'EBS']">
					<xsl:element name="{$temp/AdditionalContent/Field[@Name eq 'EBS']/@Name}">
						<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'EBS']"/>
					</xsl:element>
				</xsl:if>
				<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'ESN']">
					<xsl:element name="{$temp/AdditionalContent/Field[@Name eq 'ESN']/@Name}">
						<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'ESN']"/>
					</xsl:element>
				</xsl:if>
			</xsl:element>
			<xsl:element name="origin-station">
				<xsl:attribute name="code">
					<xsl:value-of select="$firstRailSegment/Origin/Station"/>
				</xsl:attribute>
			</xsl:element>
			<xsl:element name="destination-station">
				<xsl:attribute name="code">
					<xsl:value-of select="$lastRailSegment/Destination/Station"/>
				</xsl:attribute>
			</xsl:element>
			<xsl:for-each select="$temp/AdditionalContent/Field">
				<xsl:if test="contains(./@Name, 'via-station-')">
					<xsl:element name="via-station">
						<xsl:attribute name="code">
							<xsl:value-of select="."/>
						</xsl:attribute>
					</xsl:element>
				</xsl:if>
			</xsl:for-each>

			<xsl:for-each select="$temp/Scope/Segment">
				<xsl:element name="train-number">
					<xsl:variable name="scopesegment" select="./@segmentId"/>
					<xsl:value-of select="$allRailSegments[./@id = $scopesegment]/Train/Identifier"/>
				</xsl:element>
			</xsl:for-each>
			<xsl:element name="departure-time">
				<xsl:value-of select="substring($firstRailSegment/Origin/Schedule, 12)" />
			</xsl:element>
			<xsl:element name="departure-date">
				<xsl:value-of select="substring($firstRailSegment/Origin/Schedule, 1, 10)" />
			</xsl:element>
			<xsl:element name="proposed-price-id">
				<xsl:value-of select="$farePosition"/>
			</xsl:element>
			<xsl:element name="route-summary-id">
				<xsl:value-of select="$journey-position"/>
			</xsl:element>

			<xsl:element name="segment-id">
				<xsl:value-of select="$segmentId"/>
			</xsl:element>
			<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'segment-type']">
				<xsl:element name="segment-type">
					<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'segment-type']"/>
				</xsl:element>
			</xsl:if>
			<xsl:choose>
				<xsl:when test="$temp[./Identificator/AdditionalContent/Field = 'TCV' and
                ./AdditionalContent/Field[@Name eq 'one-ticket-indicator' and . eq 'true'] and
                ./AdditionalContent/Field[@Name eq 'segment-type' and . eq 'admission']] and
                //Journeys/Journey[Segments/RailSegment/@id = $segId]/Direction eq 'I' ">

					<xsl:variable name="inboundOrigin" select="//Journeys/Journey/Segments/RailSegment[@id eq $segId]/Origin/Station"/>
					<xsl:variable name="inboundDestination" select="//Journeys/Journey/Segments/RailSegment[@id eq $segId]/Destination/Station"/>
					<xsl:variable name="outboundPPID" select="//Journeys/Journey/Segments/RailSegment[Origin/Station eq $inboundDestination and Destination/Station eq $inboundOrigin]/@id"/>
					<outward-proposed-price-id>
						<xsl:value-of select="fn:calculatePPID(//Segments/*, $outboundPPID)"/>
					</outward-proposed-price-id>
				</xsl:when>
			</xsl:choose>
			<xsl:if test="//Reservation[1]/Passengers/Passenger/SeatingPreferences/SeatBySegment/ProximityPlacement">
				<xsl:element name="booking-specifications">
					<xsl:element name="seating-preferences">
						<xsl:element name="specific-placement">
							<xsl:element name="type-of-placement">
								<xsl:attribute name="code">
									<xsl:value-of select="'N'"/>
								</xsl:attribute>
								<xsl:value-of select="'nearby'"/>
							</xsl:element>
							<xsl:variable name="temp1" select="//Reservation[1]/Passengers/Passenger[1]/SeatingPreferences/SeatBySegment[@segmentId = $segId]"/>
							<xsl:element name="coach-number">
								<xsl:value-of select="$temp1/ProximityPlacement/@coachNumber"/>
							</xsl:element>
							<xsl:element name="seat-number">
								<xsl:value-of select="$temp1/ProximityPlacement/@seatNumber"/>
							</xsl:element>
						</xsl:element>
					</xsl:element>
				</xsl:element>
			</xsl:if>
			<xsl:element name="one-ticket-indicator">
				<xsl:value-of select="'true'"/>
			</xsl:element>
		</xsl:element>
	</xsl:template>

	<xsl:template match="RailSegment">
		<xsl:variable name="segId" select="@id"/>
		<xsl:variable name="temp" select="//Fares/AssociatedFares/Fare[Scope/Segment/@segmentId eq $segId]"/>
		<xsl:element name="proposed-price">
			<xsl:element name="price-offer">
				<xsl:element name="used-tacos">
					<xsl:element name="taco">
						<xsl:attribute name="tic">
							<xsl:value-of select="$temp/Identificator/Code"/>
						</xsl:attribute>
						<xsl:apply-templates select="$temp/Identificator/AdditionalContent"/>
						<xsl:value-of select="$temp/Identificator/Name"/>
					</xsl:element>
					<xsl:element name="unit-price">
						<xsl:element name="amount">
							<xsl:value-of select="$temp/Price/TotalPrice"/>
						</xsl:element>
						<xsl:element name="currency">
							<xsl:value-of select="$temp/Price/TotalPrice/@currencyCode"/>
						</xsl:element>
					</xsl:element>
					<xsl:if test="$temp/SpecialFares/SpecialFare[1]/Type eq 'NEGOTIATED'">
						<xsl:element name="corporate-contract">
							<xsl:element name="contract-type">
								<xsl:value-of select="$temp/SpecialFares/SpecialFare[1]/SubType"/>
							</xsl:element>
							<xsl:element name="contract-code">
								<xsl:attribute name="number">
									<xsl:value-of select="$temp/SpecialFares/SpecialFare[1]/SpecialFareCode"/>
								</xsl:attribute>
								<xsl:attribute name="distributor">
									<xsl:value-of select="//Suppliers/Supplier[1]/Credentials/AdditionalField[@Name='Distributor']"/>
								</xsl:attribute>
								<xsl:attribute name="supplier">
									<xsl:value-of select="Train/Identifier/@carrier"/>
								</xsl:attribute>
								<!-- TODO: what value should be here? -->
								<xsl:attribute name="id">
									<xsl:value-of select="position()"/>
								</xsl:attribute>
							</xsl:element>
						</xsl:element>
					</xsl:if>
					<xsl:element name="number-of-passengers">
						<xsl:value-of select="count(//Passengers/Passenger)"/>
					</xsl:element>
					<xsl:element name="passenger-list">
						<xsl:for-each select="//Passengers/Passenger">
							<xsl:element name="passenger-id">
								<xsl:value-of select="fn:calculatePaxNumber(position())"/>
							</xsl:element>
						</xsl:for-each>
					</xsl:element>
				</xsl:element>
			</xsl:element>
			<xsl:element name="product-feature">
				<xsl:element name="comfort-class">
					<xsl:value-of select="if($temp/Classification/CabinClass='First') then '1' else '2'"/>
				</xsl:element>
				<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'refundable']">
					<xsl:element name="is-refundable">
						<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'refundable']"/>
					</xsl:element>
				</xsl:if>
				<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'changeable']">
					<xsl:element name="is-changeable">
						<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'changeable']"/>
					</xsl:element>
				</xsl:if>
				<xsl:element name="carrier-description">
					<xsl:attribute name="supplier">
						<xsl:value-of select="Train/Identifier/@carrier"/>
					</xsl:attribute>
					<xsl:choose>
						<xsl:when test="fn:carrierNameFromCode(Train/Identifier/@carrier) eq $mappingNotFound">
							<xsl:value-of select="Train/Identifier/@carrier"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="fn:carrierNameFromCode(Train/Identifier/@carrier)"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:element>
				<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'EBS']">
					<xsl:element name="{$temp/AdditionalContent/Field[@Name eq 'EBS']/@Name}">
						<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'EBS']"/>
					</xsl:element>
				</xsl:if>
				<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'ESN']">
					<xsl:element name="{$temp/AdditionalContent/Field[@Name eq 'ESN']/@Name}">
						<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'ESN']"/>
					</xsl:element>
				</xsl:if>
			</xsl:element>
			<xsl:element name="origin-station">
				<xsl:attribute name="code">
					<xsl:value-of select="Origin/Station"/>
				</xsl:attribute>
			</xsl:element>
			<xsl:element name="destination-station">
				<xsl:attribute name="code">
					<xsl:value-of select="Destination/Station"/>
				</xsl:attribute>
			</xsl:element>
			<xsl:for-each select="$temp/AdditionalContent/Field">
				<xsl:if test="contains(./@Name, 'via-station-')">
					<xsl:element name="via-station">
						<xsl:attribute name="code">
							<xsl:value-of select="."/>
						</xsl:attribute>
					</xsl:element>
				</xsl:if>
			</xsl:for-each>
			<xsl:for-each select="tokenize(normalize-space(Train/Identifier), ' ')">
				<xsl:element name="train-number">
					<xsl:value-of select="."/>
				</xsl:element>
			</xsl:for-each>
			<xsl:element name="departure-time">
				<xsl:value-of select="substring(Origin/Schedule, 12)" />
			</xsl:element>
			<xsl:element name="departure-date">
				<xsl:value-of select="substring(Origin/Schedule, 1, 10)" />
			</xsl:element>
			<xsl:element name="proposed-price-id">
				<xsl:choose>
					<xsl:when test="$temp[./Identificator/AdditionalContent/Field = 'TCV' and
					./AdditionalContent/Field[@Name eq 'one-ticket-indicator' and . eq 'true'] and
					./AdditionalContent/Field[@Name eq 'segment-type' and . eq 'admission']]">
						<xsl:value-of select="fn:calculatePPID(//Segments/*, $segId)"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="'0'"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:element>
			<xsl:element name="route-summary-id">
				<xsl:value-of select="'0'"/>
			</xsl:element>
			<xsl:element name="segment-id">
				<xsl:value-of select="position()"/>
			</xsl:element>
			<xsl:if test="$temp/AdditionalContent/Field[@Name eq 'segment-type']">
				<xsl:element name="segment-type">
					<xsl:value-of select="$temp/AdditionalContent/Field[@Name eq 'segment-type']"/>
				</xsl:element>
			</xsl:if>
			<xsl:choose>
				<xsl:when test="$temp[./Identificator/AdditionalContent/Field = 'TCV' and
				./AdditionalContent/Field[@Name eq 'one-ticket-indicator' and . eq 'true'] and
				./AdditionalContent/Field[@Name eq 'segment-type' and . = 'admission']] and
				//Journeys/Journey[Segments/RailSegment/@id = $segId]/Direction = 'I' ">

					<xsl:variable name="inboundOrigin" select="//Journeys/Journey/Segments/RailSegment[@id eq $segId]/Origin/Station"/>
					<xsl:variable name="inboundDestination" select="//Journeys/Journey/Segments/RailSegment[@id eq $segId]/Destination/Station"/>
					<xsl:variable name="outboundPPID" select="//Journeys/Journey/Segments/RailSegment[Origin/Station eq $inboundDestination and Destination/Station eq $inboundOrigin]/@id"/>
					<outward-proposed-price-id>
						<xsl:value-of select="fn:calculatePPID(//Segments/*, $outboundPPID)"/>
					</outward-proposed-price-id>
				</xsl:when>
			</xsl:choose>
			<xsl:if test="//Reservation[1]/Passengers/Passenger/SeatingPreferences/SeatBySegment/ProximityPlacement">
				<xsl:element name="booking-specifications">
					<xsl:element name="seating-preferences">
						<xsl:element name="specific-placement">
							<xsl:element name="type-of-placement">
								<xsl:attribute name="code">
									<xsl:value-of select="'N'"/>
								</xsl:attribute>
								<xsl:value-of select="'nearby'"/>
							</xsl:element>
							<xsl:variable name="temp1" select="//Reservation[1]/Passengers/Passenger[1]/SeatingPreferences/SeatBySegment[@segmentId = $segId]"/>
							<xsl:element name="coach-number">
								<xsl:value-of select="$temp1/ProximityPlacement/@coachNumber"/>
							</xsl:element>
							<xsl:element name="seat-number">
								<xsl:value-of select="$temp/ProximityPlacement/@seatNumber"/>
							</xsl:element>
						</xsl:element>
					</xsl:element>
				</xsl:element>
			</xsl:if>
			<xsl:element name="one-ticket-indicator">
				<xsl:value-of select="'true'"/>
			</xsl:element>
		</xsl:element>
	</xsl:template>

	<xsl:template match="Fares/AssociatedFares/Fare/Identificator/AdditionalContent">
		<xsl:apply-templates select="Field"/>
	</xsl:template>

	<xsl:template match="Fares/AssociatedFares/Fare/Identificator/AdditionalContent/Field">
		<xsl:attribute name="{@Name}">
			<xsl:value-of select="."/>
		</xsl:attribute>
	</xsl:template>

	<xsl:template match="Reservations/Reservation[1]">
		<xsl:element name="booking-info">
			<xsl:element name="delivery-info">
				<xsl:element name="delivery-method">
					<xsl:attribute name="code">
						<xsl:if test="Fares/Ticket/DeliveryMethod/HomePrinting">
							<xsl:value-of select="'DH'"/>
						</xsl:if>
						<xsl:if test="Fares/Ticket/DeliveryMethod/TicketLess">
							<xsl:value-of select="'TL'"/>
						</xsl:if>
						<xsl:if test="Fares/Ticket/DeliveryMethod/CollectAtStation">
							<xsl:value-of select="'ST'"/>
						</xsl:if>
					</xsl:attribute>
				</xsl:element>
			</xsl:element>
			<xsl:apply-templates select="../Reservation[1]/AdditionalContent/Field"/>
			<xsl:element name="seat-info-requested">
				<xsl:value-of select="'true'"/>
			</xsl:element>
		</xsl:element>
	</xsl:template>

	<xsl:template match="Reservation[1]/AdditionalContent/Field">
		<xsl:if test="@Name = 'ticket-language'">
			<xsl:element name="{@Name}">
				<xsl:attribute name="code">
					<xsl:value-of select="."/>
				</xsl:attribute>
			</xsl:element>
		</xsl:if>
	</xsl:template>

	<xsl:template match="Suppliers">
		<xsl:element name="user-data">
			<xsl:apply-templates select="Supplier[1]/Credentials/Username" />
			<xsl:apply-templates select="Supplier[1]/Credentials/Password" />
			<xsl:element name="language">
				<xsl:attribute name="code">
					<!-- hard-coded value for SNCB -->
					<xsl:value-of select="'en_GB'" />
				</xsl:attribute>
			</xsl:element>
			<xsl:apply-templates select="Supplier/Credentials/AdditionalField" />
			<xsl:element name="user-related-data" />
		</xsl:element>
	</xsl:template>

	<xsl:template match="Username">
		<xsl:element name="user-name">
			<xsl:value-of select="." />
		</xsl:element>
	</xsl:template>

	<xsl:template match="Password">
		<xsl:element name="password">
			<xsl:value-of select="." />
		</xsl:element>
	</xsl:template>

	<xsl:template match="AdditionalField">
		<xsl:if test="@Name = 'Distributor'">
			<xsl:element name="distributor">
				<xsl:value-of select="." />
			</xsl:element>
		</xsl:if>
	</xsl:template>

	<xsl:template match="Status">
		<xsl:element name="booking-type">
			<xsl:choose>
				<xsl:when test="lower-case(.) = 'purchase' and ../Fares/Ticket/DeliveryMethod/HomePrinting">ticket</xsl:when>
				<xsl:when test="lower-case(.) = 'purchase' and ../Fares/Ticket/DeliveryMethod/CollectAtStation">ticket</xsl:when>
				<xsl:when test="../Fares/Ticket/DeliveryMethod/TicketLess">confirm</xsl:when>
				<xsl:otherwise>.</xsl:otherwise>
			</xsl:choose>
		</xsl:element>
	</xsl:template>

	<xsl:template match="Reservations/Reservation/Passengers">
		<xsl:element name="passenger-list-reply">
			<xsl:apply-templates select="Passenger"/>
		</xsl:element>
	</xsl:template>

	<xsl:template match="Passenger">
		<xsl:element name="passenger-reply">
			<xsl:element name="last-name">
				<xsl:value-of select="Name/Last"/>
			</xsl:element>
			<xsl:element name="first-name">
				<xsl:value-of select="Name/First"/>
			</xsl:element>
			<xsl:apply-templates select="AdditionalContent"/>
			<xsl:apply-templates select="Benefits"/>
			<xsl:element name="passenger-id">
				<xsl:value-of select="fn:calculatePaxNumber(position())"/>
			</xsl:element>
			<xsl:apply-templates select="SeatingPreferences/SeatByItinerary[1]"/>
		</xsl:element>
	</xsl:template>

	<xsl:template match="AdditionalContent">
	</xsl:template>

	<xsl:template match="Benefits">
		<xsl:apply-templates select="Benefit"/>
	</xsl:template>

	<xsl:template match="Benefit">
		<xsl:if test="@type = 'LYC'">
			<xsl:element name="loyalty-card">
				<xsl:element name="carrier">
					<xsl:attribute name="code">
						<xsl:value-of select="@carrier"/>
					</xsl:attribute>
					<xsl:value-of select="fn:carrierNameFromCode(@carrier)"/>
				</xsl:element>
				<xsl:element name="card-number">
					<xsl:value-of select="Identifier"/>
				</xsl:element>
			</xsl:element>
		</xsl:if>
	</xsl:template>

	<xsl:template match="SeatingPreferences/SeatByItinerary[1]">
		<xsl:if test="exists(GeneralPlacement/Position)">
			<xsl:element name="seat-preference">
				<xsl:attribute name="code">
					<xsl:value-of select="fn:computeSeatCode(GeneralPlacement/Position/@type, GeneralPlacement/SeatType/@mandatory)"/>
				</xsl:attribute>
			</xsl:element>
		</xsl:if>
	</xsl:template>

	<xsl:function name="fn:computeSeatCode" as="xs:string">
		<xsl:param name="type"/>
		<xsl:param name="mandatory"/>
		<xsl:if test="lower-case($type) eq 'window' and lower-case($mandatory) eq 'true'">R</xsl:if>
		<xsl:if test="lower-case($type) eq 'window' and not(lower-case($mandatory) eq 'true')">W</xsl:if>
		<xsl:if test="lower-case($type) eq 'aisle'">C</xsl:if>
		<xsl:if test="lower-case($type) eq 'individual'">S</xsl:if>
		<xsl:if test="lower-case($type) eq 'middle'">M</xsl:if>
	</xsl:function>
	<xsl:function name="fn:carrierNameFromCode" as="xs:string">
		<xsl:param name="code"/>
		<xsl:choose>
			<xsl:when test="lower-case($code) eq 'tha'">Thalys</xsl:when>
			<xsl:when test="lower-case($code) eq 'eur'">Eurostar</xsl:when>
			<xsl:when test="lower-case($code) eq 'tgv'">Train Gran velocite</xsl:when>
			<xsl:when test="lower-case($code) eq 'tcv'">Klassieke biljetten</xsl:when>
			<xsl:when test="lower-case($code) eq 'ble'">Eurostar Brussels - Lille</xsl:when>
			<xsl:when test="lower-case($code) eq 'bli'">TGV Brussels Lille </xsl:when>
			<xsl:when test="lower-case($code) eq 'epa'">Reservation EPA</xsl:when>
			<xsl:when test="lower-case($code) eq 'ibf'">ICE Belgium - Frankfurt</xsl:when>
			<xsl:when test="lower-case($code) eq 'lle'">Eurostar Lille - London</xsl:when>
			<xsl:when test="lower-case($code) eq 'rhe'">Rhealys TGV est</xsl:when>
			<xsl:when test="lower-case($code) eq 'tgf'">TGV France - Italia</xsl:when>
			<xsl:when test="lower-case($code) eq 'tgi'">TGV Brussels - France</xsl:when>
			<xsl:when test="lower-case($code) eq 'tgs'">TGV France - Suisse</xsl:when>
			<xsl:when test="lower-case($code) eq 'thw'">Thalys Snow</xsl:when>
			<xsl:when test="lower-case($code) eq 'thz'">Thalys Summer</xsl:when>
			<xsl:when test="lower-case($code) eq 'tpl'">TGV Paris - Luxembourg</xsl:when>
			<xsl:when test="lower-case($code) eq 'ice'">ICE beligium-frankfurt</xsl:when>
			<xsl:when test="lower-case($code) eq 'est'">Eurostar Lille</xsl:when>
			<xsl:when test="lower-case($code) eq 'Alaris'">Alaris</xsl:when>
			<xsl:when test="lower-case($code) eq 'alx'">Alex</xsl:when>
			<xsl:when test="lower-case($code) eq 'artesia'">Artesia</xsl:when>
			<xsl:when test="lower-case($code) eq 'benelix'">Intercity</xsl:when>
			<xsl:when test="lower-case($code) eq 'bus'">Bus</xsl:when>
			<xsl:when test="lower-case($code) eq 'cis'">CIS</xsl:when>
			<xsl:when test="lower-case($code) eq 'city night line'">CNL</xsl:when>
			<xsl:when test="lower-case($code) eq 'dpn'">DPN</xsl:when>
			<xsl:when test="lower-case($code) eq 'es* italia'">ES* Italia</xsl:when>
			<xsl:when test="lower-case($code) eq 'eurocity'">Eurocity</xsl:when>
			<xsl:when test="lower-case($code) eq 'eurocitybrenner'">Eurocity</xsl:when>
			<xsl:when test="lower-case($code) eq 'euronight'">Euronight</xsl:when>
			<xsl:when test="lower-case($code) eq 'express-zug'">Express-Zug</xsl:when>
			<xsl:when test="lower-case($code) eq 'fyra'">Fyra</xsl:when>
			<xsl:when test="lower-case($code) eq 'ic'">Klassieke biljetten</xsl:when>
			<xsl:when test="lower-case($code) eq 'ice_de-fr'">ICE</xsl:when>
			<xsl:when test="lower-case($code) eq 'ice_fr-de'">ICE</xsl:when>
			<xsl:when test="lower-case($code) eq 'int'">INT</xsl:when>
			<xsl:when test="lower-case($code) eq 'ir'">Interregio</xsl:when>
			<xsl:when test="lower-case($code) eq 'ire'">Interregio</xsl:when>
			<xsl:when test="lower-case($code) eq 'lyria'">Lyria</xsl:when>
			<xsl:when test="lower-case($code) eq 'obb-ec'">OEBB</xsl:when>
			<xsl:when test="lower-case($code) eq 'obb-ic'">OEBB</xsl:when>
			<xsl:when test="lower-case($code) eq 'r'">R</xsl:when>
			<xsl:when test="lower-case($code) eq 'rail jet'">OEBB</xsl:when>
			<xsl:when test="lower-case($code) eq 'rb'">Regionalbahn</xsl:when>
			<xsl:when test="lower-case($code) eq 're'">RE</xsl:when>
			<xsl:when test="lower-case($code) eq 'rex'">OEBB</xsl:when>
			<xsl:when test="lower-case($code) eq 's-bahn'">S-Bahn</xsl:when>
			<xsl:when test="lower-case($code) eq 'talgo'">Talgo</xsl:when>
			<xsl:when test="lower-case($code) eq 'tgv_fr-de'">Train Gran velocite</xsl:when>
			<xsl:when test="lower-case($code) eq 'train nuit scnf'">Train Gran velocite</xsl:when>
			<xsl:when test="lower-case($code) eq 'u-bahn'">U-Bahn</xsl:when>
			<xsl:when test="lower-case($code) eq 'x2'">x2</xsl:when>
			<xsl:otherwise><xsl:value-of select="$mappingNotFound"/></xsl:otherwise>
		</xsl:choose>
	</xsl:function>

	<!-- calculate passenger-id in format: AA, AB, AC .... AZ, BA ... BZ ... ZZ -->
	<xsl:function name="fn:calculatePaxNumber" as="xs:string">
		<xsl:param name="i"/>
		<xsl:value-of select="concat(codepoints-to-string((floor(($i - 1) div 26) + 65) cast as xs:integer), codepoints-to-string((($i - 1) mod 26 + 65) cast as xs:integer))"/>
	</xsl:function>

	<xsl:function name="fn:calculatePPID" as="xs:string">
		<xsl:param name="segments" />
		<xsl:param name="i"/>
		<xsl:for-each select="$segments/@id">
			<xsl:if test=". eq $i">
				<xsl:value-of select="position()"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:function>
</xsl:stylesheet>

