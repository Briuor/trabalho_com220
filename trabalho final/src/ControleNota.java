
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Vector;
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

// Notas->getListaProdutos().
//for(int i = 0; i <  notas.size(); i++)
//{
//    for(int j =0; j < notas.get(i).getListaProdutos().size(); j++)
//    {
//        Produto produto = notas.get(i).getListaProdutos().get(j);
//        produto.getPrecoDeCompra() * produto.getQuantEstoque();
//    }
//}
public class ControleNota {

    private ArrayList<Nota> notas;

    public ControleNota() {
        this.notas = new ArrayList<>();
        try {
            this.lerNotas(); // le arquivo e preenche array de notas
            //System.console().writer().println("arquivo notas.ser lido");
        } catch (Exception exc) {
            //System.console().writer().println("erro ao ler arquivo");
        }
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void adicionarNota(Nota novaNota) {
        notas.add(novaNota);
        try {
            this.gravarNotas();
            //System.console().writer().println("Nota adicionada em notas");
        } catch (Exception exc) {
            //System.console().writer().println("erro ao ler notas");			
        }
    }

    public void gravarNotas() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("notas.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(notas);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo notas não encontrado!");
        }
    }

    public void lerNotas() throws Exception {
        try {
            FileInputStream arquivo = new FileInputStream("notas.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            notas = (ArrayList<Nota>) in.readObject();
            in.close();
        } catch (Exception ex) {
            notas = new ArrayList<>();
        }
    }

    public void consultaFatProduto(int codProduto) {
        String saida = "Produto não encontrado.\n";
        boolean temProduto = false;
        double fatTotal = 0;
        for (int i = 0; i < notas.size(); i++) {
            for (int j = 0; j < notas.get(i).getListaProduto().size(); j++) {
                if (notas.get(i).getListaProduto().get(j).getCodigo() == codProduto) {
                    temProduto = true;
                    fatTotal = notas.get(i).getListaProduto().get(j).getValorDeVenda()*notas.get(i).getListaProduto().get(j).getQuantEstoque();
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

    public void consultaFatPeriodo(Date dataInicial, Date dataFinal) {
        String saida = "";
        double fatTotal = 0;
        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getDataEmissao().after(dataInicial) && notas.get(i).getDataEmissao().before(dataFinal)) {
                notas.get(i).setValorTotalCompra();
                fatTotal += notas.get(i).getValorTotalCompra();
            }
        }
        saida = "O Faturamento no período de " + dataInicial.toString() + " a " + dataFinal.toString() + " Foi de:\n";
        saida += "R$ " + fatTotal;
        JOptionPane.showMessageDialog(null, saida);
    }

    //LUCRO LÍQUIDO = FATURAMENTO TOTAL – CUSTO TOTAL
    public void consultaLucroLiquido(Date dataInicial, Date dataFinal) {
        String saida = "";
        double fatTotal = 0;
        double lucroLiquido = 0;
        ControleProduto custoTotal = new ControleProduto();
        
        //achando o faturamento total
        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getDataEmissao().after(dataInicial) && notas.get(i).getDataEmissao().before(dataFinal)) {
                fatTotal += notas.get(i).getValorTotalCompra();
            }
        }
        
        lucroLiquido = fatTotal - custoTotal.getQuantCustoTotal();
        
    }

   
    public void consultarMaisVendidos() {/*
        ArrayList<Integer> codProd = new ArrayList();
        ArrayList<Integer> quantidadeProd = new ArrayList();
        String listaMaisVendidos = "";
        int aux;
        
        System.out.println(codProd.size());
        
        for (int i = 0; i < notas.size(); i++) {
            for (int j = 0; j < notas.get(i).getListaProduto().size(); j++) {
                for(int k = 0; k <= codProd.size(); k++){
                   if(codProd.get(k) == notas.get(i).getListaProduto().get(j).getCodigo()){
                       quantidadeProd.set(k, quantidadeProd.get(k) + notas.get(i).getListaProduto().get(j).getQuantEstoque());
                   }
                   else{
                       codProd.add(notas.get(i).getListaProduto().get(j).getCodigo());
                       quantidadeProd.add(notas.get(i).getListaProduto().get(j).getQuantEstoque());
                   }
                }
            }
        }
         for(int j = 0; j < codProd.size(); j++){
            for(int k = 0; k < codProd.size()-1; k++){
                if(quantidadeProd.get(k) < quantidadeProd.get(k+1)){
                    aux = codProd.get(k);
                    codProd.set(k, codProd.get(k+1));
                    codProd.set(k+1, codProd.get(k));
                    
                    aux = quantidadeProd.get(k);
                    quantidadeProd.set(k, quantidadeProd.get(k+1));
                    quantidadeProd.set(k+1, quantidadeProd.get(k));
                }
           }
        }
         for(int i = 0; i < codProd.size(); i++){
             if(i<10) listaMaisVendidos += "Codigo do Produto: " + codProd.get(i) + "Vendeu: " + quantidadeProd.get(i) + "\n";
         }
<<<<<<< HEAD
         JOptionPane.showMessageDialog(null, listaMaisVendidos);*/
        
        

    }

    
}
