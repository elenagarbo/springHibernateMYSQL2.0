package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.model.Noticia;

import java.util.List;

public interface NoticiaService {
	
	public void saveNoticia(Noticia n);
	public void updateNoticia(Noticia n);
	public List<Noticia> listNoticias();
	public Noticia getNoticiaById(int id);
	public void removeNoticia(int id);

}
