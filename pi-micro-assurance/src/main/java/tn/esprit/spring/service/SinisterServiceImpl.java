package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Sinister;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.InsuredRepository;
import tn.esprit.spring.repository.SinisterRepository;



@Service
public class SinisterServiceImpl implements ISinisterService {
	
	
	
	
	@Autowired
	SinisterRepository sinisterRep;
	
	
	@Autowired
	InsuredRepository insuredRep ;
	
	@Autowired
	ContractRepository contractRep ;
	
	
	private static final org.apache.logging.log4j.Logger l = LogManager.getLogger(UserService.class);

	@Override
	public List<Sinister> retrieveAllSinisters() {
		
		List<Sinister> sinisters = (List<Sinister>) sinisterRep.findAll();
		for (Sinister sinister : sinisters){
			l.info("sinister++:" + sinister) ;
	}
		return sinisters;
	}

	@Override
	public Sinister addSinister(Sinister sinister) {
		sinisterRep.save(sinister);
		return sinister;
	}

	@Override
	public String deleteSinister(int id) {
		sinisterRep.deleteById( id);
		return "Sinister removed !! " + id;
		
	}

	@Override
	public Sinister updateSinister(Sinister sinister) {
		
	Sinister existingSinister = sinisterRep.findById(sinister.getId()).orElse(null);
	existingSinister.setDeclarationDate(sinister.getDeclarationDate());	
	existingSinister.setSinisterDate(sinister.getSinisterDate());
	existingSinister.setSinisterDescription(sinister.getSinisterDescription());
	existingSinister.setSinisterNumber(sinister.getSinisterNumber());
	existingSinister.setSinisterPlace(sinister.getSinisterPlace());
	existingSinister.setSinisterStatus(sinister.getSinisterStatus());
	existingSinister.setSinisterType(sinister.getSinisterType());
	existingSinister.setContract(sinister.getContract());
	existingSinister.setArrangments(sinister.getArrangments());
	
	return sinisterRep.save(existingSinister);
	
	
	}
	@Override
	public Sinister retrieveSinister(int id) {
	
		return sinisterRep.findById(id).orElse(null);
	
	}

	@Override
	public Sinister retrieveSinisterByDeclarationDate(Date from, Date to) {
		
	 return sinisterRep.findByDeclarationDateBetween(from, to);
	}

	@Override
	public Sinister retrieveSinisterBySinisterDate(Date from, Date to) {
		
		return sinisterRep.findBySinisterDateBetween(from, to);
	
	}

	@Override
	public Sinister declarerSinistre(Sinister sinister,Insured insured  )
{
		Insured ins = insuredRep.findById(insured.getId()).orElse(null);
		Contract con = contractRep.findByInsured(ins).getContract();
		
		sinister.setContract(con);
		sinister.setSinisterStatus("IN PROCESS");
		sinister.setSinisterNumber(+1);
		sinisterRep.save(sinister) ;
				
		return sinister ;
	}

	
	
	@Override
	public Sinister traiterSinistre(Sinister sinister, Contract contract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sinister retrieveSinisterByContract(Contract contract) {
		
		return sinisterRep.findByContract(contract);
	}

	

	

}

