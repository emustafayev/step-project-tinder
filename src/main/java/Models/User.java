package Models;

import lombok.*;

import java.util.UUID;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String userID;
    private String username;
    private String password;
    private Gender gender;
    private String imageURL="https://i.imgur.com/EvEgy19.jpg";

    public User(){}
    public User(String userID,String username, String password, String gender,String imageURL){ //for data from db
        this(username, password, gender, imageURL);
        this.userID=userID;
    } // fetch
    public User(String username, String password, String gender,String imageURL){ //from user
        this(username, password, gender);
        this.imageURL=imageURL;
    } //image
    public User(String username, String password, String gender){ // from user with default image
        super();
        this.username=username;
        this.password=password;
        this.gender=Gender.valueOf(gender);
    } //image not

    public String getAbsoluteURL(){
        return String.format("user/message/?messageTo=%s",this.userID.toString());//TODO not correct format.
    }
    // Liked Users List = >>>
}
