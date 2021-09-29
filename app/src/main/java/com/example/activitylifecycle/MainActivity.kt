package com.example.activitylifecycle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var titleName: String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.scrollveiew_example)

        titleName = sharedPreferences.getString("Title","The Avengers")

        title = titleName
        println("OnCreate called!")
    }

    override fun onStart() {
        super.onStart()
        println("OnStart called!")
    }

    override fun onResume() {
        super.onResume()
        println("OnResume called!")
    }

    override fun onPause() {
        super.onPause()
        println("OnPause called!")
    }

    override fun onStop() {
        super.onStop()
        println("OnStop called!")
    }

    override fun onRestart() {
        super.onRestart()
        println("OnRestart called!")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("OnDestroy called!")
    }
}