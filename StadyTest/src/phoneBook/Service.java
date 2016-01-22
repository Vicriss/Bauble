package phoneBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicriss on 2015/09/16.
 */
public class Service {
    private List<Person> personList2 = new ArrayList<>();


    public List<Person> listSort(List<Person> personList){

        MergeSort ms = new MergeSort();

        int[] nums= new int[personList.size()];
        for(int i=0;i<personList.size();i++){
            nums[i]=personList.get(i).getNumbers().get(0);
        }


        ms.sort(nums, 0, nums.length - 1);


        for(int i=0;i<personList.size();i++){
            for(int j=0;j<personList.size();j++){
                if(personList.get(j).getNumbers().get(0)==nums[i]){
                    personList2.add(personList.get(j));
                    break;
                }
            }
        }
        return personList2;
    }

    public Person findByName(String name){
        Person person = null;
        for(Person p:personList2){
            if(p.getName().equals(name)){
                person = p;
                break;
            }
        }
        return person;
    }

    public Person findByNumber(int number){
        Person person = null;
        for(Person p:personList2){
            for(int i:p.getNumbers()) {
                if (i==number) {
                    person = p;
                    break;
                }
            }
        }
        return person;
    }

    public void addPerson(Person person){
        personList2.add(person);
        listSort(personList2);
    }

    public void addNumber(int number,String name){
        for(int i = 0;i<personList2.size();i++){
            if(personList2.get(i).getName().equals(name))
                personList2.get(i).getNumbers().add(number);
        }
    }

    public void deleteNumber(int number){
        for(int i=0;i<personList2.size();i++){
            for(int j=0;j<personList2.get(i).getNumbers().size();j++){
                if(personList2.get(i).getNumbers().get(j)==number)
                    personList2.get(i).getNumbers().remove(j);
            }
        }
    }

    public void deleteByName(String name){
        personList2.remove(findByName(name));
    }
}
