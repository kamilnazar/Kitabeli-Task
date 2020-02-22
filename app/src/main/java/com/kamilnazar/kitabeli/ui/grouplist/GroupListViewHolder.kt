package com.kamilnazar.kitabeli.ui.grouplist

import android.os.CountDownTimer
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kamilnazar.kitabeli.data.models.Payload
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.open_group_item.view.*
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds

class GroupListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var timer: CountDownTimer? = null
    @ExperimentalTime
    fun bind(payload: Payload) {
        itemView.item_name.text = payload.itemDTO?.name
        Picasso.get()
            .load(payload.itemDTO?.images?.get(0))
            .into(itemView.group_image)
        itemView.item_price.text = "Rp ${payload.itemPrice}"
        itemView.group_price.text = "Rp ${payload.groupPrice}"
        itemView.group_join_button.text = buttontext(payload)
        timer?.cancel()
        val timeRemaining = (payload.expireAt ?: 0) * 1000 - System.currentTimeMillis()

        if (timeRemaining > 0) {
            enableView(itemView)
            timer = object : CountDownTimer(timeRemaining, 1000) {
                override fun onFinish() {
                    disableView(itemView)
                }

                override fun onTick(millisUntilFinished: Long) {
                    millisUntilFinished.milliseconds.toComponents { hours, minutes, seconds, _ ->
                        itemView.group_timer.text = "$hours : $minutes : $seconds"
                    }
                }
            }.start()
        } else disableView(itemView)
    }

    private fun buttontext(payload: Payload): String {
        val text = StringBuilder("Buy with ${payload.leaderName}")
        if (payload.groupMemberIds?.isNotEmpty() == true) {
            text.append(" and ${payload.groupMemberIds.size} others")
        }
        return text.toString()
    }

    private fun disableView(itemView: View) {
        itemView.root.isEnabled = false
        itemView.root.alpha = 0.5f
        itemView.group_timer.text = "0 : 00 : 00"
        itemView.group_join_button.isEnabled = false
    }

    private fun enableView(itemView: View) {
        itemView.root.isEnabled = true
        itemView.root.alpha = 1f
        itemView.group_join_button.isEnabled = true
    }
}