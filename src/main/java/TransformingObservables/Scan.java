/*
* apply a function to each item emitted by an Observable, sequentially, and emit each successive value
*
* The Scan operator applies a function to the first item emitted by the source Observable and then emits
* the result of that function as its own first emission. It also feeds the result of the function back into
* the function along with the second item emitted by the source Observable in order to generate its second emission.
*
* It continues to feed back its own subsequent emissions along with the subsequent emissions from the source Observable
* in order to create the rest of its sequence.
* */

package TransformingObservables;

import rx.Observable;

public class Scan {
    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .scan((integer, integer2) -> integer+integer2)
                .subscribe(integer -> System.out.println(integer));
    }
}
