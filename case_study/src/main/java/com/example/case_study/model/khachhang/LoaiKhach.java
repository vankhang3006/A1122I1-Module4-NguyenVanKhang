package com.example.case_study.model.khachhang;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loai_khach")
public class LoaiKhach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoaiKhach;
    private String tenLoaiKhach;
    @OneToMany(mappedBy = "loaiKhach")
    private List<KhachHang> khachHangs;

    public LoaiKhach() {
    }

    public LoaiKhach(int maLoaiKhach, String tenLoaiKhach) {
        this.maLoaiKhach = maLoaiKhach;
        this.tenLoaiKhach = tenLoaiKhach;
    }

    public LoaiKhach(int maLoaiKhach, String tenLoaiKhach, List<KhachHang> khachHangs) {
        this.maLoaiKhach = maLoaiKhach;
        this.tenLoaiKhach = tenLoaiKhach;
        this.khachHangs = khachHangs;
    }

    public int getMaLoaiKhach() {
        return maLoaiKhach;
    }

    public void setMaLoaiKhach(int maLoaiKhach) {
        this.maLoaiKhach = maLoaiKhach;
    }

    public String getTenLoaiKhach() {
        return tenLoaiKhach;
    }

    public void setTenLoaiKhach(String tenLoaiKhach) {
        this.tenLoaiKhach = tenLoaiKhach;
    }

    public List<KhachHang> getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(List<KhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }
}
