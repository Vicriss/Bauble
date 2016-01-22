package singleton;

/**
 * Created by vicriss on 2015/09/06.
 */
public class Test {
    public static void main(String[] args){
        SingletonExample s1 = SingletonExample.getInstance();
        SingletonExample s2 = SingletonExample.getInstance();
        if(s1==s2){
            System.out.println("same");
        }else {
            System.out.println("different");
        }

        SingletonExample2 s3 = SingletonExample2.getInstance();
        SingletonExample2 s4 = SingletonExample2.getInstance();
        if(s3==s4){
            System.out.println("same");
        }else {
            System.out.println("different");
        }

    }
}
