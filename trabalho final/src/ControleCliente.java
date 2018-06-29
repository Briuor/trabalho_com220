
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
        String retorno = "Cliente não encontrado.";
        for (int i=0;i<clientes.size();i++){
            if (clientes.get(i).getCpf() == cpf){
                retorno = "CPF pesquisado: "+clientes.get(i).getCpf()+"\n" +"Nome: "+clientes.get(i).getNome()+"\n"+"Endereço: "+clientes.get(i).getEndereco()+"\n"+"Email: "+clientes.get(i).getEmail()+"\n";
                JOptionPane.showMessageDialog(null, retorno);
                break;
            }
        }
        JOptionPane.showMessageDialog(null, retorno);
    }
    
    public void consultaCompras
}
