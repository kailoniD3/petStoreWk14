package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service


public class PetStoreService {
	
	@Autowired	
	private PetStoreDao petStoreDao;
	
	//@Autowired
  //  private PetStoreService petStoreService;
	
	//private PetStoreData petStoreData;
      
	@Transactional(readOnly = false)
    public PetStoreData savePetStore(PetStoreData petStoreData) {
        PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());

        copyPetStoreFields(petStore, petStoreData);
        //PetStore savedPetStore = petStoreDao.save(petStore);
        
        return new PetStoreData(petStoreDao.save(petStore));
    }
	
	  private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
	        petStore.setStoreName(petStoreData.getStoreName());
	        petStore.setStoreAddress(petStoreData.getStoreAddress());
	        petStore.setStoreCity(petStoreData.getStoreCity());
	        petStore.setPetStoreId(petStoreData.getPetStoreId());
	        petStore.setStoreZip(petStoreData.getStoreZip());
	        petStore.setStorePhone(petStoreData.getStorePhone());
	      
	      
	    }

    private PetStore findOrCreatePetStore(Long petStoreId) {
        if (Objects.isNull(petStoreId)) {
            return new PetStore(); 
        } else {
        	return findPetStoreById(petStoreId);
           
        }
    }
    private PetStore findPetStoreById(Long petStoreId) {
 
    	return petStoreDao.findById(petStoreId)
    	.orElseThrow(() -> new NoSuchElementException("PetStore with ID = "+ petStoreId + " was not found. "));
    	
    }
  
}
