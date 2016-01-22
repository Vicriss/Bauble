package singleton;

/**
 * Created by vicriss on 2015/09/06.
 */
public class SingletonExample2 {
    private SingletonExample2(){}

    private static SingletonExample2 instance ;

    public static SingletonExample2 getInstance(){
        if(instance==null){
            instance = new SingletonExample2();
        }
        return instance ;
    }
}
