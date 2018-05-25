package com.dagger2sample

import android.content.Context
import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var mContext: Context


    private var mPostList = ObservableArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).getApiComponent().inject(this)

        setupRecyclerView()

        callService()
    }

    private fun setupRecyclerView() {
        rvPosts.layoutManager = LinearLayoutManager(mContext)

        LastAdapter(mPostList, BR.item)
                .map<Data>(R.layout.item_rv)
                .into(rvPosts)
    }

    private fun callService() {
        rvPosts.showShimmerAdapter()
        retrofit.create(IApi::class.java).getPosts().enqueue(object : Callback<PostResp?> {
            override fun onFailure(call: Call<PostResp?>?, t: Throwable?) {
                Log.e(TAG, "onFailure: ", t)

            }

            override fun onResponse(call: Call<PostResp?>?, response: Response<PostResp?>?) {

                mPostList.addAll(response?.body()?.data.orEmpty())

                rvPosts.hideShimmerAdapter()
            }
        })
    }
}
