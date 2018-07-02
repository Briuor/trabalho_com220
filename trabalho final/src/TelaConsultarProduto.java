
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
public class TelaConsultarProduto extends SpringUtilities implements ActionListener{
    private ControleProduto controleProduto;
    private JTextField textCodigo;
    private JButton botaoConsultar, botaoVoltar;
    private JLabel labelCodigo;
    
    public TelaConsultarProduto(ControleProduto controleProduto)
    {
        this.controleProduto = controleProduto;
        textCodigo = new JTextField("", 20);
        labelCodigo = new JLabel("Codigo do produto: ");
        
        botaoConsultar = new JButton("Consultar");
        botaoVoltar = new JButton("Voltar");
        
        botaoConsultar.addActionListener(this);
        botaoVoltar.addActionListener(this);
        
        JPanel pForm = new JPanel(new SpringLayout());
        
        pForm.add(labelCodigo);
        labelCodigo.setLabelFor(textCodigo);
        pForm.add(textCodigo);
        
        SpringUtilities.makeCompactGrid(pForm,
                                1, 2, //rows, cols
                                3, 3,        //initX, initY
                                3, 3); 
        
        JPanel pButton = new JPanel();
        
        pButton.add(botaoVoltar);
        pButton.add(botaoConsultar);
        
        JPanel p = new JPanel(new BorderLayout());
        
        p.add(pForm, BorderLayout.NORTH);
        p.add(pButton, BorderLayout.SOUTH);
        
        this.add(p);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == botaoConsultar)
        {
            int codigo = Integer.parseInt(textCodigo.getText());

            controleProduto.consultarProduto(codigo);
        }
        else if(e.getSource() == botaoVoltar)
            this.dispose();
    }
}
