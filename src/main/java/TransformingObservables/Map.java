//transform the items emitted by an Observable by applying a function to each item
/*
* The Map operator applies a function of your choosing to each item emitted by the source Observable,
* and returns an Observable that emits the results of these function applications.
* */
package TransformingObservables;

import rx.Observable;

public class Map {
    public static void main(String[] args) {
        Observable.just(1,2,3)
                .map(integer -> integer*2)
                .subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        ()->System.out.println("Completed")
                );

    }
}
