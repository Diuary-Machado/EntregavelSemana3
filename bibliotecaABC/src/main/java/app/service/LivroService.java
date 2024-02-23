package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Livro;

@Service
public class LivroService {

	List<Livro> lista = new ArrayList<>();

	public String save(Livro livro) {

		lista.add(livro);

		return livro.getTitulo() + "Livro salvo com sucesso";
	}

	public List<Livro> listAll(){

		List<Livro> lista = new ArrayList<>();

		Livro livro = new Livro(1,"ISBN11111","Simpson","Porco Aranha",22101993,200);
		Livro livro1 = new Livro(2,"ISBN22222","Bart","El Barto",30102005,250);
		Livro livro2 = new Livro(3,"ISBN33333","Marge","El Margo",11111911,300);
		Livro livro3 = new Livro(4,"ISBN44444","Lisa","El Lisondo",15051890,350);

		lista.add(livro);
		lista.add(livro1);
		lista.add(livro2);
		lista.add(livro3);

		return lista;
	}

	public Livro findById(long id) {

		List<Livro> lista = this.listAll();

		if(lista != null) {

			for(int i = 0; i < lista.size(); i++) {

				if(id == lista.get(i).getId()) {

					return lista.get(i);

				}

			}

		}
		return null;
	}

	public Livro update(long id, Livro novoLivro) {

		List<Livro> lista = this.listAll();

		for(int i = 0; i < lista.size(); i++) {

			Livro livro = lista.get(i);

			if(livro != null && livro.getId() == id) {

				livro.setIssn(novoLivro.getIssn());
				livro.setTitulo(novoLivro.getTitulo());
				livro.setSinopse(novoLivro.getSinopse());
				livro.setAno(novoLivro.getAno());
				livro.setNumPag(novoLivro.getNumPag());

				return livro;
			}

		}
		return null;
	}
	
	public String delete(long id) {
		
		List<Livro> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getId() == id) {
				
				lista.remove(lista.get(i));
				
				return "Foi de Base";
			}
			
		}
		return "Não foi de Base";
	}
}
