package com.kamilnazar.kitabeli.ui.grouplist

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.data.models.Payload
import com.kamilnazar.kitabeli.ui.base.BaseActivity
import com.kamilnazar.kitabeli.ui.cartdetail.CartDetailActivity
import com.kamilnazar.kitabeli.ui.groupdetail.GroupDetailActivity
import kotlinx.android.synthetic.main.open_group_list.*
import javax.inject.Inject

class GroupListActivity : BaseActivity(), GroupClickListner {
    @Inject
    lateinit var providor: GroupListViewModelFactory

    private val adapter = GroupListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.open_group_list)
        group_list.layoutManager = LinearLayoutManager(this)
        group_list.adapter = adapter

        val viewModel by viewModels<GroupListViewModel> { providor }
        viewModel.groups.observe(this) { groupList ->
            adapter.submitList(groupList)
        }
        viewModel.loading.observe(this) { loading ->
            swipe_refresh_layout.isRefreshing = loading
        }
        swipe_refresh_layout.setOnRefreshListener {
            viewModel.loadGroups()
        }
        viewModel.loadGroups()
    }

    override fun inject() {
        app.appComponent
            .groupListComponent()
            .inject(this)
    }

    override fun groupDetail(groupId: Int?) {
        if (groupId != null) {
            GroupDetailActivity.start(this, groupId)
        }
    }

    override fun joinGroup(groupId: Int?, quantity: Int?) {
        if (groupId != null)
            CartDetailActivity.start(this, groupId, 1)
    }

    override fun shareGroup(payload: Payload?) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = "Buy ${payload?.itemDTO?.name} for Rp ${payload?.groupPrice}."
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "App link")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Share Product Via :"))
    }

    companion object {
        @JvmStatic
        fun start(activity: BaseActivity) {
            activity.startActivity(Intent(activity, GroupListActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
        }
    }
}