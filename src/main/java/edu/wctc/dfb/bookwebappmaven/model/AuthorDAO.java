package edu.wctc.dfb.bookwebappmaven.model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author dvandenberge
 */ 
@Dependent
public class AuthorDAO implements AuthorDAOStrategy,Serializable {
    @Inject
    private DBStrategy db;
    
    private String driver;
    private String url;
    private String password;
    private String username;
    
    private final String TABLE_NAME="author";
    private final String COLUMN_NAME="author_id";
    private final int RESULTS_TO_RETURN=-1;
    private final String NULL_STRING_ENTRY ="NOT ENTERED";
    
    public AuthorDAO(){
    }
    
    @Override
     public void initDAO(String driver,String url,String username,String password){
         setDriver(driver);
         setUrl(url);
         setUsername(username);
         setPassword(password);
     }
    
    @Override
    public List<Author> getAuthorList() throws ClassNotFoundException,SQLException{
        db.openConnection(driver,url,username,password);
        
        List authors=new ArrayList();
        List<Map<String,Object>> rawData=db.findAllRecords(TABLE_NAME, RESULTS_TO_RETURN);
        
        for(Map record:rawData){
            Author a=new Author();
            
            Integer id=new Integer(record.get("author_id").toString());
            a.setAuthorId(id);
            String name=(record.get("author_name")!=null?record.get("author_name").toString():NULL_STRING_ENTRY);
            a.setAuthorName(name);
            Date day=(record.get("date_added")!=null?(Date)record.get("date_added"):null);
            a.setDateAdded(day);
            
            authors.add(a);
        }
        db.closeConnection();
        return authors;
    }
    
    public Author findAuthorById(int authorID) throws SQLException,ClassNotFoundException{
        db.openConnection(driver, url, username, password);
        
        Map<String,Object> rawRec = db.findRecordById("author", "author_id", authorID);
        Author author = new Author();
        author.setAuthorId((Integer)rawRec.get("author_id"));
        author.setAuthorName(rawRec.get("author_name").toString());
        author.setDateAdded((Date)rawRec.get("date_added"));
        db.closeConnection();
        
        return author;
    }
    
    @Override
    public void createAuthor(Object value) throws ClassNotFoundException, SQLException{
        db.openConnection(driver, url, username, password);
        ArrayList a=new ArrayList();
        ArrayList b=new ArrayList();
        Date today=new Date();
        a.add(value);
        a.add(today);
        b.add("author_name");
        b.add("date_added");
        db.createRecord(TABLE_NAME, b, a);
        db.closeConnection();
    }
    
    @Override
    public int deleteAuthorById(Object value) throws ClassNotFoundException, SQLException{
        db.openConnection(driver,url,username,password);
        int returnValue=db.deleteRecordById(TABLE_NAME,COLUMN_NAME,value);
        db.closeConnection();
        return returnValue;
    }
    
    @Override
    public void updateRecordById(String tableName, List colDescriptors, List colValues,
                             String whereField, Object whereValue, boolean closeConnection)throws SQLException, Exception{
         db.openConnection(driver,url,username,password);
         db.updateRecordById(TABLE_NAME, colDescriptors, colValues, whereField, whereValue, closeConnection);
         db.closeConnection();
    }

    public DBStrategy getDb() {
        return db;
    }
    public void setDb(DBStrategy db) {
        this.db = db;
    }

    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
