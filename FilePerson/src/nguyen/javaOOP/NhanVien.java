package nguyen.javaOOP;

import java.util.Scanner;

public class NhanVien extends Person{
	private String phong;
	private float hsl, luongCB;
	private int thamNien;
	
	public NhanVien() {
		
	}
	
	public NhanVien(String phong, float hsl, float luongCB, int thamNien) {
		this.phong = phong;
		this.hsl = hsl;
		this.luongCB = luongCB;
		this.thamNien = thamNien;
	}
	
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	public float getHsl() {
		return hsl;
	}
	public void setHsl(float hsl) {
		this.hsl = hsl;
	}
	public float getLuongCB() {
		return luongCB;
	}
	public void setLuongCB(float luongCB) {
		this.luongCB = luongCB;
	}
	public int getThamNien() {
		return thamNien;
	}
	public void setThamNien(int thamNien) {
		this.thamNien = thamNien;
	}
	
}
