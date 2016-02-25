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
    
    public void updateAuthor(String tableName, List colDescriptors, List colValues,
                             String whereField, Object whereValue, boolean closeConnection) throws SQLException, Exception{
       authorDAO.updateRecordById(tableName, colDescriptors, colValues, whereField, whereValue, closeConnection);
    }
    
    public void deleteAuthorById(Object value ) throws ClassNotFoundException,SQLException{
        authorDAO.deleteAuthorById(value);
    }

    public AuthorDAOStrategy getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAOStrategy authorDAO) {
        this.authorDAO = authorDAO;
    }
    
    
    
    public static void main(String[] args) throws Exception,SQLException{
        AuthorService serv1=new AuthorService();
        System.out.println(serv1.getAuthorList());
        //serv1.deleteRecord("author","author_id",2);
        List cd=new ArrayList();
        cd.add("author_name");
        List v=new ArrayList();
        v.add("Dan lol");
        serv1.updateAuthor("author", cd, v, "author_name", "Kyle Wertz", true);
        System.out.println(serv1.getAuthorList());
        
    }
}
