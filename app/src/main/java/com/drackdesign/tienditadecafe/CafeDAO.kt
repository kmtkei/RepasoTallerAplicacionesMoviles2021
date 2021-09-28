package com.drackdesign.tienditadecafe

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CafeDAO {
    @Query("SELECT * FROM cafes")
    fun getAll(): LiveData<List<Cafe>>
    @Query("SELECT * FROM cafes WHERE idCafe = :id")
    fun get(id:Int) : LiveData<Cafe>
    @Insert
    fun insertAll(vararg cafe: Cafe)
    @Update
    fun update(cafe:Cafe)
    @Delete
    fun delete(cafe:Cafe)
}