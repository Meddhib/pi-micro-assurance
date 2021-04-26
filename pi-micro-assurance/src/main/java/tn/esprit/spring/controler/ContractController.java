package tn.esprit.spring.controler;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import tn.esprit.spring.dao.entities.Category;
import tn.esprit.spring.dao.entities.Claims;
import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.ContractStatus;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Insurer;
import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.service.IClaimsService;
import tn.esprit.spring.service.IContractService;


@RestController
public class ContractController {
	@Autowired
	IContractService cntr;
	@Autowired
	ProductRepository pR;
	
	         //double calculateNetPrimium(Contract c,Date ppBiginigReferenceYear,Date ppEndReferenceYear, List<Product> panier);
             //Contract calculateTotalPrimuim(Contract c,double tax);
	//;// gener un contrat sans signature 
	//;// signature electronique l'assureur qui confirme la souscription 
	         //void archiveContract(Contract c);
	//;
	//;
	//;
	//Document generatePDFversion(Contract c) throws IOException, BadElementException, DocumentException;
	
	
	
	//http://localhost:8081/SpringMVC/servlet/viewContractsByStatus={stat}
	@GetMapping(value = "/viewContractsByStatus={stat}")
	@ResponseBody
	List<Contract> viewContractsByStatus(@PathVariable("stat")int stat){
		List<Contract> l=new ArrayList<>();
		switch(stat){
		case 1:
			l=cntr.viewContractsByStatus(ContractStatus.Waiting_For_Confirmation);
			break;
		case 2:
			l=cntr.viewContractsByStatus(ContractStatus.Valid_Contract);
			break;
		case 3:
			l=cntr.viewContractsByStatus(ContractStatus.Ended);
			break;
		
		
		}
		
		return l;	
	};
	
	

	//http://localhost:8081/SpringMVC/servlet/viewContractsByCategory=/{cat}
	
	@GetMapping(value = "/viewContractsByCategory=/{cat}")
	@ResponseBody
	List<Contract> viewContractsByCategory(@PathVariable("cat")int cat){
		List<Contract> l=new ArrayList<>();
		switch(cat){
		case 1:
			l=cntr.viewContractsByCategory(Category.health_insurance);
			break;
		case 2:
			l=cntr.viewContractsByCategory(Category.income_insurance);
			break;
		case 3:
			l=cntr.viewContractsByCategory(Category.life_insurance);
			break;
		case 4:
			l=cntr.viewContractsByCategory(Category.agriculture_insurance);
			break;
		}
		
		return l;	
	};
	//http://localhost:8081/SpringMVC/servlet/CountContractsBetween{debut}and{fin}
	@GetMapping(value = "/CountContractsBetween{debut}and{fin}")
	@ResponseBody
	public int CountContractsBetween(@PathVariable("fin")String EndDate_ddmmmyyyy,@PathVariable("debut")String BiginingDate_yymmdd){
		int n=cntr.CountContractsBetween(EndDate_ddmmmyyyy, BiginingDate_yymmdd);
		return n;
	};
	
	
	//http://localhost:8081/SpringMVC/servlet//viewContractsByInsuredId=/0
	@GetMapping(value = "/viewContractsByInsuredId=/{Id}")
	@ResponseBody
	List<Contract> viewContractsByInsuredId(@PathVariable("Id")long Id){
		
		List<Contract> l=new ArrayList<Contract>();
		l=cntr.findInsuredContracts(Id);
		
		
		return l;	
	};
	
	
	//http://localhost:8081/SpringMVC/servlet/viewContractsByInsurerId=/0
	@GetMapping(value = "/viewContractsByInsurerId=/{Id}")
	@ResponseBody
	List<Contract> viewContractsByInsurerId(@PathVariable("Id")long Id){
		
		List<Contract> l=new ArrayList<>();
		l=cntr.findInsurerContracts(Id);
		
		
		return l;	
	};
	
	//http://localhost:8081/SpringMVC/servlet/viewContractById=/0
	@GetMapping(value = "/viewContractById=/{Id}")
	@ResponseBody
	Contract viewContractById(@PathVariable("Id")long Id){
	
		return cntr.findContractById(Id);
	};
	 
	
	//http://localhost:8081/SpringMVC/servlet/signContract-id=/{contractid}
	@PostMapping(value = "/signContract-id=/{contractid}")
	@ResponseBody
     public String signContract(@PathVariable("contractid")long contractid) {
		cntr.signContract(contractid);
		return "Contract is valid now";
	}
	
	/**/
	//http://localhost:8081/SpringMVC/servlet/delete-id=/{contractid}
	@DeleteMapping(value = "/delete-id=/{contractid}")
	@ResponseBody
     public String deleteContract(@PathVariable("contractid")long contractid) {
		Contract c=cntr.findContractById(contractid);
		cntr.deleteContract(c);
		return "Contract deleted";
	}
	/**/
	//http://localhost:8081/SpringMVC/servlet/modify-Contract
	@PutMapping("/modify-Contract")
	@ResponseBody
	public Contract modifyContract(@RequestBody Contract c) {
		cntr.updateContract(c);
		return c;
	}
	
	//http://localhost:8081/SpringMVC/servlet/unSignContract-id=/{contractid}
	@PostMapping(value = "/unSignContract-id=/{contractid}")
	@ResponseBody
     public String unSignContract(@PathVariable("contractid")long contractid) {
		cntr.unsignContract(contractid);
		return "Contract Ended";
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/generate-Contract-indId={insured}/={id1}/={id2}
	@PostMapping("/generate-Contract-indId={insured}/={id1}/={id2}")
	@ResponseBody
	public Contract generateContract(@PathVariable("insured")long insured,@PathVariable("id2")long id1,@PathVariable("id2")long id2) throws ParseException {
		Product product1=pR.findById(id1).get();
		Product product2=pR.findById(id2).get();
		
		List<Product> product=new ArrayList<Product>();
		product.add(0, product1);
		product.add(0, product2);
		Contract c=new Contract();
		c=cntr.generateContract(insured,product);
		return c;
	}
	
	//http://localhost:8081/SpringMVC/servlet/generate-pdf-Contract
	@GetMapping("/generate-pdf-Contractid={id}")
	@ResponseBody
	public Document generatePDFversion(@PathVariable("id")long id) throws IOException, BadElementException, DocumentException {
		Contract c=cntr.findContractById(id);
		Document d=cntr.generatePDFversion(c);
		return d;
	}
	
	

}