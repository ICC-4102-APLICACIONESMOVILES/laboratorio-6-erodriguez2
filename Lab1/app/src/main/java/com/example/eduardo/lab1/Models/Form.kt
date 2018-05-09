package com.example.eduardo.lab1.Models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Form {
    @PrimaryKey(autoGenerate = true)
    lateinit var id: Integer
    lateinit var name: String
    lateinit var date: String
    lateinit var category: String
    lateinit var comment: String
}