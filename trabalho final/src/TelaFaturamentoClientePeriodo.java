
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TelaFaturamentoClientePeriodo  extends SpringUtilities implements ActionListener{
    private ControleCliente controleCliente;

    JFrame frameCadastroCliente = new JFrame("Consultar Faturamento Cliente por Período");
    JPanel panelFormConsultaCliente = new JPanel(new SpringLayout());
    JPanel panelButtonCadastrar = new JPanel();
    JPanel mainPanel = new JPanel(new BorderLayout());
    
    JLabel data1 = new JLabel("Data Inicio: ", JLabel.TRAILING);
    JTextField data1Text = new JTextField(25);
    JLabel data2 = new JLabel("Data Fim: ", JLabel.TRAILING);
    JTextField data2Text = new JTextField(25);
    
    JLabel cpf = new JLabel("CPF: ", JLabel.TRAILING);
    JTextField cpfText = new JTextField(25); 
    JButton createClient = new JButton("CONSULTAR");

    public TelaFaturamentoClientePeriodo(ControleCliente controleCliente) {
        this.controleCliente = controleCliente;
        createClientWindow();
    }
    
    public void createClientWindow(){
        createClient.addActionListener(this);
        
        panelFormConsultaCliente.add(cpf);
        cpf.setLabelFor(cpfText);
        panelFormConsultaCliente.add(cpfText);   
        
        panelFormConsultaCliente.add(data1);
        data1.setLabelFor(data1Text);
        panelFormConsultaCliente.add(data1Text);
        
        panelFormConsultaCliente.add(data2);
        data2.setLabelFor(data2Text);
        panelFormConsultaCliente.add(data2Text);
        panelButtonCadastrar.add(createClient);
        
        SpringUtilities.makeCompactGrid(panelFormConsultaCliente,
                                3, 2, //rows, cols
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
        String data1 = data1Text.getText();
        Date data1Date = null, data2Date = null;
        DateFormat formatter1 = new SimpleDateFormat("MM/dd/yy");
        try {
            data1Date = (Date)formatter1.parse(data1);
        } catch (ParseException ex) {
            Logger.getLogger(TelaFaturamentoPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String data2 = data2Text.getText();
        DateFormat formatter2 = new SimpleDateFormat("MM/dd/yy");
        try {        
            data2Date = (Date)formatter2.parse(data2);
        } catch (ParseException ex) {
            Logger.getLogger(TelaFaturamentoPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        controleCliente.consultaCompras(cpf, data1Date, data2Date);
    }
}
