package com.haydikodlayalim.rc.model;

import java.util.List;

public class KisiDto {

    private Long id;
    private String adi;

    private String soyadi;

    private List<String> adresler;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public List<String> getAdresler() {
        return adresler;
    }

    public void setAdresler(List<String> adresler) {
        this.adresler = adresler;
    }
}
