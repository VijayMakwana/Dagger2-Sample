package com.dagger2sample

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Android on 5/1/2018.
 */
interface IApi {

    @GET("5b07d757320000650070006f")
    fun getPosts(): Call<PostResp>
}