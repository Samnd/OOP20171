package com.company;

import javax.swing.JOptionPane;

public class LuaChon {
    public static void main(String[] args) {
        int iLuaChon;
        String strLuaChon;
        iLuaChon = JOptionPane.showConfirmDialog(null, "Co loi xay ra. Co muon tiep tuc?","Nguyễn Văn Cường - 20155218"
                ,JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
        if(iLuaChon == JOptionPane.YES_OPTION){
            strLuaChon = "co";
        }else{
            strLuaChon = "khong";
        }
        JOptionPane.showMessageDialog(null, "Ban da chon "+strLuaChon,"Nguyễn Văn Cường - 20155218",1);
        System.exit(0);
    }
}
