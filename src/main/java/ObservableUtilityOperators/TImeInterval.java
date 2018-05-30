/*convert an Observable that emits items into one that emits indications of the amount of time elapsed between those emissions*/

/*The TimeInterval operator intercepts the items from the source Observable and emits in their place objects that indicate the
amount of time that elapsed between pairs of emissions.*/

package ObservableUtilityOperators;

import rx.Observable;

public class TImeInterval {
    public static void main(String[] args) {
        Observable.just(1, 2, 3).timeInterval().subscribe(
                integerTimeInterval -> System.out.println(integerTimeInterval),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed"));
    }
}
