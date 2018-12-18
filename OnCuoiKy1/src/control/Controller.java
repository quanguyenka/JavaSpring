/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import object.Person;
import object.Student;

/**
 *
 * @author quang
 */
public class Controller {

    Person p = new Person();
    Student s = new Student();
    public ArrayList<Student> list = new ArrayList<Student>();

    public void NhapDulieu() {
        s = new Student();
        System.out.print("Nhap ho ten : ");
        s.setHoTen(new Scanner(System.in).nextLine());
        System.out.print("Nhap ngay sinh: ");
        s.setNgaySinh(new Scanner(System.in).nextLine());
        System.out.print("Nhap dia chi: ");
        s.setDiaChi(new Scanner(System.in).nextLine());
        System.out.print("Nhap gioi tinh: ");
        s.setGioiTinh(new Scanner(System.in).nextLine());
        System.out.print("Nhap ma sinh vien: ");
        s.setMaSv(new Scanner(System.in).nextLine());
        System.out.print("Nhap email: ");
        s.setEmail(new Scanner(System.in).nextLine());
        System.out.print("Nhap diem");
        s.setDiem(new Scanner(System.in).nextFloat());
        list.add(s);
    }

    public void LuuDulieu() {
        String filePath = "sinhvien.dat";
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("Ho ten$Ngay sinh$Dia chi$Gioi tinh$Ma SV$Email$Diem TB");
                bw.close();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                bw.newLine();
                bw.write(list.get(i).getHoTen() + "$" + list.get(i).getNgaySinh() + "$" + list.get(i).getDiaChi() + "$"
                        + list.get(i).getGioiTinh() + "$" + list.get(i).getMaSv() + "$" + list.get(i).getEmail()
                        + "$" + list.get(i).getDiem());
            }
            list.clear();
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
