package com.garanti.FirstSpringWeb.model;

public class Ogrenci
{
    private Integer ID;

    private String NAME;

    private int OGR_NUMBER;

    private Integer YEAR;

    public Integer getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public int getOGR_NUMBER() {
        return OGR_NUMBER;
    }

    public Integer getYEAR() {
        return YEAR;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setOGR_NUMBER(int OGR_NUMBER) {
        this.OGR_NUMBER = OGR_NUMBER;
    }

    public void setYEAR(Integer YEAR) {
        this.YEAR = YEAR;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", OGR_NUMBER=" + OGR_NUMBER +
                ", YEAR=" + YEAR +
                '}';
    }

    public Ogrenci() {
    }

    public Ogrenci(String NAME, int OGR_NUMBER, Integer YEAR)
    {
        this.NAME = NAME;
        this.OGR_NUMBER = OGR_NUMBER;
        this.YEAR = YEAR;
    }

    public Ogrenci(Integer ID, String NAME, int OGR_NUMBER, Integer YEAR)
    {
        this.ID = ID;
        this.NAME = NAME;
        this.OGR_NUMBER = OGR_NUMBER;
        this.YEAR = YEAR;
    }
}
