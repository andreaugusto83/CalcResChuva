package projetooficinas;

import Fluxos.Arquivo;
import Metodos.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
//import javax.swing.j

public class PainelDeControle extends JFrame implements ActionListener
{
    JTextField demMensal = new JTextField("0");
    JTextField aCap = new JTextField("0");
    JTextField indMeses[] = new JTextField[13];
    JTextField nomeCidade = new JTextField();
    JTextField descDia = new JTextField("0");
    JTextField nCarros = new JTextField("0");
    JTextField aJardim = new JTextField("0");
    JTextField aPiso = new JTextField("0");
    JComboBox lCidades = new JComboBox();
    JComboBox pAproveitamento = new JComboBox();
    JComboBox aRunoff = new JComboBox();
    Arquivo bancoDados = new Arquivo();
    JMenuBar menu = new JMenuBar();
    JButton save = new JButton("Criar");
    JButton calc = new JButton("Calcular");
    JButton def = new JButton("Calcular");
    JMenuItem ajuda = new JMenuItem("Ajuda");
    JMenuItem sobre = new JMenuItem("Sobre");
    JMenuItem reset = new JMenuItem("Resetar");
    JMenuItem sair = new JMenuItem("Sair");
    Metodos rippl = new Rippl();
    Metodos aNeto = new AzevedoNeto();
    Metodos pAlemao = new PraticoAlemao();
    Metodos pAust = new PraticoAustraliano();
    Metodos pIngles = new PraticoIngles();
    Metodos simu = new Simulacao();

