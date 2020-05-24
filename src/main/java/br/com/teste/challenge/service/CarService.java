package br.com.teste.challenge.service;

import br.com.teste.challenge.model.Brand;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	public Iterable<Brand> sortListOfCars(Iterable<Brand> listOfBrandsAndCars) {
		listOfBrandsAndCars.forEach( b-> b.getList().sort((carOne, carTwo) -> carOne.getName().compareTo(carTwo.getName())));
		return listOfBrandsAndCars;
	}

}
