package JavaSE.dateDemo;

import java.text.DateFormat;

public class DateDemo {

    public static void main(String[] args) {

        DateDemo t = new DateDemo();
        DateFormat date = null;
        date = DateFormat.getDateInstance();
        System.out.println(date);
        System.out.println(t);
    }

}
