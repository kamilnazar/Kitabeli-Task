package com.kamilnazar.kitabeli.ui.grouplist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.ui.base.BaseActivity
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

    }
}