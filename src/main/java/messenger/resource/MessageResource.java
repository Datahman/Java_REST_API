package messenger.resource;

import messenger.model.Message;
import messenger.service.MessageService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("messages") // Note: The getAllMessages method is mapped to the class-level path "/messages".

public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@QueryParam("year")  int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size) {
        if(year != 0){
            return messageService.getAllMessagesForYear(year); // @Queryparam: If query parameters given i.e year,start,size then use them, else print all messages
        }
        if( start >=0 && size>=1) {
            return messageService.getPaginatedMessages(start,size);
        }

        else {
            return messageService.getAllMessages();
        }
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("test")
    public String test() {
        return "Test";
    }


    // Note 1: Path param annotation for individual resources dictated by their IDs!
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{messageid}")
    public Message getMessage(@PathParam("messageid") long messageid) {
        return messageService.getMessage(messageid);
    }

    // POST request to add message to the collection
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)


    public Message addMessage(Message message) {
        return messageService.addMessage(message);

    }

    // The delete method takes in the message id as provided by the path argument.
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{messageid}")
    public void deleteMessages(@PathParam("messageid") long messageid) {
        messageService.deleteMessage(messageid); // Don't return anything on return response
    }

    // Update messages present within the source collection
    // Also, return updated message. Note this isn't correct however, since it doesn't check the incoming 'request' message's ID i.e. an already present entry of i.d = 3 can be replaced to i.d 4 which is not the intention!
    // Use Path Param ! to do individual message updates.

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(Message message) {
        return messageService.updateMessage(message);
    }


    // For all responses on the sub-resource apply below method to call the instance

    @Path("/{messageID}/comments")
    public  CommentsResource getCommentResource(){
        return new CommentsResource();
    }

}



