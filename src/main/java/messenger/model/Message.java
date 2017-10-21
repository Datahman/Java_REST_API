package messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@XmlRootElement
public class Message {
    private long id;
    private String message;
    private Date created;
    private String author;

    public Message(){

    } // Create a new message object/resource. e.g a client sends a POST request !


    public Message(long id, String message, String author){
        this.id = id;
        this.message=message;
        this.author=author;
        this.created = new Date();
    }



    // Make a new map for containing comments per each message
    Map<Long, Comment> comments = new HashMap<Long, Comment>();

    // Get method for the comments map
    @XmlTransient // Suppress comment list during class Message instantiation
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long,Comment> comments){

        this.comments= comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    /*
    public void printCreated(){
        System.out.println(DateFormat.getDateTimeInstance().format(this.created) + "asdasdasd");
    }
       */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}

