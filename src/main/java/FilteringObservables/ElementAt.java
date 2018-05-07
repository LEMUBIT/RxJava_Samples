/*emit only item n emitted by an Observable*/
/*RxGroovy implements this operator as elementAt. Pass elementAt a zero-based index value and it will emit the solitary item from
the source Observable’s sequence that matches that index value (for example, if you pass the index value 5, elementAt will emit
the sixth item emitted by the source Observable).

If you pass in a negative index value, or if the source Observable emits fewer than index value + 1 items, elementAt will throw an
IndexOutOfBoundsException.*/

/*RxGroovy also implements the elementAtOrDefault operator. It differs from elementAt in that it will not throw an exception if
the source Observable emits fewer than index value + 1 items. Instead, it will emit a “default” item that you specify with an
additional parameter to elementAtOrDefault.*/
package FilteringObservables;

import rx.Observable;

public class ElementAt {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 2).elementAt(2).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed Element at")
        );

        //there is no value at index 10...since the elements are just 5
        Observable.just(1, 2, 3, 4, 2).elementAtOrDefault(10, 23).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed Element at or default")
        );
    }
}
