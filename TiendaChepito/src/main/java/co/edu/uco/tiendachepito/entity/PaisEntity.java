package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public class PaisEntity {
    private int id;
    private String nombre;

    public PaisEntity(int id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    private int getId() {
        return id;
    }

    private String getNombre() {
        return nombre;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private PaisEntity(final int id){
        setNombre(TextHelper.EMPTY);
    }
}
