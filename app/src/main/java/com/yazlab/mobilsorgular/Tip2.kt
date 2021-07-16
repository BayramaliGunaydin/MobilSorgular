package com.yazlab.mobilsorgular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tip1.*
import kotlinx.android.synthetic.main.activity_tip2.*

class Tip2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip2)


        val button = findViewById<Button>(R.id.button4)
        val bar = findViewById<ProgressBar>(R.id.progressBar)
        val sayfa1 = findViewById<ConstraintLayout>(R.id.sayfa1)
        val sayfa2 = findViewById<ConstraintLayout>(R.id.sayfa2)
        button.setOnClickListener {

            if(editTextNumber.text.toString()==""|| editTextNumber.text.toString().toInt()<1||editTextNumber.text.toString().toInt()>30||editTextNumber2.text.toString()==""|| editTextNumber.text.toString().toInt()<1||editTextNumber.text.toString().toInt()>30){
                 textView8.setVisibility(View.VISIBLE)
            }
            else{
            var tarih1:Int=editTextNumber.text.toString().toInt()
            var tarih2:Int=editTextNumber2.text.toString().toInt()
            if(tarih1>tarih2){
                val dg=tarih1
                tarih1=tarih2
                tarih2=dg
            }
            sayfa1.setVisibility(View.GONE)

            sayfa2.setVisibility(View.VISIBLE)
            bar.setVisibility(View.VISIBLE)
             val database = FirebaseDatabase.getInstance().getReference().orderByChild("trip_distance")
           // val database = FirebaseDatabase.getInstance().getReference().orderByChild("trip_distance")
            val trip_distancearray = ArrayList<Float?>()
            val tpep_dropoff_datetimearray = ArrayList<String?>()
            val tpep_pickup_datetimearray = ArrayList<String?>()
                val dtrip_distancearray = ArrayList<Float?>()
                val dtpep_dropoff_datetimearray = ArrayList<String?>()
                val dtpep_pickup_datetimearray = ArrayList<String?>()
            database.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {


                    for(i in dataSnapshot.children){
                        var trip_distance=i.child("trip_distance")
                        var tpep_dropoff_datetime=i.child("tpep_dropoff_datetime")
                        var tpep_pickup_datetime=i.child("tpep_pickup_datetime")


                        val a=i.getValue<Data>(Data::class.java)

                        if(tpep_dropoff_datetime.exists()){
                        trip_distancearray.add(a?.trip_distance)
                        tpep_dropoff_datetimearray.add(a?.tpep_dropoff_datetime)
                        tpep_pickup_datetimearray.add(a?.tpep_pickup_datetime)
                        println("Veri:"+tpep_pickup_datetime+tpep_dropoff_datetime+trip_distance)
                        }

                    }

                    for(i in 0..tpep_pickup_datetimearray.size-1){
                        // if(!tpep_pickup_datetimearray.get(i).isNullOrEmpty()) {
                           //  val chars: CharArray = tpep_pickup_datetimearray.get(i)!!.toCharArray()
                           //  val chars: Array<Char> = tpep_pickup_datetimearray.get(i).toCharArray().toTypedArray()
                               var string:String=tpep_pickup_datetimearray.get(i).toString()

                           //  println("qqqqqq:"+ (string.get(8)))
                           // println("qqqqqq" + string?.get(8))
                              var tarih:Int=10*string.get(8).toString().toInt()+string.get(9).toString().toInt()

                              if(tarih<=tarih2&&tarih>=tarih1){
                                  dtrip_distancearray.add(trip_distancearray.get(i))
                                  dtpep_dropoff_datetimearray.add(tpep_dropoff_datetimearray.get(i))
                                  dtpep_pickup_datetimearray.add(tpep_pickup_datetimearray.get(i))
                                  if(dtrip_distancearray.size==5){
                                      break
                                  }
                        }
                        else{

                        }
                      //   }
                    }


                    textView7.setText("$tarih1-12-2020 ve $tarih2-12-20 Tarihleri Arasındaki En Kısa Yolculuklar\n\n1.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[0]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[0]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[0]+"\n\n"+
                            "2.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[1]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[1]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[1]+"\n\n"+
                            "3.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[2]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[2]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[2]+"\n\n"+
                            "4.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[3]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[3]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[3]+"\n\n"+
                            "5.En Kısa Mesafe \nYol Uzunluk:"+dtrip_distancearray[4]+"\nBiniş Tarihi:"+ dtpep_pickup_datetimearray[4]+"\nİniş Tarihi:"+dtpep_dropoff_datetimearray[4]+"\n\n"
                            // "1.En Uzak Mesafe \nYol Uzunluk:"+trip_distancearray[trip_distancearray.size-6]+"\nBiniş Tarihi:"+ tpep_pickup_datetimearray[tpep_pickup_datetimearray.size-6]+"\n  İniş Tarihi:"+tpep_dropoff_datetimearray[tpep_dropoff_datetimearray.size-6]+"\n"





                    )
                     progressBar.setVisibility(View.GONE)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }}
    }
}