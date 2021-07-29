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
import java.util.Objects;

/**
 *
 * @author Panda
 */
public class Glumac extends AbstractDomainObject {
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
    
    public Glumac() {
        
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

    @Override
    public PreparedStatement getQueryForAll(Connection connection) throws SQLException {
        return connection.prepareStatement("Select * from glumci");
    }

    @Override
    public PreparedStatement getQueryForSearch(Connection connection, String param) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractDomainObject> getListFromResultSet(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> list = new LinkedList<>();
        while(rs.next()){
            int glumacID = rs.getInt("glumacID");
            String imePrezime = rs.getString("imePrezime");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String pol = rs.getString("pol");
            int visina = rs.getInt("visina");
            int tezina = rs.getInt("tezina");
            String bojaOciju = rs.getString("bojaOciju");
            Glumac glumac = new Glumac(glumacID, imePrezime, username, password, pol, visina, tezina, bojaOciju);
            list.add(glumac);
        }
        rs.close();
        return list;
    }

    @Override
    public PreparedStatement getQueryForInsert(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Insert into glumci(imePrezime,username,password,pol,visina,tezina,bojaOciju) values (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, ImePrezime);
        ps.setString(2, username);
        ps.setString(3, password);
        ps.setString(4, pol);
        ps.setInt(5, visina);
        ps.setInt(6, tezina);
        ps.setString(7, bojaOciju);
        return ps;
    }

    @Override
    public PreparedStatement getQueryForUpdate(Connection connection) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getQueryForDelete(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Delete from glumci where glumacID=?");
        ps.setInt(1, glumacID);
        return ps;
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public void setId(long id) {
        this.glumacID = (int) id;
    }
    
    
}
