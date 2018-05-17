package com.dagger2sample.components

import com.dagger2sample.MainActivity
import com.dagger2sample.modules.ApiModule
import com.dagger2sample.modules.ContextModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (ApiModule::class)])
interface ApiComponent {
    fun inject(mainActivity: MainActivity)
}