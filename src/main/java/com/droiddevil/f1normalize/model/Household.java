package com.droiddevil.f1normalize.model;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Household implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("@id")
    private long id;

    @SerializedName("@uri")
    private String uri;

    @SerializedName("@oldID")
    private String oldID;

    @SerializedName("@hCode")
    private String hCode;

    private String householdName;

    private String householdSortName;

    private String householdFirstName;

    private Date lastSecurityAuthorization;

    private Date lastActivityDate;

    private Date createdDate;

    private Date lastUpdatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getOldID() {
        return oldID;
    }

    public void setOldID(String oldID) {
        this.oldID = oldID;
    }

    public String gethCode() {
        return hCode;
    }

    public void sethCode(String hCode) {
        this.hCode = hCode;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public String getHouseholdSortName() {
        return householdSortName;
    }

    public void setHouseholdSortName(String householdSortName) {
        this.householdSortName = householdSortName;
    }

    public String getHouseholdFirstName() {
        return householdFirstName;
    }

    public void setHouseholdFirstName(String householdFirstName) {
        this.householdFirstName = householdFirstName;
    }

    public Date getLastSecurityAuthorization() {
        return lastSecurityAuthorization;
    }

    public void setLastSecurityAuthorization(Date lastSecurityAuthorization) {
        this.lastSecurityAuthorization = lastSecurityAuthorization;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

}