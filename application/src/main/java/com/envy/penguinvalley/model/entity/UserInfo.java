package com.envy.penguinvalley.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class UserInfo {

    @Column(name = "info")
    private String info;
}
