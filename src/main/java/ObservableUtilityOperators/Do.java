/*register an action to take upon a variety of Observable lifecycle events*/
/*You can register callbacks that ReactiveX will call when certain events take
place on an Observable, where those callbacks will be called independently from the normal
set of notifications associated with an Observable cascade. There are a variety of operators
that various ReactiveX implementations have designed to allow for this*/
package ObservableUtilityOperators;

import rx.Notification;
import rx.Observable;

public class Do {
    public static void main(String[] args) {

        /*The doOnNext operator is much like doOnEach(Action1) except that the Action that you pass it as a parameter
        does not accept a Notification but instead simply accepts the emitted item.*/
        Observable.just(1, 2, 3, 4).doOnNext(integer -> {
            if (integer % 2 == 0) System.out.println(integer + " is Divisible");
        }).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed doOnNext")
        );


        /*The doOnEach operator allows you to establish a callback that the resulting Observable will call each time it emits an item.
        You can pass this callback either in the form of an Action that takes an onNext variety of Notification as its sole parameter,
        or you can pass in an Observer whose onNext method will be called as if it had subscribed to the Observable.*/
        System.out.println("----------");
        Observable.just(1, 2, 3, 4).doOnEach(notification -> printIt(notification))
                .subscribe(integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        () -> System.out.println("Completed doOnEach")
                );
    }

    private static void printIt(Notification<? super Integer> notification) {
        System.out.println("About to Print " + notification.getValue());
    }


}
