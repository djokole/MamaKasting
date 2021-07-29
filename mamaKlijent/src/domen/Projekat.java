/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Panda
 */
public class Projekat {
    int projekatID;
    String imeProjekta;
    int glavniMuski;
    int glavniZenski;
    int sporedna1;
    int sporedna2;
    int sporedna3;
    int produkcijaID;

    public int getProjekatID() {
        return projekatID;
    }

    public void setProjekatID(int projekatID) {
        this.projekatID = projekatID;
    }

    public String getImeProjekta() {
        return imeProjekta;
    }


    public void setImeProjekta(String imeProjekta) {
        this.imeProjekta = imeProjekta;
    }

    public int getGlavniMuski() {
        return glavniMuski;
    }

    public void setGlavniMuski(int glavniMuski) {
        this.glavniMuski = glavniMuski;
    }

    public int getGlavniZenski() {
        return glavniZenski;
    }

    public void setGlavniZenski(int glavniZenski) {
        this.glavniZenski = glavniZenski;
    }

    public int getSporedna1() {
        return sporedna1;
    }

    public void setSporedna1(int sporedna1) {
        this.sporedna1 = sporedna1;
    }

    public int getSporedna2() {
        return sporedna2;
    }

    public void setSporedna2(int sporedna2) {
        this.sporedna2 = sporedna2;
    }

    public int getSporedna3() {
        return sporedna3;
    }

    public void setSporedna3(int sporedna3) {
        this.sporedna3 = sporedna3;
    }
    
    

   

    public int getProdukcijaID() {
        return produkcijaID;
    }

    public void setProdukcijaID(int produkcijaID) {
        this.produkcijaID = produkcijaID;
    }

    public Projekat(String imeProjekta, int glavniMuski, int glavniZenski, int sporedna1, int sporedna2, int sporedna3, int produkcijaID) {
        this.imeProjekta = imeProjekta;
        this.glavniMuski = glavniMuski;
        this.glavniZenski = glavniZenski;
        this.sporedna1 = sporedna1;
        this.sporedna2 = sporedna2;
        this.sporedna3 = sporedna3;
        this.produkcijaID = produkcijaID;
    }
    
    
    


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projekat other = (Projekat) obj;
        if (this.projekatID != other.projekatID) {
            return false;
        }
        return true;
    }
    
    
}
