
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
 * @author Gabriel
 */
public class ControleCliente {

    ArrayList<Cliente> clientes;

    public ControleCliente() {
        this.clientes = new ArrayList<>();
        try {
            this.lerClientes(); // le arquivo e preenche array de produtos
            System.console().writer().println("arquivo clientes.ser lido");
            String clientesStr = "";
            for (int i = 0;i < clientes.size() ;i++ ) {
                clientesStr += "Nome: " + clientes.get(i).getNome() + "\ncpf: "
                            + clientes.get(i).getCpf() + "\n";
                for(int j = 0;j < clientes.get(i).getNotas().size(); j++)
                    clientesStr += "Notas: " + clientes.get(i).getNotas().get(j).getCodigo()+"\n";
            }
            System.console().writer().println(clientesStr);
        }
        catch (Exception exc) {
            System.console().writer().println("erro ao ler arquivo de clientes");
        }
    }

    public void cadastraCliente(String nome, String endereco, String email, String cpf) {
        Cliente cliente = new Cliente(nome, endereco, email, cpf);
        try {
            clientes.add(cliente);
            this.gravarClientes();
            System.console().writer().println("Cliente " + nome + " do cpf " + cpf + " adicionado");
        } catch (Exception exc) {
            System.console().writer().println("Erro ao gravar clientes");
        }
    }

    //Recebe CPF do cliente e caso ele exista mostra informações dele, se nao gera mensagem de erro
    public void consultaCliente(String cpf) {
        String saida = "Cliente não encontrado.\n";
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf() == cpf) {
                saida = "CPF pesquisado: " + clientes.get(i).getCpf() + "\n" + "\tNome: " + clientes.get(i).getNome() + "\n" + "\tEndereço: " + clientes.get(i).getEndereco() + "\n" + "\tEmail: " + clientes.get(i).getEmail() + "\n";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, saida);
    }

    //Recebe cpf do cliente e valida cpf, retorna true se cliente existe, false se nao existe
    public boolean validaCPF(String cpf) {

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    /*  COMENTADO, POIS USAREMOS O DATE AO INVES DE STRING DATA
    public void consultaCompras(String cpf, String dataInicial, String dataFinal) {
        String saida = "CPF não encontrado.\n";
        int totalNotas;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf() == cpf) {
                saida = "CPF pesquisado: " + clientes.get(i).getCpf() + "\n";
                saida += "Total de Notas Emitidas: " + clientes.get(i).getNotas().size() + "\n";
                for (int j = 0; j < clientes.get(i).getNotas().size(); j++) {
                    saida += "Nota:\n" + "\tCódigo: " + clientes.get(i).getNotas().get(j).getCodigo() + "\tValor Total: " + clientes.get(i).getNotas().get(j).getValorTotalCompra() + "\n\n";
                }
                JOptionPane.showMessageDialog(null, saida);
                break;
            }
        }
    }*/


        //--------VERIFICAR QUANTIDADE DE PRODUTOS NA NOTA < 10
    public void emitirNota(String cpf, Nota notaEmitida) {
        String produtosNota = "";
        for (int i = 0; i < clientes.size(); i++) {
            //procura usuario pelo cpf e coloca nota emitida no array de notas dele
            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.get(i).getNotas().add(notaEmitida);
            }
        }
        //MOSTRA INFORMACOES DA NOTA
        for (int i = 0; i < notaEmitida.getListaProduto().size(); i++) {
            Produto produto = notaEmitida.getListaProduto().get(i);
            produtosNota += "Codigo: " + produto.getCodigo() + "\n";
        }
        String info = "Codigo nota: " + notaEmitida.getCodigo()
                    +"\nValor Total: " + notaEmitida.getValorTotalCompra() + "\nProdutos:\n";
        JOptionPane.showMessageDialog(null, info + produtosNota);
        //Grava cliente com nota
        try{        this.gravarClientes();  }
        catch(Exception exc){}
    }

    public void consultaFatCliente(String cpf) {
        String saida = "Cliente não encontrado.\n";
        double fatTotal = 0;
        boolean temCliente = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf() == cpf) {
                temCliente = true;
                for (int j = 0; j < clientes.get(i).getNotas().size(); j++) {
                    fatTotal += clientes.get(i).getNotas().get(j).getValorTotalCompra();
                }
            }
        }
        if (temCliente == false){
            JOptionPane.showMessageDialog(null, saida);
        }
        else {
            saida = "CPF pesquisado: "+cpf+"\n"+"Faturamento do cliente: "+fatTotal+"\n";
            JOptionPane.showMessageDialog(null, saida);
        }
    }

    public void gravarClientes() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("clientes.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(clientes);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo Clientes não encontrado!");
        }
    }

    public void lerClientes() throws Exception {
        try {
            FileInputStream arquivo = new FileInputStream("clientes.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            clientes = (ArrayList<Cliente>) in.readObject();
            in.close();
        } catch (Exception ex) {
            clientes = new ArrayList<>();
        }
    }
}
