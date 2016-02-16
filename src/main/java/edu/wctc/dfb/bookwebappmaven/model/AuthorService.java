package edu.wctc.dfb.bookwebappmaven.model;

import java.sql.SQLException;
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
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        AuthorService serv1=new AuthorService();
        System.out.println(serv1.getAuthorList());
    }
}
