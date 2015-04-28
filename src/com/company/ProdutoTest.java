package com.company;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ProdutoTest extends TestCase {
    public Produto produto;
    final int QTD_SEM_DESCONTO = 2;
    final int QTD_INVALIDA = 0;

    public ProdutoTest(String codigo, String nome, double precoBase){
        this.produto = new Produto(codigo, nome, precoBase);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"AAA111", "Produto teste 1", 10.50},
                {"AAA110", "Produto produto teste 2", 0.0},
                {"AAA112", "Produto protudo teste 3", 10.50},
                {"AAA113", "Produto produto teste 4", 10},
        });
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testPrecoParaQuantidadeInvalida() throws Exception{
            thrown.expect(Exception.class);
            thrown.expectMessage("Quantidade < 0");
            this.produto.precoParaQtde(QTD_INVALIDA);
    }

}