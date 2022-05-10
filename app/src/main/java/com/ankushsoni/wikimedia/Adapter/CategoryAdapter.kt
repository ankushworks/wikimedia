package com.ankushsoni.wikimedia.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ankushsoni.wikimedia.R
import com.ankushsoni.wikimedia.models.Category.Allcategories


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner  class  CategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    private val diffUtilCallback = object  : DiffUtil.ItemCallback<Allcategories>(){
        override fun areItemsTheSame(oldItem: Allcategories, newItem: Allcategories): Boolean {
            return oldItem.category == newItem.category
        }

        override fun areContentsTheSame(oldItem: Allcategories, newItem: Allcategories): Boolean {
            return  oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this , diffUtilCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category_preview, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val items  = differ.currentList[position]


        holder.itemView.apply {
            val  categoryText = findViewById<TextView>(R.id.categoryTest)
            categoryText.text = items.category
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}