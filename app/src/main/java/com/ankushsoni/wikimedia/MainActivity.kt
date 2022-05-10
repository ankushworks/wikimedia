package com.ankushsoni.wikimedia


import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.androiddevs.mvvmnewsapp.Adapter.ViewPagerAdapter
import com.ankushsoni.wikimedia.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.viewPager2.adapter = viewPagerAdapter



        setupViewPagerItems()


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        val itemswitch: MenuItem = menu.findItem(R.id.switch_action_bar)
        itemswitch.setActionView(R.layout.use_switch)
        val sw = menu.findItem(R.id.switch_action_bar).actionView.findViewById<View>(R.id.switch2) as SwitchMaterial



        sw.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            if(!isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }


        return true
    }


    private fun setupViewPagerItems() {
        TabLayoutMediator(binding.tabLayout,binding.viewPager2){ tab, position ->
            when(position){
                0 -> {
                    tab.text = "Article"
                }
                1-> {
                    tab.text = "Images"
                }
                2 -> {
                    tab.text = "Categories"
                }
            }
        }.attach()
    }
}