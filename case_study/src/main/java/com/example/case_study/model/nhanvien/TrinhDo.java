package com.example.case_study.model.nhanvien;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "trinh_do")
public class TrinhDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTrinhDo;
    private String tenTrinhDo;
    @OneToMany(mappedBy = "trinhDo")
    private List<NhanVien> nhanViens;

    public TrinhDo() {
    }

    public TrinhDo(int maTrinhDo, String tenTrinhDo, List<NhanVien> nhanViens) {
        this.maTrinhDo = maTrinhDo;
        this.tenTrinhDo = tenTrinhDo;
        this.nhanViens = nhanViens;
    }

    public TrinhDo(int maTrinhDo, String tenTrinhDo) {
        this.maTrinhDo = maTrinhDo;
        this.tenTrinhDo = tenTrinhDo;
    }

    public int getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
