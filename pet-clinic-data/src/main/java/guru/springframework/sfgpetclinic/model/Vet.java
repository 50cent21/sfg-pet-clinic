package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "vets")
public class Vet extends Person{

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialities",
	           joinColumns = @JoinColumn(name= "vet_id"),
	           inverseJoinColumns = @JoinColumn(name = "speciality"))
	private Set<Speciality> specialities = new HashSet<>();

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
	
}
