package messenger.service;

import com.sun.deploy.util.StringUtils;
import messenger.database.DatabaseClass;
import messenger.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private Map<String,Profile> profiles = DatabaseClass.getProfiles(); // private to keep this static instance within current namespace only.

    public ProfileService() {

        profiles.put("First_Profile_Person", new Profile(1L,"ProfileName","Your","John"));
    }

    public List<Profile> getallProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        return profiles.put(profile.getProfileName(),profile);
    }
    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName() == null ) {
            return null;
        } else {
            profiles.put(profile.getProfileName(),profile); // Make the rightful changes to the profile list
            return profile; // return newly updated profile info
        }
    }

    public void deleteProfile(String profileName) {
        profiles.remove(profileName);
    }
}
