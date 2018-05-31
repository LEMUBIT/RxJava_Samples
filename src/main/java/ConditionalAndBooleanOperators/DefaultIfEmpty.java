/*emit items from the source Observable, or a default item if the source Observable emits nothing*/

/*The DefaultIfEmpty operator simply mirrors the source Observable exactly if the source Observable
emits any items. If the source Observable terminates normally (with an onComplete) without emitting any items,
the Observable returned from DefaultIfEmpty will instead emit a default item of your choosing before it too completes.*/

package ConditionalAndBooleanOperators;

import rx.Observable;

public class DefaultIfEmpty {
    public static void main(String[] args) {
        Observable.empty().defaultIfEmpty(77).subscribe(
                o -> System.out.println(o),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }
}
