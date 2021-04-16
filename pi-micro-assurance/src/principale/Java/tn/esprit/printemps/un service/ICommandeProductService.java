package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.dao.entities.CommandeProduct;

public interface ICommandeProductService {
	
	public CommandeProduct ajoutercommande(CommandeProduct commande);
	public void supprimercommande(int commande_id);
	public Optional<CommandeProduct> getCommande_by_id(int commande_id);
	public List<CommandeProduct> get_all_commandes();
	//public List<CommandeProduct> CommandeparClient(int id) ;
	public void PayerEnLigne(int idCommande);
	public void PayerComptant(int idCommande);
	//public List<CommandeProduct> CommandeparType(String type);
	public CommandeProduct findOne(int id);

}
