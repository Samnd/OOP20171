package com.company.cuongnt.taikhoan;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SavingAccount extends Account {

    private double laiXuat;
    private Date dateCreated;
    private Scanner s;

    public static final double transferRate = 0.12;

    public SavingAccount(String name, double balance, double laiXuat) {
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
    public void deposit(double money) {
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        if (today.getMonth() == this.dateCreated.getMonth() && this.dateCreated.getDay() == today.getDay()) {
            balance = balance + money;
            System.out.println("Gửi tiền thành công");
        } else {
            System.out.println("Gửi tiền không thành công");
        }
    }

    public boolean depositFromAnother(double money) {
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        if (today.getMonth() == this.dateCreated.getMonth() && this.dateCreated.getDay() == today.getDay()) {
            balance = balance + money;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean rutTien(double money) {
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        if (today.getMonth() == this.dateCreated.getMonth() && this.dateCreated.getDay() == today.getDay()) {
            if (money > balance) {
                System.out.println("Rút tiền không thành công");
                return false;
            } else {
                balance -= money;
//                System.out.println("Rút tiền thành công");
                return true;
            }
        } else {
//            System.out.println("Rút tiền không thành công");
            return false;
        }
    }

    @Override
    public void inThongTin(){
        System.out.println("Tài khoản của " + this.name + " có số dư là: " + this.balance);
        System.out.println("Ngày tạo tài khoản: " + this.dateCreated + ", với lãi xuất là: " + this.laiXuat);
        System.out.println("Phương thức của Saving Account.");
    }

    private void creatMenu() {
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
                        int deposit = s.nextInt();
                        deposit(deposit);
                        break;
                    case 3:
                        display();
                        display("GBP");
                        break;
                    case 4:
                        System.out.println("Thoát.");
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

    /**
     * Main function cho bài thực hành về Up-casting và Down-Casting
     * todo: Up-casting, Down-Casting
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Nguyễn văn Cường - 20155218 ");
        System.out.println("Up-Casting");
        SavingAccount savingAcc = new SavingAccount("Cuong", 120000, 1.25);
        Account acc = savingAcc;
        acc.inThongTin();
        System.out.println("Down-casting");
        Account down = new Account() {
            @Override
            public void deposit(double money) {

            }

            @Override
            public boolean rutTien(double money) {
                return false;
            }

            @Override
            public void inThongTin() {
                System.out.println("Tài khoản của" + this.name + " có số dư là: " + this.balance);
                System.out.println("Phương thức của lớp Account.");
            }
        };
        try {
            SavingAccount saving = (SavingAccount) down;
            saving.inThongTin();
        } catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
        try {
            CreditAccount saving1 = (CreditAccount) down;
            saving1.inThongTin();
        } catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
        try {
            CheckingAccount saving2 = (CheckingAccount) down;
            saving2.inThongTin();
        } catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
    }

}
