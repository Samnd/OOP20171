package com.company;

import javax.swing.JOptionPane;

public class Bai1_5_1 {
     public static void main(String[] args) {
        double sum = 0;
        do {            
            String str = JOptionPane.showInputDialog(null, "Nhap vao mot so thuc: ",
                    "Nguyễn Văn Cường - 20155218", JOptionPane.INFORMATION_MESSAGE);
            if(str == null){
                System.exit(0);
            }
            try {
                      sum += Double.valueOf(str);
            } catch (NumberFormatException e) {
                continue;
            }
            int i = JOptionPane.showConfirmDialog(null,"Xac nhan","Nhap tiep?"
                    , JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
              if(i == JOptionPane.NO_OPTION )  break;
        } while (true);
        
        JOptionPane.showMessageDialog(null, "Tong cac so vua nhap = "+sum);
 
        System.exit(0);
    }
}
