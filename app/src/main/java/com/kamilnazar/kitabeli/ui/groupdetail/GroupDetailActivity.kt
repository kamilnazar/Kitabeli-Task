package com.kamilnazar.kitabeli.ui.groupdetail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.ui.base.BaseActivity
import com.kamilnazar.kitabeli.ui.cartdetail.CartDetailActivity
import com.kamilnazar.kitabeli.util.disableView
import com.kamilnazar.kitabeli.util.enableView
import com.kamilnazar.kitabeli.util.round
import it.sephiroth.android.library.numberpicker.doOnProgressChanged
import kotlinx.android.synthetic.main.group_detail.*
import kotlinx.android.synthetic.main.group_detail_content.*
import java.text.NumberFormat
import javax.inject.Inject

class GroupDetailActivity : BaseActivity() {

    @Inject
    lateinit var factory: GroupDetailViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.group_detail)
        val viewModel by viewModels<GroupDetailViewModel> { factory }
        val numberFormat = NumberFormat.getNumberInstance()
        quantity_picker.doOnProgressChanged { _, progress, _ ->
            viewModel.quantity = progress
        }
        group_detail_add_to_cart.disableView()
        viewModel.group.observe(this) { payload ->
            if (payload != null) {
                group_detail_add_to_cart.enableView()
                viewModel.quantity = 1
                image_slider.setSliderAdapter(
                    GroupImageSliderAdapter(
                        payload.itemDTO?.images ?: listOf<String>()
                    )
                )
                product_name.text = payload.itemDTO?.name
                group_price.text = "Rp ${numberFormat.format(payload.groupPrice)}"
                item_price.text = "Rp ${numberFormat.format(payload.itemPrice)}"
                ratingBar.rating = payload.itemDTO?.rating?.toFloat() ?: 0.0f
                rating.text = (payload.itemDTO?.rating?.toDouble()?.round(2) ?: 0.0).toString()
                description.text = payload.itemDTO?.description?.description
            }
        }
        viewModel.totalPrice.observe(this) { totalPrice ->
            total_price.text = "Rp ${numberFormat.format(totalPrice)}"
        }
        group_detail_add_to_cart.setOnClickListener {
            val groupId = viewModel.group.value?.id ?: 0
            val quantity = viewModel.quantity
            CartDetailActivity.start(this, groupId, quantity)
        }
    }

    override fun inject() {
        val groupId = intent.getIntExtra(GROUP_ID, 0)
        app.appComponent
            .groupDetailComponent(GroupDetailModule(groupId))
            .inject(this)
    }

    companion object {
        private const val GROUP_ID = "com.kitabeli.group_id"
        @JvmStatic
        fun start(activity: BaseActivity, groupId: Int) {
            activity.startActivity(Intent(activity, GroupDetailActivity::class.java).apply {
                putExtra(GROUP_ID, groupId)
            })
        }
    }
}