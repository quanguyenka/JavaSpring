package object;

public class Baohiem {
	
	private String packagecartype, cartype;
	private int namsx;
	
	
	public Baohiem() {
	}




	public Baohiem(String packagecartype, String cartype, int namsx) {
		this.packagecartype = packagecartype;
		this.cartype = cartype;
		this.namsx = namsx;
	}


	public String getPackagecartype() {
		return packagecartype;
	}


	public void setPackagecartype(String packagecartype) {
		this.packagecartype = packagecartype;
	}


	public String getCartype() {
		return cartype;
	}


	public void setCartype(String cartype) {
		this.cartype = cartype;
	}


	public int getNamsx() {
		return namsx;
	}


	public void setNamsx(int namsx) {
		this.namsx = namsx;
	}
	
	
}
