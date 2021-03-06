package com.abhishekd.authservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Permission class
 */
@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
}
