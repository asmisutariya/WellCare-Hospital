package com.example.wellcarehospital;

public class dataholderregister {
    String fullName,emailID,moblieNo,age,password;
    public dataholderregister(){
    }

    public dataholderregister(String fullName, String emailID, String moblieNo, String age, String password) {
        this.fullName = fullName;
        this.emailID = emailID;
        this.moblieNo = moblieNo;
        this.age = age;
        this.password = password;
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

    public String getMoblieNo() {
        return moblieNo;
    }

    public void setMoblieNo(String moblieNo) {
        this.moblieNo = moblieNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
