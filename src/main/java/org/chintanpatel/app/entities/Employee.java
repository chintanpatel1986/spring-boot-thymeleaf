package org.chintanpatel.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tbl_employee_employee_id_seq')")
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Size(max = 255)
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 255)
    @NotNull
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Size(max = 255)
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Size(max = 255)
    @NotNull
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "programming_language", columnDefinition = "varchar [](255) not null")
    private String[] programmingLanguage;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "mobile", nullable = false)
    private String mobile;

    @NotNull
    @Column(name = "\"birthDate\"", nullable = false)
    private LocalDate birthDate;

    @Size(max = 255)
    @NotNull
    @Column(name = "user_name", nullable = false)
    private String userName;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('tbl_employee_department_id_seq')")
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('tbl_employee_role_id_seq')")
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public @Size(max = 255) @NotNull String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Size(max = 255) @NotNull String firstName) {
        this.firstName = firstName;
    }

    public @Size(max = 255) @NotNull String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(@Size(max = 255) @NotNull String middleName) {
        this.middleName = middleName;
    }

    public @Size(max = 255) @NotNull String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(max = 255) @NotNull String lastName) {
        this.lastName = lastName;
    }

    public @Size(max = 255) @NotNull String getGender() {
        return gender;
    }

    public void setGender(@Size(max = 255) @NotNull String gender) {
        this.gender = gender;
    }

    public String[] getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String[] programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public @Size(max = 255) @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 255) @NotNull String email) {
        this.email = email;
    }

    public @Size(max = 255) @NotNull String getMobile() {
        return mobile;
    }

    public void setMobile(@Size(max = 255) @NotNull String mobile) {
        this.mobile = mobile;
    }

    public @NotNull LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotNull LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @Size(max = 255) @NotNull String getUserName() {
        return userName;
    }

    public void setUserName(@Size(max = 255) @NotNull String userName) {
        this.userName = userName;
    }

    public @Size(max = 255) @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@Size(max = 255) @NotNull String password) {
        this.password = password;
    }

    public @NotNull Department getDepartment() {
        return department;
    }

    public void setDepartment(@NotNull Department department) {
        this.department = department;
    }

    public @NotNull Role getRole() {
        return role;
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }
}