package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petStoreId;
    
    private String storeName;
    
    private String storeAddress;
    
    private String storeCity;
    
    private String storeZip;
    
    private String storePhone;
    
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pet_store_customer", joinColumns = @JoinColumn(name = "pet_store_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Customer> customers = new HashSet<>();
    
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> employees = new HashSet<>();;
}




//public class petStore {
//	@Entity 
	//@Data 
			
	//	@Id 
	
	//-----	
	//	private Set<PetStore> petStores 
	//	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
		
	//	private PetStore petStores 
	//	@ManyToOne(cascade = CascadeType.ALL)

	//	@JoinColumn(name = "pet_store_id")
		 
	//	private Set<Customer> customers 
		//@ManyToMany(cascade = CascadeType.PERSIST)
		//@JoinTable(name = "pet_store_customer", joinColumns = @JoinColumn(name = "pet_store_id"), inverseJoinColumns = @JoinColumn(name = "customer_id")
		
	//	private Set<Employee> employees
	//	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	//}

//}
