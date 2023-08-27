package com.example.case_study.model.nhanvien;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bo_phan")
public class BoPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maBoPhan;
    private String tenBoPhan;
    @OneToMany(mappedBy = "boPhan")
    private List<NhanVien> nhanViens;

    public BoPhan(int maBoPhan, String tenBoPhan, List<NhanVien> nhanViens) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.nhanViens = nhanViens;
    }

    public BoPhan() {
    }

    public BoPhan(int maBoPhan, String tenBoPhan) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
