package com.dagger2sample

import android.app.Application
import com.dagger2sample.components.ApiComponent
import com.dagger2sample.components.DaggerApiComponent
import com.dagger2sample.modules.ApiModule
import com.dagger2sample.modules.ContextModule

class MyApplication : Application() {

    private lateinit var mApiComponent: ApiComponent

    override fun onCreate() {
        super.onCreate()

        mApiComponent = DaggerApiComponent.builder()
                .contextModule(ContextModule(applicationContext))
                .apiModule(ApiModule())
                .build()
    }

    fun getApiComponent(): ApiComponent {
        return mApiComponent
    }

}