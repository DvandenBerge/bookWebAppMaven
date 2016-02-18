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
    public abstract void deleteRecordById(String tableName, String pkColumn, Object value) throws ClassNotFoundException, SQLException;
    public abstract void updateRecordById(String tableName, List colDescriptors, List colValues,
                             String whereField, Object whereValue, boolean closeConnection)throws SQLException, Exception;
}
