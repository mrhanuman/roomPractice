package com.example.roompractice

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface contactsDAO {

    @Insert

    suspend fun insertContact(contacts: Contacts)

    @Update
    suspend fun updateContact(contacts: Contacts)

    @Delete
    suspend fun deleteContact(contacts: Contacts)

    @Query("SELECT  * FROM contacts")
    fun getContact(): LiveData<List<Contacts>>
}