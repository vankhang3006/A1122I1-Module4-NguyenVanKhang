package com.example.case_study.model.hopdong;

import com.example.case_study.model.khachhang.KhachHang;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dich_vu_di_kem")
public class DichVuDiKem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDichVuDiKem;
    private String tenDichVuDiKem;
    private double gia;
    private String donVi;
    private String trangThai;
    @OneToMany(mappedBy = "dichVuDiKem")
    private List<HopDongChiTiet> hopDongChiTiets;

    public DichVuDiKem() {
    }

    public DichVuDiKem(int maDichVuDiKem, String tenDichVuDiKem, double gia, String donVi, String trangThai, List<HopDongChiTiet> hopDongChiTiets) {
        this.maDichVuDiKem = maDichVuDiKem;
        this.tenDichVuDiKem = tenDichVuDiKem;
        this.gia = gia;
        this.donVi = donVi;
        this.trangThai = trangThai;
        this.hopDongChiTiets = hopDongChiTiets;
    }

    public int getMaDichVuDiKem() {
        return maDichVuDiKem;
    }

    public void setMaDichVuDiKem(int maDichVuDiKem) {
        this.maDichVuDiKem = maDichVuDiKem;
    }

    public String getTenDichVuDiKem() {
        return tenDichVuDiKem;
    }

    public void setTenDichVuDiKem(String tenDichVuDiKem) {
        this.tenDichVuDiKem = tenDichVuDiKem;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<HopDongChiTiet> getHopDongChiTiets() {
        return hopDongChiTiets;
    }

    public void setHopDongChiTiets(List<HopDongChiTiet> hopDongChiTiets) {
        this.hopDongChiTiets = hopDongChiTiets;
    }
}
