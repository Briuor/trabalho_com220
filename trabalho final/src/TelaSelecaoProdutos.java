import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class TelaSelecaoProdutos extends SpringUtilities implements ActionListener{
    private ControleCliente controleCliente;
    private ControleProduto controleProduto;
    private ControleNota controleNota;

    private Nota notaFiscal; // nota fiscal a ser formada no final da compra
    private String cpfCliente; // Cpf do cliente que emite nota
    private static int idNotas = 0; 

    private JTextField textCodigo, textQuantidade, textDataEmissao;
    private JButton botaoEmitir, botaoAdicionar;
    private JLabel labelCodigo, labelQuantidade, labelEmitir;

    public TelaSelecaoProdutos(ControleCliente controleCliente, ControleProduto controleProduto,
                                ControleNota controleNota, String cpfCliente)
    {
        this.notaFiscal = new Nota();
        this.cpfCliente = cpfCliente;

        this.controleCliente = controleCliente;
        this.controleProduto = controleProduto;
        this.controleNota = controleNota;
        
        textCodigo = new JTextField("", 20);
        textQuantidade = new JTextField("", 20);
        textDataEmissao = new JTextField("", 20);
        
        labelCodigo = new JLabel("Código do produto: ");
        labelQuantidade = new JLabel("Quantidade: ");
        labelEmitir = new JLabel("Data de emissao: ");
        
        botaoEmitir = new JButton("Emitir Nota");
        botaoAdicionar = new JButton("Adicionar produto");
        botaoEmitir.addActionListener(this);
        botaoAdicionar.addActionListener(this);
        
        JPanel pFormTop = new JPanel(new SpringLayout());
        JPanel pTop = new JPanel(new BorderLayout());
        
        pFormTop.add(labelCodigo);
        labelCodigo.setLabelFor(textCodigo);
        pFormTop.add(textCodigo);
        
        pFormTop.add(labelQuantidade);
        labelQuantidade.setLabelFor(textQuantidade);
        pFormTop.add(textQuantidade);
        
        SpringUtilities.makeCompactGrid(pFormTop,
                                2, 2, //rows, cols
                                3, 3,        //initX, initY
                                3, 3);       //xPad, yPad
        
        pTop.add(botaoAdicionar, BorderLayout.SOUTH);
        pTop.add(pFormTop, BorderLayout.NORTH);
        
        JPanel pFormBot = new JPanel(new SpringLayout());
        JPanel pBot = new JPanel(new BorderLayout());
        
        pFormBot.add(labelEmitir);
        labelEmitir.setLabelFor(textDataEmissao);
        pFormBot.add(textDataEmissao);
        
        SpringUtilities.makeCompactGrid(pFormBot,
                                1, 2, //rows, cols
                                3, 3,        //initX, initY
                                3, 3);       //xPad, yPad
        
        pBot.add(botaoEmitir, BorderLayout.SOUTH);
        pBot.add(pFormBot, BorderLayout.NORTH);
                
        JPanel p = new JPanel(new BorderLayout());
        
        p.add(pTop, BorderLayout.NORTH);
        p.add(pBot, BorderLayout.SOUTH);
        
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
            //VERIFICA SE QUANTIDADE DE PRODUTOS NA NOTA MAIOR QUE 10
            //Se sim, mostra erro e sai funcao
            if(notaFiscal.getListaProduto().size() > 10)
            {
                JOptionPane.showMessageDialog(null, "Sao permitidos no maximo 10 produtos por nota");
                return ;
            }
            //Verifica se produto existe, se existe seleciona para cliente
            if(controleProduto.produtoExiste(codigo) == true)
            {
                Produto produto = new Produto(controleProduto.getProduto(codigo)); // obtem produto da lista de produtos
                //Verifica se quantidade pedida é menor que a que tem no estoque 
                //Se quantidade pedida menor, adiciona na nota fiscal
                if(quantidade < produto.getQuantEstoque()) 
                {
                    //Verifica se produto ja foi inserido na nota,se sim só incrementa quantidade e sai da funcao
                    for(int i = 0 ;i < notaFiscal.getListaProduto().size(); i++)
                    {
                        if(produto.getCodigo() == notaFiscal.getListaProduto().get(i).getCodigo())
                        {
                            //pega quantidade do produto na nota
                            int quantProdNota = notaFiscal.getListaProduto().get(i).getQuantEstoque();
                            //atualiza quantidade do produto, com o que ja tinha na nota mais o que foi selecionado
                            notaFiscal.getListaProduto().get(i).setQuantEstoque(quantProdNota+quantidade);
                            //Mostra descricao e preço de venda do produto selecionado
                            JOptionPane.showMessageDialog(null, "Descricao: " + produto.getDescricao() + 
                                "\nPreco de venda: " + produto.getValorDeVenda());
                            return ;
                        }
                    }
                    //Se produto nao existe na nota ainda, adiciona produto
                    produto.setQuantEstoque(quantidade); // Coloca quantidade do produto adiocionado igual a quantidade selecionada
                    notaFiscal.getListaProduto().add(produto); // adiciona produto na nota fiscal
                    //Mostra descricao e preço de venda do produto selecionado                    
                    JOptionPane.showMessageDialog(null, "Descricao: " + produto.getDescricao() + 
                        "\nPreco de venda: " + produto.getValorDeVenda());                    
                }
                //Se nao mostra mensagem de erro
                else 
                    JOptionPane.showMessageDialog(null, "Quantidade maxima no estoque é:" + produto.getQuantEstoque());
            }
            //Se nao existe mostra mensagem de erro
            else
                JOptionPane.showMessageDialog(null, "Produto nao existe");
        }
        
        //Se clicou em emitir nota, mostra JOptionPane com informacoes da nota
        else if (e.getSource() == botaoEmitir) 
        {
            try{
                String data = textDataEmissao.getText();
                DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
                Date dataEmissao = (Date)formatter.parse(data);
                System.console().writer().println("Data Emissao: " + dataEmissao);
                
                // GERA ID DA NOTA FISCAL IGUAL AO INDICE DELA NO ARRAY DE NOTAS DO CONTROLENOTAS
                notaFiscal.setCodigo(controleNota.getNotas().size());     
                //Calcula Valor total da compra
                double valorTotal = 0;
                for(int i = 0;i < notaFiscal.getListaProduto().size(); i++)
                    valorTotal += notaFiscal.getListaProduto().get(i).getValorDeVenda();

                notaFiscal.setValorTotalCompra(valorTotal);  

                notaFiscal.setDataEmissao(dataEmissao);
                //passa cpf do cliente que emitiu nota e a nota emitida com todos os produtos
                controleCliente.emitirNota(cpfCliente, notaFiscal); 
                //Coloca notas no array de notas do ControleNota
                controleNota.adicionarNota(notaFiscal);
                //Atualiza Estoque, recebe notas com todos os produtos comprados
                controleProduto.atualizaEstoque(notaFiscal);

            } catch(Exception exc){ System.console().writer().println("Erro emitir nota"); }
        }
     }
    
}
