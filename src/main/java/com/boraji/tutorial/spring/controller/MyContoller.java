package com.boraji.tutorial.spring.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boraji.tutorial.spring.model.Noticia;
import com.boraji.tutorial.spring.service.NoticiaService;

@Controller
public class MyContoller {

	@GetMapping("/")
	public String index(Model model, Principal principal) {
//		model.addAttribute("message", "You are logged in as " + principal.getName());
		return "index";
	}

	@GetMapping("/noticias")
	public String noticias(Model model, Principal principal) {
//		model.addAttribute("message", "Estas en noticias " + principal.getName());
		return "noticias";
	}

	@GetMapping("/contacto")
	public String contacto(Model model) {
		// model.addAttribute("message", "You are logged in as " + principal.getName());
		return "contacto";
	}

	@GetMapping("/privado")
	public String privado(Model model) {
		// model.addAttribute("message", "You are logged in as " + principal.getName());
		return "privado";
	}
	@GetMapping("/administracion")
	public String administracion(Model model) {
		// model.addAttribute("message", "You are logged in as " + principal.getName());
		return "administracion";
	}

	//a partir de aqui es mapeo de los metodos.
	NoticiaService noticiaService;
	 
	public NoticiaService getNoticiaService() {
		return noticiaService;
	}
 
	@Autowired
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}
 
	@RequestMapping(value = "/noticias", method = RequestMethod.GET)
	public String listNoticias(Model model) {
		model.addAttribute("noticia", new Noticia());
		model.addAttribute("noticiaList",
				this.noticiaService.listNoticias());
		return "noticias";
	}
 
	@RequestMapping(value = "/noticias", method = RequestMethod.GET)
	public String getlistNoticias(Model model) {
		model.addAttribute("noticia", new Noticia());
		model.addAttribute("noticiaList",
		this.noticiaService.listNoticias());
		return "noticias";
	}
 
	@RequestMapping(value = "/noticia/add", method = RequestMethod.POST)
	public String addNoticia(@ModelAttribute("noticia") Noticia n) {
		this.noticiaService.saveNoticia(n);
		return "redirect:/noticias";
	}
 
	@RequestMapping(value = "/employee/update", method = RequestMethod.POST)
	public String updateNoticia(@ModelAttribute("employee") Noticia n) {
		this.noticiaService.updateNoticia(n);
		return "redirect:/noticias";
	}
 
	@RequestMapping(value = "/removeNoticia/{id}")
	public String removeNoticia(@PathVariable("id") int id) {
		this.noticiaService.removeNoticia(id);
		return "redirect:/noticias";
	}
 
	@RequestMapping(value = "/editEmployee/{id}")
	public String editNoticia(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.noticiaService.getNoticiaById(id));
		return "edit";
	}
}
