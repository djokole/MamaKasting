package domen;


import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Panda
 */
public class Produkcija {
    int produkcijaID;
    String ime;
    String username;
    String password;

    public Produkcija(String ime, String username, String password) {
        this.ime = ime;
        this.username = username;
        this.password = password;
    }

    public Produkcija(int produkcijaID, String ime, String username, String password) {
        this.produkcijaID = produkcijaID;
        this.ime = ime;
        this.username = username;
        this.password = password;
    }
    
    

    public int getProdukcijaID() {
        return produkcijaID;
    }

    public void setProdukcijaID(int produkcijaID) {
        this.produkcijaID = produkcijaID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
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
        final Produkcija other = (Produkcija) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime;
    }
    
    
    
    
}
