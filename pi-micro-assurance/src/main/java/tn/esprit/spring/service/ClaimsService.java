package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.Claims;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.repository.ClaimRepository;
import tn.esprit.spring.repository.InsuredRepository;
@Service
public class ClaimsService implements IClaimsService {
	@Autowired
	ClaimRepository clRep;
	
	@Autowired
	InsuredRepository insRep;
	@Override
	public long SendClaim(String rec, long insuredId) {
		
		Claims claim =new Claims();
		
		Insured ins = new Insured();
		ins=insRep.findById(insuredId).get();
		claim.setInsured(ins);
	    Calendar calendar = Calendar.getInstance();
	    claim.setDateClaim(calendar.getTime());
	    claim.setDescription(rec);
	    clRep.save(claim);	
		return claim.getId();
		
		
	}

	@Override
	public List<Claims> RetrieveAllClaims() {
		
		
		List<Claims>	Claims =clRep.ViewClaims();
		return Claims;
		
	}

	@Override
	public List<Claims> RetrieveNewClaims() {
		List<Claims>	Claims =clRep.ViewClaims();
		
		return Claims;
		
	}

	@Override
	public List<Claims> GetListCliamsLastXDays(int xDays) {
		List<Claims> claims=clRep.findAll(Sort.by(Sort.Direction.ASC, "dateClaim"));
		List<Claims> claimsDay = new ArrayList<Claims>() ;
		int i=1;
		int j=0;
		for(Claims c : claims ){
			
			claimsDay.add(c);
			if(claims.get(j).getDateClaim().getDay()!=claims.get(j+1).getDateClaim().getDay())
			i++;
			j++;
			if(i==xDays||(j==(claims.size()-1)))
				break;
		}
		return claimsDay;
		
		}
	
	

	@Override
	public void DeleteClaimById(long id){
		clRep.deleteById(id);;
	}

	@Override
	public Claims OpenClaimById(long id) {
		Claims c =clRep.findById(id).get();//.ViewClaimById(id);
		c.setStatus(1);
		clRep.save(c);
		
		//clRep.UpdateClaimStatus(1, id);
		return clRep.ViewClaimById(id);
	}

	@Override
	public int CountClaimsBetween(String EndDate_ddmmmyyyy, String BiginingDate_ddmmmyyyy) throws ParseException {
		
		int claimNember=0;
		List<Claims> claims=clRep.findAll(Sort.by(Sort.Direction.ASC, "dateClaim"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date datedebut=null;
		
			datedebut = formatter.parse(BiginingDate_ddmmmyyyy);
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date datefin=null;
		
			datefin = formatter1.parse(EndDate_ddmmmyyyy);
		
		for(Claims c : claims ){
			if(c.getDateClaim().after(datedebut))
				claimNember++;
			if(c.getDateClaim().after(datefin))
				break;
		}
		
		
		return claimNember;
	}

	@Override
	public void DeleteOldClaims(String firstdate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date datedebut=null;
		
			datedebut = formatter.parse(firstdate);
		List<Claims> c =RetrieveAllClaims();
		for (Claims claim: c){
			if(claim.getDateClaim().before(datedebut))
				clRep.delete(claim);
			
		}
		
		
	
	}

	
	
	
	
}


