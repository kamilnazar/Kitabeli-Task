package com.kamilnazar.kitabeli.ui.base;


import androidx.lifecycle.ViewModel;

import com.kamilnazar.kitabeli.di.component.DaggerViewModelInjector;
import com.kamilnazar.kitabeli.di.component.ViewModelInjector;
import com.kamilnazar.kitabeli.di.modules.NetworkModule;

public abstract class BaseViewModel extends ViewModel {
//    private static final String BASE_URL = "https://walaba.id/api/v1/group/test";
//    private ViewModelInjector injector;
//
//    BaseViewModel() {
//        this.inject(getInjector());
//    }
//
//    abstract void inject(ViewModelInjector injector);
//
//    private ViewModelInjector getInjector() {
//        if (injector == null)
//            injector = DaggerViewModelInjector.builder()
//                    .networkModule(new NetworkModule(BASE_URL))
//                    .build();
//        return injector;
//    }
}
