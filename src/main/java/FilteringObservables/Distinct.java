/*suppress duplicate items emitted by an Observable*/
/*The Distinct operator filters an Observable by only allowing items through that have not already been emitted.

In some implementations there are variants that allow you to adjust the criteria by which two items are considered “distinct.”
In some, there is a variant of the operator that only compares an item against its immediate predecessor for distinctness,
thereby filtering only consecutive duplicate items from the sequence.*/
package FilteringObservables;

import rx.Observable;

public class Distinct {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,2,2,1,0).distinct().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                ()->System.out.println("Completed")
        );
    }
}
