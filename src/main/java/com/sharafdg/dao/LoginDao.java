package com.sharafdg.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class LoginDao extends Dao {

    @Setter
    private String emailId;

    @Setter
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
}
