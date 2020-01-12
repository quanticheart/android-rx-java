package com.example.rxjava.retrofit.model

import com.example.rxjava.retrofit.domain.post.Post
import io.reactivex.Single
import retrofit2.http.GET

interface ApiList {
    @GET("posts")
    fun getPosts(): Single<Post>
}