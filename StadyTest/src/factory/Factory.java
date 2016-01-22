package factory;

/**
 * Created by vicriss on 2015/09/09.
 */
public class Factory {

    public CarInterface getCar(String car){
        if("train".equals(car)){
            return new Train();
        }else if("truck".equals(car)){
            return new Truck();
        }else
            return null;
    }


    public CarInterface getCarByClassName(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        CarInterface car = (CarInterface) Class.forName(className).newInstance();
        return car;
    }
}
