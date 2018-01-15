package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.util.Date;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class User {
    private String _id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private Boolean isAcceptTermsAndConditions;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isVerified;
    private String recordStatus;

    public User() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean isAcceptTermsAndConditions() {
        return isAcceptTermsAndConditions;
    }

    public void setAcceptTermsAndConditions(Boolean acceptTermsAndConditions) {
        isAcceptTermsAndConditions = acceptTermsAndConditions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean isVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    private User(Builder builder) {
        this._id = builder._id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
        this.isAcceptTermsAndConditions = builder.isAcceptTermsAndConditions;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.isVerified = builder.isVerified;
        this.recordStatus = builder.recordStatus;
    }

    public static final class Builder {
        private String _id;
        private String name;
        private String lastName;
        private String email;
        private String password;
        private String phoneNumber;
        private String role;
        private Boolean isAcceptTermsAndConditions;
        private Date createdAt;
        private Date updatedAt;
        private Boolean isVerified;
        private String recordStatus;

        public Builder() {
        }

        public Builder id(String val) {
            this._id = val;
            return this;
        }

        public Builder name(String val) {
            this.name = val;
            return this;
        }

        public Builder lastName(String val) {
            this.lastName = val;
            return this;
        }

        public Builder email(String val) {
            this.email = val;
            return this;
        }

        public Builder password(String val) {
            this.password = val;
            return this;
        }

        public Builder phoneNumber(String val) {
            this.phoneNumber = val;
            return this;
        }

        public Builder role(String val) {
            this.role = val;
            return this;
        }

        public Builder acceptTermsAndConditions(Boolean val) {
            this.isAcceptTermsAndConditions = val;
            return this;
        }

        public Builder createdAt(Date val) {
            this.createdAt = val;
            return this;
        }

        public Builder updatedAt(Date val) {
            updatedAt = val;
            return this;
        }

        public Builder verified(Boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        public Builder recordStatus(String val) {
            this.recordStatus = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
