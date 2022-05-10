package com.androiddevs.mvvmnewsapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ankushsoni.wikimedia.ui.fragment.CategoryFragment
import com.ankushsoni.wikimedia.ui.fragment.ArticleFragment
import com.ankushsoni.wikimedia.ui.fragment.ImagesFragment


class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
       return when(position){
            0->{
                ArticleFragment()
            }
            1->{
                ImagesFragment()
            }
            2 -> {
                CategoryFragment()
            }
            else -> {
                ArticleFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return NUM_OF_FRAGMENT
    }

    companion object {
        private const val NUM_OF_FRAGMENT = 3
    }
}