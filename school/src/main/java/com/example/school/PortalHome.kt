package com.example.school

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PortalHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal_home)

        val roll =findViewById<EditText>(R.id.roll)
        val sub =findViewById<Button>(R.id.submit)


        //val str: String = roll.getText().toString()

        sub.setOnClickListener {
            val intent=Intent(this,ResultsActivity::class.java)
            intent.putExtra("Username",roll.text.toString() )
            startActivity(intent)
        }
    }
}