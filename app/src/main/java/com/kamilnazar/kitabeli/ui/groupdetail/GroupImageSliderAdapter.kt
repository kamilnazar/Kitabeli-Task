package com.kamilnazar.kitabeli.ui.groupdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kamilnazar.kitabeli.R
import com.smarteist.autoimageslider.SliderViewAdapter

class GroupImageSliderAdapter(private val images: List<String?>) :
    SliderViewAdapter<GroupImageSliderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?): GroupImageSliderViewHolder {
        return GroupImageSliderViewHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.group_detail_slider_image,
                parent,
                false
            )
        )
    }

    override fun getCount(): Int = images.size

    override fun onBindViewHolder(viewHolder: GroupImageSliderViewHolder?, position: Int) {
        viewHolder?.bind(images[position])
    }
}