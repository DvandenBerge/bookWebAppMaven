package edu.wctc.dfb.bookwebappmaven.model;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dan
 */
public class MockAuthorDAO implements AuthorDAOStrategy {
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
