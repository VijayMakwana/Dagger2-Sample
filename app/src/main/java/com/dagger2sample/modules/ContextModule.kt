package com.dagger2sample.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule(context:Context) {

    private var mContext = context

    @Provides
    @Singleton
    fun provideContext(): Context {
        return mContext
    }
}