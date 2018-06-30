
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
public class TelaAdicionarProduto extends JFrame implements ActionListener{
    private ControleProduto controleProduto;
    private JTextField textCodigo, textDescricao, textPrecoCompra, textValorVenda, textQuantidade;
    private JButton botaoAdicionar, botaoVoltar;
    

    public TelaAdicionarProduto(ControleProduto controleProduto)
    {
        this.controleProduto = controleProduto;
        textCodigo = new JTextField("", 20);
        textDescricao = new JTextField("", 20);
        textPrecoCompra = new JTextField("", 20);
        textValorVenda = new JTextField("", 20);
        textQuantidade = new JTextField("", 20);
        
        botaoAdicionar = new JButton("Adicionar");
        botaoVoltar = new JButton("Voltar");
        botaoAdicionar.addActionListener(this);
        botaoVoltar.addActionListener(this);
        
        JPanel p = new JPanel();
        p.add(new JLabel("Codigo: "));
        p.add(textCodigo);
        p.add(new JLabel("Descricao: "));
        p.add(textDescricao);
        p.add(new JLabel("preço De Compra: "));
        p.add(textPrecoCompra);
        p.add(new JLabel("Valor de Venda: "));
        p.add(textValorVenda);
        p.add(new JLabel("Quantidade: "));
        p.add(textQuantidade);
        p.add(botaoAdicionar);
        p.add(botaoVoltar);
        
        this.add(p);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoAdicionar)
        {

            int codigo = Integer.parseInt(textCodigo.getText());
            String descricao = textCodigo.getText();
            double precoCompra = Double.parseDouble(textPrecoCompra.getText());
            double valorVenda = Double.parseDouble(textValorVenda.getText());
            int quantidade = Integer.parseInt(textQuantidade.getText());
            controleProduto.adicionarProduto(codigo, descricao, precoCompra, valorVenda, quantidade);
        }
        else if(e.getSource() == botaoVoltar)
            this.dispose();

    }
}
