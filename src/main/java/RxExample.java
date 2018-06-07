import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class RxExample {
    public static void main(String[] args) {
        Observable.just(timesTwo(5)).subscribeOn(Schedulers.io())
                .subscribe(integer -> System.out.println(integer));
    }


    public static int timesTwo(int x) {
        return x * 2;
    }
}
