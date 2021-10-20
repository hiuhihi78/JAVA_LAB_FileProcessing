/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // loop until user want to exit
        while (true) {
            // display menu
            Manager.displayMenu();
            // choice option
            int choice = GetValue.getIntNumberInRange(1, 3, "your choice");
            switch (choice) {
                case 1:
                    // Find persons info
                    Manager.findPersonsInfo();
                    break;
                case 2:
                    // copy text to new file
                    Manager.copyText();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

}
