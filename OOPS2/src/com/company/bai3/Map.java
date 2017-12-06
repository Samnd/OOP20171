package com.company.bai3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Map {

    ArrayList<Vehicle> list;
    Scanner s;

    public Map(ArrayList<Vehicle> list) {
        this.list = list;
    }

    public void update() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).move();
        }
        System.out.println("Các phương tiện đã được update vị trí");
    }

    public void display() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).display();
        }
    }

    public void creatMenu() {
        System.out.println("1.Update vị trí");
        System.out.println("2.Hiển thị tọa đọ");
        System.out.println("3.Thoát");
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
                        update();
                        break;
                    case 2:
                        display();
                        break;
                    case 3:
                        System.out.println("Thoát chương trình .");
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
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(20, 30, 10, 8, 0.75));
        vehicles.add(new Bike(30, 50, 20, 16, 0.8));
        Map map = new Map(vehicles);
        map.chonChucNang();
    }
}
