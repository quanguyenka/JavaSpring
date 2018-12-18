/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author quang
 */
public class Student extends Person{

    private String maSv, email;
    private float diem;

    public Student() {
    }

    public Student(String maSv, String email, float diem) {
        this.maSv = maSv;
        this.email = email;
        this.diem = diem;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
    public void HienThiThongTin() {
        super.HienThiThongTin();
        System.out.println("Ma sinh vien: "+getMaSv());
        System.out.println("Email: "+getEmail());
        System.out.println("Diem: "+getDiem());
    }
}
