package com.example.eduardo.lab1.Models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [(ForeignKey(entity = Form::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("formId"),
        onDelete = ForeignKey.CASCADE))])
class Question {
    @PrimaryKey(autoGenerate = true)
    lateinit var id: Integer
    lateinit var content: String
    var type = "TextQuestion"
}
