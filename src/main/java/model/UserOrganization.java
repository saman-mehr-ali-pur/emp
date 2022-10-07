package model;

import java.time.ZonedDateTime;

public class UserOrganization extends BaseModel {
    private User user;
    private Organization organization;
    private ZonedDateTime registerDate;

    public UserOrganization() {
        this.registerDate = ZonedDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public ZonedDateTime getRegisterDate() {
        return registerDate;
    }

}
