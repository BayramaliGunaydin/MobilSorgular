package com.yazlab.mobilsorgular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_tip1.*
import kotlinx.coroutines.joinAll
import java.lang.StringBuilder

class Tip1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip1)

     //  val database = FirebaseDatabase.getInstance().getReference().orderByChild("tpep_dropoff_datetime").startAt("2020-12-01").endAt("2020-12-01"+"\uf8ff")
        val database = FirebaseDatabase.getInstance().getReference().orderByChild("trip_distance")
        val trip_distancearray = ArrayList<Float?>()
        val tpep_dropoff_datetimearray = ArrayList<String?>()
        val tpep_pickup_datetimearray = ArrayList<String?>()
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for(i in dataSnapshot.children){
                    var trip_distance=i.child("trip_distance")
                    var tpep_dropoff_datetime=i.child("tpep_dropoff_datetime")
                    var tpep_pickup_datetime=i.child("tpep_pickup_datetime")


                           val a=i.getValue<Data>(Data::class.java)

                    println("Veri:"+tpep_pickup_datetime+tpep_dropoff_datetime+trip_distance)
                    trip_distancearray.add(a?.trip_distance)
                    tpep_dropoff_datetimearray.add(a?.tpep_dropoff_datetime)
                    tpep_pickup_datetimearray.add(a?.tpep_pickup_datetime)


                }



                textView12.setText("En uzun mesafeli 5 yolculuk \n\n1.En Uzak Mesafe \nYol Uzunluk:"+trip_distancearray[trip_distancearray.size-1]+"\nBiniş Tarihi:"+ tpep_pickup_datetimearray[tpep_pickup_datetimearray.size-1]+"\nİniş Tarihi:"+tpep_dropoff_datetimearray[tpep_dropoff_datetimearray.size-1]+"\n\n"+
                        "2.En Uzak Mesafe \nYol Uzunluk:"+trip_distancearray[trip_distancearray.size-2]+"\nBiniş Tarihi:"+ tpep_pickup_datetimearray[tpep_pickup_datetimearray.size-2]+"\nİniş Tarihi:"+tpep_dropoff_datetimearray[tpep_dropoff_datetimearray.size-2]+"\n\n"+
                        "3.En Uzak Mesafe \nYol Uzunluk:"+trip_distancearray[trip_distancearray.size-3]+"\nBiniş Tarihi:"+ tpep_pickup_datetimearray[tpep_pickup_datetimearray.size-3]+"\nİniş Tarihi:"+tpep_dropoff_datetimearray[tpep_dropoff_datetimearray.size-3]+"\n\n"+
                        "4.En Uzak Mesafe \nYol Uzunluk:"+trip_distancearray[trip_distancearray.size-4]+"\nBiniş Tarihi:"+ tpep_pickup_datetimearray[tpep_pickup_datetimearray.size-4]+"\nİniş Tarihi:"+tpep_dropoff_datetimearray[tpep_dropoff_datetimearray.size-4]+"\n\n"+
                        "5.En Uzak Mesafe \nYol Uzunluk:"+trip_distancearray[trip_distancearray.size-5]+"\nBiniş Tarihi:"+ tpep_pickup_datetimearray[tpep_pickup_datetimearray.size-5]+"\nİniş Tarihi:"+tpep_dropoff_datetimearray[tpep_dropoff_datetimearray.size-5]+"\n\n"
                       // "1.En Uzak Mesafe \nYol Uzunluk:"+trip_distancearray[trip_distancearray.size-6]+"\nBiniş Tarihi:"+ tpep_pickup_datetimearray[tpep_pickup_datetimearray.size-6]+"\n  İniş Tarihi:"+tpep_dropoff_datetimearray[tpep_dropoff_datetimearray.size-6]+"\n"





                )
                  progressBar2.setVisibility(View.GONE)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}