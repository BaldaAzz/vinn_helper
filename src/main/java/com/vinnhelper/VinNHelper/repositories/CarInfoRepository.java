package com.vinnhelper.VinNHelper.repositories;

import com.vinnhelper.VinNHelper.models.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInfoRepository extends JpaRepository<CarInfo, Long> {
}
