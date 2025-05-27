package com.estudio.reservas.dominio.manager;

import com.estudio.reservas.dominio.entidades.Equipaje;
import com.estudio.reservas.exception.DmException;
import java.util.List;

public interface EquipajeDmInterfaz {

    void createEquipaje(Equipaje equipaje) throws DmException;

    void updateEquipaje(Equipaje equipaje) throws DmException;

    void deleteEquipaje(int id) throws DmException;

    Equipaje getEquipajeById(int id) throws DmException;

    List<Equipaje> getAllEquipajes() throws DmException;
}
