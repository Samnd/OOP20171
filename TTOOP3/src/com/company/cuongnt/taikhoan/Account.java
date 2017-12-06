package com.company.cuongnt.taikhoan;

public abstract class Account {

    protected String name;
    protected double balance;
    public static final double transferRate = 0.1;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Account() {
        name = "Unsigned";
        balance = 0;
    }

    public abstract void deposit(double money);

    public abstract boolean rutTien(double money);

    public abstract void inThongTin();

    void setData(String pName, int pBalance) {
        name = pName;
        balance = pBalance;
    }

    public void display() {
        System.out.print("Account name: " + name);
        System.out.println("\tBalance: " + (int) balance + " VND");
    }

    public void display(String currency) {
        if (currency.equals("VND")) {
            display();
        } else {
            if (currency.equals("GBP")) {
                System.out.print("Account name: " + name);
                System.out.println("\tBalance: " + balance / 30000 + "GBP");
            }
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
