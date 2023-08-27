package com.example.case_study.model.hopdong;

import com.example.case_study.model.khachhang.LoaiKhach;
import jakarta.persistence.*;

@Entity
@Table(name = "hop_dong_chi_tiet")
public class HopDongChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maHopDongChiTiet;
    private int soLuong;
    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem")
    private DichVuDiKem dichVuDiKem;
    @ManyToOne
    @JoinColumn(name = "ma_hop_dong")
    private HopDong hopDong;

    public HopDongChiTiet() {
    }

    public HopDongChiTiet(int maHopDongChiTiet, int soLuong, DichVuDiKem dichVuDiKem, HopDong hopDong) {
        this.maHopDongChiTiet = maHopDongChiTiet;
        this.soLuong = soLuong;
        this.dichVuDiKem = dichVuDiKem;
        this.hopDong = hopDong;
    }

    public int getMaHopDongChiTiet() {
        return maHopDongChiTiet;
    }

    public void setMaHopDongChiTiet(int maHopDongChiTiet) {
        this.maHopDongChiTiet = maHopDongChiTiet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public DichVuDiKem getDichVuDiKem() {
        return dichVuDiKem;
    }

    public void setDichVuDiKem(DichVuDiKem dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }

    public HopDong getHopDong() {
        return hopDong;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }
}
