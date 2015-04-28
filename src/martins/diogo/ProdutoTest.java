package martins.diogo;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class ProdutoTest extends TestCase {
    public Produto produto;
    final int[] QTDS_SEM_DESCONTO = {1, 2, 3};
    final int[] QTDS_COM_DESCONTO = {4, 6, 8};
    final int[] QTDS_COM_DESCONTO_DOBRADO = {20, 40, 99999};
    final int[] QTDS_INVALIDAS = {0, -10, -5435345};

    public ProdutoTest(String codigo, String nome, double precoBase){
        this.produto = new Produto(codigo, nome, precoBase);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"AAA111", "Produto teste 1", 10.50},
                {"AAA110", "Produto produto teste 2", 234230.0},
                {"AAA112", "Produto protudo teste 3", 10.50},
                {"AAA113", "Produto produto teste 4", 10},
        });
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPrecoParaQtdeSemDesconto() throws Exception {
        try {
            for (int quantidade : QTDS_SEM_DESCONTO) {
                double preco = this.produto.precoParaQtde(quantidade);
                assertEquals(preco, this.produto.getPrecoBase() * quantidade);
            }
        }
        catch(Exception e){
            fail();
        }
    }

    @Test
    public void testPrecoParaQtdeComDesconto(){
        try {
            for (int quantidade: QTDS_COM_DESCONTO){
                double semDesconto = this.produto.getPrecoBase() * quantidade;
                assertTrue(this.produto.precoParaQtde(quantidade) < semDesconto);
            }
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testPrecoParaQtdeComDescontoDobrado(){
        try {
            for (int quantidade: QTDS_COM_DESCONTO_DOBRADO){
                double semDesconto = this.produto.getPrecoBase() * quantidade;
                assertTrue(this.produto.precoParaQtde(quantidade) < semDesconto);
            }
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testPrecoParaQuantidadeInvalida() throws Exception{
        for (int quantidade: QTDS_INVALIDAS) {
            thrown.expect(Exception.class);
            thrown.expectMessage("Quantidade < 0");
            this.produto.precoParaQtde(quantidade);
        }
    }

}