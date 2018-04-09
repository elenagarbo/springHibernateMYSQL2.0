package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.spring.dao.NoticiaDetailsDao;
import com.boraji.tutorial.spring.model.Noticia;

@Service("noticiaService")
public class NoticiaServiceImp implements NoticiaService {
	
	@Autowired
	private NoticiaDetailsDao noticiaDetailsDao;
	

	@Override
	public void saveNoticia(Noticia n) {
		this.noticiaDetailsDao.saveNoticia(n);
	}

	@Override
	public void updateNoticia(Noticia n) {
		this.noticiaDetailsDao.updateNoticia(n);
	}

	@Override
	public List<Noticia> listNoticias() {
		return this.noticiaDetailsDao.listNoticias();
	}

	@Override
	public Noticia getNoticiaById(int id) {
		return this.noticiaDetailsDao.getNoticiaById(id);
	}

	@Override
	public void removeNoticia(int id) {
		this.noticiaDetailsDao.removeNoticia(id);
	}

}
