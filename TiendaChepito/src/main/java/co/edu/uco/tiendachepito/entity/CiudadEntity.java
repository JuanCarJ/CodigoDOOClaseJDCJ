package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;

public class CiudadEntity {
    private int id;
    private String nombre;
    private DepartamentoEntity departamento;

    public CiudadEntity(int id, String nombre, DepartamentoEntity departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }
    private CiudadEntity(final int id){
        setId(id);
        //setDepartamento();
        //setNombre();
    }

    public int getId() {
        return id;
    }

    public CiudadEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public CiudadEntity setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public CiudadEntity setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
        return this;
    }
    protected static final CiudadEntity build (){
        return new CiudadEntity(NumericHelper.ZERO);
    }
}
