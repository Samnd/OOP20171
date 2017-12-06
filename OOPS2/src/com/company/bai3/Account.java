/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.bai3;

/**
 *
 * @author MyLap
 */
public class Account {

    protected String name; 
    protected double balance;

    void setData(String pName, int pBalance) {
        name = pName;
        balance = pBalance;
    }


    public void display() {
        System.out.print("Account name: " + name);
        System.out.println("\tBalance: " +(int) balance + " VND");
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

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
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

    public Account() {
        name = "Usigned";
        balance = 0;
    }

    public void deposit(long money) {
        balance += money;
    }

    boolean rutTien(long money) {
        if (balance >= money) {
            balance -= money;
            return true;
        }
        return false;
    }

}
