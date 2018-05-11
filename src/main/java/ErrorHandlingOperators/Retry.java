/*if a source Observable emits an error, resubscribe to it in the hopes that it will complete without error*/
/*The Retry operator responds to an onError notification from the source Observable by not passing that call
through to its observers, but instead by resubscribing to the source Observable and giving it another opportunity
to complete its sequence without error. Retry always passes onNext notifications through to its observers, even from
sequences that terminate with an error, so this can cause duplicate emissions (as shown in the diagram above).*/
package ErrorHandlingOperators;

import rx.Observable;
import rx.Subscriber;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Retry {
    public static void main(String[] args) {
        /*One variant of retry takes no parameters. It will continue to resubscribe to and mirror the source
        Observable no matter how many onError notifications it receives.*/
        Observable.error(new IOException())
                .retry()
                .subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        () -> System.out.println("Completed")
                );

        /*Another variant of retry takes a single parameter: a count of the number of times it should try
        to resubscribe to the source Observable when it encounters errors. If this count is exceeded,
        retry will not attempt to resubscribe again and will instead pass the latest onError notification to its observers.*/
        Observable.error(new IOException())
                .retry(3)
                .subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        () -> System.out.println("Completed")
                );

        /*A third variant of retry takes a predicate function as a parameter.
        You write this function to accept two arguments: an Integer count of how many retries have taken place thusfar,
        and a Throwable indicating the error that caused the onError notification. This function returns a Boolean to
        indicate whether or not retry should resubscribe to and mirror the source Observable. If it does not, then retry
        passes the latest onError notification to its observers.*/
        Observable.error(new IOException())
                .retry((integer, throwable) -> {
                    if (integer > 10)
                        return false;
                    else
                        return true;
                })
                .subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        () -> System.out.println("Completed")
                );


        /*The retryWhen operator is similar to retry but decides whether or not to resubscribe to and mirror the source Observable
        by passing the Throwable from the onError notification to a function that generates a second Observable, and observes its
        result to determine what to do. If that result is an emitted item, retryWhen resubscribes to and mirrors the source and the
        process repeats; if that result is an onError notification, retryWhen passes this notification on to its observers and terminates.
        retryWhen by default operates on the trampoline Scheduler, and there is also a version that accepts a Scheduler as a parameter.*/
        Observable.create((Subscriber<? super String> s) -> {
            System.out.println("subscribing");
            s.onError(new RuntimeException("always fails"));
        }).retryWhen(attempts -> {
            return attempts.zipWith(Observable.range(1, 3), (n, i) -> i).flatMap(i -> {
                System.out.println("delay retry by " + i + " second(s)");
                return Observable.timer(i, TimeUnit.SECONDS);
            });
        }).toBlocking().forEach(System.out::println);
    }
}
