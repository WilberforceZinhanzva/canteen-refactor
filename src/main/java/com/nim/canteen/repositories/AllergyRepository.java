package com.nim.canteen.repositories;

import com.nim.canteen.entities.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AllergyRepository extends JpaRepository<Allergy,Integer> {
    Optional<Allergy> findByAllergyName(String allergyName);
}
