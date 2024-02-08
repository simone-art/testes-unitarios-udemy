package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocalServiceTest {

    @Test
    public void teste() {
        // Definir cenários
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Roberto");
        Filme filme = new Filme("Filme 1", 2, 5.0);

        // Definir a ação/Neste caso chamar o método a ser testado
        Locacao locacao = locacaoService.alugarFilme(usuario, filme);

        // Definir a verificação de acordo com o cenário esperado
       //Assertions.assertEquals(locacao.getValor(), 5);
        Assertions.assertTrue(isMesmaData(locacao.getDataLocacao(), new Date()));
        Assertions.assertTrue(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));


        // AsserThat = verifica que!
        // é uma verificação genérica
        assertThat(locacao.getValor(), is(equalTo(5.0)));
        assertThat(locacao.getValor(), is(not(6.0)));
        assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
    }
}
