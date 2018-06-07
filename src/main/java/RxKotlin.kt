import io.reactivex.Observable
import io.reactivex.rxkotlin.*

fun main(args: Array<String>) {

    val countries = listOf("Nigeria", "USA", "UK", "Russia", "Ghana", "Israel")

    countries.toObservable()
            .filter { s -> s.length > 3 }
            .subscribe(
                    { println(it) },
                    { println("$it+error") },
                    { println("Completed") }
            )
    Observable.just(2, 3, 4)


}