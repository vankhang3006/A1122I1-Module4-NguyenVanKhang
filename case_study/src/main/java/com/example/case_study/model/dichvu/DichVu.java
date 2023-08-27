package com.example.case_study.model.dichvu;

import com.example.case_study.model.hopdong.HopDong;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dich_vu")
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDichVu;
    private String tenDichVu;
    private double dienTich;
    private double chiPhiThue;
    private int soNguoiToiDa;
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int dienTichHoBoi;
    private int soTang;
    @ManyToOne
    @JoinColumn(name = "ma_kieu_thue")
    private KieuThue kieuThue;
    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu")
    private LoaiDichVu loaiDichVu;
    @OneToMany(mappedBy = "dichVu")
    private List<HopDong> hopDongs;

    public DichVu() {
    }

    public DichVu(int maDichVu, String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa, String tieuChuanPhong, String moTaTienNghiKhac, int dienTichHoBoi, int soTang) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public DichVu(int maDichVu, String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa, String tieuChuanPhong, String moTaTienNghiKhac, int dienTichHoBoi, int soTang, KieuThue kieuThue, LoaiDichVu loaiDichVu) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
        this.kieuThue = kieuThue;
        this.loaiDichVu = loaiDichVu;
    }

    public DichVu(int maDichVu, String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa, String tieuChuanPhong, String moTaTienNghiKhac, int dienTichHoBoi, int soTang, KieuThue kieuThue, LoaiDichVu loaiDichVu, List<HopDong> hopDongs) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
        this.kieuThue = kieuThue;
        this.loaiDichVu = loaiDichVu;
        this.hopDongs = hopDongs;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghiKhac() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghiKhac(String moTaTienNghiKhac) {
        this.moTaTienNghiKhac = moTaTienNghiKhac;
    }

    public int getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(int dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public KieuThue getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(KieuThue kieuThue) {
        this.kieuThue = kieuThue;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public List<HopDong> getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(List<HopDong> hopDongs) {
        this.hopDongs = hopDongs;
    }
}
