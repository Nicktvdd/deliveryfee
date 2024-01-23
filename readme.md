pseudocode delivery fee calculator

class for DeliveryRequest
val cartvalue int (in cents)
val deliverydistance int (in meters)
val numberofitems int
val time string (in UTC in ISO format)

class deliveryresponse
val deliveryfee int

contentnegotiation

illegal arguments

routing
post
val request = DeliveryRequest
val deliveryFee = calculateDeliveryFee(request) // create the function
response(deliveryResponse(deliveryfee)

calculateDeliveryFee function
if less than 10 = difference between value and 10 (if <10, then it's 10 ?)
DistanceIn500s = distanceInMeters / 500 (rounded down)
RoundedDown = floor(distanceIn500s).toInt()
v
if numberofitems >= 5
bulk = numberofitems - 4
return (bulk * 50)
v
if cartvalue >= 200
deliveryfee = 0
v
function getdayofweekfromutc(isodatetime)
formatter = datetimeformatter.iso_date_time
val datetime = localdatetime.parse(isodatetime, formatter)
val instant = datetime.toinstant(zondeofset.utc)
return instant.atzone(zondeoffset.utc).dayofweek
v
if dayofweek == "Friday"
deliveryfee *= 1,2
v
if deliveryfee > 15
deliveryfee = 15