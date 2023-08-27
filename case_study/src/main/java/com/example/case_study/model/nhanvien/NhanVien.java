package com.example.case_study.model.nhanvien;

import com.example.case_study.model.hopdong.HopDong;
import com.example.case_study.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhanVien;
    private String hoTen;
    private LocalDate ngaySinh;
    private double soCMND;
    private double luong;
    private String soDienThoai;
    private String email;
    private String diaChi;
    @ManyToOne
    @JoinColumn(name = "ma_vi_tri")
    private ViTri viTri;
    @ManyToOne
    @JoinColumn(name = "ma_trinh_do")
    private TrinhDo trinhDo;
    @ManyToOne
    @JoinColumn(name = "ma_bo_phan")
    private BoPhan boPhan;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "nhanVien")
    private List<HopDong> hopDongs;

    public NhanVien() {
    }

    public NhanVien(int maNhanVien, String hoTen, LocalDate ngaySinh, double soCMND, double luong, String soDienThoai, String email, String diaChi) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public NhanVien(int maNhanVien, String hoTen, LocalDate ngaySinh, double soCMND, double luong, String soDienThoai, String email, String diaChi, ViTri viTri, TrinhDo trinhDo, BoPhan boPhan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.viTri = viTri;
        this.trinhDo = trinhDo;
        this.boPhan = boPhan;
    }

    public NhanVien(int maNhanVien, String hoTen, LocalDate ngaySinh, double soCMND, double luong, String soDienThoai, String email, String diaChi, ViTri viTri, TrinhDo trinhDo, BoPhan boPhan, List<HopDong> hopDongs) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.viTri = viTri;
        this.trinhDo = trinhDo;
        this.boPhan = boPhan;
        this.hopDongs = hopDongs;
    }

    @Override
    public String toString() {
        return String.format("NhanVien[maNhanVien=%d, hoTen='%s', ngaySinh='%s', soCMND='%s', luong='%s', soDienThoai='%s', email='%s', diaChi='%s']", maNhanVien,hoTen,ngaySinh,soCMND,luong,soDienThoai,email,diaChi);
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
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

    public double getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(double soCMND) {
        this.soCMND = soCMND;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
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

    public ViTri getViTri() {
        return viTri;
    }

    public void setViTri(ViTri viTri) {
        this.viTri = viTri;
    }

    public TrinhDo getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(TrinhDo trinhDo) {
        this.trinhDo = trinhDo;
    }

    public BoPhan getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(BoPhan boPhan) {
        this.boPhan = boPhan;
    }

    public List<HopDong> getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(List<HopDong> hopDongs) {
        this.hopDongs = hopDongs;
    }
}
