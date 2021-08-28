package com.mateusfuchs.festajuninasb.repositories;

import com.mateusfuchs.festajuninasb.entities.Salgado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalgadoRepository extends JpaRepository<Salgado, Integer> {

}
