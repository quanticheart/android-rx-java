package com.example.rxjava.createObservable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjava.R
import com.example.rxjava.utils.MsgUtil
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class CreateObservable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        /**
         * Create
         */
        getObservableFromList(listOf("Google", "", "Micro")).subscribe(
            { result -> MsgUtil.log(result) },
            { e -> MsgUtil.log(e.message ?: "") },
            { MsgUtil.log("Custom Complete") }
        )

        /**
         * interval
         */
        getSimpleIntervalRange().subscribe(
            { result -> MsgUtil.log(result.toString()) },
            { e -> MsgUtil.log(e.message ?: "") },
            { MsgUtil.log("intervalRange Complete") }
        )
    }

    /**
     * create
     */

    /**
     * Permite criar um Observable “do zero”. Assim, cabe a você chamar cada método do Observer:
     * onNext para cada item emitido; onComplete ao terminar a sequência; e onError em caso de erro.
     */

    /**
     * A função acima está criando um Observable que emitirá os itens de uma lista. Caso algum
     * item da lista seja vazio, um erro será gerado e a sequência será interrompida.
     * Perceba que o parâmetro emitter será responsável por chamar os métodos onNext,
     * onComplete e eventualmente o onError.
     */

    private fun getObservableFromList(lista: List<String>) =
        Observable.create<String> { emitter ->
            lista.forEach { nome ->
                if (nome == "") {
                    emitter.onError(Exception("Valor em branco"))
                }
                emitter.onNext(nome)
            }
            emitter.onComplete()
        }

    /**
     * interval
     */

    /**
     * O método interval retorna um Observable que emite uma sequência crescente de
     * inteiros em um intervalo de tempo constante e configurável.
     */

    /**
     * Nesse exemplo, a emissão é feita a cada um segundo. Se você executar esse código na
     * classe de teste como foi mencionado no inicio do artigo, apenas o primeiro item será emitido.
     * Nesse caso você deverá adicionar um Thread.sleep(6_000) que fará com que o teste aguarde 6
     * segundos (1 a mais que o nosso Observable precisa.
     */

    private fun getSimpleIntervalRange() =
        Observable.intervalRange(
            50L, // start
            11L, // count
            0L, // initial delay
            1L, // period
            TimeUnit.SECONDS
        )
}