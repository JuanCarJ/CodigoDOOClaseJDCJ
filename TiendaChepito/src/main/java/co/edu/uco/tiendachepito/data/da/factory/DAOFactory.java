package co.edu.uco.tiendachepito.data.da.factory;

import co.edu.uco.tiendachepito.data.da.CiudadDAO;
import co.edu.uco.tiendachepito.data.da.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.da.PaisDAO;

public abstract class DAOFactory {

    protected abstract void obtenerConexion();

    public abstract void iniciarTransaccion();

    public abstract void confirmarTransaccion();

    public abstract void cancelarTransaccion();

    public abstract void cerrarConexion();

    public abstract PaisDAO getPaisDAO();

    public abstract DepartamentoDAO getDepartamentoDAO();

    public abstract CiudadDAO getCiudadDAO();





}
