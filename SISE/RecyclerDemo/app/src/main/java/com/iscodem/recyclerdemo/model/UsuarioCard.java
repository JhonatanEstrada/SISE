package com.iscodem.recyclerdemo.model;

/**
 * Created by iscodem on 07/04/2017.
 */

public class UsuarioCard {
    private String nombre;
    private String timeLike;
    private String numLike;
    private String fotoCard;

    public UsuarioCard(String nombre, String timeLike, String numLike, String fotoCard) {
        this.nombre = nombre;
        this.timeLike = timeLike;
        this.numLike = numLike;
        this.fotoCard = fotoCard;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTimeLike() {
        return timeLike;
    }

    public void setTimeLike(String timeLike) {
        this.timeLike = timeLike;
    }

    public String getNumLike() {
        return numLike;
    }

    public void setNumLike(String numLike) {
        this.numLike = numLike;
    }

    public String getFotoCard() {
        return fotoCard;
    }

    public void setFotoCard(String fotoCard) {
        this.fotoCard = fotoCard;
    }
}
