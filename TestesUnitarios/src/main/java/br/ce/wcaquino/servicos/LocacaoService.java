package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.lang.reflect.Modifier;
import java.util.Date;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	@Test
	public void teste() {
		// Definir cenários
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Roberto");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		// Definir a ação/Neste caso chamar o método a ser testado
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);

		// Definir a verificação de acordo com o cenário esperado
		Assertions.assertTrue(locacao.getValor() == 5);
		Assertions.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assertions.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));



	}
}