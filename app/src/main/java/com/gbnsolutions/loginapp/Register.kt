package com.gbnsolutions.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var Register: Button
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        email = findViewById(R.id.remail)
        password = findViewById(R.id.rpass)
        Register = findViewById(R.id.register)
        mAuth = FirebaseAuth.getInstance()

        Register.setOnClickListener {
            Register()
        }
    }
    fun Register(){
        mAuth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener { task->
            if (task.isSuccessful){
                Toast.makeText(this,"Registered Successful!",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,HomeScreen::class.java))
            }
            else{
                Toast.makeText(this,"User Already Exist!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}