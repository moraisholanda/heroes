package com.marvel.heroes.domain.model;

import android.content.Context;

/**
 * Created by sergio on 21/06/16.
 */
public class UserPreferences extends Preferences {
    public UserPreferences(Context context) {
        super(context);
    }

    private enum USER{
        NAME,
        EMAIL,
        GITHUB,
        DESCIRPTION
    }

    public void setName(String name){
        this.<String>setValue(USER.NAME.toString(),name);
    }
    public String getName(){
        return this.<String>getValue(USER.NAME.toString(), "");
    }

    public void setEmail(String email){
        this.<String>setValue(USER.EMAIL.toString(),email);
    }
    public String getEmail(){
        return this.<String>getValue(USER.EMAIL.toString(), "");
    }

    public void setGitHub(String gitHub){
        this.<String>setValue(USER.EMAIL.toString(),gitHub);
    }
    public String getGitHub(){
        return this.<String>getValue(USER.GITHUB.toString(), "");
    }

    public void setDescription(String gitHub){
        this.<String>setValue(USER.DESCIRPTION.toString(),gitHub);
    }
    public String getDescription(){
        return this.<String>getValue(USER.DESCIRPTION.toString(), "");
    }
}
