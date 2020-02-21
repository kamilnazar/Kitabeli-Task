package com.kamilnazar.kitabeli.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.kamilnazar.kitabeli.App

abstract class BaseActivity : AppCompatActivity() {
    val app by lazy(LazyThreadSafetyMode.NONE) { application as App }
}