package com.example.bmsbookticket.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity(name ="users_table")
public class User extends BaseModel{
    private String name;
    private String email;
}
