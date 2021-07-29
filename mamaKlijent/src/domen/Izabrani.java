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
public class Izabrani {
    Glumac g;
    String uloga;

    public Glumac getG() {
        return g;
    }

    public void setG(Glumac g) {
        this.g = g;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public Izabrani(Glumac g, String uloga) {
        this.g = g;
        this.uloga = uloga;
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
        final Izabrani other = (Izabrani) obj;
        if (!Objects.equals(this.uloga, other.uloga)) {
            return false;
        }
        if (!Objects.equals(this.g, other.g)) {
            return false;
        }
        return true;
    }
    
    
}
