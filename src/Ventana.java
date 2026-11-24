import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JTextArea textArea1;
    private JTextField txtCodigo;
    private JLabel lblCodigo;
    private JTextField txtNombre;
    private JLabel lblNombre;
    private JTextField txtEstudio;
    private JLabel lblEstudio;
    private JComboBox cbxCategoria;
    private JLabel lblCategoria;
    private JLabel lblAnioLanzamiento;
    private JSpinner spnAnioLanzamiento;
    private JButton btnRegistrar;
    private JPanel Ventana;


    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
