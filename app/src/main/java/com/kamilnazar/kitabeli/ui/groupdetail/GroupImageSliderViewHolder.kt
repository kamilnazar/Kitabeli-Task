package com.kamilnazar.kitabeli.ui.groupdetail

import android.view.View
import com.kamilnazar.kitabeli.R
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.group_detail_slider_image.view.*

class GroupImageSliderViewHolder(view: View) : SliderViewAdapter.ViewHolder(view) {
    fun bind(url: String?) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_image_black_24dp)
            .into(itemView.group_item_image)
    }
}