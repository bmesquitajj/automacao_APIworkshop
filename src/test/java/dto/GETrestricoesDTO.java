package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GETrestricoesDTO {
	private String CPF;
	
	public String novaPesquisaRestricao(String Type) {
		switch (Type) {
			case "CPF-com-restricao":
				this.CPF = "01317496094";
			break;
			
			case "CPF-invalido":
				this.CPF = "66414919024";
			break;
			
			case "alteracaoSucesso":
				this.CPF = "99988877744";
			break;
			
			case "pesquisaSimulacao":
				this.CPF = "77766655544";
			break;
	
		}
		
		return getCPF();
	}
}
