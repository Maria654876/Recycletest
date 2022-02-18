package com.example.recycletest.sevenClass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycletest.setting.Lessons
import com.example.recycletest.R
import com.google.android.material.imageview.ShapeableImageView
import java.nio.file.DirectoryStream

class SevenAdapter(private  val lesList: ArrayList<Lessons>) : RecyclerView.Adapter<SevenAdapter.SevenHolder>() {

private lateinit var  mListener : onItemClickListener


    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    var itemModelList = ArrayList<Lessons>()

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SevenHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.seven_item, parent, false)

        return SevenHolder(itemView, mListener)

    }

    override fun onBindViewHolder(holder: SevenHolder, position: Int) {
        val currentItem = lesList[position]
        holder.titleImage.setImageResource(currentItem.image)
        holder.tvHeading.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return lesList.size
    }

    class SevenHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.image_top)
        val tvHeading : TextView = itemView.findViewById(R.id.text_title)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }



}