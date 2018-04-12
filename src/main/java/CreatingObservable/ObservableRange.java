/*
 * RxJava implements this operator as range.
 * It accepts as its parameters the start value of the range and the number of items in the range.
 * If you set that number of items to zero, the resulting Observable will emit no values
 * (if you set it to a negative number, range will cause an exception).
 *
 * */

package CreatingObservable;

import rx.Observable;

public class ObservableRange {
    public static void main(String[] args) {
        //start at five to 9, and take only three values
        Observable.range(5, 10).take(3).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }
}
