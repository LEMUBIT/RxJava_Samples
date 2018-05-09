/*combine multiple Observables into one by merging their emissions*/
/*You can combine the output of multiple Observables so that they act like a single Observable, by using the Merge operator.

Merge may interleave the items emitted by the merged Observables
(a similar operator, Concat, does not interleave items, but emits all of each source Observable’s
items in turn before beginning to emit items from the next source Observable).*/
package CombiningObservables;


import rx.Observable;

public class Merge {
    public static void main(String[] args) {
        Observable num = Observable.just(1, 2, 3, 4, 5);
        Observable alpha = Observable.just("Abuja", "Benin", "Lagos");
        Observable.merge(num, alpha).subscribe(
                value -> System.out.println(value),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }
}

/*
* Output:
1
2
3
4
5
Abuja
Benin
Lagos
Completed
* */
