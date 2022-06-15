package org.etf.unibl.repositories;

import org.etf.unibl.models.entities.AddressEntity;
import org.etf.unibl.models.entities.MuseumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

}
