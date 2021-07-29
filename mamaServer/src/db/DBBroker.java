/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import domen.AbstractDomainObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Panda
 */
public class DBBroker {
    private Connection connection;
    

    public void connect() throws Exception{
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamakasting", "root", "");
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void disconnect() throws Exception {
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            throw new Exception("Greska prilikom raskidanja konekcije sa bazom!\n"+ex.getMessage());
            }
        }
    }
    
    public void commit() throws Exception{
        if(connection!=null){
            try {
                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            throw new Exception("Greska prilikom potvrdjivanja transakcije!\n"+ex.getMessage());
            }
        }
    }
    
    public void rollback() throws Exception{
        if(connection!=null){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            throw new Exception("Greska prilikom ponistavanja transakcije!\n"+ex.getMessage());
            }
        }
    }
    
     public void insert(AbstractDomainObject ado) throws SQLException{
        PreparedStatement ps =ado.getQueryForInsert(connection);
        ps.execute();
        if(ado.isAutoIncrement()){
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                ado.setId(rs.getLong(1));
            }
        }
    }
    
    public void update(AbstractDomainObject ado) throws SQLException{
        PreparedStatement ps =ado.getQueryForUpdate(connection);
        ps.execute();
    }
    
    public void delete(AbstractDomainObject ado) throws SQLException{
        PreparedStatement ps =ado.getQueryForDelete(connection);
        ps.execute();
    }
    
    public List<AbstractDomainObject> getAll(AbstractDomainObject ado) throws SQLException{
        PreparedStatement ps =ado.getQueryForAll(connection);
        ResultSet rs = ps.executeQuery();
        return ado.getListFromResultSet(rs);
    }
    
    public List<AbstractDomainObject> search(AbstractDomainObject ado, String param) throws SQLException{
        PreparedStatement ps =ado.getQueryForSearch(connection, param);
        ResultSet rs =ps.executeQuery();
        return ado.getListFromResultSet(rs);
    }
}
