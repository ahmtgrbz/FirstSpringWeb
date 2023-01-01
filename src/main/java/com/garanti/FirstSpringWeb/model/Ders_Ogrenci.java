package com.garanti.FirstSpringWeb.model;

public class Ders_Ogrenci {
    private Integer ID;
    private Integer DERS_ID;
    private Integer OGRENCI_ID;
    private Integer NOTE;
    private Integer DEVAMSIZLIK;

    public Integer getID() {
        return ID;
    }

    public Integer getDERS_ID() {
        return DERS_ID;
    }

    public Integer getOGRENCI_ID() {
        return OGRENCI_ID;
    }

    public Integer getNOTE() {
        return NOTE;
    }

    public Integer getDEVAMSIZLIK() {
        return DEVAMSIZLIK;
    }

    public void setNOTE(Integer NOTE) {
        this.NOTE = NOTE;
    }

    public void setDERS_ID(Integer DERS_ID) {
        this.DERS_ID = DERS_ID;
    }

    public void setOGRENCI_ID(Integer OGRENCI_ID) {
        this.OGRENCI_ID = OGRENCI_ID;
    }

    public void setDEVAMSIZLIK(Integer DEVAMSIZLIK) {
        this.DEVAMSIZLIK = DEVAMSIZLIK;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Ders_Ogrenci() {
    }

    public Ders_Ogrenci(Integer ID, Integer DERS_ID, Integer OGRENCI_ID, Integer NOTE, Integer DEVAMSIZLIK) {
        this.ID = ID;
        this.DERS_ID = DERS_ID;
        this.OGRENCI_ID = OGRENCI_ID;
        this.NOTE = NOTE;
        this.DEVAMSIZLIK = DEVAMSIZLIK;
    }

    public Ders_Ogrenci(Integer DERS_ID, Integer OGRENCI_ID) {
        this.DERS_ID = DERS_ID;
        this.OGRENCI_ID = OGRENCI_ID;
    }

    @Override
    public String toString() {
        return "Ders_Ogrenci{" +
                "ID=" + ID +
                ", DERS_ID=" + DERS_ID +
                ", OGRENCI_ID=" + OGRENCI_ID +
                ", NOTE=" + NOTE +
                ", DEVAMSIZLIK=" + DEVAMSIZLIK +
                '}';
    }
}
