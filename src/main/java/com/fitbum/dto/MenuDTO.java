package com.fitbum.dto;

import java.io.Serializable;
import java.util.Set;

public class MenuDTO implements Serializable {
    private Integer idMenu;
    private String nombre;
    private MenuDTO padre;
    private Integer orden;
    private Integer activo;
    private String url;
    private String icon;
    private Set<RoleDTO> roles;

    public MenuDTO() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MenuDTO getPadre() {
        return padre;
    }

    public void setPadre(MenuDTO padre) {
        this.padre = padre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
}
