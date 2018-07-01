
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
        if (temProduto == false){
            JOptionPane.showMessageDialog(null, saida);
        }
        else {
            saida = "Código do produto pesquisado: "+codProduto+"\n"+"Faturamento do produto: R$ "+fatTotal+"\n";
            JOptionPane.showMessageDialog(null, saida);
        }
    }

    public String emitirNota() {

        return null;

    }
}
