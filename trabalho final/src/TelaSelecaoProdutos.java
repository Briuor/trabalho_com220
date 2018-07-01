import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class TelaSelecaoProdutos extends JFrame implements ActionListener{
    private ControleCliente controleCliente;
    private ControleProduto controleProduto;

    private Nota notaFiscal; // nota fiscal a ser formada no final da compra
    private String cpfCliente; // Cpf do cliente que emite nota
    private static int idNotas = 0; 

    private JTextField textCodigo, textQuantidade, textDataEmissao;
    private JButton botaoEmitir, botaoAdicionar;

    public TelaSelecaoProdutos(ControleCliente controleCliente, ControleProduto controleProduto, String cpfCliente)
    {
        this.notaFiscal = new Nota();
        System.console().writer().println("nota instanciada");
        this.cpfCliente = cpfCliente;

        this.controleCliente = controleCliente;
        this.controleProduto = controleProduto;
        textCodigo = new JTextField("", 20);
        textQuantidade = new JTextField("", 20);
        textDataEmissao = new JTextField("", 20);
        
        botaoEmitir = new JButton("Emitir Nota");
        botaoAdicionar = new JButton("Adicionar produto");
        botaoEmitir.addActionListener(this);
        botaoAdicionar.addActionListener(this);
        
        JPanel p = new JPanel();
        p.add(new JLabel("Código do produto: "));
        p.add(textCodigo);
        p.add(new JLabel("Quantidade: "));
        p.add(textQuantidade);
        p.add(botaoAdicionar);
        p.add(new JLabel("Data de emissao: "));
        p.add(textDataEmissao);
        p.add(botaoEmitir);
        
        this.add(p);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Se clicou em Adicionar produto
        int codigo = Integer.parseInt(textCodigo.getText());
        int quantidade = Integer.parseInt(textQuantidade.getText());

        if(e.getSource() == botaoAdicionar)
        {
            //Verifica se produto existe, se existe seleciona para cliente
            if(controleProduto.produtoExiste(codigo) == true)
            {
                Produto produto = controleProduto.getProduto(codigo); // obtem produto da lista de produtos
                notaFiscal.getListaProduto().add(produto); // adiciona produto na nota fiscal
                System.console().writer().println(produto.getCodigo() + " selecionado");                
            }
            //Se nao existe mostra mensagem de erro
            else
                JOptionPane.showMessageDialog(null, "Produto nao existe");
        }
        
        //Se clicou em emitir nota, mostra jOptionPane com informacoes da nota
        else if (e.getSource() == botaoEmitir) 
        {
            try{
                String data = textDataEmissao.getText();
                DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
                Date dataEmissao = (Date)formatter.parse(data);
                System.console().writer().println("Data Emissao: " + dataEmissao);

                notaFiscal.setCodigo(idNotas++);          // GERA ID DA NOTA FISCAL
                notaFiscal.setValorTotalCompra(3);   
                notaFiscal.setDataEmissao(dataEmissao);
                //passa cpf do cliente que emitiu nota e a nota emitida com todos os produtos
                controleCliente.emitirNota(cpfCliente, notaFiscal); 
                //Coloca notas no array de vendas do ControleNota
                //controleNota.adicionarNota(notaFiscal);

            } catch(Exception exc){ System.console().writer().println("Erro emitir nota"); }
        }
     }
    
}
