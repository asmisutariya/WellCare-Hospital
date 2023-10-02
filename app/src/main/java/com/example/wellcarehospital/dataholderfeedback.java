package com.example.wellcarehospital;

public class dataholderfeedback {
    String fullName,emailID,message;

    public dataholderfeedback(){
    }
    public dataholderfeedback(String fullName, String emailID, String message) {
        this.fullName = fullName;
        this.emailID = emailID;
        this.message = message;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {

        this.emailID = emailID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }
}
