package phoneBook;

import java.util.Scanner;

/**
 * Created by vicriss on 2015/09/13.
 */
public class Main {

    public static void main(String args[]) {

        Service service = new Service();
        Manager manager = new Manager();

        System.out.println("====欢迎====");
        System.out.println("1.浏览联系人");
        System.out.println("2.查找联系人");
        System.out.println("3.添加联系人");
        System.out.println("4.删除联系人");
        System.out.println("5.查找号码");
        System.out.println("6.添加号码");
        System.out.println("7.删除号码");
        System.out.println("0.退出");

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        while (input != 0) {
            switch (input) {

                case 1://浏览联系人
                    manager.scanList();
                    break;

                case 2://查找联系人
                    manager.findByName();
                    break;
                case 3://添加联系人
                    manager.addPerson();
                    break;

                case 4://删除联系人
                    manager.deletePerson();
                    break;

                case 5://查找号码
                    manager.findByNumber();
                    break;

                case 6://添加号码
                    manager.addNumber();
                    break;

                case 7://删除号码
                    manager.deleteNumber();
                    break;

            }
            input = in.nextInt();
        }
        System.out.println("Bye~");
    }
}
