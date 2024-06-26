package co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.CrosscuttingTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {

	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
				"Lorem SQL"));
		mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
				"Lorem SQL"));
		mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
				"Se ha intentando realizar el cerrie de una conexion SQL que ya estaba cerrada"));
		mensajes.put(CodigoMensaje.M00010.getIdentificador(), new Mensaje(CodigoMensaje.M00010,
				"Hubo un error tratando de cerrar la conexion SQL"));
		mensajes.put(CodigoMensaje.M00011.getIdentificador(), new Mensaje(CodigoMensaje.M00011,
				"lLorem sql"));
		mensajes.put(CodigoMensaje.M00012.getIdentificador(), new Mensaje(CodigoMensaje.M00012,
				"Se ha intentado confirmar una transaccion con una conexion SQL cerrada"));
		mensajes.put(CodigoMensaje.M00013.getIdentificador(), new Mensaje(CodigoMensaje.M00013,
				"Se ha intentado confirmar una transaccion cuando el autocommit estaba activdado"));
		mensajes.put(CodigoMensaje.M00014.getIdentificador(), new Mensaje(CodigoMensaje.M00014,
				"Se ha presentado un problema tratando de confirmar una trasaccion SQL con la fuente de datos deseada"));
		mensajes.put(CodigoMensaje.M00015.getIdentificador(), new Mensaje(CodigoMensaje.M00015,
				"Se ha presentado un problema INEPSERADO tratando de confirmar una transaccion"));
		mensajes.put(CodigoMensaje.M00016.getIdentificador(), new Mensaje(CodigoMensaje.M00016,
				"Se ha presentado un problema INEPSERADO tratando de confirmar una transaccion"));
		mensajes.put(CodigoMensaje.M00017.getIdentificador(), new Mensaje(CodigoMensaje.M00017,
				"Se ha presentado un problema INEPSERADO tratando de confirmar una transaccion"));
		mensajes.put(CodigoMensaje.M00018.getIdentificador(), new Mensaje(CodigoMensaje.M00018,
				"Se ha presentado un problema INEPSERADO tratando de confirmar una transaccion"));
		mensajes.put(CodigoMensaje.M00019.getIdentificador(), new Mensaje(CodigoMensaje.M00019,
				"Se ha presentado un problema INEPSERADO tratando de confirmar una transaccion"));
		mensajes.put(CodigoMensaje.M00020.getIdentificador(), new Mensaje(CodigoMensaje.M00020,
				"Se ha presentado un problema INEPSERADO tratando de confirmar una transaccion"));
		mensajes.put(CodigoMensaje.M00021.getIdentificador(), new Mensaje(CodigoMensaje.M00021,
				"Se ha presentado un problema INEPSERADO tratando de confirmar una transaccion"));
	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {

		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004, codigo.getIdentificador());
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		// TODO: Tarea: asegure que si tiene parámetros, el contenido
		// del mensaje se retorne con los parámetros reemplazados
		// {1}, {2}, {3}

		return mensajes.get(codigo.getIdentificador());
	}

}
