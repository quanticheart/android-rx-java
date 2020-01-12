package com.example.rxjava.rxJava.Observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjava.R
import com.example.rxjava.utils.MsgUtil
import io.reactivex.Observable

class observerJust : AppCompatActivity() {

    /**
     * https://medium.com/@nglauber/introdu%C3%A7%C3%A3o-ao-rx-java-com-kotlin-90c58d184c6b
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Just
         */

        /**
         * Ao utilizar o método just foi criado um objeto Observable que emite apenas a String
         * "Hello RX". No método subscribe é registrado um observer/consumer/receiver dos dados
         * que serão emitidos. Com o Kotlin, isso é feito com uma simples instrução lambda, onde
         * o valor emitido é recebido como parâmetro.
         */

        Observable.just("Rx Go!").subscribe { msg ->
            MsgUtil.log(msg)
        }

        Observable.just("Rx Go!").subscribe(
            { msg -> MsgUtil.log(msg) },                      // onNext
            { e -> println(e.message) },                      // onError
            { MsgUtil.log("Just Complete, hide load") }      // onComplete
        )
    }
}
