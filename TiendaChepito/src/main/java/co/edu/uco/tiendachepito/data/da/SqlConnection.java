package co.edu.uco.tiendachepito.data.da;

import java.sql.Connection;

public class SqlConnection {
    private Connection connection;

    protected SqlConnection(final Connection connection){
        this.connection = connection;
    }
    private final void setConnection(final Connection connection){
        //TODO: Se debe validadr que la conexion este abierta
        this.connection = connection;
    }
    protected final Connection getConnection(){
        return connection;
    }
}
