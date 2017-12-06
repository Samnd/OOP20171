package com.company.cuongnt.kiemtra;

abstract class ThanhVien {
	private String hoTen;
	private int namSinh;
	private String maThe;
	private String ghiChu;

	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getMaThe() {
		return maThe;
	}
	public void setMaThe(String maThe) {
		this.maThe = maThe;
	}

	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public ThanhVien(String hoTen, int namSinh, String maThe) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.maThe = maThe;
	}

	public abstract String getTrangThai();

	public ThanhVien() {

	}
	
}
