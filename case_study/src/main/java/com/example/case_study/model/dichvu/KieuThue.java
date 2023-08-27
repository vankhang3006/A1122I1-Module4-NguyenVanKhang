package com.example.case_study.model.dichvu;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "kieu_thue")
public class KieuThue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKieuThue;
    private String tenKieuThue;
    @OneToMany(mappedBy = "kieuThue")
    private List<DichVu> dichVus;

    public KieuThue() {
    }

    public KieuThue(int maKieuThue, String tenKieuThue) {
        this.maKieuThue = maKieuThue;
        this.tenKieuThue = tenKieuThue;
    }

    public KieuThue(int maKieuThue, String tenKieuThue, List<DichVu> dichVus) {
        this.maKieuThue = maKieuThue;
        this.tenKieuThue = tenKieuThue;
        this.dichVus = dichVus;
    }

    public int getMaKieuThue() {
        return maKieuThue;
    }

    public void setMaKieuThue(int maKieuThue) {
        this.maKieuThue = maKieuThue;
    }

    public String getTenKieuThue() {
        return tenKieuThue;
    }

    public void setTenKieuThue(String tenKieuThue) {
        this.tenKieuThue = tenKieuThue;
    }

    public List<DichVu> getDichVus() {
        return dichVus;
    }

    public void setDichVus(List<DichVu> dichVus) {
        this.dichVus = dichVus;
    }
}
