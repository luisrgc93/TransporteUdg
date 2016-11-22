package com.luisrgc93.transporteudg.lib;

/**
 * Created by luisr_000 on 15/11/2016.
 */

public class getRutas {

    private String Nombre, RutaId, Codigo;

    public void getRutas(String Nombre, String RutaId, String Codigo)
    {
        this.Nombre = Nombre;
        this.Codigo = Codigo;
        this.RutaId = RutaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getRutaId() {
        return RutaId;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setRutaId(String rutaId) {
        RutaId = rutaId;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }


}
