
import java.util.*;
import java.text.*;
import java.io.Serializable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class Nota implements Serializable{
    private int codigo;
    private double valorTotalCompra;
    private Date dataEmissao;
    private ArrayList<Produto> listaProduto = new ArrayList<>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(double valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public Nota(int codigo, double valorTotalCompra, Date dataEmissao) {
        this.codigo = codigo;
        this.valorTotalCompra = valorTotalCompra;
        this.dataEmissao = dataEmissao;
    }

    public Nota(){
        
    }
}
