package com.example.case_study.model.dichvu;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loai_dich_vu")
public class LoaiDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoaiDichVu;
    private String tenLoaiDichVu;
    @OneToMany(mappedBy = "loaiDichVu")
    private List<DichVu> dichVus;

    public LoaiDichVu() {
    }

    public LoaiDichVu(int maLoaiDichVu, String tenLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public LoaiDichVu(int maLoaiDichVu, String tenLoaiDichVu, List<DichVu> dichVus) {
        this.maLoaiDichVu = maLoaiDichVu;
        this.tenLoaiDichVu = tenLoaiDichVu;
        this.dichVus = dichVus;
    }

    public int getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(int maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public List<DichVu> getDichVus() {
        return dichVus;
    }

    public void setDichVus(List<DichVu> dichVus) {
        this.dichVus = dichVus;
    }
}
