package KotlinExamples

import rx.Observable
import java.util.concurrent.TimeUnit

fun main(args:Array<String>)
{
    //will not run because run on another thread and time not enough to do anything
    val observable=Observable.interval(1,TimeUnit.SECONDS)
    observable.forEach { println("Non blocking $it") }

    //take an observable and block
    val observable2=Observable.interval(1,TimeUnit.SECONDS).take(5)
    observable2.toBlocking().forEach { println("Blocking $it+${Thread.currentThread().name}") }
}