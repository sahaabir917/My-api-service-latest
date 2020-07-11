package com.example.marsapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_new.*

/**
 * A simple [Fragment] subclass.
 */
class NewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var args = getArguments()
        var index = args!!.getString("Key","Not passed any data ")


//        webviews.loadUrl(index.toString())
//        webviews.settings.javaScriptEnabled = true  //enabled javascript
//////        webviews.webViewClient=MywebViewX()


        webviews.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        webviews.loadUrl(index.toString())
        webviews.settings.javaScriptEnabled = true

        d("data is passed",index)

    }







}


