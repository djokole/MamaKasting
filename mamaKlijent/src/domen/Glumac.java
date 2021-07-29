/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Objects;

/**
 *
 * @author Panda
 */
public class Glumac {
    int glumacID;
    String ImePrezime;
    String username;
    String password;
    String pol;
    int visina;
    int tezina;
    String bojaOciju;
    String rezervisan = "ne";


    public Glumac(String ImePrezime, String username, String password, String pol, int visina, int tezina, String bojaOciju) {
        this.ImePrezime = ImePrezime;
        this.username = username;
        this.password = password;
        this.pol = pol;
        this.visina = visina;
        this.tezina = tezina;
        this.bojaOciju = bojaOciju;
    }

    public Glumac(String ImePrezime, String pol, int visina, int tezina, String bojaOciju) {
        this.ImePrezime = ImePrezime;
        this.pol = pol;
        this.visina = visina;
        this.tezina = tezina;
        this.bojaOciju = bojaOciju;
    }

    public Glumac(int glumacID, String ImePrezime, String pol, int visina, int tezina, String bojaOciju) {
        this.glumacID = glumacID;
        this.ImePrezime = ImePrezime;
        this.pol = pol;
        this.visina = visina;
        this.tezina = tezina;
        this.bojaOciju = bojaOciju;
    }

    public Glumac(String username, String password) {
        this.username = username;
        this.password = password;
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
        final Glumac other = (Glumac) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    

    public int getGlumacID() {
        return glumacID;
    }

    public void setGlumacID(int glumacID) {
        this.glumacID = glumacID;
    }

    public String getImePrezime() {
        return ImePrezime;
    }

    public void setImePrezime(String ImePrezime) {
        this.ImePrezime = ImePrezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVisina() {
        return visina;
    }

    public void setVisina(int visina) {
        this.visina = visina;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public String getBojaOciju() {
        return bojaOciju;
    }

    public void setBojaOciju(String bojaOciju) {
        this.bojaOciju = bojaOciju;
    }

    public String isRezervisan() {
        return rezervisan;
    }

    public void setRezervisan(String rezervisan) {
        this.rezervisan = rezervisan;
    }

    public Glumac(int glumacID, String ImePrezime, String username, String password, String pol, int visina, int tezina, String bojaOciju) {
        this.glumacID = glumacID;
        this.ImePrezime = ImePrezime;
        this.username = username;
        this.password = password;
        this.pol = pol;
        this.visina = visina;
        this.tezina = tezina;
        this.bojaOciju = bojaOciju;
    }

    @Override
    public String toString() {
        return ImePrezime;
    }
    
    
}
