package com.programmer.helloworld

import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    //Image list
    private val images = intArrayOf(
        R.drawable.cardview_7,
        R.drawable.cardview_8,
        R.drawable.cardview_9,
        R.drawable.cardview_10,
        R.drawable.cardview_11,
        R.drawable.cardview_12)
    //Title list
    private val titles = arrayOf(
        "1 Facial Wash MS Glow",
        "2 Day Cream MS Glow",
        "3 Night Cream MS Glow",
        "4 Toner MS Glow",
        "5 Red Jelly MS Glow",
        "6 Serum MS Glow")
    //Detail list
    private val details = arrayOf(
        "membantu membersihkan wajah dari jerawat",
        "Mkandungan vitamin whitening dan anti acne bermanfaat utk mencerahkan dan glowing mengkilap",
        "memudarkan bekas jerawat, flek hitam, hingga kulit bopeng.",
        "mempercepat regenerasi sel kulit mati",
        "mempercepat regenerasi sel kulit mati",
        "mengangkat sel-sel kulit mati dan menghilangkan komedo sehingga membuat kulit terlihat lebih cerah.")
    //ViewHolder class
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init{
            itemImage = itemView.findViewById(R.id.cardImage)
            itemTitle = itemView.findViewById(R.id.cardTitle)
            itemDetail = itemView.findViewById(R.id.cardDetail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click on item ${titles[position]}",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }

    }

    //onCreateViewHolder()
    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(ViewGroup.context)
            .inflate(R.layout.card_layout, ViewGroup, false)
        return ViewHolder(v)
    }
    //onBindViewHolder()
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }
    //getItemCount()
    override fun getItemCount(): Int {
        return titles.size
    }
}