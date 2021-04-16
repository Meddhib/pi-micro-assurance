/*package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.CommandeProduct;
import tn.esprit.spring.repository.CommandeProductRepository;

@Service
public class CommandeProductService implements ICommandeProductService {
	
	@Autowired
	CommandeProductRepository commandeProductRepository;

	@Override
	public CommandeProduct ajoutercommande(CommandeProduct commande) {
		commande.setDate_commande(new Date());
		return commandeProductRepository.save(commande);
		 
	}

	@Override
	public void supprimercommande(int commande_id) {
		commandeProductRepository.deleteById(commande_id);
		
	}

	@Override
	public Optional<CommandeProduct> getCommande_by_id(int commande_id) {
		return commandeProductRepository.findById(commande_id);
	}

	@Override
	public List<CommandeProduct> get_all_commandes() {
		return (List<CommandeProduct>) commandeProductRepository.findAll();
	}

//	@Override
//	public List<CommandeProduct> CommandeparClient(int id) {
//		return commandeProductRepository.CommandeparClient(id_client);
//	}

	@Override
	public void PayerEnLigne(int idCommande) {
		commandeProductRepository.PayerEnLigne(idCommande);
		
	}

	@Override
	public void PayerComptant(int idCommande) {
		commandeProductRepository.PayerComptant(idCommande);	
	}

	@Override
	public CommandeProduct findOne(int id) {
		return commandeProductRepository.getOne(id);
	}
	
	public long pt_merci(int idCommande){
		CommandeProduct c=commandeProductRepository.getOne(idCommande);
		double a=c.getPrixtotale();
		long r = Math.round(a / 10);
		return r;
	}
	

} */
