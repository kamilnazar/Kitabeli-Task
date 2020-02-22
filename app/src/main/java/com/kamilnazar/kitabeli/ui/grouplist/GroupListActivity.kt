package com.kamilnazar.kitabeli.ui.grouplist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.ui.base.BaseActivity
import kotlinx.android.synthetic.main.open_group_list.*
import javax.inject.Inject

class GroupListActivity : BaseActivity() {
    @Inject
    lateinit var providor: GroupListViewModelFactory

    private val viewModel by viewModels<GroupListViewModel> { providor }
    private val adapter = GroupListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.open_group_list)
        inject()
        group_list.layoutManager = LinearLayoutManager(this)
        group_list.adapter = adapter
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

    private fun inject() {
        app.appComponent
            .groupListComponent()
            .inject(this)
    }
}