/*determine whether all items emitted by an Observable meet some criteria*/

/*Pass a predicate function to the All operator that accepts an item emitted
by the source Observable and returns a boolean value based on an evaluation of
that item. All returns an Observable that emits a single boolean value: true if
and only if the source Observable terminates normally and every item emitted by
the source Observable evaluated as true according to this predicate; false if any
item emitted by the source Observable evaluates as false according to this predicate.*/
package ConditionalAndBooleanOperators;

import rx.Observable;

public class All {

    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .all(integer -> integer < 4)
                .subscribe(
                aBoolean -> System.out.println(aBoolean),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }
}
