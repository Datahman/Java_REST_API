package messenger.service;

import messenger.database.DatabaseClass;
import messenger.model.Comment;
import messenger.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

    private Map<Long,Message> messages = DatabaseClass.getMessages();

    public List<Comment> getComments(long messageID){
        Map<Long,Comment> comments = messages.get(messageID).getComments(); // Returns a hash-map of comments per messageID.
        return new ArrayList<Comment>(comments.values());
    }

    public Comment getComment(long messageID, long commentID) {
        Map<Long,Comment> comments = messages.get(messageID).getComments();
        return comments.get(commentID);
    }

    public Comment addComment(long messageID, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageID).getComments();
        comment.setCommentID(comments.size() + 1);
        comments.put(comment.getCommentID(), comment);
        return comment;
    }

    public Comment updateComment(long messageID, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageID).getComments();
        if (comment.getCommentID() <= 0) {
            return null;
        }
        {
            comments.put(comment.getCommentID(), comment);
            return comment;
        }
    }

    public void deleteComment(long messageID, long commentID){

        Map<Long, Comment> comments = messages.get(messageID).getComments();

        comments.remove(commentID);

    }



}
