package com.example.eduardo.lab1.Models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import java.util.*

@Entity(foreignKeys = [(ForeignKey(entity = Question::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("questionId"),
        onDelete = ForeignKey.CASCADE))])
class Answer {
    @PrimaryKey(autoGenerate = true)
    lateinit var id: Integer
    lateinit var content: String
    lateinit var date: Date
    lateinit var coordinates: LatLng
}

