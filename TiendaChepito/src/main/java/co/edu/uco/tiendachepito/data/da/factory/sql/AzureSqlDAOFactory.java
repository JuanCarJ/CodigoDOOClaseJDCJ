package co.edu.uco.tiendachepito.data.da.factory.sql;

import co.edu.uco.tiendachepito.data.da.CiudadDAO;
import co.edu.uco.tiendachepito.data.da.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.da.PaisDAO;
import co.edu.uco.tiendachepito.data.da.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.da.sqlazuresql.DepartamentoAzureSqlDAO;
import co.edu.uco.tiendachepito.data.da.sqlazuresql.PaisAzureSqlDAO;

import java.sql.Connection;

public final class AzureSqlDAOFactory extends DAOFactory {
    private Connection connection;
    @Override
    public void obtenerConexion() {
        connection = null;
    }
    public AzureSqlDAOFactory(){
        obtenerConexion();
    }

    @Override
    public void iniciarTransaccion() {

    }

    @Override
    public void confirmarTransaccion() {

    }

    @Override
    public void cancelarTransaccion() {

    }

    @Override
    public void cerrarConexion() {

    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisAzureSqlDAO(connection);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoAzureSqlDAO()(connection);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadAzureSqlDAO(connection);
    }
}
