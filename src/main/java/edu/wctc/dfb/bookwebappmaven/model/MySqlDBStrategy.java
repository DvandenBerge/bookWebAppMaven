package edu.wctc.dfb.bookwebappmaven.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dvandenberge
 */
public class MySqlDBStrategy implements DBStrategy{
    private Connection connection;
    
        @Override
        public void openConnection(String driverName,String url,String username, String password) throws ClassNotFoundException,SQLException{
           Class.forName(driverName);
           this.connection=DriverManager.getConnection(url, username, password);
        }
        
        @Override
        public void closeConnection() throws SQLException{
            connection.close();
        }
        
        /**
         * Method that returns a certain number of records from a table in a a database
         * in a ArrayList up to a certain point: upperLimit
         * If upperLimit is 0, retrieve all records
         * TODO Convert ArayList to Array
         * @param tableName Table to be queried
         * @param upperLimit Max number of records to be retrieved
         * @return An ArrayList populated with records from a database in the form of a Map
         */
        public List<Map<String,Object>> findAllRecords(String tableName, int upperLimit) throws SQLException{
            List<Map<String,Object>> records=new ArrayList();
            String sqlQuery=(upperLimit>0)?"SELECT * FROM "+tableName+" LIMIT "+upperLimit:"SELECT * FROM "+tableName;
            if(connection!=null){
                
                Statement sqlStatement=connection.createStatement();
                ResultSet rs=sqlStatement.executeQuery(sqlQuery);
                ResultSetMetaData rsmd=rs.getMetaData();
                int columnCount=rsmd.getColumnCount();
                while(rs.next()){
                    Map<String,Object> record=new HashMap();
                    for(int i=1;i<=columnCount;i++){
                        record.put(rsmd.getColumnName(i),rs.getObject(i));
                    }
                    records.add(record);
                }
            }else{
                System.out.println("No connection could be established");
            }
            return records;
        }
        

}
