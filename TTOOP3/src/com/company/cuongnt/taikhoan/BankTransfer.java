package com.company.cuongnt.taikhoan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankTransfer {

    private static List<Bank> listBank = new ArrayList<>();
    private Scanner scan;

    private void creatMenu() {
        System.out.println("------------------------------");
        System.out.println("Nguyễn Văn Cường - 20155218");
        System.out.println("1.Quản lý Ngân hàng");
        System.out.println("2.Chuyển tiền");
        System.out.println("3.Thoát");
        System.out.print("Bạn chọn: ");
    }

    private Bank getBank(int i){
        if (i > listBank.size()){
            return null;
        } else {
            return listBank.get(i);
        }
    }

    private void chonChucNang() {
        scan = new Scanner(System.in);
        int selectNumber;
        do {
            creatMenu();
            try {
                selectNumber = scan.nextInt();
                switch (selectNumber) {
                    case 1:
                        System.out.println("Nguyễn Văn Cường - 20155218");
                        System.out.print("Nhập ngân hàng quản lý:");
                        int number = scan.nextInt();
                        Bank bankManagement = getBank(number);
                        if (bankManagement == null){
                            System.out.println("Không tìm thấy ngân hàng.");
                        } else {
                            bankManagement.chonChucNang();
                        }
                        break;
                    case 2:
                        System.out.println("Nguyễn Văn Cường - 20155218");
                        System.out.print("Nhập số tiền muốn chuyển : ");
                        int transfer = scan.nextInt();
                        System.out.println();
                        System.out.print("Nhập mã ngân hàng gửi: ");
                        int fromBank = scan.nextInt();
                        System.out.println();
                        System.out.print("Nhập mã ngân hàng nhận: ");
                        int toBank = scan.nextInt();
                        System.out.println();
                        System.out.print("Nhập số tài khoản gửi: ");
                        int fromAcc = scan.nextInt();
                        System.out.println();
                        System.out.print("Nhập số tài khoản nhận: ");
                        int toAcc = scan.nextInt();
                        System.out.println();
                        System.out.print("Chọn người trả phí: (1 - Người gửi, 0 - Người nhận) ");
                        int traphi = scan.nextInt();
                        System.out.println();
                        if (getBank(fromBank) != null && getBank(toBank) != null){
                            boolean result = getBank(fromBank).chuyenTienAdmin(fromAcc, toAcc, transfer, getBank(toBank), traphi);
                            if (result){
                                System.out.println(" Chuyển tiền thành công.");
                            } else {
                                System.out.println("Chuyển tiền thất bại.");
                            }
                        } else {
                            System.out.println("Chuyển tiền thất bại.");
                        }
                        break;
                    case 3:
                        System.out.println("Thoát.");
                        System.exit(0);
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                selectNumber = 3;
                System.out.println("Bạn nhập sai định dạng !");
                chonChucNang();
            }
        } while (selectNumber != 3);

    }

    public static void main(String[] args) {
        System.out.println("Nguyễn Văn Cường - 20155218");
        List<Account> listAccountHN = new ArrayList<>();
        listAccountHN.add((Account) new SavingAccount("Cuong HN Saving", 125000, 1.25));
        listAccountHN.add((Account) new CreditAccount(500, 10000000, 1.1, 1.25, 250000, "Cuong HN Credit"));
        listAccountHN.add((Account) new CheckingAccount("Cuong HN Checking", 300000));
        Bank HN = new Bank(listAccountHN);
        listBank.add(HN);

        List<Account> listAccountHCM = new ArrayList<>();
        listAccountHCM.add((Account) new SavingAccount("Cuong HCM Saving", 125000, 1.25));
        listAccountHCM.add((Account) new CreditAccount(500, 10000000, 1.1, 1.25, 250000, "Cuong HCM Credit"));
        listAccountHCM.add((Account) new CheckingAccount("Cuong HCM Checking", 300000));
        Bank HCM = new Bank(listAccountHCM);
        listBank.add(HCM);
        new BankTransfer().chonChucNang();
    }
}
