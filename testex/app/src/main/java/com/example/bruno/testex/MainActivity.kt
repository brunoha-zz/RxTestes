package com.example.bruno.testex

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tag = "RxJava ------------>"
        val context = this
        val source = Observable.just<String>(
                "Roberval 😄",
                "Cleston😝 ",
                "Dorival 😄",
                "Juliano 😄",
                "Thiago 😆"
        )

        source.map({ mapper ->
            mapper.length
        }).filter { filtered ->
            filtered > 10
        }.subscribe({ s -> Log.d(tag, "Received: " + s) },
                { error -> Log.e(tag, error.toString()) })


        val scheduler = TestScheduler()
        val o = Observable.interval(1, TimeUnit.SECONDS, scheduler)
                .test()
        o.assertNoValues()
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS)
        o.assertValues(0L)
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS)
        o.assertValues(0L, 1L)
        o.dispose() // Dispose the connection.
        scheduler.advanceTimeBy(100, TimeUnit.SECONDS)
        o.assertValues(0L, 1L)

        RxView.clicks(main_button).subscribe({ btn ->
            var data = main_edit.text.toString()
            RxBus.behaviorSubject.onNext(data)
            startActivity(Intent(context, SwipeActivity::class.java))

        })


    }
}
