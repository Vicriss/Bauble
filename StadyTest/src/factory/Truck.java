package factory;

/**
 * Created by vicriss on 2015/09/09.
 */
public class Truck implements CarInterface {
    @Override
    public String creator() {
        return "A truck";
    }
}
