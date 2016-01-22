package phoneBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vicriss on 2015/09/23.
 */
public class Manager {
   private Service service = new Service();
   private Scanner in = new Scanner(System.in);
   private String name;
   private int num;
   private List<Person> personList = null;

   public Manager(){
      personList = service.listSort(new Example().personExample());

   }

   public void scanList(){
      System.out.println(personList);
   }

   public void findByName(){
      System.out.println("请输入姓名：");
      String name = in.nextLine();
      Person person = service.findByName(name);
      if(person!=null) {
         System.out.println(person);
      }
      else {
         System.out.println("该联系人不存在，是否要添加新的联系人？ Y/N");
         if (in.next().equals("Y"))
            addPerson();
      }
   }

   public void addPerson(){
      Person person1 = new Person();
      String name = in.nextLine();

      System.out.println("请输入姓名：");
      while (service.findByName(name)!=null){
         System.out.println("联系人已存在！!");
         name = in.nextLine();
      }
      person1.setName(name);

      System.out.println("请输入电话：\n（输入0结束）");
      List<Integer> nums = new ArrayList<>();
      num = in.nextInt();
      while (num!=0)
         nums.add(num);
      person1.setNumbers(nums);

      System.out.println("请输入地址：");
      person1.setAddress(in.nextLine());

      service.addPerson(person1);
      System.out.println("done!");
   }

   public void deletePerson(){
      System.out.println("请输入姓名：");
      name = in.nextLine();
      service.deleteByName(name);
      System.out.println("done!");
   }

   public void findByNumber(){
      System.out.println("请输入电话：");
      num = in.nextInt();
      Person person = service.findByNumber(num);
      if(person==null){
         System.out.println("该号码不存在，是否要添加？Y/N");
         if(in.next().equals("Y"))
            addNumber();
      }else
         System.out.println(person);
   }

   public void addNumber(){

      System.out.println("添加到联系人：");
      name = in.nextLine();

      System.out.println("请输入电话：");
      num = in.nextInt();

      while (service.findByNumber(num)==service.findByName(name)){
         System.out.println("号码已存在！");
         num = in.nextInt();
      }


      service.addNumber(num,name);
      System.out.println("done!");
   }

   public void deleteNumber(){
      System.out.println("请输入电话：");
      num = in.nextInt();
      service.deleteNumber(num);
   }

}
