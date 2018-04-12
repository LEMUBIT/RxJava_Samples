/*
* RxJava implements this operator as repeat.
* It does not initiate an Observable, but operates on an Observable
* in such a way that it repeats the sequence emitted by the source
* Observable as its own sequence, either infinitely, or in the case of repeat(n), n times.
*
* There is also an operator called repeatWhen. Rather than buffering and replaying the sequence from the source Observable,
* it resubscribes to and mirrors the source Observable,
* but only conditionally.
*
* */

package CreatingObservable;

import rx.Observable;

public class ObservableRepeat {
    public static void main(String[] args) {
        Observable rg=Observable.range(0,3);
        rg.repeat(3).subscribe(
                integer->System.out.println(integer),
                throwable -> System.out.println("Error"),
                ()->System.out.println("Completed")
        );
    }
}
