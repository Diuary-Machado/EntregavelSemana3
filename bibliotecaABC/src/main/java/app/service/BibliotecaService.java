package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Biblioteca;

@Service
public class BibliotecaService {

	List<Biblioteca> lista = new ArrayList<>();

	public String save(Biblioteca biblioteca) {

		lista.add(biblioteca);

		return biblioteca.getNome() + "Biblioteca salva com sucesso";
	}

	public List<Biblioteca> listAll(){

		List<Biblioteca> lista = new ArrayList<>();

		Biblioteca biblioteca = new Biblioteca(1,"Acer","(22)22222-2222");
		Biblioteca biblioteca1 = new Biblioteca(2,"Xiaomi","(34)34343-3434");
		Biblioteca biblioteca2 = new Biblioteca(3,"Apple","(25)25252-2525");
		Biblioteca biblioteca3 = new Biblioteca(4,"Poco","(08)08080-0808");
		Biblioteca biblioteca4 = new Biblioteca(5,"Fiat","(10)10101-1010");

		lista.add(biblioteca);
		lista.add(biblioteca1);
		lista.add(biblioteca2);
		lista.add(biblioteca3);
		lista.add(biblioteca4);

		return lista;
	}

	public Biblioteca findById(long id) {

		List<Biblioteca> lista = this.listAll();

		if(lista != null) {

			for(int i = 0; i < lista.size(); i++) {

				if(id == lista.get(i).getId()) {

					return lista.get(i);

				}

			}

		}
		return null;
	}

	public Biblioteca update(long id, Biblioteca novaBiblioteca) {

		List<Biblioteca> lista = this.listAll();

		for(int i = 0; i < lista.size(); i++) {

			Biblioteca biblioteca = lista.get(i);

			if(biblioteca != null && biblioteca.getId() == id) {

				biblioteca.setNome(novaBiblioteca.getNome());
				biblioteca.setTelefone(novaBiblioteca.getTelefone());

				return biblioteca;
			}
		}
		return null;
	}

	public String delete(long id) {

		List<Biblioteca> lista = this.listAll();

		for(int i = 0; i < lista.size(); i++) {

			if(lista.get(i).getId() == id) {

				lista.remove(lista.get(i));

				return "Biblioteca deletada com sucesso";
			}

		}
		return "Impossível excluir";
	}
}
