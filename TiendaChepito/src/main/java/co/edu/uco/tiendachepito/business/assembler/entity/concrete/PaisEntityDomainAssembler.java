package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAsembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.PaisDTO;
import co.edu.uco.tiendachepito.entity.PaisEntity;
/*
public class PaisEntityDomainAssembler implements EntityDomainAsembler<PaisDomain, PaisEntity> {
    @Override
    public PaisDomain ensamblarDominio(final PaisEntity entidad) {
        var paisEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, PaisEntity.build().getId());
        return PaisDomain.crear(paisEntityTmp.getId(), paisEntityTmp.getNombre());
    }


    /*
    @Override
    public PaisEntity ensamblarEntidad(final PaisDomain dominio) {
        var DOTMP = ObjectHelper.getObjectHelper().getDefault(dominio, new PaisDomain());
        return PaisDTO.build().setId(DOTMP.getId()).setNombre(DOTMP.getNombre());
    } */
}
