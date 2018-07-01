/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class Produto implements Serializable{
    private int codigo;
    private String descricao;
    private double precoDeCompra;
    private double valorDeVenda;
    private int quantEstoque;

    public Produto(int codigo, String descricao, double precoDeCompra, double valorDeVenda, int quantEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoDeCompra = precoDeCompra;
        this.valorDeVenda = valorDeVenda;
        this.quantEstoque = quantEstoque;
    }

    public Produto(Produto produto){
        this.codigo = produto.getCodigo();
        this.descricao = produto.getDescricao();
        this.precoDeCompra = produto.getPrecoDeCompra();
        this.valorDeVenda = produto.getValorDeVenda();
        this.quantEstoque = produto.getQuantEstoque();
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(double precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public double getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }
    
    
    
    
}
