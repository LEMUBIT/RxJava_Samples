/*attach a timestamp to each item emitted by an Observable indicating when it was emitted*/

/*The Timestamp operator attaches a timestamp to each item emitted by the source Observable
before reemitting that item in its own sequence. The timestamp indicates at what time the item was emitted.*/

/*The timestamp method converts an Observable that emits items of type T into one that emits objects of type Timestamped<T>,
where each such object is stamped with the time at which it was originally emitted.

timestamp by default operates on the immediate Scheduler but also has a variant that allows you to choose the Scheduler by
passing it in as a parameter.*/
package ObservableUtilityOperators;

import rx.Observable;

public class TimeStamp {
    public static void main(String[] args) {
        Observable.just(1,2,3).timestamp().subscribe(
                integerTimestamped -> System.out.println(integerTimestamped),
                throwable -> System.out.println("Error"),
                ()->System.out.println("Completed")
        );
    }
}
