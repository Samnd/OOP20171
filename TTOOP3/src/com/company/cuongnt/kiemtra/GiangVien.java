package com.company.cuongnt.kiemtra;

public class GiangVien extends ThanhVien{

	private double soTienLuong;

	public GiangVien(){
		super();
	}

	public GiangVien(String hoTen, int namSinh, String maThe, double soTienLuong){
	    super(hoTen, namSinh, maThe);
	    this.soTienLuong = soTienLuong;
        this.setGhiChu(getTrangThai());
    }

    @Override
    public String getTrangThai(){
        if (this.soTienLuong >= 14000000){
            return "Giảng viên cao cấp";
        } else if (this.soTienLuong >= 12000000){
            return "Giảng viên chính";
        } else if (this.soTienLuong >= 10000000){
            return "Giảng viên";
        } else if (this.soTienLuong >= 8000000){
            return "Giảng viên thực hành";
        } else {
            return "Phục vụ đào tạo";
        }
    }

    public double getSoTienLuong() {
        return soTienLuong;
    }

    public void setSoTienLuong(double soTienLuong) {
        this.soTienLuong = soTienLuong;
    }
}
