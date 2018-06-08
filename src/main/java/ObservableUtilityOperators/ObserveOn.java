/*specify the Scheduler on which an observer will observe this Observable*/
/*Many implementations of ReactiveX use “Schedulers” to govern an Observable’s
transitions between threads in a multi-threaded environment. You can instruct
an Observable to send its notifications to observers on a particular Scheduler
by means of the ObserveOn operator.*/

/*By default, an Observable and the chain of operators that you apply to it will do its work,
and will notify its observers, on the same thread on which its Subscribe method is called.
The SubscribeOn operator changes this behavior by specifying a different Scheduler on which the
Observable should operate. The ObserveOn operator specifies a different Scheduler that the Observable
will use to send notifications to its observers.*/

/*The SubscribeOn operator designates which thread the Observable will begin operating on,
no matter at what point in the chain of operators that operator is called. ObserveOn,
on the other hand, affects the thread that the Observable will use below where that operator appears.
For this reason, you may call ObserveOn multiple times at various points during the chain of Observable
operators in order to change on which threads certain of those operators operate*/

/*Unlike subscribeOn(), where you place observeOn() in your chain does matter,
as this operator only changes the thread that’s used by the observables that appear downstream. */

/*The RxAndroid library includes Android-specific bindings for RxJava 2, making it a valuable additional
resource for Android developers (and something we’ll be looking at in much more detail in the next post of this series).*/

package ObservableUtilityOperators;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class ObserveOn {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread())
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
