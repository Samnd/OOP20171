package com.company.bai4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreditAccount extends Account {

    private double limit;
    private double debitInterest;
    private double creditInterest;
    private int dateCreated;
    Scanner s;

    public CreditAccount(int dateCreated, double limit, double creditInterest, double debitInterest, int balance, String name) {
        super(name, balance);
        this.limit = limit;
        this.debitInterest = debitInterest;
        this.creditInterest = creditInterest;
        this.dateCreated = dateCreated;
    }

    @Override
    public void deposit(long money) {
        balance += money;
    }

    @Override
    public boolean rutTien(long money) {
        if (money > balance + limit) {
            System.out.println("Rút không thành công");
            return false;
        } else {
            balance -= money;
            System.out.println("Rút thành công");
            return true;
        }
    }

    public void tinhLai() {
        if (balance > 0) {
            balance += balance * debitInterest;
        } else {
            balance += balance * creditInterest;
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Lãi suất gửi :" + debitInterest);
        System.out.println("Lãi suất ghi nợ :" + creditInterest);
        System.out.println("Hạn mức :" + limit);

    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setDebitInterest(double debitInterest) {
        this.debitInterest = debitInterest;
    }

    public void setCreditInterest(double creditInterest) {
        this.creditInterest = creditInterest;
    }

    public void creatMenu() {
        System.out.println("1.Nhập lãi suất gửi");
        System.out.println("2.Nhập lãi suất ghi nợ");
        System.out.println("3.Nhập hạn mức");
        System.out.println("4.Rút tiền");
        System.out.println("5.Gửi tiền");
        System.out.println("6.Tính lãi");
        System.out.println("7.In thông tin");
        System.out.println("8.Thoát");
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
                        System.out.print("Nhập lãi suất gửi :");
                        double debitInterest = s.nextDouble();
                        setDebitInterest(debitInterest);
                        break;
                    case 3:
                        System.out.print("Nhập hạn mức:");
                        int limit = s.nextInt();
                        setLimit(limit);
                        break;
                    case 2:
                        System.out.print("Nhập lãi suất ghi nợ :");
                        double credit = s.nextDouble();
                        setCreditInterest(credit);
                        break;
                    case 4:
                        System.out.print("Nhập số tiền muốn rut :");
                        int rutTien = s.nextInt();
                        rutTien(rutTien);
                        break;
                    case 5:
                        System.out.print("Nhập số tiền muốn gửi :");
                        int depossit = s.nextInt();
                        deposit(depossit);
                        break;
                    case 7:
                        display();
                        break;
                    case 8:
                        System.out.println("Thoát chương trình .");
                        System.exit(0);
                    case 6:
                        tinhLai();
                        display();
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                selectNumber = 8;
                System.out.println("Bạn nhập sai định dạng !");
                chonChucNang();
            }
        } while (selectNumber != 8);

    }

    public static void main(String[] args) {
        System.out.println("Nguyễn Văn Cường - 20155218");
        CreditAccount c = new CreditAccount(200, 200000, 0.3, 0.4, 1000000, "Nguyễn Văn Cường");
        c.chonChucNang();
    }
}
