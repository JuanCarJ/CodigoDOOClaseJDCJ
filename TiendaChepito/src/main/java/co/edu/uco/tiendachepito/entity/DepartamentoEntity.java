package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.dto.PaisDTO;

public class DepartamentoEntity {
    private int id;
    private String nombre;
    private PaisDTO pais;

    public int getId() {
        return id;
    }

    public DepartamentoEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public DepartamentoEntity setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public DepartamentoEntity setPais(PaisDTO pais) {
        this.pais = pais;
        return this;
    }

    public DepartamentoEntity(int id, String nombre, PaisDTO pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }
}
