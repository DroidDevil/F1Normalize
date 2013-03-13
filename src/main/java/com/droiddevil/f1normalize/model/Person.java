package com.droiddevil.f1normalize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.droiddevil.f1normalize.normalizer.NormalizerName;
import com.google.gson.annotations.SerializedName;

public class Person implements Serializable {

    public abstract static class IdUri {

        @SerializedName("@id")
        private String id;

        @SerializedName("@uri")
        private String uri;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

    }

    public abstract static class IdUriName extends IdUri {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class HouseholdMemberType implements Serializable {

        private static final long serialVersionUID = 1L;

        @SerializedName("@id")
        private long id;

        @SerializedName("@uri")
        private String uri;

        private String head;

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

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

    }

    public static class Status extends IdUriName implements Serializable {

        private static final long serialVersionUID = 1L;

        private String comment;

        private Date date;

        private SubStatus subStatus;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public SubStatus getSubStatus() {
            return subStatus;
        }

        public void setSubStatus(SubStatus subStatus) {
            this.subStatus = subStatus;
        }

    }

    public static class SubStatus extends IdUriName implements Serializable {

        private static final long serialVersionUID = 1L;

    }

    public static class Occupation extends IdUriName implements Serializable {

        private static final long serialVersionUID = 1L;

        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    public static class School extends IdUriName implements Serializable {

        private static final long serialVersionUID = 1L;

    }

    public static class Denomination extends IdUriName implements Serializable {

        private static final long serialVersionUID = 1L;

    }

    public static class Weblink implements Serializable {

        private static final long serialVersionUID = 1L;

        private String userID;

        private String passwordHint;

        private String passwordAnswer;

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getPasswordHint() {
            return passwordHint;
        }

        public void setPasswordHint(String passwordHint) {
            this.passwordHint = passwordHint;
        }

        public String getPasswordAnswer() {
            return passwordAnswer;
        }

        public void setPasswordAnswer(String passwordAnswer) {
            this.passwordAnswer = passwordAnswer;
        }

    }

    public static class Attributes implements Serializable {

        private static final long serialVersionUID = 1L;

        private List<Attribute> attribute;

        public List<Attribute> getAttribute() {
            return attribute;
        }

        public void setAttribute(List<Attribute> attribute) {
            this.attribute = attribute;
        }

    }

    public static class Attribute extends IdUri implements Serializable {

        private static final long serialVersionUID = 1L;

        AttributePerson person;

        AttributeGroup attributeGroup;

        private Date startDate;

        private Date endDate;

        private String comment;

        private Date createdDate;

        private Date lastUpdatedDate;

        public AttributePerson getPerson() {
            return person;
        }

        public void setPerson(AttributePerson person) {
            this.person = person;
        }

        public AttributeGroup getAttributeGroup() {
            return attributeGroup;
        }

