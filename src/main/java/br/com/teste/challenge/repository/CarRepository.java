package br.com.teste.challenge.repository;

import br.com.teste.challenge.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{
	
	Car findByName(String name);
	
}
