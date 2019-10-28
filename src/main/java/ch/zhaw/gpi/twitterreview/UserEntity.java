package ch.zhaw.gpi.twitterreview;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * UserEntity
 */
@Entity(name = "User")
public class UserEntity {

    @Id
    private String userName;       
    private String firstName;    
    private String officialName;    
    private String eMail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    
    
}