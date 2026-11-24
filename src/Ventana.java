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
    private JTextField txtBuscar;
    private JTextArea txtAreaBuscar;
    private JTextField txtNombreEditar;
    private JTextField txtEstudioEfditar;
    private JComboBox cbxCategoriaEditar;
    private JSpinner spnAnioEditar;
    private JButton btnEditarDatos;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JLabel lblCodigoBuscar;
    private JLabel lblEditarDatos;
    private JLabel lblNombreEditar;
    private JLabel lblEstudioEditar;
    private JLabel lblCategoriaEditar;
    private JLabel lblAnioEditar;
    private JList lstRanking;
    private JSpinner spnRestarVotos;
    private JButton btnRestarVotos;


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