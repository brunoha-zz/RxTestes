package com.example.bruno.testex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_swipe.*
import java.util.*

class SwipeActivity : AppCompatActivity() {

    lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)
        val list: MutableList<String> = ArrayList()
        disposable = RxBus
                        .behaviorSubject
                        .subscribe({ onNext ->
                            swipe_textview.text = onNext as String
                        }, {
                            Log.e("SwipeActivity -------->", it.message)
                        })
        list.add("Teste 1")
        list.add("pokemon 2")
        list.add("Harry Potter")
        list.add("Roberglauberson")

        swipe_recyclerview.adapter = GenericalAdapter(list, this)
        swipe_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}
