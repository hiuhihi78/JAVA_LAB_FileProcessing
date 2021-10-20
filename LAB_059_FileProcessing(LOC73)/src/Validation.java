
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class Validation {

    public static boolean checkFileExisted(String fileName) {
       FileReader file = null;
        try {
            file = new FileReader(fileName);
            file.close();
            return true;
        } catch (Exception e) {
            try {
                file.close();
            } catch (Exception ex) {
            }
            return false;
        }
    }

    public static boolean checkARecordExisted(ArrayList<Person> list, Person obj) {
        for(Person person : list){
            if(person.getName().equalsIgnoreCase(obj.getName()) &&
                    person.getAddress().equalsIgnoreCase(obj.getAddress())&&
                    person.getMoney() == obj.getMoney()){
                return true;
            }
        }
        return false;
    }
    
}
