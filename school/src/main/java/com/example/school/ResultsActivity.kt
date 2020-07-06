package com.example.school

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore


class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)


        val maths=findViewById<TextView>(R.id.maths_marks)

        val phy=findViewById<TextView>(R.id.phy_marks)
        val social=findViewById<TextView>(R.id.social_marks)
        val english=findViewById<TextView>(R.id.english_marks)
        val first_lang=findViewById<TextView>(R.id.fl_marks)
        val sec_lang=findViewById<TextView>(R.id.sl_marks)

        val name=findViewById<TextView>(R.id.name)
        val class_sec=findViewById<TextView>(R.id.sec)

       var strUser: String = intent.getStringExtra("Username")



      var myDB = FirebaseFirestore.getInstance()


        val docRef: DocumentReference =
                myDB.collection("school1").document(strUser)
        docRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document != null) {

                    val namef: String? = document.getString("name")

                    name.text =namef

                    val csec: String? = document.getString("class")

                    class_sec.text =csec



                    val mathsm: String? = document.getString("maths")

                    maths.text =mathsm



                    val phym: String? = document.getString("physics")

                    phy.text =phym


                    val engm: String? = document.getString("english")

                    english.text =engm

                    val socm: String? = document.getString("social")

                    social.text =socm



                    val flm: String? = document.getString("first_lang")

                    first_lang.text =flm

                    val slm: String? = document.getString("sec_lang")

                    sec_lang.text =slm




                } else {
                    Log.d("LOGGER", "No such document")
                    Toast.makeText(this, "error",
                            Toast.LENGTH_SHORT).show()
                }
            } else {
                Log.d("LOGGER", "get failed with ", task.exception)
                Toast.makeText(this, "pls try again ",
                        Toast.LENGTH_SHORT).show()
            }
        }



    }
}