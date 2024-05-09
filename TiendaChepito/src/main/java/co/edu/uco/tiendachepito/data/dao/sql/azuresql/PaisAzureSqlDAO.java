package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public final class PaisAzureSqlDAO extends SqlConnection implements PaisDAO {

	public PaisAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void crear(final PaisEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO Pais(Nombre) ");
		sentenciaSql.append("VALUES(?)");
		try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
			sentenciaPreparada.setString(1,  entidad.getNombre());
			sentenciaPreparada.executeUpdate();

		}catch (final SQLException exception){
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la inofrmacion del nuevo Pais. Por favor intente de neuvo y en caso de persistir el problema, comuniquese con el administrador de la tienda chepito";
			var mensajeTecnico = "Se ha presentado un problema tratando de realizar un insert de la informacion del pais";
			throw  new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		}catch (final Exception exception){

		}
	}

	@Override
	public final void actualizar(final PaisEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("UPDATE Pais");
		sentenciaSql.append("SET Nombre = 'Venezuela'");
		sentenciaSql.append("WHERE id = 1");

	}

	@Override
	public final void eliminar(final int id) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("DELETE FROM Pais");
		sentenciaSql.append("WHERE id = 1");
	}

	@Override
	public final List<PaisEntity> consultar(PaisEntity entidad) {
		final var listaPaises = new ArrayList<PaisEntity>();
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("SELECT id, nombre");
		sentenciaSql.append("FROM Pais");
		sentenciaSql.append("ORDER BY nombre ASC");

		try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())){
			try(final ResultSet resultados = sentenciaPreparada.executeQuery()){
				 	while ((resultados.next())){
						 PaisEntity paisTmp = PaisEntity.build(resultados.getInt("id"), resultados.getString("nombre"));
						 listaPaises.add(paisTmp);

					}
			}

		}catch (final SQLException exception){
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la inofrmacion del nuevo Pais. Por favor intente de neuvo y en caso de persistir el problema, comuniquese con el administrador de la tienda chepito";
			var mensajeTecnico = "Se ha presentado un problema tratando de realizar un insert de la informacion del pais";
			throw  new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		}catch (final Exception exception){

		}return listaPaises;
	}

}
