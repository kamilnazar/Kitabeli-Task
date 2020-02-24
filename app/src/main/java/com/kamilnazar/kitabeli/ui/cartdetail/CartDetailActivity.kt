package com.kamilnazar.kitabeli.ui.cartdetail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.databinding.CartActivityBinding
import com.kamilnazar.kitabeli.ui.base.BaseActivity
import com.kamilnazar.kitabeli.ui.grouplist.GroupListActivity
import it.sephiroth.android.library.numberpicker.doOnProgressChanged
import javax.inject.Inject

class CartDetailActivity : BaseActivity() {
    @Inject
    lateinit var factory: CartDetailViewModelFactory

    private val groupId by lazy(LazyThreadSafetyMode.NONE) { intent.getIntExtra(GROUP_ID, 0) }
    private val quantity by lazy(LazyThreadSafetyMode.NONE) { intent.getIntExtra(QUANTITY, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<CartActivityBinding>(this, R.layout.cart_activity)
        binding.lifecycleOwner = this
        val viewModel by viewModels<CartViewModel> { factory }
        binding.viewModel = viewModel

        binding.quantityPickerCart.progress = quantity
        viewModel.itemQuantity.value = quantity
        binding.quantityPickerCart.doOnProgressChanged { _, progress, _ ->
            viewModel.itemQuantity.value = progress
        }
        binding.groupDetailAddToCart.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Purchase Success")
                .setMessage("You have  purchased ${viewModel.group.value?.itemDTO?.name} for ${viewModel.totalPrice.value}")
                .setPositiveButton("OK") { _, _ ->
                    GroupListActivity.start(this)
                }.show()
        }
    }

    override fun inject() {
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