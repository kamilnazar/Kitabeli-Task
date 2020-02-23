package com.kamilnazar.kitabeli.ui.cartdetail

import android.content.Intent
import android.os.Bundle
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.ui.base.BaseActivity

class CartDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)
    }

    override fun inject() {

    }

    companion object {
        @JvmStatic
        fun start(activity: BaseActivity) {
            activity.startActivity(Intent(activity, CartDetailActivity::class.java))
        }
    }
}