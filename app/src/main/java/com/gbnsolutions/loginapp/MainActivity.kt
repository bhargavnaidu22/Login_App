package com.gbnsolutions.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button
    lateinit var register: TextView
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        register = findViewById(R.id.register)
        mAuth = FirebaseAuth.getInstance()
        login.setOnClickListener {
            Login()
        }
        register.setOnClickListener {
            startActivity(Intent(this,Register::class.java))
        }
    }
    fun Login(){
        mAuth.signInWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener { task->
            if (task.isSuccessful)
            {
                startActivity(Intent(this,HomeScreen::class.java))
                Toast.makeText(this,"Logged Successful!",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Invalid Credentials!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}