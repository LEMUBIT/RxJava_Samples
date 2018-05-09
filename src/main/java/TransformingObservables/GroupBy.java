/*
* RxJava implements the groupBy operator. The Observable it returns emits items of a particular subclass of Observable —
* the GroupedObservable. Objects that implement the GroupedObservable interface have an additional method — getkey — by
* which you can retrieve the key by which items were designated for this particular GroupedObservable.

Another version of groupBy allows you to pass in a transformative function that changes the elements before they are emitted
 by the resulting GroupedObservables.

Note that when groupBy splits up the source Observable into an Observable that emits GroupedObservables, each of these
GroupedObservables begins to buffer the items that it will emit upon subscription. For this reason, if you ignore any of
these GroupedObservables (you neither subscribe to it or apply an operator to it that subscribes to it), this buffer will
present a potential memory leak. For this reason, rather than ignoring a GroupedObservable that you have no interest in observing,
you should instead apply an operator like take(0) to it as a way of signalling to it that it may discard its buffer.

If you unsubscribe from one of the GroupedObservables, that GroupedObservable will be terminated.
If the source Observable later emits an item whose key matches the GroupedObservable that was terminated in this way,
groupBy will create and emit a new GroupedObservable to match the key.
* */

package TransformingObservables;

//TODO: Implement Example
public class GroupBy {
    public static void main(String[] args) {


    }
}
