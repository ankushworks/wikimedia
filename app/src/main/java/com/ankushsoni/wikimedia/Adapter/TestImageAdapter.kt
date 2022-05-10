package com.ankushsoni.wikimedia.Adapter


import android.view.InflateException
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ankushsoni.wikimedia.R
import com.ankushsoni.wikimedia.databinding.ItemArticlePreviewBinding
import com.ankushsoni.wikimedia.databinding.ItemImagesPreviewBinding
import com.ankushsoni.wikimedia.models.featuredImages.Page
import com.bumptech.glide.Glide


class TestImageAdapter  : ListAdapter<Page, TestImageAdapter.ImageViewHolder>(ImageDiffUtill()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImagesPreviewBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return  ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val  currentItem = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(currentItem)
            }
        }
        holder.bind(currentItem)

    }

    private var onItemClickListener : ((Page) -> Unit)? = null

    fun setonClickListener(listener : (Page) -> Unit){
        onItemClickListener = listener
    }


   inner class ImageViewHolder(val binding: ItemImagesPreviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(page : Page){

            val imageUrl = page.imageinfo.map { it.url}[0]
            val user = page.imageinfo.map { it.user }[0]
            val articleLink  = page.imageinfo.map { it.descriptionshorturl }[0]

            binding.apply {
                title.text = page.title.replace("File:" , "")
                byUser.text = user
                Glide.with(itemView).load(imageUrl).into(ivImage)

            }


        }
    }



}



class ImageDiffUtill : DiffUtil.ItemCallback<Page>(){

    override fun areItemsTheSame(oldItem: Page, newItem: Page): Boolean {
        return oldItem.pageid == newItem.pageid
    }

    override fun areContentsTheSame(oldItem: Page, newItem: Page): Boolean {
        return  oldItem == newItem
    }

}

