package phoneBook;

import java.util.List;

/**
 * Created by vicriss on 2015/09/13.
 */
public class Person {
    private String name;
    private List<Integer> numbers ;
    private String address;

    public Person(){}

    public Person(String name, List<Integer> numbers, String address) {
        this.name = name;
        this.numbers = numbers;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", numbers=" + numbers +
                ", address='" + address + '\'' +
                '}'+"\n";
    }
}
