package domen;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
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
public class Produkcija extends AbstractDomainObject {
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

    public Produkcija() {
        
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

    @Override
    public PreparedStatement getQueryForAll(Connection connection) throws SQLException {
        return connection.prepareStatement("Select * from produkcije");
    }

    @Override
    public PreparedStatement getQueryForSearch(Connection connection, String param) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractDomainObject> getListFromResultSet(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> list = new LinkedList<>();
        while(rs.next()){
            int produkcijaID = rs.getInt("produkcijaID");
            String imeProdukcije = rs.getString("imeProdukcije");
            String korisnickoIme = rs.getString("korisnickoIme");
            String lozinka = rs.getString("lozinka");
            Produkcija produkcija = new Produkcija(imeProdukcije, korisnickoIme, lozinka);
            list.add(produkcija);
        }
        rs.close();
        return list;
    }

    @Override
    public PreparedStatement getQueryForInsert(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Insert into produkcije(imeProdukcije,korisnickoIme,lozinka) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, ime);
        ps.setString(2, username);
        ps.setString(3, password);
        return ps;
    }

    @Override
    public PreparedStatement getQueryForUpdate(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Update produkcije set imeProdukcije=?, korisnickoIme=?, lozinka=? where produkcijaId=?");
        ps.setString(1, ime);
        ps.setString(2, username);
        ps.setString(3, password);
        ps.setLong(4, produkcijaID);
        return ps;
    }

    @Override
    public PreparedStatement getQueryForDelete(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Delete from produkcije where produkcijaID=?");
        ps.setInt(1, produkcijaID);
        return ps;
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public void setId(long id) {
        this.produkcijaID = (int) id;
    }
    
    
    
    
}
