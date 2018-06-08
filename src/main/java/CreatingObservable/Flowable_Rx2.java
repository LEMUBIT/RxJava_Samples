/*n RxJava 2, the RxJava team decided to split the standard Observable into two types:
the regular kind we’ve been looking at throughout this series, and Flowables.

Flowables function in much the same way as Observables, but with one major difference:
Flowables only send as many items as the observer requests. If you have an Observable that’s
emitting more items than its assigned observer can consume, then you may want to consider switching to a Flowable instead.*/

/*Flowable incurs more of an overhead than a regular Observable, so in the interests of creating a high-performing app,
you should stick with Observables unless you suspect that your application is struggling with backpressure.*/
package CreatingObservable;

import io.reactivex.Flowable;

public class Flowable_Rx2 {
    public static void main(String[] args) {
        Flowable.just(1,2,3).subscribe(integer -> System.out.println(integer));

    }
}
