package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

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
        Assertions.assertTrue(locacao.getValor() == 5);
        Assertions.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assertions.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));



    }
}
