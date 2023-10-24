import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import javax.swing.text.MaskFormatter;

public class PaginaAgendamentos {
    private static ArrayList<Evento> eventos = new ArrayList<Evento>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarGUI();
            }
        });
    }

    private static void criarGUI() {
        JFrame frame = new JFrame("Agendamento de Eventos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel lblNome = new JLabel("Nome do Evento:");
        JTextField txtNome = new JTextField();

        JLabel lblData = new JLabel("Data do Evento (dd/MM/yyyy):");
        JFormattedTextField txtData = createFormattedDateField();

        JLabel lblTipoEvento = new JLabel("Tipo de Evento:");
        ButtonGroup tipoEventoGroup = new ButtonGroup();
        JRadioButton musicaRadio = new JRadioButton("Show de Música");
        JRadioButton comediaRadio = new JRadioButton("Show de Comédia");
        tipoEventoGroup.add(musicaRadio);
        tipoEventoGroup.add(comediaRadio);

        JLabel lblCapacidadePreco = new JLabel("Capacidade Máxima / Preço do Ingresso / Faixa Etária:");
        JFormattedTextField txtCapacidade = createNumericField();
        JFormattedTextField txtPrecoIngresso = createDecimalField();
        JFormattedTextField txtFaixaEtaria = createNumericField();

        JButton btnAgendar = new JButton("Agendar Evento");

        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblData);
        panel.add(txtData);
        panel.add(lblTipoEvento);
        panel.add(musicaRadio);
        panel.add(comediaRadio);
        panel.add(lblCapacidadePreco);
        panel.add(txtCapacidade);
        panel.add(txtPrecoIngresso);
        panel.add(txtFaixaEtaria);
        panel.add(btnAgendar);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        btnAgendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                Date data = null;
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    data = sdf.parse(txtData.getText());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                Evento evento = null;
                if (musicaRadio.isSelected()) {
                    int capacidade = ((Number) txtCapacidade.getValue()).intValue();
                    double precoIngresso = ((Number) txtPrecoIngresso.getValue()).doubleValue();
                    evento = new ShowDeMusica(nome, data, capacidade, precoIngresso);
                } else if (comediaRadio.isSelected()) {
                    int faixaEtaria = ((Number) txtFaixaEtaria.getValue()).intValue();
                    evento = new ShowDeComedia(nome, data, faixaEtaria);
                } else {

                    return;
                }

                eventos.add(evento); 
                JOptionPane.showMessageDialog(frame, "Evento agendado com sucesso!");
            }
        });
    }

    private static JFormattedTextField createFormattedDateField() {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField textField = new JFormattedTextField(mask);
        return textField;
    }

    private static JFormattedTextField createNumericField() {
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getIntegerInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(10);
        return textField;
    }

    private static JFormattedTextField createDecimalField() {
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getNumberInstance());
        formatter.setValueClass(Double.class);
        formatter.setMinimum(0.0);
        formatter.setMaximum(Double.MAX_VALUE);
        JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(10);
        return textField;
    }

    private static void agendarEvento(Evento evento) {

    }
}

class Evento {
    private String nome;
    private Date data;

    public Evento(String nome, Date data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

class ShowDeMusica extends Evento {
    private int capacidade;
    private double precoIngresso;

    public ShowDeMusica(String nome, Date data, int capacidade, double precoIngresso) {
        super(nome, data);
        this.capacidade = capacidade;
        this.precoIngresso = precoIngresso;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }
}

class ShowDeComedia extends Evento {
    private int faixaEtaria;

    public ShowDeComedia(String nome, Date data, int faixaEtaria) {
        super(nome, data);
        this.faixaEtaria = faixaEtaria;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
}
