package messenger.database;

import messenger.model.Message;
import messenger.model.Profile;

import java.util.HashMap;
import java.util.Map;

// A static class pretending. to be a database table definition for Messahes, and Profile.
public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap();
    private static Map<String, Profile> profiles = new HashMap();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
