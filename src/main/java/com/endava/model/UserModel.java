package com.endava.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class UserModel {

    @Id
    private ObjectId _id;
    //@Id
    private String email;
    private String password;
    private String role;

    public void setId(ObjectId id) {this._id = id;}

    public ObjectId getId() {return this._id;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){return this.email;}

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){return this.password;}

    public void setRole(String role) {
        this.role = role;
    }
}
