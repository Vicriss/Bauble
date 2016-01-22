package singleton;

/**
 * Created by vicriss on 2015/09/06.
 */
public class SingletonExample {
    private SingletonExample(){}

    private static SingletonExample instance  = new SingletonExample();

    public static SingletonExample getInstance(){
        return instance ;
    }
}
