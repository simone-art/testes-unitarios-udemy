package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class LocalServiceTest {

    //Rule, artificio de Junit que permite alterar o comportamento do teste
    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Test
    public void teste()throws Exception{
        // Definir cenários
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Roberto");
        Filme filme = new Filme("Filme 1", 0, 5.0);

        // Definir a ação/Neste caso chamar o método a ser testado
        Locacao locacao;

        //Try and catch permite o tratamento de exceções
        try {
            locacao = locacaoService.alugarFilme(usuario, filme);

            //Usando o errorCollector pra identificar testes que falham ao executá-los

            error.checkThat(locacao.getValor(), is(equalTo(5.0)));
            error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
            error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));

        } catch (Exception ex){
            ex.printStackTrace();
            Assert.fail("Não deveria lançar exceção");
        }
        // Definir a verificação de acordo com o cenário esperado
       //Assertions.assertEquals(locacao.getValor(), 5);
//        Assertions.assertTrue(isMesmaData(locacao.getDataLocacao(), new Date()));
//        Assertions.assertTrue(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));


        // AsserThat = verifica que!
        // é uma verificação genérica
//        assertThat(locacao.getValor(), is(equalTo(5.0)));
//        assertThat(locacao.getValor(), is(not(6.0)));
//        assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
//        assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));


    }
}
