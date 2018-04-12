/*
* When you work with Observables, it can be more convenient
* if all of the data you mean to work with can be represented as Observables,
* rather than as a mixture of Observables and other types.
* This allows you to use a single set of operators to govern the entire lifespan of the data stream.
*/
package CreatingObservable;

import rx.Observable;

import java.util.Arrays;

public class ObservableFrom {
    public static void main(String[] args) {
        Integer[] scores = {23, 434, 5454, 454, 2323, 122, 43434, 34};

        Observable.from(scores).subscribe(
                integer -> System.out.println("Score: "+integer),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")

        );
    }
}
