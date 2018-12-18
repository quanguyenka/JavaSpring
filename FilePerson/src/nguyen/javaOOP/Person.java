package nguyen.javaOOP;

public class Person {
	private String hoTen, ngaySinh, diaChi, gioiTinh;
	
	public Person() {
		hoTen = null;
		ngaySinh = null;
		diaChi = null;
		gioiTinh = null;
	}
	
	public Person(String hoTen, String ngaySinh, String diaChi, String gioiTinh) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNgaySinh () {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi () {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	
} 
