
package model;

import java.util.Date;

/**
 *
 * @author DELL LATITUDE
 */
public class DonBh {
    private int maDon;
    private String imei;
    private int maKH;
    private String loi;
    private int maLK;
    private int giaDon;
    private int maNV;
    private String trangThai;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public DonBh() {
        super();
    }

    public DonBh(int maDon, String imei, int maKH, String loi, int maLK, int giaDon, int maNV, String trangThai) {
        this.maDon = maDon;
        this.imei = imei;
        this.maKH = maKH;
        this.loi = loi;
        this.maLK = maLK;
        this.giaDon = giaDon;
        this.maNV = maNV;
        this.trangThai = trangThai;
        
    }

    public int getMaDon() {
        return maDon;
    }

    public void setMaDon(int maDon) {
        this.maDon = maDon;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getLoi() {
        return loi;
    }

    public void setLoi(String loi) {
        this.loi = loi;
    }

    public int getMaLK() {
        return maLK;
    }

    public void setMaLK(int maLK) {
        this.maLK = maLK;
    }

    public int getGiaDon() {
        return giaDon;
    }

    public void setGiaDon(int giaDon) {
        this.giaDon = giaDon;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
