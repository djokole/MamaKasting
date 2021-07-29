/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Panda
 */
public class Projekat extends AbstractDomainObject {
    int projekatID;
    String imeProjekta;
    int glavniMuski;
    int glavniZenski;
    int sporedna1;
    int sporedna2;
    int sporedna3;
    int produkcijaID;

    public Projekat() {
        
    }

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

    public Projekat(int projekatID, String imeProjekta, int glavniMuski, int glavniZenski, int sporedna1, int sporedna2, int sporedna3, int produkcijaID) {
        this.projekatID = projekatID;
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

    @Override
    public PreparedStatement getQueryForAll(Connection connection) throws SQLException {
        return connection.prepareStatement("Select * from projekat");
    }

    @Override
    public PreparedStatement getQueryForSearch(Connection connection, String param) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractDomainObject> getListFromResultSet(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> list = new LinkedList<>();
        while(rs.next()){
            int projekatID = rs.getInt("projekatID");
            String imeProjekta = rs.getString("imeProjekta");
            int glavniMuski = rs.getInt("glavniMuski");
            int glavniZenski = rs.getInt("glavniZenski");
            int sporedna1 = rs.getInt("sporedna1");
            int sporedna2 = rs.getInt("sporedna2");
            int sporedna3 = rs.getInt("sporedna3");
            int produkcijaID = rs.getInt("produkcijaID");
            Projekat projekat = new Projekat(projekatID, imeProjekta, glavniMuski, glavniZenski, sporedna1, sporedna2, sporedna3, produkcijaID);
            list.add(projekat);
        }
        rs.close();
        return list;
    }

    @Override
    public PreparedStatement getQueryForInsert(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Insert into projekat(imeProjekta,glavniMuski,glavniZenski,sporedna1,sporedna2,sporedna3,produkcijaID) values (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, imeProjekta);
        ps.setInt(2, glavniMuski);
        ps.setInt(3, glavniZenski);
        ps.setInt(4, sporedna1);
        ps.setInt(5, sporedna2);
        ps.setInt(6, sporedna3);
        ps.setInt(7, produkcijaID);
        return ps;
    }

    @Override
    public PreparedStatement getQueryForUpdate(Connection connection) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getQueryForDelete(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Delete from projekat where projekatID=?");
        ps.setInt(1, projekatID);
        return ps;
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public void setId(long id) {
        this.projekatID = (int) id;
    }
    
    
}
