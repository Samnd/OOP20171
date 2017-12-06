package com.company2;

public class Account {
    
    protected String name; // Account name
    protected int balance; // Balance

// Value setting method
    void setData(String pName, int pBalance) {
        name = pName;
        balance = pBalance;
    }
// display() method without argument

    public void display() {
        System.out.println("There is no argument. ");
        System.out.print("Account name: " + name);
        System.out.println("\tBalance: " + balance + "VND");
    }

    public void display(String currency) {
        if (currency.equals("VND")) {
            display();
        } else {
            if (currency.equals("GBP")) {
                System.out.println("There is no argument. ");
                System.out.print("Account name: " + name);
                System.out.println("\tBalance: " + balance / 30000 + "GBP");
            }
        }
    }

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account() {
        name = "Usigned";
        balance = 0;
    }

    public void deposit(long money) {
        balance += money;
    }

    boolean rutTien(long money) {
        if(balance >= money){
            balance -= money;
            return true;
        }
        return false;
    }
    
     public static void main(String args[]) {
        Account obj = new Account();
        obj.setData("Duong Khac San", 100000);
        obj.deposit(20000);
         obj.display();
        if(!obj.rutTien(30000)){
            System.out.println("Loi su du trong tai khoan khong du de rut tien");
        }else{
             System.out.println("Rut tien thanh cong!");
        }
        obj.display();
        obj.display("GBP");
    }
}
