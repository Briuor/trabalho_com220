
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class TelaFaturamentoProduto extends SpringUtilities implements ActionListener{
      private ControleNota controleNota;

    JFrame frameCadastroCliente = new JFrame("Consultar Produto por Periodo");
    JPanel panelFormConsultaCliente = new JPanel(new SpringLayout());
    JPanel panelButtonCadastrar = new JPanel();
    JPanel mainPanel = new JPanel(new BorderLayout());
    
    JLabel codigo = new JLabel("Codigo do Produto: ", JLabel.TRAILING);
    JTextField codigoText = new JTextField(25);
    
    JButton createClient = new JButton("CONSULTAR");

    public TelaFaturamentoProduto(ControleNota controleNota) {
        this.controleNota = controleNota;
        createClientWindow();
    }
    
    public void createClientWindow(){
        createClient.addActionListener(this);
        
        panelFormConsultaCliente.add(codigo);
        codigo.setLabelFor(codigoText);
        panelFormConsultaCliente.add(codigoText);

        panelButtonCadastrar.add(createClient);
        
        SpringUtilities.makeCompactGrid(panelFormConsultaCliente,
                                1, 2, //rows, cols
                                3, 3,        //initX, initY
                                3, 3);       //xPad, yPad
        
        mainPanel.add(panelFormConsultaCliente, BorderLayout.NORTH);
        mainPanel.add(panelButtonCadastrar, BorderLayout.SOUTH);
        
        frameCadastroCliente.add(mainPanel);
        frameCadastroCliente.pack();
        frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroCliente.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int codigo = Integer.parseInt(codigoText.getText());
        controleNota.consultaFatProduto(codigo);
    }
}
