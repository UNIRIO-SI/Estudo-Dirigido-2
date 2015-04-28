package com.company;

/**
 * Created by diogomartins on 4/28/15.
 */
public class Produto {
    public String codigo;
    public String nome;
    public double precoBase;

    public Produto(String codigo, String nome, double precoBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public double precoParaQtde(int quantidade) throws Exception{
        double precoSemDesconto = quantidade * this.precoBase;

        if (quantidade <= 3){
            return precoSemDesconto;
        }
        else if(quantidade <= 8){
            return this.desconto(10, precoSemDesconto);
        }
        else if(quantidade > 8){
            return this.desconto(20, precoSemDesconto);
        }
        throw new Exception("Quantidade < 0");
    }

    private double desconto(int porcentagem, double preco){
        return preco - ((porcentagem/100) * preco);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
