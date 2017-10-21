package messenger.resource;

//ProfileResource: This class does the implemntation of the various CRUD  operations as declared on ProfileService class.

import messenger.model.Profile;
import messenger.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("profiles")
public class ProfileResource {

    private  ProfileService profileService = new ProfileService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Profile> getProfiles(){
        return profileService.getallProfiles();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);

    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    @Path("{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
        profile.setProfileName(profileName); // Set the POST profile instance to 'profileName'as per the URI
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("{profileName}")
    public void deleteProfile(@PathParam("profileName") String profileName){
        profileService.deleteProfile(profileName);
    }




}
