package itsol.object;

public class SinhVien {
	private String id, hoTen, email, sdt, lop, ghichu, acount;
	
	public SinhVien(String id, String hoTen, String email, String sdt, String lop, String ghichu, String acount) {
        this.id = id;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.lop = lop;
        this.ghichu = ghichu;
        this.acount = acount;
    }

    public SinhVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    @Override
    public String toString() {
        return "sinhvien{" + "id=" + id + ", hoTen=" + hoTen + ", email=" + email + ", sdt=" + sdt + ", lop=" + lop + ", ghichu=" + ghichu + ", acount=" + acount + '}';
    }
}
