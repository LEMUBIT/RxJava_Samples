/*when an item is emitted by either of two Observables,
combine the latest item emitted by each Observable via a specified
function and emit items based on the results of this function*/

/*
* The CombineLatest operator behaves in a similar way to Zip, but while Zip emits items
* only when each of the zipped source Observables have emitted a previously unzipped item,
* CombineLatest emits an item whenever any of the source Observables emits an item
* (so long as each of the source Observables has emitted at least one item).
* When any of the source Observables emits an item, CombineLatest combines the most
* recently emitted items from each of the other source Observables, using a function you provide,
* and emits the return value from that function.
* */
package CombiningObservables;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class CombineLatest {
    public static void main(String[] args) {

        Observable letters = Observable.just("A", "b", "C");
        Observable numbers = Observable.just(1, 2, 3, 4, 5);
        List<Observable> observables = new ArrayList<>();

        observables.add(numbers);
        observables.add(letters);
        Observable.combineLatest(letters,numbers,(alpha,num)->num.toString()+alpha).subscribe(
                o->System.out.println(o.toString()),
                throwable -> System.out.println("error "+throwable),
                ()->System.out.println("Completed")
        );
    }
}
