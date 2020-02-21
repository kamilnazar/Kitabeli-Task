package com.kamilnazar.kitabeli.ui.grouplist

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.ui.base.BaseActivity
import javax.inject.Inject

class GroupListActivity : BaseActivity() {
    @Inject
    lateinit var providor: GroupListViewModelFactory

    val viewModel by viewModels<GroupListViewModel> { providor }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.open_group_list)
        inject()
        viewModel.groups.observe(this) { t ->
            Log.d("sdsad", t.toString())
        }
        viewModel.loadGroups()
    }

    private fun inject() {
        app.appComponent.get(GroupListModule()).inject(this)
    }
}