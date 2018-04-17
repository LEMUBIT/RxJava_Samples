/*
* transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
*
* The FlatMap operator transforms an Observable by applying a function that you specify to each item emitted by the source Observable,
* where that function returns an Observable that itself emits items. FlatMap then merges the emissions of these resulting Observables,
* emitting these merged results as its own sequence.
  This method is useful, for example, when you have an Observable that emits a series of items that themselves have Observable members or
  are in other ways transformable into Observables, so that you can create a new Observable that emits the complete collection of items
  emitted by the sub-Observables of these items.
  Note that FlatMap merges the emissions of these Observables, so that they may interleave.
* */

package TransformingObservables;

import rx.Observable;

public class FlatMap {
    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .flatMap(integer -> Observable.just("A", "B", "C").map(integer1 -> integer + integer1))
                .subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        () -> System.out.println("Complete")
                );


        System.out.println("---------------------");
        Observable.just(1, 2, 3)
                .flatMap(integer -> addOne(integer))
                .flatMap(integer -> multiplyByTwo(integer))
                .subscribe(integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        () -> System.out.println("Completed")
                );
    }


    //needs to return Observable
    public static Observable<Integer> addOne(int x) {
        return Observable.just(x + 1);
    }


    public static Observable<Integer> multiplyByTwo(int x) {
        return Observable.just(x * 2);
    }
}


/*
* OUTPUT:
1A
1B
1C
2A
2B
2C
3A
3B
3C
Complete
---------------------
4
6
8
Completed
* */