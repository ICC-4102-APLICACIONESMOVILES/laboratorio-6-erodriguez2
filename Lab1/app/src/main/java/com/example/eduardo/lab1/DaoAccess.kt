package com.example.eduardo.lab1

import android.arch.persistence.room.*
import com.example.eduardo.lab1.Models.Form

/**
 * Created by eduardo on 03-04-18.
 */
@Dao
interface DaoAccess {

    @Insert
    fun insertOnlySingleForm (form: Form)
    @Insert
    fun insertMultipleForms (forms: MutableList<Form>)
    @Query("SELECT * FROM Form WHERE id = :arg0")
    fun fetchOneFormsByFormId (id: Int): Form
    @Query("SELECT * FROM Form")
    fun getAllForms(): List<Form>
    @Update
    fun updateForm (form: Form)
    @Delete
    fun deleteForm (form: Form)
}