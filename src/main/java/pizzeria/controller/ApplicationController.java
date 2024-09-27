package pizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pizzeria.model.*;
import pizzeria.service.ImpastoService;
import pizzeria.service.IngredienteService;
import pizzeria.service.PizzaService;
import pizzeria.service.UtenteService;

@Controller

public class ApplicationController {

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private ImpastoService impastoService;
	@Autowired
	private IngredienteService ingredienteService;
	
	private Utente attivo;

	@RequestMapping("/")
	public String viewLoginPage(Model model) {
		return "login";
	}

	@RequestMapping(value = "/loginAttempt")
	public String login(@ModelAttribute Utente user, Model model) {

		String next = "login";
		String errore = "Credenziali errate, riprovare.";
		Utente utente = utenteService.getUser(user.getUsername(), user.getPsw());
		if (utente != null) {
			next = "redirect:/home";
			attivo = utente;
			errore = null;
		}
		model.addAttribute("errore", errore);

		return next;
	}

	@RequestMapping("/home")
	public String viewHomePage(Model model) {

		attivo = utenteService.getUserById(attivo.getId());
		model.addAttribute("username", attivo.getUsername());

		model.addAttribute("listaPizzeUtente", attivo.getPizze());
		return "indexpage";
	}

	@RequestMapping("/new")
	public String showNewPizzaPage(Model model) {
		Wrapper wrapper = new Wrapper();
		model.addAttribute("wrapper", wrapper);
		model.addAttribute("listaIngredienti", ingredienteService.findAll());
		model.addAttribute("listaImpasti", impastoService.findAll());

		return "newpizza";
	}

	public void verificaESalva(Wrapper w, boolean update) {

		if (w.getNomepizza() != null && !w.getNomepizza().isBlank()) {
			try {
				Impasto impasto = impastoService.findById(w.getImpasto());
				List<Ingrediente> lista = new ArrayList<Ingrediente>();
				for (int i : w.getIngredienti()) {
					lista.add(ingredienteService.findById(i));
				}

				if (!update) {
					Pizza p = new Pizza(w.getNomepizza(), attivo, impasto, lista);
					pizzaService.save(p);
				}

				else {

					Pizza p = pizzaService.findById(w.getIdpizza());
					p.setNome(w.getNomepizza());
					p.setImpasto(impasto);
					p.setIngredienti(lista);
					pizzaService.save(p);
				}

			} catch (Exception e) {

			}

		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePizza(@ModelAttribute("wrapper") Wrapper wrapper) {
		verificaESalva(wrapper, false);
		return "redirect:/home";
	}

	@RequestMapping("/edit/{id}")
	public String showEditPizzaPage(@PathVariable int id, Model model) {

		Pizza pizza = pizzaService.findById(id);

		Wrapper w = new Wrapper();
		w.setIdpizza(pizza.getId());
		w.setNomepizza(pizza.getNome());
		model.addAttribute("listaIngredienti", ingredienteService.findAll());
		model.addAttribute("listaImpasti", impastoService.findAll());
		model.addAttribute("wrapper", w);
		return "editpizza";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePizza(@ModelAttribute Wrapper wrapper) {

		verificaESalva(wrapper, true);
		return "redirect:/home";
	}

	@RequestMapping("/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		pizzaService.delete(id);
		return "redirect:/home";
	}

}
