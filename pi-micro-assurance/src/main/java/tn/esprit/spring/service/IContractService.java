package tn.esprit.spring.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import tn.esprit.spring.dao.entities.Category;
import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.ContractStatus;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Insurer;
import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.dao.entities.User;

public interface IContractService {
	
	Contract calculateNetPrimium(Contract c,String ppBiginigReferenceYear,String ppEndReferenceYear, List<Product> panier) throws ParseException;
	Contract calculateTotalPrimuim(Contract c,double tax);
	Contract generateContract(long insuredid, List<Product> product) throws ParseException;// gener un contrat sans signature 
	Contract signContract( long contractid);// signature electronique l'assureur qui confirme la souscription 
	void archiveContract(Contract c);
	void deleteContract(Contract c);
	void updateContract(Contract c);
	public Contract unsignContract( long contractid) ;
	List<Contract> findInsuredContracts(long Ind);
	List<Contract> findInsurerContracts(long Inr);
	void evaluteContract(Contract c);
	List<Contract> viewContractsByCategory(Category cat);
	public int CountContractsBetween(String EndDate_ddmmyyyy,String BiginingDate_yymmdd);
	List<Contract> findContractByCategory(Category categorie);
	Document generatePDFversion(Contract c) throws IOException, BadElementException, DocumentException;
	List<Contract> viewContractsByStatus(ContractStatus stat);
	Contract findContractById(long Inr);

	
	
	
	
}
