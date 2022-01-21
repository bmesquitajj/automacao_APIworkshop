package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class POSTsimulacoesDTO {

	private String nome;
	private String cpf;
	private String email;
	private float valor;
	private int parcelas;
	private boolean seguro;
	
	public POSTsimulacoesDTO criarNovaSimulacao(String type) {
		switch (type) {
			case "novoCadastroSucesso":
				 this.nome = "Testando Sites";
				 this.cpf = "99988877744";
				 this.email = "testando@teste.com";
				 this.valor = 12345;
				 this.parcelas = 2;
				 this.seguro = true;
			break;
			
			case "novoCadastroNomeVazio":
				 this.cpf = "15935785245";
				 this.email = "testando@teste.com";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "novoCadastroCPFexistente":
				 this.nome = "Maicon Dougras";
				 this.cpf = "99988877744";
				 this.email = "testando@teste.com";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "novoCadastroCPFForamatoDiferente":
				 this.nome = "Maicon Dougras";
				 this.cpf = "999.888.777-44";
				 this.email = "testando@teste.com";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "novoCadastroEmailInvalido":
				 this.nome = "Maicon Dougras";
				 this.cpf = "88877766655";
				 this.email = "testando";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "novoCadastroValorMenor":
				 this.nome = "Testando Sites";
				 this.cpf = "77766655544";
				 this.email = "testando@teste.com";
				 this.valor = 500;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "novoCadastroParcelaMaior":
				 this.nome = "Testando Sites";
				 this.cpf = "77766655544";
				 this.email = "testando@teste.com";
				 this.valor = 5000;
				 this.parcelas = 80;
				 this.seguro = true;
			break;
			
			case "novoCadastroSeguroNulo":
				 this.nome = "Testando Sites";
				 this.cpf = "77766655544";
				 this.email = "testando@teste.com";
				 this.valor = 5000;
				 this.parcelas = 80;
			break;

		
		}
		
		 return POSTsimulacoesDTO.builder().
				 nome(this.getNome()).
				 cpf(this.getCpf()).
				 email(this.getEmail()).
				 valor(this.getValor()).
				 parcelas(this.getParcelas()).
				 seguro(this.isSeguro()).build();
	}
}
