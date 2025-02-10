package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var check: CheckBox;
    private lateinit var buttonLogin: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_main)

        check = findViewById(R.id.checkInicio)
        buttonLogin = findViewById(R.id.btnLogin)
        acciones()
    }

    private fun acciones(){
        check.setOnCheckedChangeListener { _, b ->
            buttonLogin.isEnabled = b
        }

        buttonLogin.setOnClickListener{
            //cambio de pantalla
            val intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}