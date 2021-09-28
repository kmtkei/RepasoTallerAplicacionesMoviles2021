package com.drackdesign.tienditadecafe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.elemento_cafe.view.*

class cafeAdapter (private val mContext: Context, private val listadoCafes: List<Cafe>) : ArrayAdapter<Cafe>(mContext , 0, listadoCafes)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.elemento_cafe, parent, false)

        val cafe = listadoCafes[position]

        layout.nombre_cafe.text = cafe.nombre

        return layout

    }
}
