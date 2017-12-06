package com.company.bai3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SavingAccount extends Account {

    private double laiXuat;
    private List<Account> accounts;
    Scanner s;

    public SavingAccount(String name, int balance, double laiXuat, ArrayList<Account> accounts) {
        super(name, balance);
        this.accounts = accounts;
        this.laiXuat = laiXuat;
        chonChucNang();
    }

    public void tinhTienLai() {
        for (Account account : accounts) {
            account.setBalance(account.getBalance()+account.getBalance() * laiXuat);
        }
         System.out.println("TÍnh lãi thành công !");
    }

    public void inThongTin() {
        for (Account account : accounts) {
            account.display();
            account.display("GBP");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Lai xuat: " + this.laiXuat);
    }

    @Override
    public void display(String x) {
        super.display(x);
        System.out.println("Lai xuat: " + this.laiXuat);
    }

    public void setLaiXuat(double laiXuat) {
        this.laiXuat = laiXuat;
    }

    public void creatMenu() {
        System.out.println("1.Nhập lãi suất");
        System.out.println("2.Tính lãi ");
        System.out.println("3.In thông tin");
        System.out.println("4.Thoát");
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
                        System.out.print("Nhập lãi suất: ");
                        double laiXuat = s.nextDouble();
                        setLaiXuat(laiXuat);
                        break;
                    case 2:
                        tinhTienLai();
                        break;
                    case 3:
                        inThongTin();
                        break;
                    case 4:
                        System.out.println("Thoát chương trình .");
                        System.exit(0);

                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                selectNumber = 4;
                System.out.println("Bạn nhập sai định dạng !");
                chonChucNang();
            }
        } while (selectNumber != 4);

    }

    public static void main(String[] args) {
          System.out.println("Nguyễn Văn Cường- 20155218!");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Nguyễn Văn Cường", 20155218));
        accounts.add(new Account("Cuong Nguyen", 200000));
        SavingAccount account = new SavingAccount("Cuong Nguyen", 10000000, 0.03, accounts);

    }
}
