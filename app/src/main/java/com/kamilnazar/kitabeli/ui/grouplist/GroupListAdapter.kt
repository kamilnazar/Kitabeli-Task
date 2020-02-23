package com.kamilnazar.kitabeli.ui.grouplist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.data.models.Payload
import kotlin.time.ExperimentalTime

class GroupListAdapter(private val groupClickListner: GroupClickListner) :
    PagedListAdapter<Payload, GroupListViewHolder>(DIFF_UTIL) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupListViewHolder {
        return GroupListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.open_group_item,
                parent, false
            ),groupClickListner
        )
    }


    @ExperimentalTime
    override fun onBindViewHolder(holder: GroupListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Payload>() {
            override fun areItemsTheSame(oldItem: Payload, newItem: Payload): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Payload, newItem: Payload): Boolean =
                oldItem == newItem
        }
    }
}