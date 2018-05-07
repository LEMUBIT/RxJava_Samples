/*emit only those items from an Observable that pass a predicate test*/
/*The Filter operator filters an Observable by only allowing items through
that pass a test that you specify in the form of a predicate function.*/
package FilteringObservables;

import rx.Observable;

public class Filter {
    public static void main(String[] args) {
        Observable.just(8, 2, 3, 4, 1, 15).filter(integer -> integer%2==0).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }
}
