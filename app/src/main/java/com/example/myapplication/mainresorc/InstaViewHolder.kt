package com.example.sopt_2ndseminar2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import org.w3c.dom.Text

class InstaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_username = itemView.findViewById<TextView>(R.id.tv_username)
    val imp_profile= itemView.findViewById<ImageView>(R.id.img_profile)
    val imp_contents= itemView.findViewById<ImageView>(R.id.img_contents)

    fun bind(instaData: InstaData){
        tv_username.text=instaData.username
        Glide.with(itemView).load(instaData.img_profile).into(imp_profile)
        Glide.with(itemView).load(instaData.img_contents).into(imp_contents)
    }
}