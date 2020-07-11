package com.example.marsapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row.view.*

class MarsAdapter(private val mars: List<Marsdata>) :RecyclerView.Adapter<MarsAdapter.ViewHolder>() {

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

       val type : TextView = itemview.type
        val id : TextView = itemview.text2
        val imageView : ImageView = itemview.image2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent ,false)
        return ViewHolder(view)

    }

    override fun getItemCount() = mars.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.type.text = mars[position].type
        holder.id.text = mars[position].id
        Picasso.get().load(mars[position].img_src).into(holder.imageView)
    }
}