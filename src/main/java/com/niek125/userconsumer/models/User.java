package com.niek125.userconsumer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    private String id;
    private String profilePicture;
    private String userName;
    private String email;
}
