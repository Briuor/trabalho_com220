import javax.swing.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public final class TelaCadastroCliente extends SpringUtilities {
    JFrame frameCadastroCliente = new JFrame("Cadastrar Cliente");
    JPanel panelFormCadastroCliente = new JPanel(new SpringLayout());
    JPanel panelButtonCadastrar = new JPanel();
    JPanel mainPanel = new JPanel(new BorderLayout());
    
    JButton createClient = new JButton("CADASTRAR");

    public TelaCadastroCliente() {
        createClientWindow();
    }
    
    
    
    public void createClientWindow(){
        
        String[] labels = {"Nome: ", "Endereço: ", "Email: ", "CPF: "};
        int numPairs = labels.length;
        
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            panelFormCadastroCliente.add(l);
            JTextField textField = new JTextField(25);
            l.setLabelFor(textField);
            panelFormCadastroCliente.add(textField);
        }
        panelButtonCadastrar.add(createClient);

        
        
        SpringUtilities.makeCompactGrid(panelFormCadastroCliente,
                                numPairs, 2, //rows, cols
                                3, 3,        //initX, initY
                                3, 3);       //xPad, yPad
        
        mainPanel.add(panelFormCadastroCliente, BorderLayout.NORTH);
        mainPanel.add(panelButtonCadastrar, BorderLayout.SOUTH);
        
        frameCadastroCliente.add(mainPanel);
        frameCadastroCliente.pack();
        frameCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCadastroCliente.setVisible(true);
    }

    

    public static void main(String[] args) {
        TelaCadastroCliente init = new TelaCadastroCliente();
    }

    

}
