//create an Observable that emits the return value of a function-like directive
/*
There are a number of ways that programming languages have for obtaining
values as the result of calculations, with names like functions, futures, actions,
 callables, runnables, and so forth. The operators grouped here under the Start operator
 category make these things behave like Observables so that they can be chained with other
 Observables in an Observable cascade
*
*
* The rxjava-async module includes the start operator,
* which accepts a function as its parameter, calls that function to retrieve a value,
* and then returns an Observable that will emit that value to each subsequent observer.
* Note that the function will only be executed once, even if more than one observer subscribes to the resulting Observable.
* */

//Added example using Observable defer just to demonstrate using Defer
package CreatingObservable;


import rx.Observable;
import rx.util.async.Async;


public class ObservableStart {
    static int x=4;
    public static void main(String[] args) {

        //use the Async.start()
        Observable observableRun = Async.start(() -> getValue());
        Observable observableDefer = Observable.defer(()->Async.start(() -> getValue()));

        //X has been changed but observableRun will not notice because
        // it has been calculated already, only observableDefer will return freshest value
        //this is not part of lesson, it's just a reminder or Defer
        x=6;

        observableRun.subscribe(
                integer->System.out.println(integer),
                throwable -> System.out.println("Error"),
                ()->System.out.println("Completed")
        );

        //Observable defer returns freshest value
        observableDefer.subscribe(
                integer->System.out.println("Defer:"+integer),
                throwable -> System.out.println("Error"),
                ()->System.out.println("Completed")
        );
    }

    public static int getValue() {
        return x;
    }
    /*
    OutPut:
    4
    Completed
    Defer:6
    Completed
    */
}
