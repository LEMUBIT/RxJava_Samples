package CreatingObservable;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

import java.awt.*;

/*
RxJava is a library that allows us to represent any operation as
an asynchronous data stream that can be created on any
thread, declaratively composed, and consumed by multiple objects on
any thread.*/
public class ObservableCreate2 {
    public static void main(String[] args) {
        Observable observable = Observable.defer(() ->
                Observable.create((Observable.OnSubscribe<String>) subscriber -> {
                    if (!subscriber.isUnsubscribed()) {
                        try {
                            subscriber.onNext("lovely");
                            subscriber.onNext("nice");
                            subscriber.onNext("Thread executed on: " + Thread.currentThread().getName());
                            subscriber.onCompleted();
                        } catch (Exception e) {
                            subscriber.onError(e);
                        }
                    }
                }).subscribeOn(Schedulers.io())
        );
        /*Schedulers determine the thread on which Observables emit their
         asynchronous data streams and the thread on which Observers consume those data streams*/

        /*There is another method on Observable that takes a Scheduler:
        observeOn(). The Scheduler passed into this method will determine
        the thread on which the Observer consumes the data emitted
        by the Observable subscribeOn() actually returns an Observable,
        so you can chain observeOn() onto the Observable that is returned
        by the call to subscribeOn():*/

       Subscription subscription = observable.subscribe(
                o -> System.out.println(o),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );

       /*In cases where an Observable may live longer than its Observer
        because it is emitting items on a separate thread calling
        Subscription.unsubscribe() clears the Observable’s reference to
        the Observer whose connection is represented by the Subscription
        object.*/

       /*
        *
        *   Any call to Observable.subscribe() returns a Subscription. Subscriptions represent
        *   a connection between an Observable that’s
        *   emitting data and an Observer that’s consuming that data. More
        *   specifically, the Subscription returned by Observable.subscribe()
        *   represents the connection between the Observable receiving
        *   the subscribe() message and the Observer that is passed in as a
        *   parameter to the subscribe() method. Subscriptions give us the
        *   ability to sever that connection by calling Subscription.unsubscribe().
        * */

       subscription.unsubscribe();

       /*If an Activity utilizes multiple Observables, then the Subscriptions
       returned from each call to Observable.subscribe() can all
       be added to a CompositeSubscription, a Subscription whose
       unsubscribe() method will unsubscribe all Subscriptions that
       were previously added to it and that may be added to it in the future.*/


       /*Android: As long as an Observable survives an Activity’s configuration
        change, RxJava provides several operators that save us from having
        to re-query a data source after a configuration change: the cache and replay operators.
        These operators both ensure that Observers who subscribe to an Observable after that Observable has emitted
        its items will still see that same sequence of items.*/
    }
}
