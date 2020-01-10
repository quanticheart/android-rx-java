package com.example.rxjava.observableEObserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjava.R
import com.example.rxjava.utils.MsgUtil
import io.reactivex.Observable

class MainActivity : AppCompatActivity() {

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

        /**
         * from
         */

        /**
         * Existem algumas variações do método from para criar um Observable.
         * Abaixo estão sendo listadas duas delas:
         */

        /**
         * Os nomes dos métodos são auto-explicativos. Perceba que o lambda passado para no subscribe
         * passado para o Observable criado pelo método fromArray é chamado 3 vezes
         * (uma para cada item emitido). Outro detalhe desse exemplo é que foram passados
         * três lambdas para o Observable criado com o fromIterable que representam respectivamente
         * os métodos: onNext, onError e onComplete.
         */

        Observable.fromArray("Google", "Micro", "App").subscribe { array ->
            MsgUtil.log(array)
        }

        Observable.fromIterable(listOf("Google", "Micro", "App")).subscribe(
            { MsgUtil.log(it) },                               // onNext
            { e -> println(e.message) },                      // onError
            { MsgUtil.log("fromIterable Complete, hide load") }      // onComplete
        )
    }
}
