package com.example.case_study.model.nhanvien;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vi_tri")
public class ViTri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maViTri;
    private String tenViTri;
    @OneToMany(mappedBy = "viTri")
    private List<NhanVien> nhanViens;

    public ViTri() {
    }

    public ViTri(int maViTri, String tenViTri, List<NhanVien> nhanViens) {
        this.maViTri = maViTri;
        this.tenViTri = tenViTri;
        this.nhanViens = nhanViens;
    }

    public ViTri(int maViTri, String tenViTri) {
        this.maViTri = maViTri;
        this.tenViTri = tenViTri;
    }

    public int getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
