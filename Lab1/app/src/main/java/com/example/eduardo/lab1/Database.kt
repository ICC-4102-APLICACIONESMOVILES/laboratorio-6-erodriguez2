package com.example.eduardo.lab1

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.example.eduardo.lab1.Models.Form

/**
 * Created by eduardo on 03-04-18.
 */
@Database(entities = [(Form::class)], version = 1, exportSchema = false)
abstract class FormDatabase : RoomDatabase() {
    abstract fun daoAccess(): DaoAccess
}