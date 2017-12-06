package com.company;

import javax.swing.JOptionPane;

public class HienThiHaiSo {
    public static void main(String[] args) {
        String strSo1,strSo2;
        String strHienThi = "Ban vua nhap ";
        strSo1 = JOptionPane.showInputDialog(null,"Hay nhap so thu 1: ","Nguyễn Văn Cường - 20155218",JOptionPane.INFORMATION_MESSAGE);
        if(strSo1 == null) System.exit(0);
        strSo2 = JOptionPane.showInputDialog(null,"Hay nhap so thu 2: ","Nguyễn Văn Cường - 20155218",JOptionPane.INFORMATION_MESSAGE);
        if(strSo2 == null) System.exit(0);
       JOptionPane.showMessageDialog(null, strHienThi +strSo1 +" Va "+strSo2,"Hien thi hai so",JOptionPane.INFORMATION_MESSAGE);
       // System.out.println("Tong hai so vua nhap  = "+Integer.valueOf(strSo1)+ Integer.valueOf(strSo2));
        JOptionPane.showMessageDialog(null, "Tong hai so = "+(Integer.valueOf(strSo1)+ Integer.valueOf(strSo2)), "Nguyễn Văn Cường - 20155218", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
