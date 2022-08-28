package com.example.sms_back_end.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author zhuangqihan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "zid")
    private long zid;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "contact")
    private String contact;
    @Column(name = "program")
    private int programCode;
    @Column(name = "stage")
    private int stage;
}
