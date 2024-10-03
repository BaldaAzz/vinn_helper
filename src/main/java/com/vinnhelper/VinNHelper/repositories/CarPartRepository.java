package com.vinnhelper.VinNHelper.repositories;

import com.vinnhelper.VinNHelper.models.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}
