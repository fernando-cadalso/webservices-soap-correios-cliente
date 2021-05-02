package br.com.caelum.correios.soap;

import java.math.BigDecimal;
import java.util.List;

public class TesteClienteCorreios {

	public static void main(String[] args) {

		/*
		 * Instância um objeto que faz a conexão com o serviço WSDL dos Correios.
		 */
		CalcPrecoPrazoWSSoap cliente = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();
		/*
		 * Define os parâmetros da operação calcPrecoPrazo.
		 */
		String codigoSedex = "40010";
		String cepOrigemCaelumSP = "04101300"; //Caelum SP
		String cepDestino = "20040030"; // Caelum RJ
		String peso3kg = "3";
		BigDecimal comprimento20cm = new BigDecimal(20);
		BigDecimal altura10cm = new BigDecimal(10);
		BigDecimal largura15cm = new BigDecimal(15);
		BigDecimal diametro10cm = new BigDecimal(10);
		int formatoEncomendaCaixa = 1; // 1 é caixa ou pacote
		BigDecimal semValorDeclarado= BigDecimal.ZERO;
		String semEntregueEmMaos = "N";
		String semAvisoRecebimento = "N";
		String semCodigoEmpresa = "";
		String semSenhaEmpresa = "";
		/*
		 * Faz a chamada à operação do serviço.
		 */
		CResultado resultado = cliente.calcPrecoPrazo(semSenhaEmpresa, semSenhaEmpresa, semEntregueEmMaos, cepOrigemCaelumSP, cepDestino, semCodigoEmpresa, formatoEncomendaCaixa, comprimento20cm, altura10cm, largura15cm, diametro10cm, semSenhaEmpresa, semValorDeclarado, semAvisoRecebimento);
		/*
		 * Recupera o resultado
		 */
		List<CServico> servicosPesquisados = resultado.getServicos().getCServico();
		String valorFrete = servicosPesquisados.get(0).getValor();
		/*
		 * Exibe no console.
		 */
		System.out.printf("Frete para %s é de %s %n", cepDestino, valorFrete);
	}

}
