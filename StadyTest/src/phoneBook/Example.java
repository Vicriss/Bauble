package phoneBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicriss on 2015/09/13.
 */
public class Example {

    public List<Person> personList= new ArrayList<>();

    public List<Person> personExample(){

        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();
        List list4 = new ArrayList();
        list1.add(125452333);
        list1.add(175452444);
        list1.add(175452444);
        list2.add(145452555);
        list3.add(165452343);
        list4.add(115452343);

        Person person1 = new Person("sam",list1,"uestc");
        Person person2 = new Person("Jim",list2,"uestc");
        Person person3 = new Person("John",list3,"uestc");
        Person person4 = new Person("Ken",list4,"uestc");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        return personList;
    }


}
