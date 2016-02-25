/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dfb.bookwebappmaven.model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dvandenberge
 */
public interface AuthorDAOStrategy {

    public abstract List<Author> getAuthorList() throws ClassNotFoundException, SQLException;
    public abstract int deleteAuthorById(Object value) throws ClassNotFoundException, SQLException;
    public abstract void updateRecordById(String tableName, List colDescriptors, List colValues,
                             String whereField, Object whereValue, boolean closeConnection)throws SQLException, Exception;
     public abstract void initDAO(String driver,String url,String username,String password);
         public abstract void setPassword(String password);
    public abstract void setUrl(String url);
    public abstract void setUsername(String username);
    public abstract void setDriver(String driver);
    public abstract String getDriver();
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract String getUrl();
}
