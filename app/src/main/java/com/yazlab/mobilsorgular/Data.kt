package com.yazlab.mobilsorgular

class Data {
    var VendorID:Int=0
var DOLocationID:Int=0
var PULocationID:Int=0
var passenger_count:Int=0
    var total_amount:Float=0.0F
   var tpep_dropoff_datetime:String=""
    var tpep_pickup_datetime:String=""
   var trip_distance:Float=0.0F
    var Borough:String=""
    var LocationID:Int=0
    var Zone:String=""
    var service_zone:String=""
   /* var RatecodeID:Int=0
   var congestion_surcharge:Float=0.0F
   var extra:Float=0.0F
   var fare_amount:Float=0.0F
  var  improvement_surcharge:Float=0.0F
  var  mta_tax:Float=0.0F
  var  payment_type:Int=0
  var  store_and_fwd_flag:String=""
   var tip_amount:Float=0.0F
   var tolls_amount:Float=0.0F*/
    constructor(DOLocationID:Int,PULocationID:Int,passenger_count:Int,total_amount:Float,tpep_dropoff_datetime:String,tpep_pickup_datetime:String,trip_distance:Float,Borough:String,LocationID:Int,Zone:String,service_zone:String){
        this.DOLocationID=DOLocationID
        this.PULocationID=PULocationID
        this.passenger_count=passenger_count
        this.total_amount=total_amount
        this.tpep_dropoff_datetime=tpep_dropoff_datetime
        this.tpep_pickup_datetime=tpep_pickup_datetime
        this.trip_distance=trip_distance
       this.Borough=Borough
       this.LocationID=LocationID
       this.Zone=Zone
       this.service_zone=service_zone
    }
   constructor()


}