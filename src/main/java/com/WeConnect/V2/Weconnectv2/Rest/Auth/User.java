package com.WeConnect.V2.Weconnectv2.Rest.Auth;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    String id;
   // @Column(name="profile_pic")
    //byte[] profile_pic; --v3 update
    @Column(name="username",nullable = false,unique = true,updatable = false)
    String username;
    @Column(name="email_id",nullable = false,unique = true,updatable = false)
    String email_id;
    @Column(name="password",nullable = false,updatable = true)
    String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
