package com.kamilnazar.kitabeli.ui.groupdetail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.ui.base.BaseActivity
import kotlinx.android.synthetic.main.group_detail.*
import javax.inject.Inject

class GroupDetailActivity : BaseActivity() {

    @Inject
    lateinit var factory: GroupDetailViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.group_detail)
        val viewModel by viewModels<GroupDetailViewModel> { factory }

        viewModel.group.observe(this) { payload ->
            image_slider.setSliderAdapter(GroupImageSliderAdapter(payload?.itemDTO?.images ?: listOf<String>()))
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