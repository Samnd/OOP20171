package com.company.bai4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckingAccount extends Account {

    Scanner s;

    public CheckingAccount(String name, int balance) {
        super(name, balance);
    }

    @Override
    public void deposit(long money) {
        this.balance = this.balance + money;
        System.out.println("Gửi thành công");
    }

    @Override
    public boolean rutTien(long money) {
        if (money > this.balance) {
            System.out.println("Không được rút quá số dư");
            return false;
        } else {
            this.balance -= money;
            System.out.println("Rút thành công");
            return true;
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
        System.out.println("Nguyễn Văn Cường - 20155218");
        CheckingAccount c = new CheckingAccount("Nguyễn Văn Cường", 10000);
        c.chonChucNang();
    }
}
