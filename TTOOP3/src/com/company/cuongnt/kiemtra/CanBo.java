package com.company.cuongnt.kiemtra;

public class CanBo extends ThanhVien {

	private double soTienDaTieu;

	public CanBo(){
		super();
	}

	public CanBo(String hoTen, int namSinh, String maThe, double soTienDaTieu){
	    super(hoTen, namSinh, maThe);
        this.soTienDaTieu = soTienDaTieu;
        this.setGhiChu(getTrangThai());
	}

	@Override
    public String getTrangThai(){
	    if (this.soTienDaTieu >= 14000000){
	        return "Giám đốc";
        } else if (this.soTienDaTieu >= 12000000){
	        return "Phó giám đốc";
        } else if (this.soTienDaTieu >= 10000000){
            return "Trưởng phòng";
        } else if (this.soTienDaTieu >= 8000000){
            return "Phó phòng";
        } else {
            return "Nhân viên";
        }
    }

    public double getSoTienDaTieu() {
        return soTienDaTieu;
    }

    public void setSoTienDaTieu(double soTienDaTieu) {
        this.soTienDaTieu = soTienDaTieu;
    }
}
