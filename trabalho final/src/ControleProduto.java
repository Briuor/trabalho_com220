
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    private TelaAdicionarProduto telaAddProduto;
    ArrayList <Produto> produtos = new ArrayList <>();
    
    //Função que serve tanto para adicionar um produto que antes não existia no sistema, quanto para incrementar sua quantidade no estoque caso ele ja exista.
    public void adicionarProduto (int codigo, String descricao, double precoCompra, double valorVenda, int quantEstoque){
        //Primeiro Caso: se ele já existe:
        for (int i=0;i<produtos.size();i++){ //Busca do produto para verificar se ele já existe
            if (produtos.get(i).getCodigo()==codigo){ //Caso ele ja exista:
                int quantidadeEstoque = produtos.get(i).getQuantEstoque(); //Obtém-se a quantidade atual do estoque
                produtos.get(i).setQuantEstoque(quantidadeEstoque+quantEstoque); //Acrescenta a quantidade desejada
                return;
            }
        }
        //Segundo caso: adicionar um produto que antes não existia no sistema
        produtos.add(new Produto(codigo, descricao, precoCompra, valorVenda, quantEstoque));
    }
    
    public void consultarProduto (int codigo){
        String saida = "Produto não encontrado.\n";
        for (int i=0;i<produtos.size();i++){
            if (produtos.get(i).getCodigo() == codigo){
                saida = "Código pesquisado: "+produtos.get(i).getCodigo()+"\n"+"\tEstoque: "+produtos.get(i).getQuantEstoque()+"\n"+"\tDescrição: "+produtos.get(i).getDescricao()+"\n"+"\tPreço de Venda: "+produtos.get(i).getValorDeVenda()+"\n";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, saida);
    }
    
    
}
