/*Singles are useful when you just need to emit one value. In these scenarios, creating an Observable can feel like overkill,
but a Single is designed to simply emit a single value and then complete, either by calling:

onSuccess(): The Single emits its sole value.
onError(): If the Single is unable to emit its item, then it’ll pass this method the resulting Throwable.
A Single will call one of these methods only, and then immediately terminate.*/
package CreatingObservable;

import io.reactivex.Single;

public class Singles {
    public static void main(String[] args) {
        Single.just(3.142).subscribe(aDouble -> System.out.println(aDouble));
    }
}
