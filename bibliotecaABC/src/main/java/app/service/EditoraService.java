package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Editora;

@Service
public class EditoraService {

	List<Editora> lista = new ArrayList<>();
	
	public String save(Editora editora) {
		
		lista.add(editora);
		
		return editora.getNome() + "Editora salva com sucesso";
	}
	
	public List<Editora> listAll(){
		
		List<Editora> lista = new ArrayList<>();
		
		Editora editora1 = new Editora(1,"Apple","Rua Mandaguari","(01)01010-0101");
		Editora editora2 = new Editora(2,"Xbox","Rua da Republica","(02)02020-0202");
		Editora editora3 = new Editora(3,"Nissam","Rua Dz7","(03)03030-0303");
		Editora editora4 = new Editora(4,"Gol","Rua Aparecida","(04)04040-0404");
		
		lista.add(editora1);
		lista.add(editora2);
		lista.add(editora3);
		lista.add(editora4);
		
		return lista;
	}
	
	public Editora findById(long id) {
		
		List<Editora> lista = this.listAll();
		
		if(lista != null) {
			
			for(int i = 0; i < lista.size(); i++) {
				
				if(id == lista.get(i).getIdEditora()) {
					
					return lista.get(i);
					
				}
				
			}
			
		}
		return null;
	}
	
	public Editora update(long id, Editora novaEditora) {
		
		List<Editora> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			Editora editora = lista.get(i);
			
			if(editora != null && editora.getIdEditora() == id) {
				
				editora.setNome(novaEditora.getNome());
				editora.setEndereco(novaEditora.getEndereco());
				editora.setTelefone(novaEditora.getTelefone());
				
				return editora;
			}
			
		}
		return null;
	}
	
	public String delete(long id) {
		
		List<Editora> lista = this.listAll();
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getIdEditora() == id) {
				
				lista.remove(lista.get(i));
				
				return "Deletado com absoluto sucesso";
			}
			
		}
		return "Não foi deletado com absoluto sucesso";
	}
}
