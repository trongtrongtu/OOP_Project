package model;

public class Product {
    private String imei;
    private int maKH;
    private String tenSP;
    private String loaiSP;
    private String nxs;
    private String hanBaoHanh;
    private String hinhAnh;
    private String thongTinSP;

    // Constructor
    public Product() {
    }

    public Product(String imei, int maKH, String tenSP, String loaiSP, String nxs, String hanBaoHanh, String hinhAnh, String thongTinSP) {
        this.imei = imei;
        this.maKH = maKH;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.nxs = nxs;
        this.hanBaoHanh = hanBaoHanh;
        this.hinhAnh = hinhAnh;
        this.thongTinSP = thongTinSP;
    }
    // getter, setter

    public String getThongTinSP() {
        return thongTinSP;
    }

    public void setThongTinSP(String thongTinSP) {
        this.thongTinSP = thongTinSP;
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

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getNxs() {
        return nxs;
    }

    public void setNxs(String nxs) {
        this.nxs = nxs;
    }

    public String getHanBaoHanh() {
        return hanBaoHanh;
    }

    public void setHanBaoHanh(String hanBaoHanh) {
        this.hanBaoHanh = hanBaoHanh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
