package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AsserTest {

    @Test
    public void test(){
        // condições boleanas
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        // condições pra comparar objetos
        Assert.assertEquals(1, 1);
        // O valor delta permite estabelecer uma margem de eroo
        Assert.assertEquals(0.51, 0.51, 0.01);

        // Comparando int e Integer
        int i = 5;
        Integer i2 = 5;
        // Assert.assertEquals(i, i2); esta linha não compila e está com erro porque int e integer
        //Não são iguais
        // O correto seria o seguinte:
        Assert.assertEquals(Integer.valueOf(i), i2);
        Assertions.assertEquals(i, i2.intValue());

        // Comparando String usando asserEquals
        Assert.assertEquals("bola", "bola");
        //Assert.assertEquals("bola", "Bola");
        // Pra fazer funcionar o assertEquals usando o equalsIgnoreCase
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".startsWith("bo"));

        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 1");
        Usuario u3 = u2;
        //Assert.assertEquals(u1, u2); Não funciona porque o u1 e u2 estão
        // guardaods na memória em instancias diferentes. Pra funcionar deve-se
        // criar na classe Usuário o método Equals pra verificar que o
        //Objeto seja o mesmo
        Assert.assertEquals(u1, u2);
        Assert.assertSame(u3, u2);

        // Nulo
        Usuario u4 = null;
        Assert.assertTrue(u4 == null);
        Assert.assertNull(u4);

        //Objetos diferentes
        Assert.assertNotEquals("Bola", "casa");
        Assert.assertNotSame(u1, u2); //Apesar de terem o mesmo valor são de instâncias diferentes

        //certifica que o objeto não seja vazio
        Assert.assertNotNull(u2);
        
    }
}
