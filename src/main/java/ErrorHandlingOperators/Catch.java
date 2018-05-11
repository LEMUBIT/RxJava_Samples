/*recover from an onError notification by continuing the sequence without error*/
/*The Catch operator intercepts an onError notification from the source Observable and,
instead of passing it through to any observers, replaces it with some other item or sequence of items,
potentially allowing the resulting Observable to terminate normally or not to terminate at all.

There are several variants of the Catch operator, and a variety of names used by different ReactiveX
implementations to describe this operation, as you can see in the sections below.

In some ReactiveX implementations, there is an operator called something like “OnErrorResumeNext”
that behaves like a Catch variant: specifically reacting to an onError notification from the source Observable.
In others, there is an operator with that name that behaves more like a Concat variant: performing the concatenation
operation regardless of whether the source Observable terminates normally or with an error. This is unfortunate and confusing,
but something we have to live with.*/
package ErrorHandlingOperators;

import rx.Observable;

import java.io.IOException;
/*
##onErrorReturn
instructs an Observable to emit a particular item when it encounters an error, and then terminate normally
##onErrorResumeNext
instructs an Observable to begin emitting a second Observable sequence if it encounters an error
##onExceptionResumeNext
instructs an Observable to continue emitting items after it encounters an exception (but not another variety of throwable)*/
public class Catch {
    public static void main(String[] args) {
        /*onErrorReturn*/
        Observable.error(new IOException())
                .onErrorReturn(throwable -> -1)
                .subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        ()->System.out.println("Completed")
                );

        /*onErrorResumeNext*/
        Observable.error(new IOException())
                .onErrorResumeNext( Observable.just(1,2,3))
                .subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        ()->System.out.println("Completed onErrorResumeNext")
                );


        /*onErrorResumeNext*/
        /*Much like onErrorResumeNext method, this returns an Observable that mirrors the behavior of the source Observable,
        unless that Observable invokes onError in which case, if the Throwable passed to onError is an Exception,
        rather than propagating that Exception to the observer, onExceptionResumeNext will instead begin mirroring a second,
        backup Observable. If the Throwable is not an Exception, the Observable returned by onExceptionResumeNext will propagate
        it to its observer’s onError method and will not invoke its backup Observable.*/
        Observable.error(new IOException())
                .onExceptionResumeNext( Observable.just(1,2,3))
                .subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println("Error"),
                        ()->System.out.println("Completed onExceptionResumeNext")
                );

    }
}
