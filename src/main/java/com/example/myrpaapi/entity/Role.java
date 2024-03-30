package com.example.myrpaapi.entity;

import com.example.myrpaapi.enumerate.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private RoleType roleType;

}