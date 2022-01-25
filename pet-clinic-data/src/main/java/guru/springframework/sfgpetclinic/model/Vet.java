package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person{

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialities",
	           joinColumns = @JoinColumn(name= "vet_id"),
	           inverseJoinColumns = @JoinColumn(name = "speciality"))
	private Set<Speciality> specialities = new HashSet<>();

	
}
