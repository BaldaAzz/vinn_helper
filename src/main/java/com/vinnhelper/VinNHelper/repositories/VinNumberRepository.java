package com.vinnhelper.VinNHelper.repositories;

import com.vinnhelper.VinNHelper.models.VinNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinNumberRepository extends JpaRepository<VinNumber, Long> {
}
