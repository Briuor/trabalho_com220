
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class ControleProduto {
    private ArrayList <Produto> produtos;
    public int auxCustoTotal;

    public ControleProduto(){
        this.produtos = new ArrayList<>();
        try{
            this.lerProdutos(); // le arquivo e preenche array de produtos
            //System.console().writer().println("arquivo produtos.ser lido");
        }
        catch(Exception exc){
            //System.console().writer().println("erro ao ler arquivo");
        }
    }
    
    //Função que serve tanto para adicionar um produto que antes não existia no sistema, quanto para incrementar sua quantidade no estoque caso ele ja exista.
    public void adicionarProduto (int codigo, String descricao, double precoCompra, double valorVenda, int quantEstoque){
        try{
            //Primeiro Caso: se ele já existe
            for (int i=0;i<produtos.size();i++){ 
                //Busca do produto para verificar se ele já existe
                //Caso ele ja exista:
                if (produtos.get(i).getCodigo()==codigo){ 
                    int quantidadeEstoque = produtos.get(i).getQuantEstoque(); //Obtém-se a quantidade atual do estoque
                    produtos.get(i).setQuantEstoque(quantidadeEstoque+quantEstoque); //Acrescenta a quantidade desejada
                    //---GRAVA ARQUIVO---
                    this.gravarProdutos();
                    //System.console().writer().println("produto " + codigo + "ja existente gravado");            
                    return;
                }
                //Se nao existe
            }
            //Segundo caso: adicionar um produto que antes não existia no sistema
            //System.console().writer().println("Produto "+ codigo +" Adicionado");
            produtos.add(new Produto(codigo, descricao, precoCompra, valorVenda, quantEstoque));
            //---GRAVA ARQUIVO---
            this.gravarProdutos();
            //System.console().writer().println("produto " + codigo + " gravado");            
        } catch (Exception exc){
            //System.console().writer().println("Nao foi possivel adicionar produto");            
        }

    }
    
    public void consultarProduto (int codigo){
        String saida = "Produto não encontrado.\n";

        for (int i=0;i<produtos.size();i++){
            //System.console().writer().println(codigo + " e " +produtos.get(0).getCodigo());
            if (produtos.get(i).getCodigo() == codigo){
                saida = "Código pesquisado: "+produtos.get(i).getCodigo()+"\n"+"\tEstoque: "+produtos.get(i).getQuantEstoque()+"\n"+"\tDescrição: "+produtos.get(i).getDescricao()+"\n"+"\tPreço de Venda: R$"+produtos.get(i).getValorDeVenda()+"\n";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, saida);
    }

    //Verifica se produto existe, se existe retorna true
    public boolean produtoExiste(int codigo)
    {
        for (int i=0;i<produtos.size();i++)
        {
            if (produtos.get(i).getCodigo() == codigo)
                return true;
        }
        return false;
    }

    //Retorna produto com o codigo passado pelo parametro
    public Produto getProduto(int codigo)
    {
        for (int i=0;i<produtos.size();i++)
        {
            if (produtos.get(i).getCodigo() == codigo){
                return produtos.get(i); 
            }
        }
        return null;
    }

    //Atualiza Estoque de produtos
    public void atualizaEstoque(Nota nota){
        Produto produtoNota;
        int quantiEstoque;  // guarda quantidade de produto no estoque
        //Para cada produto da nota atualiza o estoque
        for(int i = 0;i < nota.getListaProduto().size(); i++)
        {
            produtoNota = nota.getListaProduto().get(i);
            //Varre produtos existentes e compara com o da nota
            for(int j = 0; j < produtos.size(); j++)
            {
                //Se sao iguais, retira quantidade do produto da nota do produto no estoque
                if (produtoNota.getCodigo() == produtos.get(j).getCodigo()) 
                {
                    quantiEstoque = produtos.get(j).getQuantEstoque();//pega quantidade no estoque
                    //retira do estoque
                    //System.console().writer().println(quantiEstoque +"-"+ produtoNota.getQuantEstoque());
                    produtos.get(j).setQuantEstoque(quantiEstoque - produtoNota.getQuantEstoque());
                    //Grava atualização
                    try{
                        this.gravarProdutos();
                    } catch (Exception exc){}
                }
            }
        }
    }
    
    public void gravarProdutos() throws Exception 
    {
        try {
            FileOutputStream arquivo = new FileOutputStream("produtos.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(produtos);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo Produtos não encontrado!");
        }
    }

    public void lerProdutos() throws Exception
    {
        try {
            FileInputStream arquivo = new FileInputStream("produtos.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            produtos = (ArrayList<Produto>) in.readObject();
            in.close();
        } catch (Exception ex) {
            produtos = new ArrayList<>();
        }
    }
    
}
