package com.sphy.steticappproject.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cliente {

    @PrimaryKey
    private @NonNull String name;
    @ColumnInfo
    private String apellidos;
    @ColumnInfo
    private String DNI;
    @ColumnInfo
    private String telefono;
    @ColumnInfo
    private String calle;
    @ColumnInfo
    private int numCalle;
    @ColumnInfo
    private String email;
    @ColumnInfo
    private boolean VIP;


    public Cliente() {
    }

    public Cliente(@NonNull String name, String apellidos, String DNI, String telefono, String calle, int numCalle, String email, boolean VIP) {
        this.name = name;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.telefono = telefono;
        this.calle = calle;
        this.numCalle = numCalle;
        this.email = email;
        this.VIP = VIP;
    }

    public Cliente(@NonNull String name, String apellidos, String DNI) {
        this.name = name;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumCalle() {
        return numCalle;
    }

    public void setNumCalle(int numCalle) {
        this.numCalle = numCalle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }
}
