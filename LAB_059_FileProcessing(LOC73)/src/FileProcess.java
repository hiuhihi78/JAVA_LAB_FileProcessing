
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
class FileProcess {

    public static ArrayList<Person> readData(String fileName) {
        ArrayList<Person> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String stringLine;
            String[] array;
            String name, address;
            double money;
            while (true) {
                stringLine = bufferedReader.readLine();
                if (stringLine == null || stringLine.trim().length() < 3) {
                    break;
                }
                array = stringLine.split("[|]");
                name = array[0].trim();
                address = array[1].trim();
                money = Double.parseDouble(array[2].trim());
                Person person = new Person(name, address, money);
                boolean recordExisted = Validation.checkARecordExisted(list, person);
                if (recordExisted == false) {
                    list.add(person);
                }
            }
            fileReader.close();
            bufferedReader.close();
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    static void writeData(ArrayList<Person> list, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            ArrayList<Person> listNotDuplicateRecord = new ArrayList<>();
            for(Person person : list){
                boolean recordExisted = Validation.checkARecordExisted(listNotDuplicateRecord, person);
                if(recordExisted == false){
                    listNotDuplicateRecord.add(person);
                }
            }
            for(Person person : listNotDuplicateRecord){
                String name = person.getName();
                String address = person.getAddress();
                double money = person.getMoney();
                printWriter.printf("%s|%s|%.1f\n", name, address, money);
            }
            printWriter.close();
            fileWriter.close();
        } catch (Exception e) {
        }
    }

}
