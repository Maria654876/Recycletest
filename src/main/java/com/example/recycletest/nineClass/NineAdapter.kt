package com.example.recycletest.nineClass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycletest.setting.Lessons
import com.example.recycletest.R
import com.google.android.material.imageview.ShapeableImageView

class NineAdapter(private  val lesList: ArrayList<Lessons>) : RecyclerView.Adapter<NineAdapter.NineHolder>() {

    private lateinit var  mListener : NineAdapter.onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class NineHolder(itemView: View, listener: NineAdapter.onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.image_top)
        val tvHeading : TextView = itemView.findViewById(R.id.text_title)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NineHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.seven_item, parent, false)

        return NineAdapter.NineHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: NineHolder, position: Int) {
        val currentItem = lesList[position]
        holder.titleImage.setImageResource(currentItem.image)
        holder.tvHeading.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return lesList.size
    }
}