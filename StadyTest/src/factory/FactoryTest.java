package factory;

/**
 * Created by vicriss on 2015/09/09.
 */
public class FactoryTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
       Factory factory = new Factory();
        CarInterface train = factory.getCarByClassName("factory.Train");
        System.out.println(train.creator());
    }
}
