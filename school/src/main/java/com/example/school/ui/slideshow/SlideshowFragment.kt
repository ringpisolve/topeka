package com.example.school.ui.slideshow

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.school.PortalHome
import com.example.school.R
import com.example.school.ResultsActivity
import com.google.firebase.auth.FirebaseAuth

class SlideshowFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val view: View = inflater!!.inflate(R.layout.fragment_slideshow, container, false)

        val email = view.findViewById<EditText>(R.id.email).toString()
        val password = view.findViewById<EditText>(R.id.password).toString()
        val login = view.findViewById<Button>(R.id.login)


        var mAuth = FirebaseAuth.getInstance();



        login?.setOnClickListener {

            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {


                mAuth!!.signInWithEmailAndPassword(email!!, password!!).addOnCompleteListener {
                    Toast.makeText(requireActivity().baseContext, "Authentication completed",
                            Toast.LENGTH_SHORT).show()
                    val iii = Intent(requireActivity().baseContext,PortalHome::class.java)
                    requireActivity().startActivity(iii)

                }
            }
            else
            {
                Toast.makeText(requireActivity().baseContext, "Authentication failed",
                        Toast.LENGTH_SHORT).show()
            }




        }
        return view
        return root

    }
}
