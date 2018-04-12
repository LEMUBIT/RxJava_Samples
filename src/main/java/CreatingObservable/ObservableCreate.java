/*
You can create an Observable from scratch by using the Create operator.
You pass this operator a function that accepts the observer as its parameter.
Write this function so that it behaves as an Observable — by calling the observer’s onNext, onError,
and onCompleted methods appropriately.

A well-formed finite Observable must attempt to call either the observer’s onCompleted method exactly once
or its onError method exactly once, and must not thereafter attempt to call any of the observer’s other methods.
*/
package CreatingObservable;

import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;


public class ObservableCreate {
    public static void main(String[] args) {
        List<String> bestClubs = new ArrayList<>();
        bestClubs.add("Barcelona");
        bestClubs.add("Real Madrid");
        bestClubs.add("Bayern Munich");
        bestClubs.add("Chelsea");
        bestClubs.add("Man City");

        rx.Observable.create(subscriber -> {
            try {
                if (!subscriber.isUnsubscribed())
                    bestClubs.forEach(s -> subscriber.onNext(s));

                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        }).subscribe(
                s -> System.out.println("Club: " + s),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );


    }
}
