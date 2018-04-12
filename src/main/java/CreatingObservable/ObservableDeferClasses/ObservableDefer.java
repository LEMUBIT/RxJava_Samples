/*
The Defer operator waits until an observer subscribes to it,
and then it generates an Observable, typically with an Observable factory function.
It does this afresh for each subscriber, so although each subscriber may think it is subscribing to the same Observable,
in fact each subscriber gets its own individual sequence.

In some circumstances, waiting until the last minute (that is, until subscription time)
to generate the Observable can ensure that this Observable contains the freshest data.

E.g if you have an observable to write to disk, that should not happen until subscription happens
*/

package CreatingObservable.ObservableDeferClasses;

import rx.Observable;

public class ObservableDefer {
    public static void main(String[] args) {
        observableModel observableModel = new observableModel();


        Observable<String> observable = observableModel.getInfo();
        Observable<String> observableDefer = observableModel.getDeferInfo();

        //data is changed after creation, only defer will get update because it isn't created yet.
        observableModel.setAge(22);
        observableModel.setName("Dan");


        observable.subscribe(System.out::println);
        observableDefer.subscribe(System.out::println);


            /*
            Output:
            Just:age= 0: name= null
            Defer:age= 22: name= Dan
            */
    }
}
