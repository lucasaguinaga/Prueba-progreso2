import javax.swing.*;
import java.util.List;
public class Ventana {
    private JTabbedPane tabbedPane1;
    private JPanel Ventana;
    private JTextArea textArea1;
    private JList list1;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtEstudio;
    private JComboBox cbxCategoria;
    private JSpinner spnAnioLanzamiento;
    private JButton btnRegistrar;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JTextArea txtAreaBuscar;
    private JTextField txtNombreEditar;
    private JTextField txtEstudioEfditar;
    private JComboBox cbxCategoriaEditar;
    private JSpinner spnAnioEditar;
    private JButton btnEditarDatos;
    private JButton btnEliminar;
    private JSpinner spnRestarVotos;
    private JButton btnRestarVotos;

    private JTextField txtBuscarTexto;
    private JButton btnBuscarTexto;
    private JList lstRanking;

    private final GestorVideojuego gestor = new GestorVideojuego();
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final DefaultListModel<String> modeloRanking = new DefaultListModel<>();
    private Integer codigoSeleccionado = null;
    private String ultimaBusquedaTexto = null;
    public Ventana() {
        configurarComponentes();
        gestor.cargarInicial();
        btnRegistrar.addActionListener(e -> registrar());
        btnBuscarTexto.addActionListener(e -> buscarTexto());
        btnBuscar.addActionListener(e -> buscarPorCodigo());
        btnEditarDatos.addActionListener(e -> editar());
        btnEliminar.addActionListener(e -> eliminar());
        btnRestarVotos.addActionListener(e -> restarVotos());
        tabbedPane1.addChangeListener(e -> refrescarRanking());
        limpiarSeleccion();
        refrescarTodo();
    }
    private void configurarComponentes() {
        tabbedPane1.setTitleAt(0, "Listado");
        tabbedPane1.setTitleAt(1, "Búsqueda");
        tabbedPane1.setTitleAt(2, "Ranking");
        cbxCategoria.setModel(new DefaultComboBoxModel<>(GestorVideojuego.CATEGORIAS));
        cbxCategoriaEditar.setModel(new DefaultComboBoxModel<>(GestorVideojuego.CATEGORIAS));
        int max = GestorVideojuego.anioMax();
        spnAnioLanzamiento.setModel(new SpinnerNumberModel(2020, GestorVideojuego.ANIO_MIN, max, 1));
        spnAnioEditar.setModel(new SpinnerNumberModel(2020, GestorVideojuego.ANIO_MIN, max, 1));
        spnAnioLanzamiento.setEditor(new JSpinner.NumberEditor(spnAnioLanzamiento, "#"));
        spnAnioEditar.setEditor(new JSpinner.NumberEditor(spnAnioEditar, "#"));
        spnRestarVotos.setModel(new SpinnerNumberModel(1, 1, 3, 1));
        list1.setModel(modeloLista);
        lstRanking.setModel(modeloRanking);
        txtAreaBuscar.setEditable(false);
        textArea1.setEditable(false);
    }

    private void registrar() {
        try {
            int codigo = parseEntero(txtCodigo.getText(), "código");
            int anio = (Integer) spnAnioLanzamiento.getValue();
            gestor.registrar(codigo, txtNombre.getText(), txtEstudio.getText(),
                    (String) cbxCategoria.getSelectedItem(), anio);
            txtCodigo.setText("");
            txtNombre.setText("");
            txtEstudio.setText("");
            refrescarTodo();
            JOptionPane.showMessageDialog(Ventana, "Videojuego registrado.");
        } catch (IllegalArgumentException ex) {
            aviso(ex.getMessage());
        }
    }
