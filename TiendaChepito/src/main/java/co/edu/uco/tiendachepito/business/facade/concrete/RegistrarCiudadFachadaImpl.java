package co.edu.uco.tiendachepito.business.facade.concrete;

import co.edu.uco.tiendachepito.business.facade.RegistrarCiudadFachada;
import co.edu.uco.tiendachepito.business.usecase.RegistrarCiudad;
import co.edu.uco.tiendachepito.business.usecase.concrete.RegistrarCiudadImpl;
import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.BusinessTiendaChepitoException;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.dao.factory.enums.Factory;
import co.edu.uco.tiendachepito.dto.CiudadDTO;

public final class RegistrarCiudadFachadaImpl implements RegistrarCiudadFachada {

    private DAOFactory factory;

    private RegistrarCiudadFachadaImpl(){
        factory = DAOFactory.getFactory(Factory.AZURESQL);
    }
    @Override
    public final void ejecutar(CiudadDTO ciudad){
        try {
            factory.iniciarTransaccion();
            RegistrarCiudad useCase = new RegistrarCiudadImpl(factory);
            useCase.ejecutar(null);
            factory.confirmarTransaccion();
        }catch (final TiendaChepitoException exception){
            factory.cancelarTransaccion();
            throw exception;
        }catch (final Exception excepcion ){
            factory.cancelarTransaccion();
            var MensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion de la nueva ciudad";
            var MensajeTecnico = "Se ha presentado un problema inesperado tratando de registrar la informacion de la nueva ciudad  en metodo de ejectur...";
            throw new BusinessTiendaChepitoException(MensajeTecnico, MensajeUsuario);
        }finally { factory.cerrarConexion();
        }

    }
}
