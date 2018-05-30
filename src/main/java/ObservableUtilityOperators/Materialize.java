/*represent both the items emitted and the notifications sent as emitted items, or reverse this process*/
/*A well-formed, finite Observable will invoke its observer’s onNext method zero or more times, and then
will invoke either the onCompleted or onError method exactly once. The Materialize operator converts this
series of invocations — both the original onNext notifications and the terminal onCompleted or onError
notification — into a series of items emitted by an Observable.*/

/*The Dematerialize operator reverses this process. It operates on an Observable that has previously been
transformed by Materialize and returns it to its original form.*/
package ObservableUtilityOperators;

import rx.Observable;

public class Materialize {
    public static void main(String[] args) {
        Observable.just(1, 2, 3).materialize().subscribe(
                integerNotification -> System.out.println("Notification:" + integerNotification +
                        "  Notification kind:" + integerNotification.getKind() +
                        "  Notification value:" + integerNotification.getValue() +
                        "  Completed:" + integerNotification.isOnCompleted()
                ),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")

        );
    }
}
