package com.example.marsapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.typerow.view.*
import org.w3c.dom.Text
import java.lang.reflect.Type

class TypesAdapter(private val types : List<Typedata>) : RecyclerView.Adapter<TypesAdapter.ViewHolder>() {

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val typeing :TextView = itemView.types
        val body : TextView = itemView.body
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.typerow,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = types.size

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.typeing.text = types[position].userId.toString()
        holder.body.text = types[position].body
    }
}