package com.company;

import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog(null, "Hay nhap ten ban: ", "Nguyễn Văn Cường - 20155218", 1);
        
        if(result == null) System.exit(0);
        JOptionPane.showMessageDialog(null, "Xin chao "+result+"!");
        System.exit(0);
    }
}
