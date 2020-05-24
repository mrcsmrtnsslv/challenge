package br.com.teste.challenge.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@OneToMany(mappedBy="brand", cascade = CascadeType.ALL)
	private List<Car> list;

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

	public List<Car> getList() {
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	public void setList(List<Car> list) {
		this.list = list;
	}

}
