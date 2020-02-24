package com.kamilnazar.kitabeli.ui.cartdetail

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamilnazar.kitabeli.R
import com.kamilnazar.kitabeli.data.models.Payload
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.squareup.picasso.Picasso
import java.text.NumberFormat


class CartViewModel(
    private val groudId: Int,
    private val quantity: Int,
    private val groupRepository: GroupRepository
) : ViewModel() {

    val group = groupRepository.groupById(groudId)
    var itemQuantity = MutableLiveData<Int>().apply { value = 0 }
    val priceCalculation = MediatorLiveData<String>()
    val totalPrice = MediatorLiveData<String>()

    private val numberFormat: NumberFormat = NumberFormat.getNumberInstance()

    init {
        priceCalculation.addSource(
            itemQuantity
        ) { qty ->
            priceCalculation.value = priceCalculationString(group.value?.groupPrice, qty)
            totalPrice.value = totalPrice(group.value?.groupPrice, qty)
        }
        priceCalculation.addSource(
            group
        ) { grp ->
            priceCalculation.value = priceCalculationString(grp?.groupPrice, itemQuantity.value)
            totalPrice.value = totalPrice(grp?.groupPrice, itemQuantity.value)
        }


    }

    private fun priceCalculationString(price: Int?, quantity: Int?) = "$price x $quantity"
    private fun totalPrice(price: Int?, quantity: Int?) =
        "Rp ${numberFormat.format((price ?: 0) * (quantity ?: 0))}"

    companion object {
        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun loadImage(view: ImageView, payload: Payload?) {
            Picasso.get()
                .load(payload?.itemDTO?.images?.get(0))
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(view)
        }
    }
}