package com.company.cuongnt.kiemtra;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<SinhVien> sv = new ArrayList<SinhVien>();
	private static ArrayList<GiangVien> gv = new ArrayList<GiangVien>();
	private static ArrayList<CanBo> cb = new ArrayList<CanBo>();
	
	public static void menu(){
        System.out.println("------------------------------");
        System.out.println("Nguyễn Văn Cường - 20155218");
        System.out.println("1. Thêm đối tượng");
		System.out.println("2. Sửa đối tượng");
		System.out.println("3. Xóa đối tượng");
		System.out.println("4. Xem các đối tượng");
		System.out.println("5. Thoát");

		System.out.print("Bạn chọn chức năng: ");
		int chon = new Scanner(System.in).nextInt();
		switch (chon) {
		case 1:
			themThanhVien();
			break;
		case 2:
			suaThanhVien();
			break;
		case 3:
			xoaThanhVien();
			break;
		case 4:
			thongTinThanhVien();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	private static void thongTinThanhVien() {
		int i=1;
		System.out.println("---------------------------");
        System.out.println("Nguyễn Văn Cường - 20155218");
		System.out.println("STT\tTên sinh viên\t\tSố tiền nợ\t\tGhi chú");
		for(SinhVien sinhVien : sv){
			System.out.print(i+"\t");
			System.out.printf("%s\t\t%.2f\t\t%s\n",sinhVien.getHoTen(),sinhVien.getSoHPNo(),sinhVien.getGhiChu());
			i++;
		}
		System.out.println("---------------------------");
        i=1;
		System.out.println("STT\tTên giảng viên\t\tSố tiền lương\t\tGhi chú");
		for(GiangVien giangVien : gv){
			System.out.print(i+"\t");
			System.out.printf("%s\t\t%.2f\t\t%s\n",giangVien.getHoTen(),giangVien.getSoTienLuong(),giangVien.getGhiChu());
			i++;
		}
		System.out.println("---------------------------");
		i=1;
		System.out.println("STT\tTên cán bộ\t\tSố tiền đã tiêu\t\tGhi chú");
		for(CanBo canBo : cb){
			System.out.print(i+"\t");
			System.out.printf("%s\t\t%.2f\t\t%s\n",canBo.getHoTen(),canBo.getSoTienDaTieu(),canBo.getGhiChu());
			i++;
		}
		System.out.println("---------------------------");
	}

	private static void xoaThanhVien() {
		System.out.println("---------------------------");
        System.out.println("Nguyễn Văn Cường - 20155218");
		System.out.println("Chọn đối tượng cần xóa: ");
		System.out.println("1. Sinh viên");
		System.out.println("2. Giảng viên");
		System.out.println("3. Cán bộ");
		System.out.println("4. Thoát");
		System.out.print("Chọn : ");
		int chon = new Scanner(System.in).nextInt();
		switch (chon) {
		case 1:
		    try {
                xoaSinhVien();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
			break;
		case 2:
            try {
                xoaGiangVien();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            break;
		case 3:
            try {
                xoaCanBo();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            break;
		case 4:
			break;
		default:
			break;
		}
		
	}

	private static void xoaCanBo() {
		System.out.println("---------------------------");
		System.out.print("Xóa cán bộ số : ");
		int i = new Scanner(System.in).nextInt();
		cb.remove(i-1);
		System.out.println("Xóa thành công");
		System.out.println("---------------------------");
	}

	private static void xoaGiangVien() {
		System.out.println("---------------------------");
		System.out.print("Xóa giảng viên số : ");
		int i = new Scanner(System.in).nextInt();
		gv.remove(i-1);
		System.out.println("Xóa thành công");
		System.out.println("---------------------------");
	}

	private static void xoaSinhVien() {
		System.out.println("---------------------------");
		System.out.print("Xóa sinh viên số : ");
		int i = new Scanner(System.in).nextInt();
		sv.remove(i-1);
		System.out.println("Xóa thành công");
		System.out.println("---------------------------");
	}

	private static void suaThanhVien() {
		System.out.println("---------------------------");
        System.out.println("Nguyễn Văn Cường - 20155218");
		System.out.println("Chọn đối tượng cần sửa: ");
		System.out.println("1. Sinh viên");
		System.out.println("2. Giảng viên");
		System.out.println("3. Cán bộ");
		System.out.println("4. Thoát");
		int chon = new Scanner(System.in).nextInt();
		switch (chon) {
		case 1:
			suaSinhVien();
			break;
		case 2:
			suaGiangVien();
			break;
		case 3:
			suaCanBo();
			break;
		case 4:
			break;
		default:
			break;
		
		}
	}

	private static void suaCanBo() {
		System.out.println("---------------------------");
		CanBo cb1 = new CanBo();
		System.out.print("Sửa cán bộ số : ");
		int i = new Scanner(System.in).nextInt();
		cb1 = cb.get(i-1);
		System.out.println("STT\tTên cán bộ\t\tNăm sinh\t\tMã thẻ\t\tSố tiền đã tiêu");
		System.out.printf("%d\t%s\t\t%d\t\t%s\t\t%.2f\n",i,cb1.getHoTen(),cb1.getNamSinh(),cb1.getMaThe(),cb1.getSoTienDaTieu());
		System.out.println("1. Sửa tên");
		System.out.println("2. Sửa năm sinh");
		System.out.println("3. Sửa mã thẻ");
		System.out.println("4. Sửa số tiền đã tiêu");
		System.out.print("Bạn chọn : ");
		int chon = new Scanner(System.in).nextInt();
		switch (chon) {
		case 1:
			System.out.print("Nhập tên mới : ");
			String ten = new Scanner(System.in).nextLine();
			cb1.setHoTen(ten);
			break;
		case 2:
			System.out.print("Nhập năm sinh mới");
			int ns = new Scanner(System.in).nextInt();
			cb1.setNamSinh(ns);
			break;
		case 3:
			System.out.print("Nhập mã thẻ mới : ");
			String mt = new Scanner(System.in).nextLine();
			cb1.setMaThe(mt);
			break;
		case 4:
			System.out.print("Nhập số tiền lương mới : ");
			double st = new Scanner(System.in).nextDouble();
			cb1.setSoTienDaTieu(st);
			cb1.setGhiChu(cb1.getTrangThai());
			break;
		default:
			break;
	}
		System.out.println("Sửa thành công");
		System.out.println("---------------------------");
	}

	private static void suaGiangVien() {
		System.out.println("---------------------------");
		GiangVien gv1 = new GiangVien();
		System.out.print("Sửa giảng viên số : ");
		int i = new Scanner(System.in).nextInt();
		gv1 = gv.get(i-1);
		System.out.println("STT\tTên giảng viên\t\tNăm sinh\t\tMã thẻ\t\tSố tiền lương");
		System.out.printf("%d\t%s\t\t%d\t\t%s\t\t%.2f\n",i,gv1.getHoTen(),gv1.getNamSinh(),gv1.getMaThe(),gv1.getSoTienLuong());
		System.out.println("1. Sửa tên");
		System.out.println("2. Sửa năm sinh");
		System.out.println("3. Sửa mã thẻ");
		System.out.println("4. Sửa số tiền lương");
		System.out.print("Bạn chọn : ");
		int chon = new Scanner(System.in).nextInt();
		switch (chon) {
		case 1:
			System.out.print("Nhập tên mới : ");
			String ten = new Scanner(System.in).nextLine();
			gv1.setHoTen(ten);
			break;
		case 2:
			System.out.print("Nhập năm sinh mới");
			int ns = new Scanner(System.in).nextInt();
			gv1.setNamSinh(ns);
			break;
		case 3:
			System.out.print("Nhập mã thẻ mới : ");
			String mt = new Scanner(System.in).nextLine();
			gv1.setMaThe(mt);
			break;
		case 4:
			System.out.print("Nhập số tiền lương mới : ");
			double tl = new Scanner(System.in).nextDouble();
			gv1.setSoTienLuong(tl);
			gv1.setGhiChu(gv1.getTrangThai());
			break;
		default:
			break;
	}
		System.out.println("Sửa thành công");
		System.out.println("---------------------------");
	}

	private static void suaSinhVien() {
		System.out.println("---------------------------");
		SinhVien sv1 = new SinhVien();
		System.out.print("Sửa sinh viên số : ");
		int i = new Scanner(System.in).nextInt();
		sv1 = sv.get(i-1);
		System.out.println("STT\tTên sinh viên\t\tNăm sinh\t\tMã thẻ\t\tSố học phí nợ");
		System.out.printf("%d\t%s\t\t%d\t\t%s\t\t%.2f\n",i,sv1.getHoTen(),sv1.getNamSinh(),sv1.getMaThe(),sv1.getSoHPNo());
		System.out.println("1. Sửa tên");
		System.out.println("2. Sửa năm sinh");
		System.out.println("3. Sửa mã thẻ");
		System.out.println("4. Sửa số học phí nợ");
		System.out.print("Bạn chọn : ");
		int chon = new Scanner(System.in).nextInt();
		switch (chon) {
		case 1:
			System.out.print("Nhập tên mới : ");
			String ten = new Scanner(System.in).nextLine();
			sv1.setHoTen(ten);
			break;
		case 2:
			System.out.print("Nhập năm sinh mới");
			int ns = new Scanner(System.in).nextInt();
			sv1.setNamSinh(ns);
			break;
		case 3:
			System.out.print("Nhập mã thẻ mới : ");
			String mt = new Scanner(System.in).nextLine();
			sv1.setMaThe(mt);
			break;
		case 4:
			System.out.print("Nhập học phí nợ mới : ");
			double hp = new Scanner(System.in).nextDouble();
			sv1.setSoHPNo(hp);
			sv1.setGhiChu(sv1.getTrangThai());
			break;
		default:
			break;
		}
		System.out.println("Sửa thành công");
		System.out.println("---------------------------");
	}

	private static void themThanhVien() {
		System.out.println("---------------------------");
        System.out.println("Nguyễn Văn Cường - 20155218");
		System.out.println("Chọn đối tượng: ");
		System.out.println("1. Sinh viên");
		System.out.println("2. Giảng viên");
		System.out.println("3. Cán bộ");
		System.out.println("4. Thoát");
		System.out.print("Bạn chọn : ");
		int chon = new Scanner(System.in).nextInt();
		switch (chon) {
		case 1:
			themSinhVien();
			break;
		case 2:
			themGiangVien();
			break;
		case 3:
			themCanBo();
			break;
		case 4:
			break;
		default:
			break;
		
		}
	}

	private static void themCanBo() {
		System.out.println("---------------------------");
		System.out.print("Tên cán bộ: ");
		String ten = new Scanner(System.in).nextLine();
		System.out.print("Năm sinh: ");
		int ns = new Scanner(System.in).nextInt();
		System.out.print("Mã thẻ : ");
		String mt = new Scanner(System.in).nextLine();
		System.out.print("Số tiền đã tiêu : ");
		double st = new Scanner(System.in).nextDouble();
		cb.add(new CanBo(ten, ns, mt, st));
		System.out.println("Thêm cán bộ thành công");
		System.out.println("---------------------------");
	}

	private static void themGiangVien() {
		System.out.println("---------------------------");
		System.out.print("Tên giảng viên: ");
		String ten = new Scanner(System.in).nextLine();
		System.out.print("Năm sinh: ");
		int ns = new Scanner(System.in).nextInt();
		System.out.print("Mã thẻ : ");
		String mt = new Scanner(System.in).nextLine();
		System.out.print("Số tiền lương : ");
		double tl = new Scanner(System.in).nextDouble();
		gv.add(new GiangVien(ten, ns, mt, tl));
		System.out.println("Thêm giảng viên thành công");
		System.out.println("---------------------------");

	}

	private static void themSinhVien() {
		System.out.println("---------------------------");
		System.out.print("Tên sinh viên: ");
		String ten = new Scanner(System.in).nextLine();
		System.out.print("Năm sinh: ");
		int ns = new Scanner(System.in).nextInt();
		System.out.print ("Mã thẻ : ");
		String mt = new Scanner(System.in).nextLine();
		System.out.print("Số học phí nợ : ");
		double hp = new Scanner(System.in).nextDouble();
		sv.add(new SinhVien(ten, ns, mt, hp));
		System.out.println("Thêm sinh viên thành công");
		System.out.println("---------------------------");
	}

	public static void main(String[] args) {
		System.out.println("Nguyễn Văn Cường - 20155218");
		while(true){
			menu();
		}
	}

}
