package com.journeyid.sdk.sample

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import io.journeyid.drawer.application.Journey

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Journey.init(this)
    }
}