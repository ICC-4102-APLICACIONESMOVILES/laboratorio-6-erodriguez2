package com.example.eduardo.lab1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.LayoutInflater
import android.support.annotation.Nullable
import android.util.Log
import com.example.eduardo.lab1.Models.Form
import org.jetbrains.anko.find


class FormAdapter(mContext: Context, resource: Int, list: ArrayList<Form>) : ArrayAdapter<Form>(mContext, resource, list) {
    private var formsList = ArrayList<Form>()
    private var resourceLayout = 0

    init {
        formsList = list
        resourceLayout = resource
    }

    override fun getView(position: Int, @Nullable view: View?, parent: ViewGroup): View {

        var listItem = view

        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.form_item_layout, parent, false)
        }

        val currentForm = formsList[position]
        Log.d("currentForm", currentForm.toString())

        val name = listItem!!.find(R.id.nameForm) as TextView
        name.text = "Nombre: " + currentForm.name

        val date = listItem!!.find(R.id.dateForm) as TextView
        date.text = "Fecha: " + currentForm.date

        val comment = listItem!!.find(R.id.commentForm) as TextView
        comment.text = "Comentario: " + currentForm.comment

        return listItem
    }
}