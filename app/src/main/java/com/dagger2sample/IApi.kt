package com.example.android.mvpdagger.network

import com.dagger2sample.Post
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Android on 5/1/2018.
 */
interface IApi {

    @GET("/posts")
    fun getPosts(): Call<List<Post>>
}