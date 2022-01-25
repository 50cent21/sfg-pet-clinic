package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long>
                           implements VetService{

	private SpecialityService specialityService;
	
	@Override
	public Vet save(Vet object) {
		
		if(object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(specialty -> {
				if(specialty.getId() == 0) {
					Speciality savedSpecialty = specialityService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	
}
