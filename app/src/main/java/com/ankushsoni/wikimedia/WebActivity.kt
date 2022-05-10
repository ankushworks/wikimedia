package com.ankushsoni.wikimedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.ankushsoni.wikimedia.databinding.ActivityMainBinding
import com.ankushsoni.wikimedia.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    private lateinit var webView : WebView
    private  var url : String? = null
    lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        url = intent.getStringExtra("URL").toString()

        binding.apply {
            webView.loadUrl(url!!)
            webView.settings.loadWithOverviewMode = true
            webView.settings.useWideViewPort = true
        }

    }
}