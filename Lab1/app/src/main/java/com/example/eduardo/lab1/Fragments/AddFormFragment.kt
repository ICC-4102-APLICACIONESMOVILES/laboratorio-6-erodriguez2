package com.example.eduardo.lab1.Fragments


import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.eduardo.lab1.Models.Form
import com.example.eduardo.lab1.FormDatabase

import com.example.eduardo.lab1.R
import org.jetbrains.anko.support.v4.find


/**
 * A simple [Fragment] subclass.
 */
class AddFormFragment : Fragment() {

    private lateinit var formDatabase: FormDatabase
    private lateinit var nameFormContent : EditText
    private lateinit var dateFormContent : EditText
    private lateinit var categoryFormContent : Spinner
    private lateinit var commentaryFormContent : EditText
    private lateinit var addFormButton : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var list_of_items = arrayOf("Categoria 1", "Categoria 2", "Categoria 3")

        val DATABASE_NAME = "form_db"
        formDatabase = Room.databaseBuilder(view.context,
                FormDatabase::class.java, DATABASE_NAME)
                .build()

        getUIReferences()
        setListeners()

        val aa = ArrayAdapter(view.context, android.R.layout.preference_category, list_of_items)
        categoryFormContent!!.adapter = aa
    }

    private fun getUIReferences(){
        nameFormContent = find(R.id.nameFormContent)
        dateFormContent = find(R.id.dateFormContent)
        categoryFormContent = find(R.id.categoryFormContent)
        commentaryFormContent = find(R.id.commentaryFormContent)
        addFormButton = find(R.id.addFormButton)
    }

    private fun setListeners(){
        addFormButton.setOnClickListener {
            Thread(Runnable {
                val form = Form()
                form.name = nameFormContent.text.toString()
                form.date = dateFormContent.text.toString()
                form.category = categoryFormContent.selectedItem.toString()
                form.comment = commentaryFormContent.text.toString()
                formDatabase.daoAccess().insertOnlySingleForm(form)
            }).start()
        }
    }

}// Required empty public constructor
