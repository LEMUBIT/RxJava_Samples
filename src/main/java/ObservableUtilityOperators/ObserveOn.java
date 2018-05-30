/*specify the Scheduler on which an observer will observe this Observable*/
/*Many implementations of ReactiveX use “Schedulers” to govern an Observable’s
transitions between threads in a multi-threaded environment. You can instruct
an Observable to send its notifications to observers on a particular Scheduler
by means of the ObserveOn operator.*/

/*By default, an Observable and the chain of operators that you apply to it will do its work,
and will notify its observers, on the same thread on which its Subscribe method is called.
The SubscribeOn operator changes this behavior by specifying a different Scheduler on which the
Observable should operate. The ObserveOn operator specifies a different Scheduler that the Observable
will use to send notifications to its observers.*/

/*The SubscribeOn operator designates which thread the Observable will begin operating on,
no matter at what point in the chain of operators that operator is called. ObserveOn,
on the other hand, affects the thread that the Observable will use below where that operator appears.
For this reason, you may call ObserveOn multiple times at various points during the chain of Observable
operators in order to change on which threads certain of those operators operate*/
package ObservableUtilityOperators;

//TODO: Implement Example
public class ObserveOn {
    public static void main(String[] args) {

    }
}
