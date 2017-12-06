package com.company;

import javax.swing.JOptionPane;

public class Bai1_5_2 {

    public static void main(String[] args) {
        String thang, nam;
        
        int year, month,day;
        do {
            thang = JOptionPane.showInputDialog(null, "Hay nhap thang: ",
                    "Nguyễn Văn Cường - 20155218", JOptionPane.INFORMATION_MESSAGE);
            if(thang == null) System.exit(0);
            try {
                month = Integer.valueOf(thang);
                if (month < 1 || month > 12) {
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        } while (true);
        do {
            nam = JOptionPane.showInputDialog(null, "Hay nhap nam: ",
                    "Nguyễn Văn Cường - 20155218", JOptionPane.INFORMATION_MESSAGE);
           if(nam == null) System.exit(0);
            try {
                year = Integer.valueOf(nam);
                if (year < 0) {
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        } while (true);

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:{
                 day  = 31;
                 break;
            }
            case 2:{
                if(year % 4 == 0){
                   day = 29;
                }else{
                    day = 28;
                }
                break;
            }
            default: day = 30;
        }
        
        JOptionPane.showMessageDialog(null, "Thang  "+ month +" nam "+ year +" co "+day+" ngay");
    }
}
