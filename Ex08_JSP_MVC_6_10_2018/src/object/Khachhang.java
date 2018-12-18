package object;

public class Khachhang {
	private String cusCode, hoTen, email, diaChi, carCode, packagetype,cartype;
	private int sdt;
		
	public Khachhang() {
		
	}

	public Khachhang(String cusCode, String hoTen, String email, String diaChi, String carCode, String packagetype,
			String cartype, int sdt) {
		super();
		this.cusCode = cusCode;
		this.hoTen = hoTen;
		this.email = email;
		this.diaChi = diaChi;
		this.carCode = carCode;
		this.packagetype = packagetype;
		this.cartype = cartype;
		this.sdt = sdt;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getPackagetype() {
		return packagetype;
	}

	public void setPackagetype(String packagetype) {
		this.packagetype = packagetype;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	
	
}
