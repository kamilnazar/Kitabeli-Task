package com.kamilnazar.kitabeli.ui.cartdetail

import dagger.Subcomponent

@CartScope
@Subcomponent(modules = [CartModule::class])
interface CartComponent {
    fun inject(activity: CartDetailActivity)
}