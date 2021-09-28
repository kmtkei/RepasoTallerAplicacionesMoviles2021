package com.drackdesign.tienditadecafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listado_cafes.*

class ListadoCafes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_cafes)

        var listadocafes = emptyList<Cafe>()
        val database = AppDatabase.getDatabase(this)
        database.cafes().getAll().observe(this, {listadocafes = it
        val adapter = cafeAdapter(this, listadocafes)
            listado.adapter = adapter
        })

        listado.setOnItemClickListener{ parent, view, position, id->
            val intent = Intent(this, CafeDescripcion::class.java)
            intent.putExtra("id", listadocafes[position].idCafe)
            startActivity(intent)
        }
        /*val cafe1 = Cafe("Expresso")
        val cafe2 = Cafe("Capuchino")
        val cafe3 = Cafe("Mocca")
        val cafe4 = Cafe("Americano")
        val cafe5 = Cafe("Café con Leche")
        val cafe6 = Cafe("Macchiato")

        val listaCafes = listOf(cafe1, cafe2, cafe3,cafe4, cafe5, cafe6 )

        val adapter = cafeAdapter(this, listaCafes)
        listado.adapter = adapter*/



    }


    fun volverMain(view: View){
        Toast.makeText(this, "Volviendo a Main", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }




}