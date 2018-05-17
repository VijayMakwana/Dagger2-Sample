package com.dagger2sample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.android.mvpdagger.network.IApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

data class Post(val userId: Int, val id: Int, val title: String, val body: String)

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var mContext:Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).getApiComponent().inject(this)

        callService()
    }

    private fun callService() {
        retrofit.create(IApi::class.java).getPosts().enqueue(object : Callback<List<Post>?> {
            override fun onFailure(call: Call<List<Post>?>?, t: Throwable?) {
                Log.e(TAG, "onFailure: ", t)

            }

            override fun onResponse(call: Call<List<Post>?>?, response: Response<List<Post>?>?) {
                Toast.makeText(mContext, "Got The Response", Toast.LENGTH_SHORT).show()
                tvResp.text = response?.body().toString()
            }
        })
    }
}
