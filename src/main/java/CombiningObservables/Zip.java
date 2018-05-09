/*combine the emissions of multiple Observables together via a specified function
and emit single items for each combination based on the results of this function*/
/*
* The Zip method returns an Observable that applies a function of your choosing to the combination of items emitted,
* in sequence, by two (or more) other Observables, with the results of this function becoming the items emitted by
* the returned Observable. It applies this function in strict sequence, so the first item emitted by the new Observable
* will be the result of the function applied to the first item emitted by Observable #1 and the first item emitted by
* Observable #2; the second item emitted by the new zip-Observable will be the result of the function applied to the second
* item emitted by Observable #1 and the second item emitted by Observable #2; and so forth. It will only emit as many items
* as the number of items emitted by the source Observable that emits the fewest items.
* */
package CombiningObservables;

import rx.Observable;

public class Zip {
    public static void main(String[] args) {
      Observable observable1=Observable.just("A","B","C");
     Observable observable2=  Observable.just("1","2","3");
        Observable.zip(
                observable1,
                observable2,
                (a,b)->a+b.toString()
        ).subscribe(
                n->System.out.println(n),
                throwable -> System.out.println("Error"),
                ()->System.out.println("Completed")
        );
    }
}
