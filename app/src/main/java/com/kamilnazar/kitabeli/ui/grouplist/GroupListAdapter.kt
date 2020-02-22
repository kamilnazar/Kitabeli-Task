package com.kamilnazar.kitabeli.ui.grouplist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.data.models.Payload
import kotlin.time.ExperimentalTime

class GroupListAdapter(private val groupList: List<Payload>) :
    RecyclerView.Adapter<GroupListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupListViewHolder {
        return GroupListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.open_group_item,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = groupList.size

    @ExperimentalTime
    override fun onBindViewHolder(holder: GroupListViewHolder, position: Int) {
        holder.bind(groupList[position])
    }
}