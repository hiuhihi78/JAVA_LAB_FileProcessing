/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Admin
 */
class Manager {
    

    public static void displayMenu() {
        System.out.println("========== File Processing =========");
        System.out.println("1.	Find person info");
        System.out.println("2.	Copy Text to new file");
        System.out.println("3.	Exit");
    }

    public static void findPersonsInfo() {
        ArrayList<Person> list = new ArrayList<>();
        System.out.println("--------- Person info ---------");
        String pathFile = GetValue.getInputString("Path");
        // check file was existed
        boolean fileExisted = Validation.checkFileExisted(pathFile);
        if (fileExisted == false) {
            System.out.println("File not existed\n");
            return;
        }
        double money = GetValue.getMoney();
        System.out.println("------------- Result ----------");
        // get data form file
        list.addAll(FileProcess.readData(pathFile));
        if (list.isEmpty()) {
            System.out.println("Empty!\n");
            return;
        }
        // search all record have greater than money
        ArrayList<Person> listSearch = GetValue.getListPersonGreaterThanMoney(list, money);
        // sort listSearch
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person t, Person t1) {
                if (t.getMoney() > t1.getMoney()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        // display result
        System.out.printf("%-13s%-13s%s\n", "Name", "Address", "Money");
        for (Person person : listSearch) {
            System.out.println(person);
        }
        System.out.println("");
    }

    public static void copyText() {
        ArrayList<Person> list = new ArrayList<>();
        System.out.println("------------- Copy text --------------");
        String source = GetValue.getInputString("Source");
        // check file was existed
        boolean fileExisted = Validation.checkFileExisted(source);
        if (fileExisted == false) {
            System.out.println("File not existed\n");
            return;
        }
        // get data from source
        list.addAll(FileProcess.readData(source));
        System.out.println(list.size());
        String fileName = GetValue.getInputNameFile("new file name");
        // write data to new file
        FileProcess.writeData(list, fileName);
        System.out.println("Copy done...\n");

    }

}
