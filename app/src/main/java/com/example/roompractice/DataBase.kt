package com.example.roompractice

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Contacts::class], version = 2)
@TypeConverters(Converter::class)
abstract class DataBase : RoomDatabase() {

    abstract fun contactsDao(): contactsDAO

    companion object {

        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contacts ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        @Volatile
        private var INSTANCE: DataBase? = null


        fun getDataBase(context: Context): DataBase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "contactDB",
                    ).addMigrations(migration_1_2).build()

                }

            }
            return INSTANCE!!
        }


    }
}