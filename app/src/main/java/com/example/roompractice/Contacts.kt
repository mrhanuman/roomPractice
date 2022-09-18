package com.example.roompractice

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "contacts")
data class Contacts(

    @PrimaryKey(autoGenerate = true)

    val id: Long,
    val name: String,
    val phone: String,
    val date : Date,
    val isActive: Int
)