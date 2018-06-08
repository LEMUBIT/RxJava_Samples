package KotlinExamples

import rx.Observable

fun main(args: Array<String>) {
    val numbers = Observable.from(1..100)

    numbers .filter { it % 2 == 0 } //not normal filter, actually returns an observable
            .map { it * 10 }
            .forEach { println("$it+${Thread.currentThread().name}") }//calls subscribe
}