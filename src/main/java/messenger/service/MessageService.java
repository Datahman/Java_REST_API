package messenger.service;

import messenger.database.DatabaseClass;
import messenger.model.Message;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.time.Year;
import java.util.*;
import java.util.List;


// Declare a Message service class to implement CRUD operations.
// Use message instance from the Database class
public class MessageService {


    private Map<Long,Message> messages = DatabaseClass.getMessages();

    // Primary constructor to fill in two hard coded  message entries during instantiation of the MessageService class.
    // Related note: These two will ALWAYS be made upon invokation of the HTTP methods present in the Message Service class.


    public MessageService(){
        messages.put(1L,new Message(1,"Message one","John"));
        messages.put(2L,new Message(2,"Message one", "Tony"));
    }

    public List<Message> getAllMessages(){
        return new ArrayList<Message>(messages.values()) ; // Values of the message dict. are all the MessageResource. So store on a new list.
    }


    // Get message based on an ID
    public Message getMessage(long id){
        return messages.get(id);
    }

    // Add an ID for a given message instance

    public Message addMessage(Message message){
        message.setId(messages.size() + 1);
        messages.put( message.getId(), message);
        return message;
    }

    // Previous entry must be present to update a message
    // Try: How about the conditional: message.getID != MessageResource.containsKey(message.getID) ?

    public Message updateMessage(Message message) {

        if (message.getId() <= 0) {
            return null;
        } else {
            messages.put(message.getId(), message);
            return message;
        }
    }

    // Delete a message based on an ID

    public void deleteMessage(long id) {
         messages.remove(id);
    }


    //  Filter messages based on year

    public List<Message> getAllMessagesForYear(int year){
        List<Message> messagesForYear = new ArrayList<Message>();  // Make a blank list
        Calendar cal = Calendar.getInstance();                     // Make a calendar instance when this method invoked
        for (Message message: messages.values()) {
            cal.setTime(message.getCreated());                     // Hand over the date variable of all the messages to 'cal' instance
            if (cal.get(1) == year) { // Calendar object 'cal' has year field as int '1'
                messagesForYear.add(message);
            }

        }
        return messagesForYear; // Add messages to the empty list that match the input year
    }

    // Pagination based i.e start_point, and size.

    public List<Message> getPaginatedMessages(int start, int size) {
        List<Message> paginatedArrayList = new ArrayList<Message>(messages.values());
        Iterator messageIterator = messages.entrySet().iterator();

        if (start + size > paginatedArrayList.size()) {
            return new ArrayList<Message>();

        }
        {
            return paginatedArrayList.subList(start, size);
        }


    }



    /*
    //TO DO Dummy method to check date format

    public String  returnDate() {
        Iterator it = messages.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            return pair.getValue().toString();

        }
    }
*/

//  TO DO: Try implementing the ITERATOR CLASS on the paginated list !



//        while(messageIterator.hasNext()) {
//            Map.Entry KVpair = (Map.Entry) messageIterator.next();
//
//            // if clause: If the for loop pointer exceeds the paginated index then return an empty list.
//            if (start + size > paginatedArrayList.size()) {
//                return new ArrayList<Message>();
//                {
//                   paginatedArrayList.add(KVpair.getKey().hashCode(),KVpair.getValue().toString());
//
//                }
//            }
//        }







}
