package com.karanpractice26.PatientService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivilegedAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String zip;
}
