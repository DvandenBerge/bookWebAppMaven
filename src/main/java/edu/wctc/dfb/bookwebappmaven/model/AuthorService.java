package edu.wctc.dfb.bookwebappmaven.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dvandenberge
 */
public class AuthorService {
    private AuthorDAOStrategy authorDAO=new AuthorDAO();
    
    public List<Author> getAuthorList() throws ClassNotFoundException,SQLException{
        return authorDAO.getAuthorList();
    }
    
    public void updateRecord(String tableName, List colDescriptors, List colValues,
                             String whereField, Object whereValue, boolean closeConnection) throws SQLException, Exception{
       authorDAO.updateRecordById(tableName, colDescriptors, colValues, whereField, whereValue, closeConnection);
    }
    
    public void deleteRecord(String tableName, String pkColumn, Object value ) throws ClassNotFoundException,SQLException{
        authorDAO.deleteRecordById(tableName, pkColumn, value);
    }
    public static void main(String[] args) throws Exception,SQLException{
        AuthorService serv1=new AuthorService();
        System.out.println(serv1.getAuthorList());
        //serv1.deleteRecord("author","author_id",2);
        List cd=new ArrayList();
        cd.add("author_name");
        List v=new ArrayList();
        v.add("Dan lol");
        serv1.updateRecord("author", cd, v, "author_name", "Kyle Wertz", true);
        System.out.println(serv1.getAuthorList());
        
    }
}
