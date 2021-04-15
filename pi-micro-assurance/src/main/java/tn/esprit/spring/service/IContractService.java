package tn.esprit.spring.service;

import java.util.*;

import tn.esprit.spring.dao.entities.Category;
import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Insurer;
import tn.esprit.spring.dao.entities.Product;

public interface IContractService {
	
	double calculateNetPrimium(Contract c,Date ppBiginigReferenceYear,Date ppEndReferenceYear, List<Product> panier);
	Contract calculateTotalPrimuim(Contract c,double tax);
	Contract generateContract(Contract c,Insured insured, List<Product> product);// gener un contrat sans signature 
	Contract signContract(Insured insured,Insurer insurer, Contract contract);// signature electronique l'assureur qui confirme la souscription 
	void archiveContract(Contract c);
	void deleteContract(Contract c);
	void updateContract(Contract c);
	void unsignContract(Contract c);
	List<Contract> findInsuredContracts(Insured Ind);
	List<Contract> findInsurerContracts(Insured Inr);
	void evaluteContract(Contract c);
	List<Contract> viewContractsByCategory(Category cat);
	public int CountContractsBetween(String EndDate_ddmmyyyy,String BiginingDate_yymmdd);
	List<Contract> findContractByCategory(Category categorie);
	
	
	
}
