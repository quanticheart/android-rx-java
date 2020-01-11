package com.example.rxjava.Emitter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjava.R
import com.example.rxjava.utils.MsgUtil
import io.reactivex.*
import java.util.concurrent.TimeUnit

class EmitterFlowable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Tipos de emissores
         */

        /**
         * Até agora falamos apenas do tipo de emissor Observable mas o RX possui outros tipos:
         */
    }

    override fun onResume() {
        super.onResume()
        /**
         * Flowable
         */

        /**
         * Flowable (onNext, onError e onComplete) igual ao Observable,
         * mas suporta o conceito de Back pressure.
         */

        Flowable.create<String> ({ emitter ->
            emitter.onNext("Hello Flowable")
            emitter.onComplete()
            emitter.onError(Exception())
        }, BackpressureStrategy.BUFFER)
    }

}