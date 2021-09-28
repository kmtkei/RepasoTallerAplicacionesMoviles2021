package com.drackdesign.tienditadecafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import kotlinx.android.synthetic.main.activity_cafe_descripcion.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CafeDescripcion : AppCompatActivity() {
    private lateinit var database : AppDatabase
    private lateinit var cafe : Cafe
    private lateinit var cafeLiveData :LiveData<Cafe>

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cafe, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafe_descripcion)

       database = AppDatabase.getDatabase(this)
        val idcafe = intent.getIntExtra("id", 0)

        cafeLiveData = database.cafes().get(idcafe)
        cafeLiveData.observe(this, {cafe = it

            nombre_cafe_d.text = cafe.nombre
        })


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.editar -> {
                val intent = Intent(this, ingresar_cafe::class.java)
                intent.putExtra("cafe", cafe)
                startActivity(intent)
            }
            R.id.eliminar -> {
                cafeLiveData.removeObservers(this)
                CoroutineScope(Dispatchers.IO).launch {
                    database.cafes().delete(cafe)
                    this@CafeDescripcion.finish()
                }
            }
        }


        return super.onOptionsItemSelected(item)
    }

    fun volverListado(view: View){
        Toast.makeText(this, "Volviendo a Main", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ListadoCafes::class.java)
        startActivity(intent)
        finish()
    }
}