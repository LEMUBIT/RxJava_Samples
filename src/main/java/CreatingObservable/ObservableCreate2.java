package CreatingObservable;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
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

        observable.subscribe(
                o -> System.out.println(o),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }
}
