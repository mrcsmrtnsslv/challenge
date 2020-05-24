package br.com.teste.challenge.repository;

import br.com.teste.challenge.model.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

	Brand findByName(String brandName);
	
	@Override
	@Query("Select b from Brand as b order by b.name desc")
	Iterable<Brand> findAll();
	
	Iterable<Brand> findByOrderByNameDesc();
}
