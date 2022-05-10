package com.ankushsoni.wikimedia.Adapter


import android.view.InflateException
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ankushsoni.wikimedia.databinding.ItemArticlePreviewBinding
import com.ankushsoni.wikimedia.models.RandomArticle.Page


class TestArticleAdapter  : ListAdapter<Page, ArticleViewHolder>(ArticleDiffUtill()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
       val binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return  ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
       val  currentItem = getItem(position)
        holder.bind(currentItem)

    }


}


class ArticleViewHolder(val binding: ItemArticlePreviewBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(page : Page){
        binding.apply {
            expandTextView.text = page.extract
            articleTitle.text = page.title
        }
    }
}

class ArticleDiffUtill : DiffUtil.ItemCallback<Page>(){

    override fun areItemsTheSame(oldItem: Page, newItem: Page): Boolean {
        return oldItem.pageid == newItem.pageid
    }

    override fun areContentsTheSame(oldItem: Page, newItem: Page): Boolean {
        return  oldItem == newItem
    }

}

