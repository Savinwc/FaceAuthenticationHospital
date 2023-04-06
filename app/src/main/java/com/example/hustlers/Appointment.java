package com.example.hustlers;

public class Appointment {
    private  String uid;
    private String docId;
    private boolean isVerified;


    private long token;
    public Appointment(String uid, String docId, boolean isVerified, long token) {
        this.uid = uid;
        this.docId = docId;
        this.isVerified = isVerified;
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "uid='" + uid + '\'' +
                ", docId='" + docId + '\'' +
                ", isVerified=" + isVerified + '\'' +
                ", token=" + token +
                '}';
    }
}
