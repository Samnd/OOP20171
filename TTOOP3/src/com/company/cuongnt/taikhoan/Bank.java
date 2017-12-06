package com.company.cuongnt.taikhoan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bank {

    private List<Account> listAccount;
    private Scanner s;

    public Bank() {
        listAccount = new ArrayList<>();
    }

    public Bank(List<Account> listAccount) {
        this.listAccount = listAccount;
    }

    public List<Account> getListAccount() {
        return listAccount;
    }

    public void themAccount(Account account) {
        listAccount.add(account);
    }

    private Account getAccount(int i){
        if (i > listAccount.size()){
            return null;
        } else {
            return listAccount.get(i);
        }
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

    public void inThongTinTaiKhoan() {
        for (Account aListAccount : listAccount) {
            aListAccount.inThongTin();
        }
    }

    public double tinhTongTien() {
        double sum = 0.0d;
        for (int i = 0; i < listAccount.size(); i++) {
            sum += listAccount.get(i).getBalance();
        }
        return sum;
    }

    private void creatMenu() {
        System.out.println("------------------------------");
        System.out.println("1.Thêm Saving Account");
        System.out.println("2.Thêm Checking Account");
        System.out.println("3.Thêm Credit Account");
        System.out.println("4.Xóa account");
        System.out.println("5.In thông tin tất cả tài khoản");
        System.out.println("6.Tính tổng tiền tất cả tài khoản");
        System.out.println("7.Thoát");
        System.out.print("Bạn chọn: ");
    }

    public boolean chuyenTienAdmin(int fromAcc, int toAcc, double money, Bank toBank, int traphi){
        if (this.getAccount(fromAcc) == null || toBank.getAccount(toAcc) == null){
            return false;
        } else {
            if (this.getAccount(fromAcc).rutTien(money)){
                if (toBank.getAccount(toAcc) instanceof SavingAccount){
                    if (((SavingAccount) toBank.getAccount(toAcc)).depositFromAnother(money)){
                        double phi = money*(this.getAccount(fromAcc).transferRate);
                        if (traphi == 1){
                            this.getAccount(fromAcc).rutTien(phi);
                        } else {
                            toBank.getAccount(toAcc).rutTien(phi);
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    double phi = money*(this.getAccount(fromAcc).transferRate);
                    if (traphi == 1){
                        this.getAccount(fromAcc).rutTien(phi);
                    } else {
                        toBank.getAccount(toAcc).rutTien(phi);
                    }
                    toBank.getAccount(toAcc).deposit(money);
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public void chonChucNang() {
        s = new Scanner(System.in);
        int selectNumber;
        String name;
        double balance;
        do {
            creatMenu();
            try {
                selectNumber = s.nextInt();
                switch (selectNumber) {
                    case 1:
                        System.out.print("Nhập tên: ");
                        name = s.next();
                        s.nextLine();
                        System.out.print("Nhập số dư: ");
                        balance = s.nextInt();
                        SavingAccount account = new SavingAccount( name, balance, 1.25);
                        Account acc = account;
                        themAccount(acc);
                        break;
                    case 2:
                        System.out.print("Nhập tên: ");
                        name = s.next();
                        s.nextLine();
                        System.out.print("Nhập số dư: ");
                        balance = s.nextInt();
                        CheckingAccount account1 = new CheckingAccount(name, balance);
                        acc = account1;
                        themAccount(acc);
                        break;
                    case 3:
                        System.out.print("Nhập tên: ");
                        name = s.next();
                        s.nextLine();
                        System.out.print("Nhập số dư: ");
                        balance = s.nextInt();
                        CreditAccount account2 = new CreditAccount(200, 2000000, 0.3, 0.4, balance, name);
                        acc = account2;
                        themAccount(acc);
                        break;
                    case 4:
                        System.out.print("Nhập tên tài khoản muốn xóa: ");
                        String deleteName = s.next();
                        if (xoaAccount(deleteName)) {
                            System.out.println("Xóa thành công");
                        } else {
                            System.out.println("Tên tài khoản muốn xóa không đúng !");
                        }
                        break;
                    case 5:
                        inThongTinTaiKhoan();
                        break;
                    case 6:
                        System.out.println("Tổng số dư tất cả tài khoản là : " + tinhTongTien());
                        break;
                    case 7:
                        System.out.println("Thoát chương trình .");
                        selectNumber = 7;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                selectNumber = 7;
                System.out.println("Bạn nhập sai định dạng !");
                chonChucNang();
            }
        } while (selectNumber != 7);

    }

    public static void main(String[] args) {
        System.out.println("Nguyễn Văn Cường - 20155218 ");
        List<Account> listAccount = new ArrayList<>();
        SavingAccount saving = new SavingAccount("Cường Saving", 100000, 1.25);
        Account accSaving = saving;
        listAccount.add(accSaving);
        CreditAccount credit = new CreditAccount(300, 2000000, 0.75, 0.6, 120000, "Cuong Credit");
        Account accCredit = credit;
        listAccount.add(accCredit);
        CheckingAccount checking = new CheckingAccount("Cuong Checking", 155000);
        Account accChecking = checking;
        listAccount.add(accChecking);
        Bank bank = new Bank(listAccount);
        bank.chonChucNang();
    }

}
