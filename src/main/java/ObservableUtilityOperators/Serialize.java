/*force an Observable to make serialized calls and to be well-behaved*/

/*It is possible for an Observable to invoke its observers’ methods asynchronously, perhaps from different threads.
This could make such an Observable violate the Observable contract, in that it might try to send an OnCompleted or
OnError notification before one of its OnNext notifications, or it might make an OnNext notification from two different
threads concurrently. You can force such an Observable to be well-behaved and synchronous by applying the Serialize operator to it.*/

/*RxJava implements this operator as serialize. It does not by default operate on any particular Scheduler.*/
package ObservableUtilityOperators;

import io.reactivex.Observable;

//TODO: Implement Example
public class Serialize {
    public static void main(String[] args) {

    }
}
