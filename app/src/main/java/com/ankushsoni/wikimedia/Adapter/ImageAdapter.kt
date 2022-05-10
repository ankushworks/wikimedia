package com.ankushsoni.wikimedia.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ankushsoni.wikimedia.R
import com.ankushsoni.wikimedia.models.featuredImages.Page
import com.bumptech.glide.Glide
import android.util.Log
import android.webkit.WebView


class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner  class  ImageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    private val diffUtilCallback = object  : DiffUtil.ItemCallback<Page>(){
        override fun areItemsTheSame(oldItem: Page, newItem: Page): Boolean {
            return oldItem.pageid == newItem.pageid
        }

        override fun areContentsTheSame(oldItem: Page, newItem: Page): Boolean {
            return  oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this , diffUtilCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_images_preview, parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val pages = differ.currentList[position]

        holder.itemView.apply {
             val imageUrl = pages.imageinfo.map { it.url}[0]
             val user = pages.imageinfo.map { it.user }[0]
             val articleLink  = pages.imageinfo.map { it.descriptionshorturl }[0]

             Glide.with(this).load(imageUrl).into(findViewById<ImageView>(R.id.ivImage))
             findViewById<TextView>(R.id.title).text = pages.title.replace("File:" , "")
             findViewById<TextView>(R.id.byUser).text = user
             setOnClickListener {
                 onItemClickListener?.let {
                     it(pages)
                 }
             }
        }
    }


    private var onItemClickListener : ((Page) -> Unit)? = null

    fun setonClickListener(listener : (Page) -> Unit){
        onItemClickListener = listener
    }



    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}