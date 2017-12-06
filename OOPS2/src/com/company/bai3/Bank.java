package com.company.bai3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bank {

    List<Account> listAccount;
    Scanner s;

    public Bank() {
        listAccount = new ArrayList<>();
        chonChucNang();
    }

    public Bank(List<Account> listAccount) {
        this.listAccount = listAccount;
    }

    public void themAccount(Account account) {
        listAccount.add(account);
    }

    public boolean xoaAccount(String name) {
        for (Account account : listAccount) {
            if (account.getName().equals(name)) {
                listAccount.remove(account);
                return true;
            }
        }
        return false;
    }

    public void inThongTin() {
        for (int i = 0; i < listAccount.size(); i++) {
            listAccount.get(i).display();
        }
    }

    public double tinhTongTien() {
        double sum = 0.0d;
        for (int i = 0; i < listAccount.size(); i++) {
            sum += listAccount.get(i).getBalance();
        }
        return sum;
    }

    public void creatMenu() {
        System.out.println("1.Thêm account");
        System.out.println("2.Xóa account");
        System.out.println("3.In thông tin tất cả tài khoản");
        System.out.println("4.Tính tổng tiền tất cả tài khoản");
        System.out.println("5.Thoát");
        System.out.print("Bạn chọn: ");
    }

    public void chonChucNang() {
        s = new Scanner(System.in);
        int selectNumber;
        do {
            creatMenu();
            try {
                selectNumber = s.nextInt();
                switch (selectNumber) {
                    case 1:
                        System.out.print("Nhập tên: ");
                        String name = s.next();
                        s.nextLine();
                        System.out.print("Nhập số dư: ");
                        int balance = s.nextInt();
                        Account account = new Account(name, balance);
                        themAccount(account);
                        break;
                    case 2:
                        System.out.print("Nhập tên tài khoản muốn xóa: ");
                        String deletename = s.next();
                        if (xoaAccount(deletename)) {
                            System.out.println("Xóa thành công");
                        } else {
                            System.out.println("Tên tài khoản muốn xóa không đúng !");
                        }
                        break;
                    case 3:
                        inThongTin();
                        break;
                    case 4:
                        System.out.println("Tổng số dư tất cả tài khoản là : " + tinhTongTien());
                        break;
                    case 5:
                        System.out.println("Thoát chương trình .");
                        System.exit(0);

                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                selectNumber = 5;
                System.out.println("Bạn nhập sai định dạng !");
                chonChucNang();
            }
        } while (selectNumber != 5);

    }

    public static void main(String[] args) {
        System.out.println("Nguyễn Văn Cường - 20155218 ");
        Bank bank = new Bank();
    }

}
