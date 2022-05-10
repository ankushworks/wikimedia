package com.ankushsoni.wikimedia.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ankushsoni.wikimedia.databinding.ItemCategoryPreviewBinding

import com.ankushsoni.wikimedia.models.Category.Allcategories



class TestCategoryAdapter : ListAdapter<Allcategories, TestCategoryAdapter.CategoryViewHolder>(CategoryDiffUitll()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
         val binding = ItemCategoryPreviewBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
         return  CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem =  getItem(position)
        holder.bind(currentItem)
    }

    class CategoryViewHolder(private val binding : ItemCategoryPreviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(allCategory: Allcategories) {
            binding.apply {
                categoryTest.text = allCategory.category
            }
        }

    }

    class CategoryDiffUitll : DiffUtil.ItemCallback<Allcategories>() {
        override fun areItemsTheSame(oldItem: Allcategories, newItem: Allcategories): Boolean {
            return oldItem.category == newItem.category
        }

        override fun areContentsTheSame(oldItem: Allcategories, newItem: Allcategories): Boolean {
            return  oldItem == newItem
        }
    }



}