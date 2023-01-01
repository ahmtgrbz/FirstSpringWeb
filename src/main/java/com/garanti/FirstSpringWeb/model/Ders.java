package com.garanti.FirstSpringWeb.model;

public class Ders
{
    private Integer ID;

    // bu bir foreign key 'dir
    private Integer OGR_ID;

    // bu bir foreign key 'dir
    private Integer KONU_ID;

    public Integer getID() {
        return ID;
    }

    public Integer getOGR_ID() {
        return OGR_ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

   public void setOGR_ID(Integer OGR_ID) {
        this.OGR_ID = OGR_ID;
    }

    public void setKONU_ID(Integer KONU_ID) {
        this.KONU_ID = KONU_ID;
    }

    public Integer getKONU_ID() {
        return KONU_ID;
    }

    public Ders() {
    }

    public Ders(Integer OGR_ID, Integer KONU_ID)
    {
        this.OGR_ID = OGR_ID;
        this.KONU_ID = KONU_ID;
    }

    public Ders(Integer ID, Integer OGR_ID, Integer KONU_ID)
    {
        this.ID = ID;
        this.OGR_ID = OGR_ID;
        this.KONU_ID = KONU_ID;
    }

    @Override
    public String toString() {
        return "Ders{" +
                "ID=" + ID +
                ", OGR_ID=" + OGR_ID +
                ", KONU_ID=" + KONU_ID +
                '}';
    }
}
