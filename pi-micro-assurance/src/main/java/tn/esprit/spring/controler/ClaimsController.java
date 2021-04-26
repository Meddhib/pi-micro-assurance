package tn.esprit.spring.controler;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.Claims;

import tn.esprit.spring.service.IClaimsService;


@RestController
public class ClaimsController {

	
	
	@Autowired
	IClaimsService Icl;
	
	// SEND A claim : http://localhost:8081/SpringMVC/servlet/send-claim/1
		@PostMapping(value = "/send-claim/{insuredId}&{rec}")
		@ResponseBody
		public long SendClaim(@PathVariable("rec") String rec, @PathVariable("insuredId") long insuredId) {
	    	return	Icl.SendClaim(rec, insuredId);
	    }
		@GetMapping(value = "/retrieve-all-rec")
		@ResponseBody
		public List<Claims> getclaims() {
			
			return Icl.RetrieveAllClaims();
		}
		@GetMapping(value = "/retrieve-claim-id=/{id}")
		@ResponseBody
         public String getClaimByid(@PathVariable("id")long id) {
			
			return Icl.OpenClaimById(id).getDescription();
		}
		
		
		@DeleteMapping(value = "/delete-claim-id=/{claimid}")
		@ResponseBody
         public String deletclaim(@PathVariable("claimid")long id) {
			Icl.DeleteClaimById(id);
			return "Claim deleted";
		}
		@GetMapping(value = "/retrieve-New-Claims")
		@ResponseBody
		public List<Claims> RetrieveNewClaims(){
			return Icl.RetrieveNewClaims();
		}
		
		@GetMapping(value = "/retrieve-last=/{xDays}days")
		@ResponseBody
		public List<Claims> GetListCliamsLastXDays(@PathVariable("xDays")int xDays){
			return Icl.GetListCliamsLastXDays(xDays);
		};
		@GetMapping(value = "/CountClaimsBetween{debut}&{fin}")
		@ResponseBody
		public int CountClaimsBetween(@PathVariable("fin")String EndDate_ddmmmyyyy,@PathVariable("debut")String BiginingDate_yymmdd) throws ParseException{
			int n=Icl.CountClaimsBetween(EndDate_ddmmmyyyy, BiginingDate_yymmdd);
			return n;
		};
		
		@DeleteMapping(value = "/DeleteOldClaims{date}")
		@ResponseBody
		public String DeleteOldClaims(@PathVariable("date")String firstdate) throws ParseException{
			Icl.DeleteOldClaims(firstdate);
			return "claims deleted";
			
		};
		
		
		
		
}
