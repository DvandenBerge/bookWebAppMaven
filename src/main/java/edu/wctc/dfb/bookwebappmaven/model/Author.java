package edu.wctc.dfb.bookwebappmaven.model;


import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dan
 */
public class Author {
    private String authorName;
    private int authorId;
    private Date dateAdded;

    public Author(){
    }
    public Author(int authorId){
        this.authorId=authorId;
    }
    public Author(String authorName,int authorId, Date date){
        this.authorName=authorName;
        this.authorId=authorId;
        this.dateAdded=date;
    }
    
    @Override
    public String toString(){
        return Integer.toString(authorId)+" "+authorName+" "+dateAdded;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.authorName);
        hash = 73 * hash + this.authorId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (this.authorId != other.authorId) {
            return false;
        }
        if (!Objects.equals(this.authorName, other.authorName)) {
            return false;
        }
        return true;
    }
    
    
}
