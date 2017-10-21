package messenger.resource;

import messenger.model.Comment;
import messenger.service.CommentService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")// Access the class level path for the CommentResource. Note this is same as mapping path until /comments.
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CommentsResource  {

    private CommentService commentService = new CommentService();


    @GET
    public List<Comment> getComments (@PathParam("messageID") long messageID){
        return commentService.getComments(messageID);
    }

    // Adding a comment on a particular message ID ! hence coupled parameters messageID, Comment comment
    @POST

    public Comment addComment (@PathParam("messageID") long messageID,Comment comment){
        return commentService.addComment(messageID,comment);

    }

    // For updating a particular comment (based on commentID), set commendID as per the PathParam variable

    @PUT
    @Path("/{commentID}")
    public Comment updateComment(@PathParam("messageID") long messageID, @PathParam("commentID") long commentID, Comment comment){

        comment.setCommentID(commentID); // Note the 'request' variable here is commentID
        return commentService.updateComment(messageID,comment);
    }

    @DELETE
    @Path("/{commentID}")
    public void deleteComment(@PathParam("messageID") long messageID,
                              @PathParam("commentID") long commentID){
        commentService.deleteComment(messageID,commentID);
    }



    @GET
    @Path("/{commentID}")
    public Comment getCommentID(@PathParam("commentID") long commentID,
                               @PathParam("messageID") long messageID){
        return commentService.getComment(messageID,commentID);
    }


}
