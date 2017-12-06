package com.company.bai4;

public abstract class Account {

    protected String name;
    protected double balance;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    
     public Account() {
        name = "Usigned";
        balance = 0;
    }

    public abstract void deposit(long money);

    public abstract boolean rutTien(long money);

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

   
    public static void main(String[] args) {
        Account account = new Account() {
            @Override
            public void deposit(long money) {
                
            }

            @Override
            public boolean rutTien(long money) {
                return true;
            }
        };
        account.deposit(0);
    }
}
