package CreatingObservable.ObservableDeferClasses;


import rx.Observable;

/* This class is just used to prove that defer() waits, check out @ObservableDefer class */
public class observableModel {
    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Observable<String> getInfo() {
        return Observable.just("Just:" + "age= " + String.valueOf(age) + ":" + " name= " + name);
    }

    //Uses the defer() instead of Just(), in order to get freshest data
    public Observable<String> getDeferInfo() {
        return Observable.defer(() -> Observable.just("Defer:" + "age= " + String.valueOf(age) + ":" + " name= " + name));
    }
}
