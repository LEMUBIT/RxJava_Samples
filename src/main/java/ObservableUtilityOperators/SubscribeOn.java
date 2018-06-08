/*Many implementations of ReactiveX use “Schedulers” to govern an Observable’s transitions between threads in a
multi-threaded environment. You can instruct an Observable to do its work on a particular Scheduler by calling
the Observable’s SubscribeOn operator.

The ObserveOn operator is similar, but more limited. It instructs the Observable to send notifications to observers
on a specified Scheduler.*/

/*By default, an Observable and the chain of operators that you apply to it will do its work, and will notify its observers,
on the same thread on which its Subscribe method is called. The SubscribeOn operator changes this behavior by specifying a
different Scheduler on which the Observable should operate. The ObserveOn operator specifies a different Scheduler that the
Observable will use to send notifications to its observers.

As shown in this illustration, the SubscribeOn operator designates which thread the Observable will begin operating on,
no matter at what point in the chain of operators that operator is called. ObserveOn, on the other hand, affects the thread
that the Observable will use below where that operator appears. For this reason, you may call ObserveOn multiple times at
various points during the chain of Observable operators in order to change on which threads certain of those operators operate.*/


/*
Schedulers.io(): Designed to be used for IO-related tasks.

Schedulers.computation(): Designed to be used for computational tasks.
By default, the number of threads in the computation scheduler is limited to the number of CPUs available on your device.

Schedulers.newThread(): Creates a new thread.*/

/*The subscribeOn() operator will have the same effect no matter where you place it in the observable chain; however,
you can't use multiple subscribeOn() operators in the same chain. If you do include more than one subscribeOn(),
then your chain will only use the subscribeOn() that’s the closest to the source observable.*/

package ObservableUtilityOperators;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class SubscribeOn {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation())
                .subscribe(integer -> System.out.println(integer + " --" + Thread.currentThread().getName()));


        //The reason I wrote the below code was to prevent program from closing too early for
        //the code above to execute
        Observable.interval(1, TimeUnit.SECONDS)
                .take(3)
                .toBlocking()
                .subscribe(aLong -> System.out.println(aLong + " --" + Thread.currentThread().getName())
        );
    }
}
