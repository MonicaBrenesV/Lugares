package com.example.lugares.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lugares.model.Lugar

@Dao
interface LugarDao {
}

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addInicio(practica: Lugar)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  updateInicio(practica: Lugar)

    @Delete
    suspend fun  deleteInicio(practica: Lugar)

    @Query("SELECT * FROM LUGAR") //NOMBRE DE LA TABLA
    fun getAllData() : LiveData<List<Lugar>> //NOMBRE DEL MODEL
}