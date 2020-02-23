package com.kamilnazar.kitabeli.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.kamilnazar.kitabeli.App

abstract class BaseActivity : AppCompatActivity() {
    val app by lazy(LazyThreadSafetyMode.NONE) { application as App }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    abstract fun inject()
}