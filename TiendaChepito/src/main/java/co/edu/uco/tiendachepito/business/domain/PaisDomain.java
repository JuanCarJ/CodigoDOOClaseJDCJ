package co.edu.uco.tiendachepito.business.domain;

import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;
import org.w3c.dom.Text;

public class PaisDomain {
    private int id;
    private String nombre;

    public PaisDomain(int id, String nombre) {
        setId(id);
        setNombre(nombre);
    }
    public PaisDomain(){
        setNombre(TextHelper.EMPTY);
    }
    public static final PaisDomain crear(final int id, final String nombre){
        return new PaisDomain(id, nombre);
    }
    public int getId() {
        return id;
    }

    /*public static final PaisDomain crear(){
        //
    }*/


    private PaisDomain setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    private PaisDomain setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
