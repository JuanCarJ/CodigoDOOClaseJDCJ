package co.edu.uco.tiendachepito.data.da.sqlazuresql;

import co.edu.uco.tiendachepito.data.da.PaisDAO;
import co.edu.uco.tiendachepito.data.da.SqlConnection;
import co.edu.uco.tiendachepito.entity.PaisEntity;
import org.yaml.snakeyaml.nodes.CollectionNode;

import java.sql.Connection;
import java.util.List;

public final class PaisAzureSqlDAO extends SqlConnection implements PaisDAO {

    public PaisAzureSqlDAO(final Connection connection){
        super(connection);
    }
    @Override
    public final void actualizar(PaisEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE Pais");
        sentenciaSql.append("SET nombre = 'Venezuela'");
        sentenciaSql.append("WHERE PaisID = 1;");
    }

    @Override
    public final List<PaisEntity> consultar(PaisEntity entidad) {
        /*SELECT id, nombre from Pais where id = 1 order by nombre asc */
    }

    @Override
    public final void crear(PaisEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO Pais(Nombre)");
        sentenciaSql.append("Values('Colombia)");
    }

    @Override
    public final void eliminar(int id) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("DELETE FROM Pais WHERE PaisID = 1;");
    }
}
