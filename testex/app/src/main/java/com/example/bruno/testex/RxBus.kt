package com.example.bruno.testex

import io.reactivex.subjects.BehaviorSubject
import java.util.*

/**
 * Created by bruno on 28/06/18.
 */
class RxBus {
     companion object {
          val behaviorSubject : BehaviorSubject<Any>
                  = BehaviorSubject.create()
     }


}