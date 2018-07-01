
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gabriel
 */
public class ControleNota {

    ArrayList<Nota> notas = new ArrayList<>();

    public void consultaFatProduto(int codProduto) {
        String saida = "Produto não encontrado.\n";
        boolean temProduto = false;
        double fatTotal = 0;
        for (int i = 0; i < notas.size(); i++) {
            for (int j = 0; j < notas.get(i).getListaProduto().size(); j++) {
                if (notas.get(i).getListaProduto().get(j).getCodigo() == codProduto) {
                    temProduto = true;
                    fatTotal += notas.get(i).getListaProduto().get(j).getValorDeVenda();
                }

            }
        }
        if (temProduto == false) {
            JOptionPane.showMessageDialog(null, saida);
        } else {
            saida = "Código do produto pesquisado: " + codProduto + "\n" + "Faturamento do produto: R$ " + fatTotal + "\n";
            JOptionPane.showMessageDialog(null, saida);
        }
    }

    /*
    Coisa a se pensar: de que forma iremos consultar os 10 produtos mais vendidos?
        Pela alteração quantidade no estoque talvez? Aparentemente viavel, mas tem muitos contras;
        Fazendo FORs que percorrem todas as notas e todos os produtos somando os totais de cada um? Complicado e com problemas pra identificar
            no final quais totais são de quais produtos
        Alguma outra sugestão? Escrevam aqui que eu procuro fazer...
    */
    public void topDezMaisVendidos() {
        for (int i = 0; i < notas.size(); i++) {
            for (int j = 0; j < notas.get(i).getListaProduto().size(); j++) {

            }
        }
    }

    //Emitir nota é o responsável pelas compras dos clientes
    /*
    Coisas para lembrar:
        Ao emitir uma nota deve-se alterar a quantEstoque do produto de acordo com a compra;
        Uma nota pode ter no máximo 10 tipos de produtos diferentes;
    */
    public String emitirNota() {

        return null;

    }
}
