package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;


@Data 
@NoArgsConstructor 

public class PetStoreData {
	
	 private Long petStoreId;  
	 private String storeName;
	 private String storeAddress;
	 private String storeCity;
	 private String storeZip;
	 private String storePhone;
	 private Set<PetStoreEmployee> employees = new HashSet<>();;  
	 private Set<PetStoreCustomer> customers = new HashSet<>();   
	   
	public PetStoreData(PetStore petStore) {
		petStoreId = petStore.getPetStoreId();
		storeName = petStore.getStoreName();
		storeAddress = petStore.getStoreAddress();
		storeCity = petStore.getStoreCity();
		storeZip = petStore.getStoreZip();
		storePhone = petStore.getStorePhone();
	
		  for (Employee employee : petStore.getEmployees()) {
	            employees.add(new PetStoreEmployee(employee));
	        }

	        for (Customer customer : petStore.getCustomers()) {
	            customers.add(new PetStoreCustomer(customer));
	        }
	    }
		//add for loop for employee and customer
		
	 @Data
	    @NoArgsConstructor
	    public class PetStoreEmployee {
	        
		 	private Long employeeId;
	        private String employeeName;
	        private String employeeFirstName;
	        private String employeeLastName;
	        private String employeePhone;
	        private String employeeJobTitle;

	        public PetStoreEmployee(Employee employee) {
	            this.employeeId = employee.getEmployeeId();
	            this.employeeFirstName = employee.getEmployeeFirstName();
	            this.employeeLastName = employee.getEmployeeLastName();
	            this.employeePhone = employee.getEmplyeePhone();
	            this.employeeJobTitle = employee.getEmployeeJobTitle();
	        }
	    }

	  
	    @Data
	    @NoArgsConstructor
	    public static class PetStoreCustomer {
	    
	        private Long customerId;
	        private String customerFirstName;
	        private String customerLastName;
	        private String customerEmail;
	        
	        
	        public PetStoreCustomer(Customer customer) {
	            this.customerId = customer.getCustomerId();
	            this.customerFirstName = customer.getCustomerFirstName();
	            this.customerLastName = customer.getCustomerLastName();
	            this.customerEmail = customer.getCustomerEmail();
	        }
	}
	    
	 
}

