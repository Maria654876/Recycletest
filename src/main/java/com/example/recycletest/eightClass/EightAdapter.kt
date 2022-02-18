package com.example.recycletest.eightClass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycletest.setting.Lessons
import com.example.recycletest.R
import com.google.android.material.imageview.ShapeableImageView

class EightAdapter (private  val lesList: ArrayList<Lessons>) : RecyclerView.Adapter<EightAdapter.EightHolder>() {

    private lateinit var  mListener : onItemClickListener


    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListene(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EightAdapter.EightHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.seven_item, parent, false)

        return EightAdapter.EightHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: EightAdapter.EightHolder, position: Int) {
        val currentItem = lesList[position]
        holder.titleImage.setImageResource(currentItem.image)
        holder.tvHeading.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return lesList.size
    }

    class EightHolder(itemView: View, listener: EightAdapter.onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.image_top)
        val tvHeading : TextView = itemView.findViewById(R.id.text_title)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

}