
import java.awt.BorderLayout;
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
public class TelaAdicionarProduto extends SpringUtilities implements ActionListener{
    private ControleProduto controleProduto;
    private JTextField      textCodigo, textDescricao, textPrecoCompra, textValorVenda, textQuantidade;
    private JButton         botaoAdicionar, botaoVoltar;
    private JLabel          labelCodigo, labelDescricao, labelPrecoCompra, labelValorVenda, labelQuantidade;

    public TelaAdicionarProduto(ControleProduto controleProduto)
    {
        this.controleProduto = controleProduto;
        
        labelCodigo = new JLabel("Codigo: ");
        labelDescricao = new JLabel("Descricao: ");
        labelPrecoCompra = new JLabel("preço De Compra: ");
        labelValorVenda = new JLabel("Valor de Venda: ");
        labelQuantidade = new JLabel("Quantidade: ");
        
        textCodigo = new JTextField("", 20);
        textDescricao = new JTextField("", 20);
        textPrecoCompra = new JTextField("", 20);
        textValorVenda = new JTextField("", 20);
        textQuantidade = new JTextField("", 20);
        
        botaoAdicionar = new JButton("Adicionar");
        botaoVoltar = new JButton("Voltar");
        botaoAdicionar.addActionListener(this);
        botaoVoltar.addActionListener(this);
        
        JPanel pForm = new JPanel(new SpringLayout());
        
        pForm.add(labelCodigo);
        labelCodigo.setLabelFor(textCodigo);
        pForm.add(textCodigo);
        
        pForm.add(labelDescricao);
        labelDescricao.setLabelFor(textDescricao);
        pForm.add(textDescricao);
        
        pForm.add(labelPrecoCompra);
        labelPrecoCompra.setLabelFor(textPrecoCompra);
        pForm.add(textPrecoCompra);
        
        pForm.add(labelValorVenda);
        labelValorVenda.setLabelFor(textValorVenda);
        pForm.add(textValorVenda);
        
        pForm.add(labelQuantidade);
        labelQuantidade.setLabelFor(textQuantidade);
        pForm.add(textQuantidade);
        
        JPanel pButton = new JPanel();
        
        pButton.add(botaoAdicionar);
        pButton.add(botaoVoltar);
        
        SpringUtilities.makeCompactGrid(pForm,
                                5, 2, //rows, cols
                                3, 3,        //initX, initY
                                3, 3); 
        
        JPanel p = new JPanel(new BorderLayout());
        
        p.add(pForm, BorderLayout.NORTH);
        p.add(pButton, BorderLayout.SOUTH);
        
        this.add(p);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoAdicionar)
        {

            int codigo = Integer.parseInt(textCodigo.getText());
            String descricao = textDescricao.getText();
            double precoCompra = Double.parseDouble(textPrecoCompra.getText());
            double valorVenda = Double.parseDouble(textValorVenda.getText());
            int quantidade = Integer.parseInt(textQuantidade.getText());
            controleProduto.adicionarProduto(codigo, descricao, precoCompra, valorVenda, quantidade);
        }
        else if(e.getSource() == botaoVoltar)
            this.dispose();

    }
}
