package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Autor;

@Service
public class AutorService {

List<Autor> lista = new ArrayList<>();
	
	public String save(Autor autor) {
		
		lista.add(autor);
		
		return autor.getNome() + "Autor salvo com sucesso";
	}
	
	public List<Autor> listAll(){
		
		List<Autor> lista = new ArrayList<>();
		
		Autor autor1 = new Autor(1,"Jack Sparrow","789.987.654-45",21);
		Autor autor2 = new Autor(2,"Barbossa","123.321.456-56",31);
		Autor autor3 = new Autor(3,"Barba Negra","456.654.789-98",51);
		Autor autor4 = new Autor(4,"Edward NewGate","000.000.000-00",61);
		
		lista.add(autor1);
		lista.add(autor2);
		lista.add(autor3);
		lista.add(autor4);
		
		return lista;
	}
	
	public Autor findById(long id) {
		
		List<Autor> lista = this.listAll();
		
		if(lista != null) {
			
			for(int i = 0; i < lista.size(); i++) {
				
				if(id == lista.get(i).getIdAutor()) {
					
					return lista.get(i);
					
				}
				
			}
			
		}
		return null;
	}
	
	public Autor update(long id, Autor novoAutor) {
		
		List<Autor> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			Autor autor = lista.get(i);
			
			if(autor != null && autor.getIdAutor() == id) {
				
				autor.setNome(novoAutor.getNome());
				autor.setCpf(novoAutor.getCpf());
				autor.setIdade(novoAutor.getIdade());
				
				return autor;
			}
		}
		return null;
	}
	
	public String delete(long id) {
		
		List<Autor> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getIdAutor() == id) {
				
				lista.remove(lista.get(i));
				
				return "Deletado com absoluto sucesso";
			}
			
		}
		 return "Não foi possível deletar";
	}
}
