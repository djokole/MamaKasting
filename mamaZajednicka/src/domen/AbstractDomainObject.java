/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDomainObject implements Serializable{
    public abstract PreparedStatement getQueryForAll(Connection connection) throws SQLException;
    public abstract PreparedStatement getQueryForSearch(Connection connection, String param) throws SQLException;
    public abstract List<AbstractDomainObject> getListFromResultSet(ResultSet rs) throws SQLException;
    public abstract PreparedStatement getQueryForInsert(Connection connection) throws SQLException;
    public abstract PreparedStatement getQueryForUpdate(Connection connection) throws SQLException;
    public abstract PreparedStatement getQueryForDelete(Connection connection) throws SQLException;
    public abstract boolean isAutoIncrement();
    public abstract void setId(long id);
}
