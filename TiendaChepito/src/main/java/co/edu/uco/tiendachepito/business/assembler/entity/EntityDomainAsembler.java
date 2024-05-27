package co.edu.uco.tiendachepito.business.assembler.entity;

public interface EntityDomainAsembler <D,E>{
    D ensamblarDominio(E entity);

    E ensamblarEntidad(D dominio);
}
