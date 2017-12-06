package com.company.bai4;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SavingAccount extends Account {

    private double laiXuat;
    private Date dateCreated;
    Scanner s;

    public SavingAccount(String name, int balance, double laiXuat) {
        super(name, balance);
        this.laiXuat = laiXuat;
        dateCreated = new Date(System.currentTimeMillis());
    }

    public void tinhLai() {
        this.balance += this.balance * this.laiXuat;
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

    @Override
    public void deposit(long money) {
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        if (today.getMonth() == this.dateCreated.getMonth() && this.dateCreated.getDay() == today.getDay()) {
            balance = balance + money;
            System.out.println("Gửi tiền thành công");
        } else {
            System.out.println("Gửi tiền không thành công");
        }
    }

    @Override
    public boolean rutTien(long money) {
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        if (today.getMonth() == this.dateCreated.getMonth() && this.dateCreated.getDay() == today.getDay()) {
            if (money > balance) {
                System.out.println("Rút tiền không thành công");
                return false;
            } else {
                balance -= money;
                System.out.println("Rút tiền thành công");
                return true;
            }
        } else {
            System.out.println("Rút tiền không thành công");
            return false;
        }
    }

    public void creatMenu() {
        System.out.println("1.Rút tiền");
        System.out.println("2.Gửi tiền");
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
                        System.out.print("Nhập số tiền muốn rút :");
                        int balance = s.nextInt();
                        rutTien(balance);
                        break;
                    case 2:
                        System.out.print("Nhập số tiền muốn gửi :");
                        int depossit = s.nextInt();
                        deposit(depossit);
                        break;
                    case 3:
                        display();
                        display("GBP");
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
        System.out.println("Nguyễn Văn Cường - 20155218 ");
        SavingAccount s = new SavingAccount("", 1000000, 0.5);
        s.chonChucNang();
    }

}
