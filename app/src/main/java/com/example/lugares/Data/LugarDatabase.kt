package com.example.lugares.Data
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lugares.model.Lugar

@Database(entities = [Lugar::class], version = 1, exportSchema = false)
abstract class class LugarDatabase: RoomDatabase() {
    abstract fun lugarDao(): LugarDao

    companion object {
        @Volatile
        private var INSTANCE: LugarDatabase? = null

        fun getDatabase(context: android.content.Context): LugarDatabase {

            val temInstance = INSTANCE
            if (temInstance != null) {
                return temInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder( //CODIGO PRA CREAR BASE DE DATOS
                    context.applicationContext,
                    LugarDatabase::class.java,
                    "inicio_database"
                ).build()
                INSTANCE=instance
                return instance
            }

        }