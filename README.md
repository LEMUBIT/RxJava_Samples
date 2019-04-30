# RxJava_Samples
Sample codes of RxJava Operations, implementing its different features in a self-explanatory way. It can serve as a fast reference to RxJava features. You will see the description of the particular operation at the top of each Class which can help you better understand the code. Each Java class displays a different RxJava example using a simple code snippet such as the example below demonstrating RxJava Materialize() operation.

```java
   Observable.just(1, 2, 3).materialize().subscribe(
                integerNotification -> System.out.println("Notification:" + integerNotification +
                        "  Notification kind:" + integerNotification.getKind() +
                        "  Notification value:" + integerNotification.getValue() +
                        "  Completed:" + integerNotification.isOnCompleted()
                ),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")

        );
```
