package com.company.cuongnt.kiemtra;

public class SinhVien extends ThanhVien{
	
	private double soHPNo;

	public SinhVien(){
		super();
	}

	public SinhVien(String hoTen, int namSinh, String maThe, double soHPNo){
		super(hoTen, namSinh, maThe);
		this.soHPNo = soHPNo;
		this.setGhiChu(getTrangThai());
	}

	@Override
	public String getTrangThai(){
		if (this.soHPNo >= 8000000){
			return "Quyết định đuổi học";
		} else if (this.soHPNo >= 5000000){
			return "Cảnh cáo mức 2";
		} else if (this.soHPNo >= 3000000){
			return "Cảnh cáo mức 1";
		} else if (this.soHPNo >= 1000000){
			return "Nhắc nhở";
		} else {
			return "Bình thường";
		}
	}

	public double getSoHPNo() {
		return soHPNo;
	}

	public void setSoHPNo(double soHPNo) {
		this.soHPNo = soHPNo;
	}
}
