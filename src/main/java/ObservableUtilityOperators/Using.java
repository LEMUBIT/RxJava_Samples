/*create a disposable resource that has the same lifespan as the Observable*/

/*The Using operator is a way you can instruct an Observable to create a resource
that exists only during the lifespan of the Observable and is disposed of when the Observable terminates.*/

/*You pass the using operator three parameters:

#a factory function that creates a disposable resource
#a factory function that creates an Observable
#a function that disposes of the resource
When an observer subscribes to the Observable returned from using, using will use the Observable factory function
to create the Observable the observer will observe, while at the same time using the resource factory function to
create whichever resource you have designed it to make. When the observer unsubscribes from the Observable, or when
the Observable terminates (normally or with an error), using will call the third function to dispose of the resource it created.

using does not by default operate on any particular Scheduler.*/
package ObservableUtilityOperators;

//TODO: Implement Example
public class Using {
    public static void main(String[] args) {

    }
}
