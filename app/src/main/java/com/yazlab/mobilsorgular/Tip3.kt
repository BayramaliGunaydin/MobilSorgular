package com.yazlab.mobilsorgular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.gms.maps.SupportMapFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_tip2.*
import kotlinx.android.synthetic.main.activity_tip3.*

class Tip3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip3)
        val intent = Intent(this, SonucTip3::class.java)

        progressBar3.setVisibility(View.GONE)

        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            if (editTextNumber3.text.toString() == "" || editTextNumber3.text.toString().toInt() < 1 || editTextNumber3.text.toString().toInt() > 30) {
                textView9.setVisibility(View.VISIBLE)
            }
            else{
            progressBar3.setVisibility(View.VISIBLE)
            var secilentarih = editTextNumber3.text.toString().toInt()

            var location1: String = "İstanbul"
            var location2: String = "Ankara"
            val database = FirebaseDatabase.getInstance().getReference().orderByChild("trip_distance")
            // val database = FirebaseDatabase.getInstance().getReference().orderByChild("trip_distance")
            val trip_distancearray = ArrayList<Float?>()
            val tpep_dropoff_datetimearray = ArrayList<String?>()
            val tpep_pickup_datetimearray = ArrayList<String?>()
            val dtrip_distancearray = ArrayList<Float?>()
            val dtpep_dropoff_datetimearray = ArrayList<String?>()
            val dtpep_pickup_datetimearray = ArrayList<String?>()
            val PULocationIDarray = ArrayList<Int?>()
            val DOLocationIDarray = ArrayList<Int?>()
            val location = Array<String>(270) { "" }





            database.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {


                    for (i in dataSnapshot.children) {
                        var trip_distance = i.child("trip_distance")
                        var tpep_dropoff_datetime = i.child("tpep_dropoff_datetime")
                        var tpep_pickup_datetime = i.child("tpep_pickup_datetime")
                        var PULocationID = i.child("PULocationID")
                        var DOLocationID = i.child("DOLocationID")
                        var LocationID = i.child("LocationID")
                        var Zone = i.child("Zone")
                        var Borough = i.child("Borough")

                        val a = i.getValue<Data>(Data::class.java)

                        if (tpep_dropoff_datetime.exists()) {
                            trip_distancearray.add(a?.trip_distance)
                            tpep_dropoff_datetimearray.add(a?.tpep_dropoff_datetime)
                            tpep_pickup_datetimearray.add(a?.tpep_pickup_datetime)
                            PULocationIDarray.add(a?.PULocationID)
                            DOLocationIDarray.add(a?.DOLocationID)
                            println("Veri:" + tpep_pickup_datetime + tpep_dropoff_datetime + PULocationID + DOLocationID + trip_distance)
                        }
                        if (Borough.exists()) {
                            var loc: Int = a?.LocationID!!
                            var yer = a?.Borough + " " + a?.Zone
                            location[loc] = yer
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

                        if (tarih == secilentarih) {
                            dtrip_distancearray.add(trip_distancearray.get(i))
                            dtpep_dropoff_datetimearray.add(tpep_dropoff_datetimearray.get(i))
                            dtpep_pickup_datetimearray.add(tpep_pickup_datetimearray.get(i))
                            location1 = location[PULocationIDarray.get(i)!!]
                            location2 = location[DOLocationIDarray.get(i)!!]
                            break


                        } else {

                        }
                        //   }
                    }




                    intent.putExtra("location1", location1)
                    intent.putExtra("location2", location2)
                    startActivity(intent)

                    //   )
                    //  progressBar.setVisibility(View.GONE)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })


        }
        }
    }
}