        public void setAttributeGroup(AttributeGroup attributeGroup) {
            this.attributeGroup = attributeGroup;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
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

    public static class AttributePerson extends IdUri implements Serializable {

        private static final long serialVersionUID = 1L;

    }

    public static class AttributeGroup extends IdUriName implements Serializable {

        private static final long serialVersionUID = 1L;

        private AttributeGroupAttribute attribute;

        public AttributeGroupAttribute getAttribute() {
            return attribute;
        }

        public void setAttribute(AttributeGroupAttribute attribute) {
            this.attribute = attribute;
        }

    }

    public static class AttributeGroupAttribute extends IdUriName implements Serializable {

        private static final long serialVersionUID = 1L;

    }

    public static class Communications implements Serializable {

        private static final long serialVersionUID = 1L;

        private List<Communication> communication;

        public List<Communication> getCommunication() {
            return communication;
        }

        public void setCommunication(List<Communication> communication) {
            this.communication = communication;
        }

    }

    public static class Communication extends IdUri implements Serializable {

        private static final long serialVersionUID = 1L;

        private CommunicationHousehold household;

        private CommunicationPerson person;

        private CommunicationType type;

        private String communicationGeneralType;

        private String communicationValue;

        private String searchCommunicationValue;

        private boolean listed;

        private String communicationComment;

        private Date createdDate;

        private Date lastUpdatedDate;

        public CommunicationHousehold getHousehold() {
            return household;
        }

        public void setHousehold(CommunicationHousehold household) {
            this.household = household;
        }

        public CommunicationPerson getPerson() {
            return person;
        }

        public void setPerson(CommunicationPerson person) {
            this.person = person;
        }

        public CommunicationType getType() {
            return type;
        }

        public void setType(CommunicationType type) {
            this.type = type;
        }

        public String getCommunicationGeneralType() {
            return communicationGeneralType;
        }

        public void setCommunicationGeneralType(String communicationGeneralType) {
            this.communicationGeneralType = communicationGeneralType;
        }

        public String getCommunicationValue() {
            return communicationValue;
        }

        public void setCommunicationValue(String communicationValue) {
            this.communicationValue = communicationValue;
        }

        public String getSearchCommunicationValue() {
            return searchCommunicationValue;
        }

        public void setSearchCommunicationValue(String searchCommunicationValue) {
            this.searchCommunicationValue = searchCommunicationValue;
        }

        public boolean isListed() {
            return listed;
        }

        public void setListed(boolean listed) {
            this.listed = listed;
        }

        public String getCommunicationComment() {
            return communicationComment;
        }

        public void setCommunicationComment(String communicationComment) {
            this.communicationComment = communicationComment;
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

    public static class CommunicationHousehold extends IdUri implements Serializable {

        private static final long serialVersionUID = 1L;

    }

    public static class CommunicationPerson extends IdUri implements Serializable {

        private static final long serialVersionUID = 1L;

    }

    public static class CommunicationType extends IdUriName implements Serializable {

        private static final long serialVersionUID = 1L;

    }

    private static final long serialVersionUID = 1L;

    @SerializedName("@id")
    private long id;

    @SerializedName("@uri")
    private String uri;

    @SerializedName("@imageURI")
    private String imageURI;

    @SerializedName("@oldID")
    private String oldID;

    @SerializedName("@iCode")
    private String iCode;

    @SerializedName("@oldHouseholdID")
    private String oldHouseholdID;

    private String title;

    private String salutation;

    private String prefix;

    @NormalizerName
    private String firstName;

    @NormalizerName
    private String lastName;

    private String suffix;

    @NormalizerName
    private String middleName;

    private String goesByName;

    @NormalizerName
    private String formerName;

    private String gender;

    private Date dateOfBirth;

    private String maritalStatus;

    private HouseholdMemberType householdMemberType;

    private boolean isAuthorized;

    private Status status;

    private Occupation occupation;

    private String employer;

    private School school;

    private Denomination demonination;

    private String formerChurch;

    private String barCode;

    private String memberEnvelopeCode;

    private String defaultTagComment;

    private Weblink weblink;

    private String solicit;

    private String thank;

    private Date firstRecord;

    private Attributes attributes;

    private String address;

    private Communications communications;

    private Date lastMatchDate;

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

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getOldID() {
        return oldID;
    }

    public void setOldID(String oldID) {
        this.oldID = oldID;
    }

    public String getiCode() {
        return iCode;
    }

    public void setiCode(String iCode) {
        this.iCode = iCode;
    }

    public String getOldHouseholdID() {
        return oldHouseholdID;
    }

    public void setOldHouseholdID(String oldHouseholdID) {
        this.oldHouseholdID = oldHouseholdID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGoesByName() {
        return goesByName;
    }

    public void setGoesByName(String goesByName) {
        this.goesByName = goesByName;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public HouseholdMemberType getHouseholdMemberType() {
        return householdMemberType;
    }

    public void setHouseholdMemberType(HouseholdMemberType householdMemberType) {
        this.householdMemberType = householdMemberType;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Denomination getDemonination() {
        return demonination;
    }

    public void setDemonination(Denomination demonination) {
        this.demonination = demonination;
    }

    public String getFormerChurch() {
        return formerChurch;
    }

    public void setFormerChurch(String formerChurch) {
        this.formerChurch = formerChurch;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getMemberEnvelopeCode() {
        return memberEnvelopeCode;
    }

    public void setMemberEnvelopeCode(String memberEnvelopeCode) {
        this.memberEnvelopeCode = memberEnvelopeCode;
    }

    public String getDefaultTagComment() {
        return defaultTagComment;
    }

    public void setDefaultTagComment(String defaultTagComment) {
        this.defaultTagComment = defaultTagComment;
    }

    public Weblink getWeblink() {
        return weblink;
    }

    public void setWeblink(Weblink weblink) {
        this.weblink = weblink;
    }

    public String getSolicit() {
        return solicit;
    }

    public void setSolicit(String solicit) {
        this.solicit = solicit;
    }

    public String getThank() {
        return thank;
    }

    public void setThank(String thank) {
        this.thank = thank;
    }

    public Date getFirstRecord() {
        return firstRecord;
    }

    public void setFirstRecord(Date firstRecord) {
        this.firstRecord = firstRecord;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Communications getCommunications() {
        return communications;
    }

    public void setCommunications(Communications communications) {
        this.communications = communications;
    }

    public Date getLastMatchDate() {
        return lastMatchDate;
    }

    public void setLastMatchDate(Date lastMatchDate) {
        this.lastMatchDate = lastMatchDate;
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