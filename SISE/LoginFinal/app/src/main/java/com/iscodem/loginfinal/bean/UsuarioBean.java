package com.iscodem.loginfinal.bean;

import java.io.Serializable;

/**
 * Created by dporrasc on 01/03/2017.
 */

public class UsuarioBean implements Serializable{
    private String nombre;
    private String usuario;
    private String password;

    public UsuarioBean() { }

    public UsuarioBean(String nombre, String usuario, String password) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
