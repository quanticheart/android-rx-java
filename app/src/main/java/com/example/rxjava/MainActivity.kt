package com.example.rxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjava.R
import com.example.rxjava.retrofit.model.Api
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Api.getPost()
    }
}