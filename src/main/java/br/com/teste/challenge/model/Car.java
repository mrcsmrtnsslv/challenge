package br.com.teste.challenge.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "brand", referencedColumnName = "id", nullable = false)
	private Brand brand;

	@OneToMany
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Brand getBrand() {
		return brand;
	}
	public Car(String name, Brand brand) {
		this.name = name;
		this.brand = brand;
	}

	public Car() {
	}

}
