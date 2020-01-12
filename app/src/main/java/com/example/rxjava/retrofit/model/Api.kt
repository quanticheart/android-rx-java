package com.example.rxjava.retrofit.model

import com.example.rxjava.retrofit.domain.post.Post
import com.example.rxjava.retrofit.model.client.RetrofitClient.getConnect
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

object Api {

    /**
     * This site for get new ApiToken
     *
     * https://gorest.co.in/rest-console.html
     */

    fun getPost() {
        getConnect().getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : SingleObserver<Post> {
                override fun onSuccess(t: Post) {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }
            })
    }
}