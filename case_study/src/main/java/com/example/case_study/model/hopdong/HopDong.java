package com.example.case_study.model.hopdong;

import com.example.case_study.model.dichvu.DichVu;
import com.example.case_study.model.khachhang.KhachHang;
import com.example.case_study.model.nhanvien.NhanVien;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "hop_dong")
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maHopDong;
    private LocalDate ngayLamHopDong;
    private LocalDate ngayKetThuc;
    private double tienDatCoc;
    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "ma_khach_hang")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "ma_dich_vu")
    private DichVu dichVu;
    @OneToMany(mappedBy = "hopDong")
    private List<HopDongChiTiet> hopDongChiTiets;

    public HopDong() {
    }

    public HopDong(int maHopDong, LocalDate ngayLamHopDong, LocalDate ngayKetThuc, double tienDatCoc, NhanVien nhanVien, KhachHang khachHang, DichVu dichVu, List<HopDongChiTiet> hopDongChiTiets) {
        this.maHopDong = maHopDong;
        this.ngayLamHopDong = ngayLamHopDong;
        this.ngayKetThuc = ngayKetThuc;
        this.tienDatCoc = tienDatCoc;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.dichVu = dichVu;
        this.hopDongChiTiets = hopDongChiTiets;
    }

    public int getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(int maHopDong) {
        this.maHopDong = maHopDong;
    }

    public LocalDate getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(LocalDate ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public List<HopDongChiTiet> getHopDongChiTiets() {
        return hopDongChiTiets;
    }

    public void setHopDongChiTiets(List<HopDongChiTiet> hopDongChiTiets) {
        this.hopDongChiTiets = hopDongChiTiets;
    }
}