    public PainelDeControle()
    {
        setSize(800,580);
        setVisible(true);
        setResizable(false);
        setTitle("Calculadora de Volume de Reservatorio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);        
        
        JLabel demanda = new JLabel("Calculo de Volume");
        demanda.setBounds(100, 20, 200, 60);
        add(demanda);

        JLabel demMens = new JLabel("Demanda Mensal (m³):");
        demMens.setBounds(10, 70, 200, 20);
        add(demMens);

        add(demMensal);
        demMensal.setBounds(150, 70, 150, 20);

        JLabel areaCap = new JLabel("Area de Captação (m²):");
        areaCap.setBounds(10, 100, 200, 20);
        add(areaCap);

        add(aCap);
        aCap.setBounds(150, 100, 150, 20);
        
        JLabel cidade = new JLabel("Cidade:");
        cidade.setBounds(10, 130, 200, 20);
        add(cidade);
        
        lCidades.setBounds(150, 130, 150, 20);
        add(lCidades);

        for(int j = 0; j < bancoDados.getNumeroCidades(); j++)
        {
            lCidades.addItem(bancoDados.getCidades(j));
        }

        JLabel capApro = new JLabel("Coeficiente Ap. (Cap):");
        capApro.setBounds(10, 160, 200, 20);
        add(capApro);

        pAproveitamento.setBounds(150, 160, 150, 20);
        add(pAproveitamento);

        for(double i = 100; i >= 0; i--)
        {
            pAproveitamento.addItem(i / 100);
        }

        JLabel coefRu = new JLabel("Coeficiente de Runoff:");
        coefRu.setBounds(10, 190, 200, 20);
        add(coefRu);

        aRunoff.setBounds(150, 190, 150, 20);
        add(aRunoff);

        for(double i = 100; i >= 0; i--)
        {
            aRunoff.addItem(i/100);
        }

        JLabel criaCid = new JLabel("Criar Nova Cidade");
        criaCid.setBounds(350, 270, 200, 20);
        add(criaCid);

        JLabel inds = new JLabel("Indices Pluviometricos Médios Mensais (mm)");
        inds.setBounds(30, 290, 300, 20);
        add(inds);

        JLabel indPluv = new JLabel("Nome da Cidade:");
        indPluv.setBounds(10, 320, 200, 20);
        add(indPluv);

        nomeCidade.setBounds(130, 320, 150, 20);
        add(nomeCidade);

        JLabel meses[] = new JLabel [12];

        meses[0] = new JLabel("Janeiro:");
        meses[0].setBounds(10, 350, 200, 20);
        meses[1] = new JLabel("Fevereiro:");
        meses[1].setBounds(10, 380, 200, 20);
        meses[2] = new JLabel("Março:");
        meses[2].setBounds(10, 410, 200, 20);
        meses[3] = new JLabel("Abril:");
        meses[3].setBounds(10, 440, 200, 20);
        meses[4] = new JLabel("Maio:");
        meses[4].setBounds(260, 350, 200, 20);
        meses[5] = new JLabel("Junho:");
        meses[5].setBounds(260, 380, 200, 20);
        meses[6] = new JLabel("Julho:");
        meses[6].setBounds(260, 410, 200, 20);
        meses[7] = new JLabel("Agosto:");
        meses[7].setBounds(260, 440, 200, 20);
        meses[8] = new JLabel("Setembro:");
        meses[8].setBounds(510, 350, 200, 20);
        meses[9] = new JLabel("Outubro:");
        meses[9].setBounds(510, 380, 200, 20);
        meses[10] = new JLabel("Novembro:");
        meses[10].setBounds(510, 410, 200, 20);
        meses[11] = new JLabel("Dezembro:");
        meses[11].setBounds(510, 440, 200, 20);

        for(int i = 0; i < 12; i++)
        {
            add(meses[i]);
        }
        
        indMeses[0] = new JTextField("0");
        indMeses[0].setBounds(90, 350, 100, 20);
        indMeses[1] = new JTextField("0");
        indMeses[1].setBounds(90, 380, 100, 20);
        indMeses[2] = new JTextField("0");
        indMeses[2].setBounds(90, 410, 100, 20);
        indMeses[3] = new JTextField("0");
        indMeses[3].setBounds(90, 440, 100, 20);
        indMeses[4] = new JTextField("0");
        indMeses[4].setBounds(330, 350, 100, 20);
        indMeses[5] = new JTextField("0");
        indMeses[5].setBounds(330, 380, 100, 20);
        indMeses[6] = new JTextField("0");
        indMeses[6].setBounds(330, 410, 100, 20);
        indMeses[7] = new JTextField("0");
        indMeses[7].setBounds(330, 440, 100, 20);
        indMeses[8] = new JTextField("0");
        indMeses[8].setBounds(580, 350, 100, 20);
        indMeses[9] = new JTextField("0");
        indMeses[9].setBounds(580, 380, 100, 20);
        indMeses[10] = new JTextField("0");
        indMeses[10].setBounds(580, 410, 100, 20);
        indMeses[11] = new JTextField("0");
        indMeses[11].setBounds(580, 440, 100, 20);

        for(int j = 0; j < 12; j++)
        {
            add(indMeses[j]);
        }

        JLabel mesPChuva = new JLabel("Meses de pouca chuva:");
        mesPChuva.setBounds(440, 470, 200, 20);
        add(mesPChuva);

        indMeses[12] = new JTextField("0");
        indMeses[12].setBounds(580,470,100,20);
        add(indMeses[12]);

        JLabel calcDemanda = new JLabel("Calculo de Demanda");
        calcDemanda.setBounds(500, 40, 200, 20);
        add(calcDemanda);

        JLabel desc = new JLabel("Usos sanitarios diarios:");
        desc.setBounds(400, 70, 200, 20);
        add(desc);

        descDia.setBounds(570, 70, 150, 20);
        add(descDia);

        JLabel carros = new JLabel("Numero de carros(Lavagem):");
        carros.setBounds(400, 100, 200, 20);
        add(carros);

        nCarros.setBounds(570, 100, 150, 20);
        add(nCarros);

        JLabel jardim = new JLabel("Area do Jardim(Regagem):");
        jardim.setBounds(400, 130, 200, 20);
        add(jardim);
        
        aJardim.setBounds(570, 130, 150, 20);
        add(aJardim);

        JLabel piso = new JLabel ("Area do Piso(Lavagem):");
        piso.setBounds(400,160,200,20);
        add(piso);

        aPiso.setBounds(570,160,150,20);
        add(aPiso);

        save.addActionListener(this);
        save.setBounds(555, 500, 130, 40);
        add(save);

        calc.addActionListener(this);
        calc.setBounds(75, 220, 130, 40);
        add(calc);

        def.addActionListener(this);
        def.setBounds(500, 190, 130, 40);
        add(def);

        menu.setBounds(0, 0, 800, 40);
        add(menu);

        reset.addActionListener(this);
        reset.setBounds(5, 5, 70, 30);
        menu.add(reset);

        ajuda.addActionListener(this);
        ajuda.setBounds(115, 5, 70, 30);
        menu.add(ajuda);

        sobre.addActionListener(this);
        sobre.setBounds(235, 5, 70, 30);
        menu.add(sobre);

        sair.addActionListener(this);
        sair.setBounds(345, 5, 70, 30);
        menu.add(sair);

        repaint();
    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(save))
        {
            double[] indices = new double[13];

            for(int i = 0; i < 13; i++)
            {
                indices[i] = Double.parseDouble(indMeses[i].getText().toString());
            }

            bancoDados.criaCidade(indices, nomeCidade.getText());

            lCidades.addItem(nomeCidade.getText());

            JDialog cidadeCriada = new JDialog();
            cidadeCriada.setTitle("Cidade Criada");
            cidadeCriada.setSize(300, 100);
            cidadeCriada.setVisible(true);

            JLabel cid = new JLabel("Cidade '" + nomeCidade.getText() + "' criada com sucesso!");
            cidadeCriada.add(cid);

            repaint();
        }

        if(e.getSource().equals(calc))
        {
            rippl.resetar(); aNeto.resetar(); pAlemao.resetar(); pIngles.resetar();

            double dD = Double.parseDouble(demMensal.getText().toString());
            double dCap = Double.parseDouble(aCap.getText().toString());

            double Cur[] = null;

            try {
                Cur = bancoDados.getPluv((lCidades.getSelectedItem()).toString());
            } catch (IOException ex) {}

            double capA = Double.parseDouble(pAproveitamento.getSelectedItem().toString());

            JDialog resultados = new JDialog();
            resultados.setSize(630,240);
            resultados.setTitle("Calculo do Volume");
            resultados.setLayout(null);
            resultados.setVisible(true);
            resultados.setResizable(false);
            JTextArea resul = new JTextArea("Resultados apresentados para os metodos da ABNT com os seguintes dados" +
                    "\nDemanda mensal:" + dD + "m³ \nCidade de " + lCidades.getSelectedItem().toString() +
                    "\nArea de captação:" + dCap + "m²"
                    + "\n\nRippl:"  + rippl.calcula(dD, dCap, Cur, capA) +
                    "\nAzevedo Neto: " + aNeto.calcula(dD, dCap, Cur, capA) +
                    "\nPratico Alemão: " + pAlemao.calcula(dD, dCap, Cur, Double.parseDouble(aRunoff.getSelectedItem().toString())) +
                    "\nPratico Inglês: " + pIngles.calcula(dD, dCap, Cur, capA) +
                    "\nSimulação: " + simu.calcula(dD, dCap, Cur, capA) +
                    "\nPratico Australiano: " + pAust.calcula(dD, dCap, Cur, capA));
            resul.setBounds(0, 0, 600, 300);
            resultados.add(resul);
            resul.setEditable(false);
        }

        if(e.getSource().equals(def))
        {
            JDialog demCalc = new JDialog();
            demCalc.setSize(200, 60);
            demCalc.setTitle("Calculo de Demanda");
            demCalc.setVisible(true);
            double dL = Double.parseDouble(descDia.getText().toString());
            double dC = Double.parseDouble(nCarros.getText().toString());
            double dJ = Double.parseDouble(aJardim.getText().toString());
            double dA = Double.parseDouble(aPiso.getText().toString());

            double deM =  ((dL * 12.4) + (dC * 150) + (dJ * 2) +  (dA * 2))/1000;

            JTextArea valor = new JTextArea("Demanda Mensal = " + deM + "m³");
            valor.setBounds(50, 0, 100, 100);
            demCalc.add(valor);
        }

        if(e.getSource().equals(ajuda))
        {
            JDialog help = new JDialog();
            help.setSize(800, 480);
            help.setTitle("Ajuda");
            help.setVisible(true);

            JTextArea ajud = new JTextArea("\nCalculo de volume: Cálculo do volume de reservatório para armazenamento de água da chuva com base nos métodos da ABNT." +
"\n\nDemanda mensal (m³): Quanto será utilizado de água não potável pelo empreendimento mensalmente." +

"\n\nCidade: Nome da cidade em que se encontra o empreendimento." +

"\n\nÁrea de captação (m²): Área que será utilizada para a captação da água durante os momentos de chuva." +

"\n\nCoeficiente Ap. (Cap): Coeficiente de aproveitamento de escoamento superficial." +

"\n\nCalculo de demanda: Calculo de demanda para um empreendimento." +

"\n\nUsos diários sanitários: Quantas vezes o vaso sanitário será utilizado por dia." +

"\n\nNumero de carros (lavagem): Quantos carros serão lavados a partir da água coletada da chuva." +

"\n\nÁrea do jardim (regagem): Área de jardins que será regada a partir da água coletada da chuva. " +

"\n\nÁrea do piso (lavagem): Área de piso que será regada a partir da água coletada da chuva. " +

"\n\nCriar nova cidade: Cria uma nova cidade a partir dos índices pluviométricos inseridos pelo usuário." +

"\n\nNome da cidade: Nome que terá a cidade criada." +

"\n\nMeses de pouca chuva: Quantos meses a cidade a ser criada terá com escassez de chuva.");

            help.add(ajud);
            ajud.setSize(800, 480);
            ajud.setEditable(false);
            help.setResizable(false);

        }

        if(e.getSource().equals(sair))
        {
            System.exit(0);
        }

        if(e.getSource().equals(sobre))
        {
            JDialog sobr = new JDialog();
            sobr.setSize(470, 300);
            sobr.setVisible(true);

            JTextArea about = new JTextArea ("                                                                     SOBRE"+

"\nSoftware Para Cálculo do Volume de Reservatório Para Armazenamento de Água \nda Chuva." +

"\n\nPrograma feito à disciplina de Oficinas de Integração I, do Curso Superior \nde Engenharia de Computação do Departamento Acadêmico de Informática \nda Universidade Tecnológica Federal do Paraná, ano de 2011." +

"\n\nTrabalho produzido pelos alunos: \n*André Augusto Dequech Carvalho \n*Felipe Augusto Zborowski \n*Vinícius Placeres Vanderley" +

"\n\nCom a orientação dos professores: \n*Prof. Stella Maris da Cruz Bezerra \n*Prof. Adolfo Gustavo Serra Seca Neto");

            about.setBounds(0, 0, 500, 400);
            sobr.add(about);
            about.setEditable(false);

        }

        if(e.getSource().equals(reset))
        {
            demMensal.setText("0");
            aCap.setText("0");
            for(int i = 0; i < 13; i++)
            {
                indMeses[i].setText("0");
            }
            nomeCidade.setText(null);
            descDia.setText("0");
            nCarros.setText("0");
            aJardim.setText("0");
            aPiso.setText("0");
        }

    }

}