package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Autor {
     
	private long idAutor;
	private String nome;
	private String cpf;
	private Integer idade;
}
