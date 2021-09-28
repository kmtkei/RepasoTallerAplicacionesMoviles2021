package com.drackdesign.tienditadecafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_cafe.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ingresar_cafe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_cafe)

        var idcafe: Int? = null
        if (intent.hasExtra("cafe")) {
            val cafe = intent.extras?.getSerializable("cafe") as Cafe
            Toast.makeText(this, "idcafe = ${cafe.idCafe.toString()}", Toast.LENGTH_SHORT).show()
            idcafe = cafe.idCafe
            nombre_cafe_insert.setText(cafe.nombre)
        }

        btnInsert.setOnClickListener {
            val database = AppDatabase.getDatabase(this)
            var nombre = nombre_cafe_insert.text.toString()

            val cafe = Cafe(nombre)

            if (idcafe != null) {
                Toast.makeText(this, "idcafe = ${idcafe.toString()}", Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    cafe.idCafe = idcafe
                    database.cafes().update(cafe)
                    this@ingresar_cafe.finish()
                }
            } else {
                Toast.makeText(this, "idcafe = ${idcafe.toString()}", Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    database.cafes().insertAll(cafe)
                    this@ingresar_cafe.finish()
                }

                Toast.makeText(this, "Se ingreso el Cafe", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }


        }



        fun volverMain(view: View) {
            Toast.makeText(this, "Volviendo a Main", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

