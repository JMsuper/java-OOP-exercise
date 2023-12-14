package org.example.app;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<Barbarian> userList;

    public Users(){
        this.userList = new ArrayList<>();
    }

    public void addUser(Barbarian barbarian){
        this.userList.add(barbarian);
    }

    public void printUsers(){
        for(Barbarian user : userList){
            user.print();
        }
    }
}
