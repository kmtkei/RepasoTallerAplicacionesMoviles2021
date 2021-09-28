package com.drackdesign.tienditadecafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mostrarListado(view: View) {
        val mensaje : String = getString(R.string.mensaje_mostrar) // getString(R.string.mensaje_mostrar)  --- Obtener valor de Resource/Values/Strings para Toast
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ListadoCafes::class.java)
        startActivity(intent)
        finish()
    }

    fun cerrarApp(view: View){
        Toast.makeText(this, "cerrando la aplicacion", Toast.LENGTH_SHORT).show()
        finishAndRemoveTask()
    }
    fun IngresarCafe(view: View){
        val mensaje : String = getString(R.string.mensaje_mostrar)
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ingresar_cafe::class.java)
        startActivity(intent)
        finish()
    }

}