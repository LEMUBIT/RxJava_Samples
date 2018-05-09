/*convert an Observable that emits Observables into a single Observable that emits the
items emitted by the most-recently-emitted of those Observables*/

/*Switch subscribes to an Observable that emits Observables.
Each time it observes one of these emitted Observables, the Observable returned by
Switch unsubscribes from the previously-emitted Observable begins emitting items from the latest Observable.
Note that it will unsubscribe from the previously-emitted Observable when a new Observable is emitted from the source Observable,
not when the new Observable emits an item. This means that items emitted by the previous Observable between the time the subsequent
Observable is emitted and the time that subsequent Observable itself begins emitting items will be dropped*/

/*RxJava implements this operator as switchOnNext. It does not by default operate on any particular Scheduler.*/
package CombiningObservables;

//TODO: Implement Example
public class Switch {
    public static void main(String[] args) {

    }
}
