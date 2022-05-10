package com.ankushsoni.wikimedia.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ankushsoni.wikimedia.R
import com.ankushsoni.wikimedia.models.RandomArticle.Page
import com.ms.square.android.expandabletextview.ExpandableTextView


class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    inner  class  ArticleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    private val diffUtilCallback = object  : DiffUtil.ItemCallback<Page>(){
        override fun areItemsTheSame(oldItem: Page, newItem: Page): Boolean {
            return oldItem.pageid == newItem.pageid
        }

        override fun areContentsTheSame(oldItem: Page, newItem: Page): Boolean {
            return  oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this , diffUtilCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article_preview, parent, false))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val pages  = differ.currentList[position]


        holder.itemView.apply {
            val expandableTextView = this.findViewById<ExpandableTextView>(R.id.expand_text_view)
            val articleTitle = this.findViewById<TextView>(R.id.articleTitle)
            expandableTextView.text = pages.extract
            articleTitle.text = pages.title
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}



