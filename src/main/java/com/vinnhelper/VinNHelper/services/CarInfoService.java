package com.vinnhelper.VinNHelper.services;

import com.vinnhelper.VinNHelper.models.CarInfo;
import com.vinnhelper.VinNHelper.repositories.CarInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarInfoService {

    private CarInfoRepository carInfoRepository;

    @Autowired
    public CarInfoService(CarInfoRepository carInfoRepository) {
        this.carInfoRepository = carInfoRepository;
    }

    public CarInfo findById(Long id) {
        return carInfoRepository.findById(id).orElse(null);
    }

    public List<CarInfo> findAll() {
        return carInfoRepository.findAll();
    }

    public CarInfo createCarInfo(CarInfo carInfo) {
        return carInfoRepository.save(carInfo);
    }

//    Проверить можно ли объекту просто присвоить id и сохранить
    public CarInfo updateCarInfo(Long id, CarInfo updatedeCarInfo) {
        CarInfo existingCarInfo = carInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("Car info is not exist"));

        existingCarInfo.setOtherInformation(updatedeCarInfo.getOtherInformation());

        return carInfoRepository.save(existingCarInfo);
    }

    public void deleteCarInfo(Long id) {
        carInfoRepository.deleteById(id);
    }
}
