package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PUTsimulacoesDTO {
	private String nome;
	private String cpf;
	private String email;
	private float valor;
	private int parcelas;
	private boolean seguro;
	
	public POSTsimulacoesDTO alterarSimulacao(String type) {
		switch (type) {
			case "alteracaoSucesso":
				 this.nome = "Testando Sites Alterado";
				 this.cpf = "99988877744";
				 this.email = "testando@teste.com";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "alteracaoNomeVazio":
				 this.nome = "";
				 this.cpf = "99988877744";
				 this.email = "testando@teste.com";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "alteracaoCPFexistente":
				 this.nome = "Maicon Dougras";
				 this.cpf = "77766655544";
				 this.email = "testando@teste.com";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "alteracaoCPFForamatoDiferente":
				 this.nome = "Maicon Dougras";
				 this.cpf = "777-666-555.44";
				 this.email = "testando@teste.com";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
			break;
			
			case "alteracaoEmailInvalido":
				 this.nome = "Maicon Dougras Alterado";
				 this.cpf = "99988877744";
				 this.email = "testando";
				 this.valor = 12345;
				 this.parcelas = 20;
				 this.seguro = true;
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
