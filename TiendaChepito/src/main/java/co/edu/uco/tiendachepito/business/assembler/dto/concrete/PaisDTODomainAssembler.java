package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.PaisDTO;

public class PaisDTODomainAssembler implements DTODomainAssembler <PaisDomain, PaisDTO> {


    @Override
    public PaisDomain ensamblarDominio(final PaisDTO dto) {
        var paisDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new PaisDTO());
        return PaisDomain.crear(paisDtoTmp.getId(), paisDtoTmp.getNombre());
    }

    @Override
    public PaisDTO ensamblarDTO(final PaisDomain dominio) {
        var DOTMP = ObjectHelper.getObjectHelper().getDefault(dominio, new PaisDomain());
        return PaisDTO.build().setId(DOTMP.getId()).setNombre(DOTMP.getNombre());
    }
}
