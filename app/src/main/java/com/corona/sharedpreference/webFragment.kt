package com.corona.sharedpreference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.web_fragment.*
import kotlinx.android.synthetic.main.web_fragment.view.*
import org.jetbrains.annotations.Nullable

class webFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.web_fragment,container,false)
        val halamanWeb : WebView = view.findViewById(R.id.webView)
            halamanWeb.webViewClient = object : WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }
            }
        halamanWeb.loadUrl("http://hendra.ml")
        halamanWeb.settings.javaScriptEnabled = true
        halamanWeb.settings.allowContentAccess = true
        halamanWeb.settings.domStorageEnabled = true
        halamanWeb.settings.useWideViewPort = true
        halamanWeb.settings.setAppCacheEnabled(true)
        view.kembali.setOnClickListener {
            if (halamanWeb.canGoBack()){halamanWeb.goBack()}
        }
        return view

    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }




}