package com.br.facezup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.facezup.models.PostagemModel;
import com.br.facezup.services.postagemService;
@Controller
public class postagemController {


	@Autowired
	postagemService postagemServices;


	@GetMapping
	public ModelAndView exibir() {
		ModelAndView modelAndView = new ModelAndView("postagem.html");
		modelAndView.addObject("postagens", postagemServices.retornarPostagem());
		return modelAndView;
	}
	@PostMapping
	public String salvarPostagem(PostagemModel postagemModel) {
		postagemServices.salvarPostagem(postagemModel);
		return "redirect:/";
	}
}
