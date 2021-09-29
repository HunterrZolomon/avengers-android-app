package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin:Button
    lateinit var txtForgotPassword:TextView
    lateinit var txtRegister:TextView

    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("tony","steve","bruce","thanos")

    lateinit var  sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if(isLoggedIn){
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        title = "Login"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegisterYourself)

        btnLogin.setOnClickListener{
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfUser = "Avenger"
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            if((mobileNumber == validMobileNumber)){

                if(password == validPassword[0]){
                    nameOfUser = "Tony Stank/Iron Man"
                    savePreferences(nameOfUser)
                    startActivity(intent)
                }
                else if(password == validPassword[1]){
                    nameOfUser = "Sbeve Rogres/Craptain America"
                    savePreferences(nameOfUser)
                    startActivity(intent)
                }
                else if(password == validPassword[2]){
                    nameOfUser = "Bruce Banner/The Hulk"
                    savePreferences(nameOfUser)
                    startActivity(intent)
                }
                else if(password == validPassword[3]){
                    nameOfUser = "The Avengers"
                    savePreferences(nameOfUser)
                    startActivity(intent)
                }
            }
            else{
                Toast.makeText(this@LoginActivity,"Incorrect Credentials",Toast.LENGTH_LONG).show()
            }



        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    override fun onStop() {
        super.onStop()
        sharedPreferences.edit().clear().apply()
        finish()
    }

    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }


}