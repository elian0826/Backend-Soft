package com.estudio.reservas.cu;

import com.estudio.reservas.dominio.entidades.Aerolinea;
import com.estudio.reservas.dominio.entidades.Moneda;
import com.estudio.reservas.dominio.entidades.Paises;
import com.estudio.reservas.dominio.entidades.TipoPago;


import com.estudio.reservas.dominio.manager.AerolineaDmInterfaz;
import com.estudio.reservas.dominio.manager.MonedaDmInterfaz;
import com.estudio.reservas.dominio.manager.PaisesDmInterfaz;
import com.estudio.reservas.dominio.manager.TipoPagoDmInterfaz;


import com.estudio.reservas.dto.DataGeneral;
import com.estudio.reservas.dto.GetMaestras;
import com.estudio.reservas.mapper.AerolineaMapper;
import com.estudio.reservas.mapper.MonedaMapper;
import com.estudio.reservas.mapper.PaisesMapper;
import com.estudio.reservas.mapper.TipoPagoMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdmonListasGenerales implements AdmonListasGeneralesInterfaz {

    @Autowired
    private AerolineaDmInterfaz aerolineaDmInterfaz;

    @Autowired
    private MonedaDmInterfaz monedaDm;

    @Autowired
    private TipoPagoDmInterfaz tipoPagoDm;

    @Autowired
    private PaisesDmInterfaz PaisesDm;

    @Override
    public DataGeneral getDataGeneral(List<GetMaestras> lista) throws Exception {
        DataGeneral dataGeneral = new DataGeneral();

        for (GetMaestras maestras : lista) {
            switch (maestras.getNombre().toLowerCase()) {

                case "aerolinea":
                    List<Aerolinea> listaAerolinea = aerolineaDmInterfaz.getAllAerolineas();
                    dataGeneral.setData(maestras.getNombre(), AerolineaMapper.mapper.toListEntityDto(listaAerolinea));
                    break;

                case "moneda":
                    List<Moneda> listMonedas = monedaDm.getAllMonedas();
                    dataGeneral.setData(maestras.getNombre(), MonedaMapper.mapper.toListEntityDto(listMonedas));
                    break;

                case "tipo_pago":
                    List<TipoPago> listaTipoPago = tipoPagoDm.getAllTipoPago();
                    dataGeneral.setData(maestras.getNombre(), TipoPagoMapper.mapper.toListEntityDto(listaTipoPago));
                    break;

                case "paises":
                    List<Paises> listaPaises = PaisesDm.getAllPaises();
                    dataGeneral.setData(maestras.getNombre(), PaisesMapper.mapper.toListEntityDto(listaPaises));
                    break;

                default:
                    // log o ignorar
                    break;
            }
        }

        return dataGeneral;
    }
}
