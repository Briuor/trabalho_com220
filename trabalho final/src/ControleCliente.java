
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
public class ControleCliente {
    ArrayList <Cliente> clientes = new ArrayList <>();
    
    public void cadastraCliente (String nome, String endereco, String email, String cpf){
        Cliente cliente = new Cliente (nome, endereco, email, cpf);
        clientes.add(cliente);
    }
    
    public void consultaCliente (String cpf){
        String saida = "Cliente não encontrado.\n";
        for (int i=0;i<clientes.size();i++){
            if (clientes.get(i).getCpf() == cpf){
                saida = "CPF pesquisado: "+clientes.get(i).getCpf()+"\n" +"\tNome: "+clientes.get(i).getNome()+"\n"+"\tEndereço: "+clientes.get(i).getEndereco()+"\n"+"\tEmail: "+clientes.get(i).getEmail()+"\n";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, saida);
    }
    
<<<<<<< HEAD
    public static void main(String[] args) {
        TelaCadastroCliente init = new TelaCadastroCliente();
=======
    public void consultaCompras (String cpf, String dataInicial, String dataFinal){
        String saida = "CPF não encontrado.\n";
        int totalNotas;
        for (int i=0;i<clientes.size();i++){
            if (clientes.get(i).getCpf() == cpf){
                saida = "CPF pesquisado: "+clientes.get(i).getCpf()+"\n";
                saida += "Total de Notas Emitidas: "+clientes.get(i).getNotas().size()+"\n";
                for (int j=0;j<clientes.get(i).getNotas().size();j++){
                    saida += "Nota:\n"+"\tCódigo: "+clientes.get(i).getNotas().get(j).getCodigo()+"\tValor Total: "+clientes.get(i).getNotas().get(j).getValorTotalCompra()+"\n\n";
                }
                JOptionPane.showMessageDialog(null, saida);
                break;
            }
        }
>>>>>>> db340f6327b7c086474ad57c56edcfa7d1b3a84c
    }
}
