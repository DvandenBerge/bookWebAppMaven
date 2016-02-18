package edu.wctc.dfb.bookwebappmaven.model;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dan
 */
public class MockAuthorDAO implements AuthorDAOStrategy {

    @Override
    public void updateRecordById(String tableName, List colDescriptors, List colValues, String whereField, Object whereValue, boolean closeConnection) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteAuthorById(Object value) throws ClassNotFoundException, SQLException {
        return 1;
    }
    private ArrayList<Author> authors;
    
    public MockAuthorDAO(){
        authors=new ArrayList<Author>();
        authors.add(new Author("Bob",1,new Date()));
        authors.add(new Author("Sally",2,new Date()));
        authors.add(new Author("Joe",3,new Date()));
    }
    
    @Override
    public ArrayList getAuthorList(){
        return authors;
    }
    
    public void addAuthor(Author a){
        authors.add(a);
    }
    
    
}
