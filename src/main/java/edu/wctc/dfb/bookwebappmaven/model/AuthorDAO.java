package edu.wctc.dfb.bookwebappmaven.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dvandenberge
 */
public class AuthorDAO implements AuthorDAOStrategy {
    
    private DBStrategy db=new MySqlDBStrategy();
    
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String URL= "jdbc:mysql://localhost:3306/books";
    private final String PASSWORD="admin";
    private final String USERNAME="root";
    
    private final String TABLE_NAME="author";
    private final String COLUMN_NAME="author_id";
    private final int RESULTS_TO_RETURN=-1;
    private final String NULL_STRING_ENTRY ="NOT ENTERED";
    
    @Override
    public List<Author> getAuthorList() throws ClassNotFoundException,SQLException{
        db.openConnection(DRIVER,URL,USERNAME,PASSWORD);
        
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
    
    @Override
    public int deleteAuthorById(Object value) throws ClassNotFoundException, SQLException{
        db.openConnection(DRIVER,URL,USERNAME,PASSWORD);
        int returnValue=db.deleteRecordById(TABLE_NAME,COLUMN_NAME,value);
        db.closeConnection();
        return returnValue;
    }
    
    public void updateRecordById(String tableName, List colDescriptors, List colValues,
                             String whereField, Object whereValue, boolean closeConnection)throws SQLException, Exception{
         db.openConnection(DRIVER,URL,USERNAME,PASSWORD);
         db.updateRecordById(TABLE_NAME, colDescriptors, colValues, whereField, whereValue, closeConnection);
         db.closeConnection();
    }
}
