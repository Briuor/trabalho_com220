import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class MenuPrincipal extends JFrame implements ActionListener{
    private JTabbedPane tabbedPane;
    private JButton botaoAdicionar, botaoEmitirNota, botaoConsultProd, botaoConsultClient,
                    botaoFaturProd, botaoFaturClient, botaoFaturPeriod, // Botoes de cohnsultar faturamento
                    botaoConsultarLucro, botaoVendas, botaoMaisVendidos;

    private ControleProduto controleProduto;
    private ControleCliente controleCliente;
    private ControleNota controleNota;

    public void inicializaControles()
    {
        this.controleProduto = new ControleProduto();
        this.controleCliente = new ControleCliente();
        this.controleNota = new ControleNota();
    }

    public MenuPrincipal()
    {
        super("Trabalho Final");
        this.inicializaControles();
        tabbedPane = new JTabbedPane();
        
        botaoConsultClient = new JButton("Consultar Cliente");
        botaoFaturProd = new JButton("Consultar Faturamento Produto");
        botaoFaturClient = new JButton("Consultar Cliente");
        botaoFaturPeriod = new JButton("Consultar Cliente");
        JPanel pConsultas = new JPanel();
        pConsultas.add(botaoConsultClient);
        pConsultas.add(botaoFaturProd);
        pConsultas.add(botaoFaturClient);
        pConsultas.add(botaoFaturPeriod);

        botaoAdicionar = new JButton("Adicionar produto");
        botaoConsultProd = new JButton("Consultar produto");
        botaoEmitirNota = new JButton("Emitir Nota");
        JPanel pOperacoes = new JPanel();
        pOperacoes.add(botaoAdicionar);
        pOperacoes.add(botaoConsultProd);
        pOperacoes.add(botaoEmitirNota);

        tabbedPane.add("Inicio", pOperacoes); //add painel de operacoes
        tabbedPane.add("Financeiro", pConsultas);        //add painel de consultas
        
        botaoAdicionar.addActionListener(this);
        botaoConsultProd.addActionListener(this);
        botaoEmitirNota.addActionListener(this);
        
        this.add(tabbedPane);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            //Se clicar em adicionar Produtos
            if(e.getSource() == botaoAdicionar)
             new TelaAdicionarProduto(controleProduto);
            
            //Se clicar em Consutlar Produto
            else if(e.getSource() == botaoConsultProd)
             new TelaConsultarProduto(controleProduto);

            //Se clicar em Emitir Nota
            else if(e.getSource() == botaoEmitirNota)
             new TelaInsercaoCPF(controleCliente);
        }
        catch(Exception exc){

        }

    }
    
    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
