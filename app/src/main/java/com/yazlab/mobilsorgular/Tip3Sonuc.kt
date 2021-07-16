package com.yazlab.mobilsorgular

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.*
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_tip2.*
import java.io.IOException


class Tip3Sonuc : AppCompatActivity(), OnMapReadyCallback {


    var location1:String = "İstanbul";
    var location2:String= "Ankara"
    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle :Bundle ?=intent.extras

        location1=bundle?.getString("location1")!!
        location2=bundle?.getString("location2")!!
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip3_sonuc)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.



     /*   val database = FirebaseDatabase.getInstance().getReference().orderByChild("trip_distance")
        // val database = FirebaseDatabase.getInstance().getReference().orderByChild("trip_distance")
        val trip_distancearray = ArrayList<Float?>()
        val tpep_dropoff_datetimearray = ArrayList<String?>()
        val tpep_pickup_datetimearray = ArrayList<String?>()
        val dtrip_distancearray = ArrayList<Float?>()
        val dtpep_dropoff_datetimearray = ArrayList<String?>()
        val dtpep_pickup_datetimearray = ArrayList<String?>()
        val PULocationIDarray = ArrayList<Int?>()
        val DOLocationIDarray = ArrayList<Int?>()
        val location = Array<String>(270){""}

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (i in dataSnapshot.children) {
                    var trip_distance = i.child("trip_distance")
                    var tpep_dropoff_datetime = i.child("tpep_dropoff_datetime")
                    var tpep_pickup_datetime = i.child("tpep_pickup_datetime")
                    var PULocationID=i.child("PULocationID")
                    var DOLocationID=i.child("DOLocationID")
                    var LocationID=i.child("LocationID")
                    var Zone=i.child("Zone")
                    var Borough=i.child("Borough")

                    val a = i.getValue<Data>(Data::class.java)

                    if (tpep_dropoff_datetime.exists()) {
                        trip_distancearray.add(a?.trip_distance)
                        tpep_dropoff_datetimearray.add(a?.tpep_dropoff_datetime)
                        tpep_pickup_datetimearray.add(a?.tpep_pickup_datetime)
                        PULocationIDarray.add(a?.PULocationID)
                        DOLocationIDarray.add(a?.DOLocationID)
                        println("asdasdsadsad" + tpep_pickup_datetime + trip_distance)
                    }
                    if(Borough.exists()){
                        var loc:Int=a?.LocationID!!
                        var yer=a?.Borough+" "+a?.Zone
                        println("Yer: "+yer)
                        location[loc]=yer
                    }

                }

                for (i in tpep_pickup_datetimearray.size - 1 downTo 0) {
                    // if(!tpep_pickup_datetimearray.get(i).isNullOrEmpty()) {
                    //  val chars: CharArray = tpep_pickup_datetimearray.get(i)!!.toCharArray()
                    //  val chars: Array<Char> = tpep_pickup_datetimearray.get(i).toCharArray().toTypedArray()
                    var string: String = tpep_pickup_datetimearray.get(i).toString()

                    //  println("qqqqqq:"+ (string.get(8)))
                    // println("qqqqqq" + string?.get(8))
                    var tarih: Int = 10 * string.get(8).toString().toInt() + string.get(9).toString().toInt()
                    println("qqqqq:$tarih")
                    if (tarih == secilentarih) {
                        dtrip_distancearray.add(trip_distancearray.get(i))
                        dtpep_dropoff_datetimearray.add(tpep_dropoff_datetimearray.get(i))
                        dtpep_pickup_datetimearray.add(tpep_pickup_datetimearray.get(i))
                        location1=location[PULocationIDarray.get(i)!!]
                        location2=location[DOLocationIDarray.get(i)!!]
                        break
                        println("asdasdasdasdasdasddsa")

                    } else {

                    }
                    //   }
                }
                println("enuzun:" + dtrip_distancearray.get(0))
                println("lokasyon1:"+location1)
                /*   textView7.setText("$tarih1-12-2020 ve $tarih2-12-20 Tarihleri Arasındaki En Kısa Yolculuklar\n\n1.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[0]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[0]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[0]+"\n\n"+
                        "2.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[1]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[1]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[1]+"\n\n"+
                        "3.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[2]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[2]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[2]+"\n\n"+
                        "4.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[3]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[3]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[3]+"\n\n"+
                        "5.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[4]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[4]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[4]+"\n\n"
                        // "1.En Uzak Mesafe \nYol Uzunluk:"+trip_distancearray[trip_distancearray.size-6]+"\nBiniş Tarihi:"+ tpep_pickup_datetimearray[tpep_pickup_datetimearray.size-6]+"\n  İniş Tarihi:"+tpep_dropoff_datetimearray[tpep_dropoff_datetimearray.size-6]+"\n"*/


                //   )
                //  progressBar.setVisibility(View.GONE)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })*/



      /*  if(Geocoder.isPresent()){
    try {
        val location:String = "İstanbul";
        val gc = Geocoder(this)

        val addresses: List<Address> = gc.getFromLocationName(location, 5)
        var ll: MutableList<LatLng?>? = ArrayList<LatLng?>() // A list to save the coordinates if they are available
        for( a in addresses){
            if(a.hasLatitude() && a.hasLongitude()){
                ll!!.add(LatLng(a.latitude, a.longitude))
                println("istanbul"+ll.get(0))
            }
        }
    } catch (e : IOException) {

    }
}*/




        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    private lateinit var mMap: GoogleMap
    override fun onMapReady(googleMap: GoogleMap) {

            mMap = googleMap


            mMap.getUiSettings().setZoomControlsEnabled(true)

            var pickuplocation: LatLng = LatLng(0.0, 0.0)
            var dropofflocation: LatLng = LatLng(0.0, 0.0)
            println("lokasyon1:" + location1)
            if (Geocoder.isPresent()) {
                try {
                    /*  val location:String = "İstanbul";
                val location2:String= "Ankara"*/
                    val gc = Geocoder(this)
                    println("qwqwqwqwqwa")
                    val addresses: List<Address> = gc.getFromLocationName(location1, 5)
                    val addresses2: List<Address> = gc.getFromLocationName(location2, 5)
                   // val ll: List<LatLng> = ArrayList<LatLng>()
                   // var ll: MutableList<LatLng?>? = ArrayList<LatLng?>() // A list to save the coordinates if they are available
                  //  val addresses: List<Address> = gc.getFromLocationName(location1, 5) // get the found Address Objects
                    var ll: MutableList<LatLng?> = ArrayList<LatLng?>()
                    var ll2: MutableList<LatLng?>? = ArrayList<LatLng?>()
                    println("qwqwqwqwqwa")
                    for (a in addresses) {
                        if (a.hasLatitude() && a.hasLongitude()) {

                            ll.add(LatLng(a.latitude, a.longitude))
                            pickuplocation = ll.get(0)!!
                             println("alış" + pickuplocation)
                            //  println("istanbul"+ll.get(0))


                            mMap.addMarker(MarkerOptions().position(pickuplocation).title(location1))

                        //    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pickuplocation, 5F))

                        }
                    }
                    for (a in addresses2) {
                        if (a.hasLatitude() && a.hasLongitude()) {

                            ll2!!.add(LatLng(a.latitude, a.longitude))
                            dropofflocation = ll2.get(0)!!

                            //  println("istanbul"+ll.get(0))


                            mMap.addMarker(MarkerOptions().position(dropofflocation).title(location2))
                              mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pickuplocation, 10F))

                        }
                    }


                } catch (e: IOException) {

                }
            }




            // build URL to call API
            // val url = getURL(pickuplocation, dropofflocation)

            /*   async {
            // Connect to URL, download content and convert into string asynchronously
            val result = URL(url).readText()
            uiThread {
                // When API call is done, create parser and convert into JsonObjec
                val parser:com.beust.klaxon.Parser = Parser()
                val stringBuilder: StringBuilder = StringBuilder(result)
                val json: JsonObject = parser.parse(stringBuilder) as JsonObject
                // get to the correct element in JsonObject
                val routes = JsonArray<JsonObject>("routes")
                val points = routes!!["legs"]["steps"][0] as JsonArray<JsonObject>
                // For every element in the JsonArray, decode the polyline string and pass all points to a List
                val polypts = points.flatMap { decodePoly(it.obj("polyline")?.string("points")!!)  }
                // Add  points to polyline and bounds
                options1.add(pickuplocation)
                LatLongB.include(pickuplocation)
                for (point in polypts)  {
                    options1.add(point)
                    LatLongB.include(point)
                }
                options1.add(dropofflocation)
                LatLongB.include(dropofflocation)
                // build bounds
                val bounds = LatLongB.build()
                // add polyline to the map
                mMap!!.addPolyline(options1)
                // show map with route centered
                mMap!!.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100))
            }
        }*/
        }



    }



 /*   private fun getURL(from : LatLng, to : LatLng) : String {
        val origin = "origin=" + from.latitude + "," + from.longitude
        val dest = "destination=" + to.latitude + "," + to.longitude
        val sensor = "sensor=false"
        val params = "$origin&$dest&$sensor"
        return "https://maps.googleapis.com/maps/api/directions/json?$params"
    }


private fun decodePoly(encoded: String): List<LatLng> {
    val poly = ArrayList<LatLng>()
    var index = 0
    val len = encoded.length
    var lat = 0
    var lng = 0

    while (index < len) {
        var b: Int
        var shift = 0
        var result = 0
        do {
            b = encoded[index++].toInt() - 63
            result = result or (b and 0x1f shl shift)
            shift += 5
        } while (b >= 0x20)
        val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
        lat += dlat

        shift = 0
        result = 0
        do {
            b = encoded[index++].toInt() - 63
            result = result or (b and 0x1f shl shift)
            shift += 5
        } while (b >= 0x20)
        val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
        lng += dlng

        val p = LatLng(lat.toDouble() / 1E5,
                lng.toDouble() / 1E5)
        poly.add(p)
    }

    return poly
}*/




