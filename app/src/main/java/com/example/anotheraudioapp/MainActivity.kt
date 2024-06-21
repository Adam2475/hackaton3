package com.example.anotheraudioapp

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Casting WebView in main activity
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Assign the view to the new variable
        webView = findViewById<WebView>(R.id.webview)
        webView.settings.builtInZoomControls = true;
        // Enabling javascript
        webView.settings.javaScriptEnabled = true
        // Adding WebView functionality
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()


        // Load the HTML file from assets
        webView.loadUrl("file:///android_asset/{index.html}")
    }
}