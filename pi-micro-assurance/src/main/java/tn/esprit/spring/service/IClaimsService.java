package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.*;

import tn.esprit.spring.dao.entities.Claims;


public interface IClaimsService {
	public long SendClaim(String rec,long insuredId);
	public List<Claims> RetrieveAllClaims();
	public List<Claims> RetrieveNewClaims();
	public List<Claims> GetListCliamsLastXDays(int xDays);
	public void DeleteClaimById(long id);
	public Claims OpenClaimById(long id);
	public int CountClaimsBetween(String EndDate_ddmmmyyyy,String BiginingDate_yymmdd) throws ParseException;
	void DeleteOldClaims(String firstdate) throws ParseException;
	
}
