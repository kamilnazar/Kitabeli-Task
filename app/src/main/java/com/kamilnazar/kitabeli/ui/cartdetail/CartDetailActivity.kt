package com.kamilnazar.kitabeli.ui.cartdetail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.databinding.CartActivityBinding
import com.kamilnazar.kitabeli.ui.base.BaseActivity
import javax.inject.Inject

class CartDetailActivity : BaseActivity() {
    @Inject
    lateinit var factory: CartDetailViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<CartActivityBinding>(this, R.layout.cart_activity)
        binding.lifecycleOwner = this
        val viewModel by viewModels<CartViewModel> { factory }
        binding.viewModel = viewModel
    }

    override fun inject() {
        val groupId = intent.getIntExtra(GROUP_ID, 0)
        val quantity = intent.getIntExtra(QUANTITY, 0)
        app.appComponent
            .cartComponent(CartModule(groupId, quantity))
            .inject(this)
    }

    companion object {
        private const val GROUP_ID = "group_id"
        private const val QUANTITY = "quantity"
        @JvmStatic
        fun start(activity: BaseActivity, groupId: Int, quantity: Int) {
            activity.startActivity(Intent(activity, CartDetailActivity::class.java).apply {
                putExtra(GROUP_ID, groupId)
                putExtra(QUANTITY, quantity)
            })
        }
    }
}