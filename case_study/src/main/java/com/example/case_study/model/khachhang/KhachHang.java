package com.example.case_study.model.khachhang;

import com.example.case_study.model.hopdong.HopDong;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhachHang;
    private String hoTen;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private double soCMND;
    private String soDienThoai;
    private String email;
    private String diaChi;
    @ManyToOne
    @JoinColumn(name = "ma_loai_khach")
    private LoaiKhach loaiKhach;
    @OneToMany(mappedBy = "khachHang")
    private List<HopDong> hopDongs;

    public KhachHang() {
    }

    public KhachHang(int maKhachHang, String hoTen, LocalDate ngaySinh, boolean gioiTinh, double soCMND, String soDienThoai, String email, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public KhachHang(int maKhachHang, String hoTen, LocalDate ngaySinh, boolean gioiTinh, double soCMND, String soDienThoai, String email, String diaChi, LoaiKhach loaiKhach) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.loaiKhach = loaiKhach;
    }

    public KhachHang(int maKhachHang, String hoTen, LocalDate ngaySinh, boolean gioiTinh, double soCMND, String soDienThoai, String email, String diaChi, LoaiKhach loaiKhach, List<HopDong> hopDongs) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.loaiKhach = loaiKhach;
        this.hopDongs = hopDongs;
    }

    public List<HopDong> getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(List<HopDong> hopDongs) {
        this.hopDongs = hopDongs;
    }

    @Override
    public String toString() {
        return String.format("KhachHang[maKhachHang=%d, hoTen='%s', ngaySinh='%s', gioiTinh='%s', soCMND='%s', soDienThoai='%s', email='%s', diaChi='%s']", maKhachHang,hoTen,ngaySinh,gioiTinh,soCMND,soDienThoai,email,diaChi);
    }
    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(double soCMND) {
        this.soCMND = soCMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LoaiKhach getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(LoaiKhach loaiKhach) {
        this.loaiKhach = loaiKhach;
    }
}
