package com.drackdesign.tienditadecafe

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "cafes")
class Cafe (
    val nombre:String,
    @PrimaryKey(autoGenerate = true)
    var idCafe: Int = 0
    ) :Serializable