package com.example.roompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataBase : DataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBase = DataBase.getDataBase(this)

//        dataBase = Room.databaseBuilder(this.applicationContext,DataBase::class.java,"contactDB").build()

        GlobalScope.launch {
            dataBase.contactsDao().insertContact(Contacts(0,"anuj","8826", Date(), 1))
        }

        dataBase.contactsDao().getContact().observe(this,Observer{
            Log.d("hanuman",it.toString())
        })
    }
}