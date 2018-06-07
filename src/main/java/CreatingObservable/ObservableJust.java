/*The Just operator converts an item into an Observable that emits that item.

Just is similar to From, but note that From will dive into an array or an iterable or something
 of that sort to pull out items to emit, while Just will simply emit the array or iterable or
 what-have-you as it is, unchanged, as a single item.

Note that if you pass null to Just, it will return an Observable that emits null as an item.
Do not make the mistake of assuming that this will return an empty Observable (one that emits no items at all).
For that, you will need the Empty operator.*/

package CreatingObservable;

import rx.Observable;
import rx.Observer;

public class ObservableJust {
    public static void main(String[] args) {
        rx.Observable.just(2, 4, 8).subscribe(
                s -> System.out.println("No:" + s),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")

        );




        Observable observable = Observable.just(1, 2, 3);

        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error");
            }

            @Override
            public void onNext(Object o) {
                System.out.println(o);
            }
        };

        observable.subscribe(observer);
    }
}
