package com.ccc.tcapi.entites;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "users")
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "UserRowID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userRowID;

    @NotNull
    @Column(name = "OrgRowID")
    private Integer orgRowID;

    @NotEmpty(message = "Usercode can't be empty.")
    @Column(name = "UserCode", length = 6)
    private String userCode;

    @Column(name = "EmailActivationToken", nullable = true, length = 30)
    private String emailActivationToken;

    @NotEmpty(message = "Password can't be empty.")
    @Column(name = "PasswordHash", length = 255)
    private String passwordHash;

    @NotEmpty(message = "FirstName can't be empty.")
    @Size(min = 2, max = 30, message = "FirstName length must be min 2 char and maximum 30 char.")
    @Column(name = "FirstName", length = 30)
    private String firstName;

    @Size(min = 2, max = 30, message = "MiddleName length must be min 2 char and maximum 30 char.")
    @Column(name = "MiddleName", nullable = true, length = 30)
    private String middleName;

    @NotEmpty(message = "LastName can't be empty.")
    @Size(min = 2, max = 30, message = "LastName length must be min 2 char and maximum 30 char.")
    @Column(name = "LastName", length = 30)
    private String lastName;

    @Email(message = "Please enter a valid email id")
    @NotEmpty(message = "Email can't be empty.")
    @Size(min = 5, max = 50, message = "Email length must be min 5 char and maximum 50 char.")
    @Column(name = "Email", length = 50, unique = true)
    private String email;

    @NotNull()
    @Column(name = "UserTypeRowID")
    private Integer userTypeRowID;

    @NotNull()
    @Column(name = "CreatedDate", length = 20)
    private String createdDate;

    @NotNull()
    @Size(max = 15)
    @Column(name = "CreatedBy", length = 15)
    private String createdBy;

    @Size(max = 15)
    @Column(name = "UpdatedBy", nullable = true, length = 15)
    private String updatedBy;

    @Size(max = 15)
    @Column(name = "UpdatedDate", nullable = true, length = 15)
    private String updatedDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private TeacherEntity teacher;

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public Integer getUserRowID() {
        return userRowID;
    }

    public void setUserRowID(Integer userRowID) {
        this.userRowID = userRowID;
    }

    public Integer getOrgRowID() {
        return orgRowID;
    }

    public void setOrgRowID(Integer orgRowID) {
        this.orgRowID = orgRowID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getEmailActivationToken() {
        return emailActivationToken;
    }

    public void setEmailActivationToken(String emailActivationToken) {
        this.emailActivationToken = emailActivationToken;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public Integer getUserTypeRowID() {
        return userTypeRowID;
    }

    public void setUserTypeRowID(Integer userTypeRowID) {
        this.userTypeRowID = userTypeRowID;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

}
