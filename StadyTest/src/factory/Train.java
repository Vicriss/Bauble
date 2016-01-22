package factory;

/**
 * Created by vicriss on 2015/09/09.
 */
public class Train implements CarInterface {
    @Override
    public String creator() {
        return "A train";
    }
}
