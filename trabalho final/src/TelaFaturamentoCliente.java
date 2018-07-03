
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
public class TelaFaturamentoCliente extends SpringUtilities implements ActionListener{
         private ControleCliente controleCliente;

    JFrame frameCadastroCliente = new JFrame("Consultar Faturamento por Cliente");
    JPanel panelFormConsultaCliente = new JPanel(new SpringLayout());
    JPanel panelButtonCadastrar = new JPanel();
    JPanel mainPanel = new JPanel(new BorderLayout());
    
    JLabel cpf = new JLabel("CPF: ", JLabel.TRAILING);
    JTextField cpfText = new JTextField(25);
    
    JButton createClient = new JButton("CONSULTAR");

    public TelaFaturamentoCliente(ControleCliente controleCliente) {
        this.controleCliente = controleCliente;
        createClientWindow();
    }
    
    public void createClientWindow(){
        createClient.addActionListener(this);
        
        panelFormConsultaCliente.add(cpf);
        cpf.setLabelFor(cpfText);
        panelFormConsultaCliente.add(cpfText);

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
        String cpf = cpfText.getText();
        controleCliente.consultaFatCliente(cpf);
    }
}
