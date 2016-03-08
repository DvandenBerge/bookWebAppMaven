package edu.wctc.dfb.bookwebappmaven.model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
/**
 *
 * @author dvandenberge
 */
@SessionScoped
public class AuthorService implements Serializable {
    @Inject
    private AuthorDAOStrategy authorDAO;
    
    public AuthorService(){
    }
    
    public List<Author> getAuthorList() throws ClassNotFoundException,SQLException{
        return authorDAO.getAuthorList();
    }
    
    private  void editEntry(String tableName, List colDescriptors, List colValues,
                             String whereField, Object whereValue, boolean closeConnection) throws SQLException, Exception{
       authorDAO.updateRecordById(tableName, colDescriptors, colValues, whereField, whereValue, closeConnection);
    }
    
    public void createAuthor(Object value) throws ClassNotFoundException,SQLException{
        authorDAO.createAuthor(value);
    }
    
    public void deleteAuthorById(Object value ) throws ClassNotFoundException,SQLException{
        authorDAO.deleteAuthorById(value);
    }

    public void updateAuthor(int id, String name) throws SQLException,Exception{
        ArrayList a=new ArrayList();
        ArrayList b=new ArrayList();
        a.add("author_name");
        b.add(name);
       editEntry("author", a,b, "author_id" , id , true);
    }
    
    public Author findAuthorById(int authorID) throws SQLException,ClassNotFoundException{
        return authorDAO.findAuthorById(authorID);
    }
    
    public AuthorDAOStrategy getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAOStrategy authorDAO) {
        this.authorDAO = authorDAO;
    }
    
    
}
