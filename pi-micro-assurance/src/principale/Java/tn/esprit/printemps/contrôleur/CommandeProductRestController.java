/*package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.CommandeProduct;
import tn.esprit.spring.service.CommandeProductService;

@RestController
public class CommandeProductRestController {
	
	@Autowired
	private CommandeProductService CommandesService;
	
	@PostMapping("/ajouter")
	public CommandeProduct AjouterCommande( @RequestBody CommandeProduct c) {
		return CommandesService.ajoutercommande(c);
	}
	
	@GetMapping("/afficher")
	public List<CommandeProduct> getAllCommande() {
		return CommandesService.get_all_commandes();
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CommandeProduct> DeleteCommande(@PathVariable(value = "id") int idCommande) {
		CommandeProduct c = CommandesService.findOne(idCommande);
		if (c == null) {
			return ResponseEntity.notFound().build();
		}
		CommandesService.supprimercommande(idCommande);
		return ResponseEntity.ok().build();
	}
	

	@PutMapping("/payerenligne/{idCommande}")
	public void PayerEnLigne(@PathVariable(value = "idCommande") int idCommande) {
		CommandesService.PayerEnLigne(idCommande);
	}
	
	@PutMapping("/payerporteaporte/{idCommande}")
	public void PayerPorteaPorte(@PathVariable(value = "idCommande") int idCommande) {
		CommandesService.PayerComptant(idCommande);
	}
	
	@GetMapping("pt_merci/{idCommande}")
	public long pt_merci(@PathVariable(value ="idCommande")int idCommande){
		return CommandesService.pt_merci(idCommande);
	}
}
*/
