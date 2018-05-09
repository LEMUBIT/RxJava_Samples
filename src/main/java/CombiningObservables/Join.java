/*combine items emitted by two Observables whenever an item from one Observable is
emitted during a time window defined according to an item emitted by the other Observable*/
/*The Join operator combines the items emitted by two Observables, and selects which items to combine based
on duration-windows that you define on a per-item basis. You implement these windows as Observables whose lifespans
begin with each item emitted by either Observable. When such a window-defining Observable either emits an item or completes,
the window for the item it is associated with closes. So long as an item’s window is open, it will combine with any item emitted
by the other Observable. You define the function by which the items combine.*/

//TODO: Implement Example
package CombiningObservables;

public class Join {
    public static void main(String[] args) {

    }
}
