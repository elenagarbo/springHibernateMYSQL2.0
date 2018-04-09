package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.Noticia;

public interface NoticiaDetailsDao {
	
	public void saveNoticia(Noticia n);
	public void updateNoticia(Noticia n);
	public List<Noticia> listNoticias();
	public Noticia getNoticiaById(int id);
	public void removeNoticia(int id);

}









