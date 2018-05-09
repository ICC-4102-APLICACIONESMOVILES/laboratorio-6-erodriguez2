package com.example.eduardo.lab1

import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.common.api.GoogleApiClient
import org.jetbrains.anko.find

class AnswerFormActivity : AppCompatActivity(){

    private lateinit var idFormAnswerContent: TextView
    private lateinit var nameFormAnswerContent: TextView
    private lateinit var dateFormAnswerContent: TextView
    private lateinit var categoryFormAnswerContent: TextView
    private lateinit var commentFormAnswerContent: TextView
    private lateinit var sendAnswerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_form)

        getUIReferences()
        val extras = intent.extras
        setFormValues(extras)
        setReferences()
    }

    private fun getUIReferences()
    {
        idFormAnswerContent = find(R.id.idFormContent)
        nameFormAnswerContent = find(R.id.nameFormAnswerContent)
        dateFormAnswerContent = find(R.id.dateFormAnswerContent)
        categoryFormAnswerContent = find(R.id.categoryFormAnswerContent)
        commentFormAnswerContent = find(R.id.commentFormAnswerContent)
        sendAnswerButton = find(R.id.sendAnswerButton)
    }

    private fun setFormValues(extras: Bundle)
    {
        idFormAnswerContent.text = extras.get("formId").toString()
        nameFormAnswerContent.text = extras.get("formName").toString()
        dateFormAnswerContent.text = extras.get("formDate").toString()
        categoryFormAnswerContent.text = extras.get("formCategory").toString()
        commentFormAnswerContent.text = extras.get("formComment").toString()
    }

    private fun setReferences()
    {
        sendAnswerButton.setOnClickListener {

        }
    }
}
