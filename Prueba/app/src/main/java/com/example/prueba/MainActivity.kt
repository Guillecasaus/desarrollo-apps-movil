package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.example.prueba.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var check: CheckBox;
    private lateinit var buttonLogin: Button;
    private lateinit var spinnerPerfil: Spinner
    private lateinit var editCorreo: EditText
    private lateinit var editPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_main)

        spinnerPerfil = findViewById(R.id.spinnerPerfil)
        editCorreo = findViewById(R.id.editCorreo)
        editPass = findViewById(R.id.editPass)
        check = findViewById(R.id.checkInicio)
        buttonLogin = findViewById(R.id.btnLogin)

        acciones()
    }

    override fun onRestart() {
        super.onRestart()
        editCorreo.text.clear()
        editPass.text.clear()
        check.isChecked = false
    }

    private fun acciones(){
        check.setOnCheckedChangeListener { _, b ->
            buttonLogin.isEnabled = b
        }

        buttonLogin.setOnClickListener{
            //cambio de pantalla

            val user = User(editCorreo.text.toString(), editPass.text.toString(), spinnerPerfil.selectedItem.toString())

            val bundle: Bundle = Bundle()
            bundle.putSerializable("user", user)

            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("datos",bundle)

            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}