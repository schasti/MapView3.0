package com.example.mapview

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.mapview.ui.theme.MapViewTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WebViewPage("")
                    WebViewPage("2")
                }
            }
        }
    }
}
val num =1

@Composable
fun WebViewPage(beacon : String) {
    AndroidView(factory = {
        val apply = WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl("file:///android_asset/Html.html")
        }
        apply.settings.javaScriptEnabled = true
        apply
    }, //update = { it.loadUrl("file:///android_asset/Html.html"})
        update = {it.loadUrl("javascript:changeBluetooth("+beacon+")")})
}
