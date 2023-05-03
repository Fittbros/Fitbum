package com.fitbum.dto;

import java.io.Serializable;
import java.util.Set;

public class RoleDTO implements Serializable {
    private Integer idRole;
    private String nombreRole;

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNombreRole() {
        return nombreRole;
    }

    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }
}
