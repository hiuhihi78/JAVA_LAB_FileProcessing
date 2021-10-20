
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
class GetValue {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntNumberInRange(int from, int to, String msg) {
        int result = 0;
        // loop until user input correct
        while (true) {
            result = getInputPositiveInt(msg);
            if (result < from || result > to) {
                System.err.println("Invalid of " + msg + ", " + msg
                        + " must be in range [" + from + " - " + to + "]!");
            } else {
                return result;
            }
        }
    }

    public static String getInputString(String msg) {
        String result = null;
        // loop until user input correct
        while (true) {
            System.out.print("Enter " + msg + ":");
            result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Invalid of " + msg + ", " + msg + " must be not empty!");
            } else {
                return result;
            }
        }
    }

    public static int getInputPositiveInt(String msg) {
        int result = 0;
        // loop until user input correct
        while (true) {
            try {
                String temp = getInputString(msg);
                result = Integer.parseInt(temp);
                if (result < 0) {
                    System.err.println("Invalid of " + msg + ", " + msg + " must be positive interger!");
                    continue;
                } else if (result == 0) {
                    System.err.println("Invalid of " + msg + ", " + msg + " must be greater than 0!");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Invalid of " + msg + ", " + msg + " must be positive interger!");
            }
        }
    }

    public static double getMoney() {
        double result = 0;
        // loop until user input correct
        while (true) {
            try {
                String temp = getInputString("Money");
                result = Double.parseDouble(temp);
                if (result < 0) {
                    return 0;
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Invalid of Money, Money must be a number!");
            }
        }
    }

    public static ArrayList<Person> getListPersonGreaterThanMoney(ArrayList<Person> list, double money) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : list) {
            if (person.getMoney() >= money) {
                boolean personExisted = Validation.checkARecordExisted(result, person);
                if (personExisted == false) {
                    result.add(person);
                }
            }
        }
        return result;
    }

    public static String getInputNameFile(String msg) {
        while (true) {
            String fileName = getInputString(msg);
            if (fileName.matches("(.*).txt")) {
                return fileName;
            } else {
                System.err.println("Invalid of file name, file name must be follow format [string].txt");
            }
        }
    }
}
