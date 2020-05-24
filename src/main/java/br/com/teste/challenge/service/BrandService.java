package br.com.teste.challenge.service;

import br.com.teste.challenge.model.Brand;
import br.com.teste.challenge.model.Car;
import br.com.teste.challenge.repository.BrandRepository;
import br.com.teste.challenge.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private CarRepository carRepository;

	public void save(String name, String brandName) {
		Iterable<Brand> markReturned = brandRepository.findAll();
		if (markReturned.iterator().hasNext()) {
			Brand brand = brandRepository.findByName(brandName);
			Car car = carRepository.findByName(name);

			if (Objects.isNull(brand)) {
				if (Objects.isNull(car)) {
					saveNewBrandAndCar(name, brandName);
				} else {
					saveNewBrand(brandName);
					throw new RuntimeException("The brand was saved but the car model was not. Existing car model.");
				}
			} else {
				if (Objects.isNull(car)) {
					updateBrand(brand.getId(), name, brandName);
				} else {
					throw new RuntimeException("Existing car brand and model.");
				}
			}
		} else {
			saveNewBrandAndCar(name, brandName);
		}
	}

	public void delete(String nameCar) {
		Car car = carRepository.findByName(nameCar);
		if(!Objects.isNull(car)) {
			carRepository.delete(car);
		}else {
			throw new RuntimeException("The car does not exist.");
		}
	}
	
	private void updateBrand(Long idBrand, String name, String nameBrand) {
		Brand entity = new Brand();
		entity.setId(idBrand);
		entity.setName(nameBrand);
		Car car = new Car(name, entity);
		entity.getList().add(car);
		brandRepository.save(entity);
	}

	private void saveNewBrand(String brandName) {
		Brand entity = new Brand();
		entity.setName(brandName);
		brandRepository.save(entity);
	}

	private void saveNewBrandAndCar(String name, String markName) {
		Brand entity = new Brand();
		Car carModel = new Car(name, entity);
		entity.setName(markName);
		entity.getList().add(carModel);
		brandRepository.save(entity);
	}

}
