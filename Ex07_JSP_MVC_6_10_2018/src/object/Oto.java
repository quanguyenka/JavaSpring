package object;

public class Oto {
	private String maXe, hangXe, loaixe, baoHiem;
    private int namSx, soLuong;
    private float giaXe;
    
    
    
	public Oto() {
		
	}

	public Oto(String maXe, String hangXe, String loaixe, String baoHiem, int namSx, int soLuong, float giaXe) {
		super();
		this.maXe = maXe;
		this.hangXe = hangXe;
		this.loaixe = loaixe;
		this.baoHiem = baoHiem;
		this.namSx = namSx;
		this.soLuong = soLuong;
		this.giaXe = giaXe;
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public String getHangXe() {
		return hangXe;
	}

	public void setHangXe(String hangXe) {
		this.hangXe = hangXe;
	}

	public String getLoaixe() {
		return loaixe;
	}

	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}

	public String getBaoHiem() {
		return baoHiem;
	}

	public void setBaoHiem(String baoHiem) {
		this.baoHiem = baoHiem;
	}

	public int getNamSx() {
		return namSx;
	}

	public void setNamSx(int namSx) {
		this.namSx = namSx;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGiaXe() {
		return giaXe;
	}

	public void setGiaXe(float giaXe) {
		this.giaXe = giaXe;
	}


}
