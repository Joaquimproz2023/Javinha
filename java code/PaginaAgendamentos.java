import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import javax.swing.text.MaskFormatter;

public class PaginaAgendamentos {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarGUI();
            }
        });
    }

    private static void criarGUI() {
        JFrame frame = new JFrame("Agendamento de Shows");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel lblNomeArtista = new JLabel("Nome do Artista:");
        JTextField txtNomeArtista = new JTextField();

        JLabel lblData = new JLabel("Data do Show (dd/MM/yyyy):");
        JFormattedTextField txtData = createFormattedDateField();

        JLabel lblCapacidade = new JLabel("Capacidade Máxima:");
        JFormattedTextField txtCapacidade = createNumericField();

        JLabel lblPrecoIngresso = new JLabel("Preço do Ingresso:");
        JFormattedTextField txtPrecoIngresso = createDecimalField();

        JButton btnAgendar = new JButton("Agendar");

        panel.add(lblNomeArtista);
        panel.add(txtNomeArtista);
        panel.add(lblData);
        panel.add(txtData);
        panel.add(lblCapacidade);
        panel.add(txtCapacidade);
        panel.add(lblPrecoIngresso);
        panel.add(txtPrecoIngresso);

        btnAgendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeArtista = txtNomeArtista.getText();
                Date data = null;
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    data = sdf.parse(txtData.getText());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                int capacidade = ((Number) txtCapacidade.getValue()).intValue();
                double precoIngresso = ((Number) txtPrecoIngresso.getValue()).doubleValue();

                Show Show = new Show(nomeArtista, data, capacidade, precoIngresso);
                agendarShow(Show);
                JOptionPane.showMessageDialog(frame, "Show agendado com sucesso!");
            }
        });

        panel.add(btnAgendar);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
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

    private static void agendarShow(Show show) {

    }
}
