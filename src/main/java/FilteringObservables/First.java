/*emit only the first item (or the first item that meets some condition) emitted by an Observable*/
/*If you are only interested in the first item emitted by an Observable, or the first item that meets
some criteria, you can filter the Observable with the First operator.*/
/*n some implementations there is also a Single operator. It behaves similarly to First except that it
waits until the source Observable terminates in order to guarantee that it only emits a single item
(otherwise, rather than emitting that item, it terminates with an error). You can use this to not only
take the first item from the source Observable but to also guarantee that there was only one item.*/

package FilteringObservables;

import rx.Observable;

public class First {
    public static void main(String[] args) {
        Observable.just(8,4,5,6).first().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error:"+throwable),
                () -> System.out.println("Completed First()")
        );

        Observable.just(8, 2, 3, 4, 1, 15).first(integer -> integer>10).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error:"+throwable),
                () -> System.out.println("Completed First(func)")
        );

        Observable.just(8).single().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error:"+throwable),
                () -> System.out.println("Completed Single")
        );

    }
}
