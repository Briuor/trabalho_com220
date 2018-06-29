
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class Nota {
    private int codigo;
    private double valorTotalCompra;
    private String DataEmissao;
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

    public String getDataEmissao() {
        return DataEmissao;
    }

    public void setDataEmissao(String DataEmissao) {
        this.DataEmissao = DataEmissao;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public Nota(int codigo, double valorTotalCompra, String DataEmissao) {
        this.codigo = codigo;
        this.valorTotalCompra = valorTotalCompra;
        this.DataEmissao = DataEmissao;
    }
}
