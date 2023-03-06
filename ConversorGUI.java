import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorGUI {
    private JFrame ventana;
    private JTextField txtCantidad;
    private JComboBox<String> cbMoneda;
    private JButton btnConvertir;
    private JLabel lblResultado;

    private final double TIPO_CAMBIO_DOLAR = 0.056;
    private final double TIPO_CAMBIO_EURO = 0.052;
    private final double TIPO_CAMBIO_LIBRA = 0.046;
    private final double TIPO_CAMBIO_YEN = 7.55;
    private final double TIPO_CAMBIO_WON = 72.12;

    public ConversorGUI() {
        // Configurar ventana principal
        ventana = new JFrame("Conversor de moneda");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());

        // Configurar componentes
        txtCantidad = new JTextField(10);
        cbMoneda = new JComboBox<String>(new String[]{"Dólar", "Euro", "Libra", "Yen", "Won"});
        btnConvertir = new JButton("Convertir");
        lblResultado = new JLabel("");

        // Agregar componentes a la ventana
        ventana.add(new JLabel("Cantidad de pesos mexicanos: "));
        ventana.add(txtCantidad);
        ventana.add(new JLabel("Convertir a: "));
        ventana.add(cbMoneda);
        ventana.add(btnConvertir);
        ventana.add(lblResultado);

        // Agregar listener al botón de convertir
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double cantidad = Double.parseDouble(txtCantidad.getText());
                int seleccion = cbMoneda.getSelectedIndex();

                double resultado = 0;
                switch (seleccion) {
                    case 0: // Dólar
                        resultado = cantidad * TIPO_CAMBIO_DOLAR;
                        break;
                    case 1: // Euro
                        resultado = cantidad * TIPO_CAMBIO_EURO;
                        break;
                    case 2: // Libra
                        resultado = cantidad * TIPO_CAMBIO_LIBRA;
                        break;
                    case 3: // Yen
                        resultado = cantidad * TIPO_CAMBIO_YEN;
                        break;
                    case 4: // Won
                        resultado = cantidad * TIPO_CAMBIO_WON;
                        break;
                }

                lblResultado.setText(String.format("$%.2f pesos mexicanos son equivalentes a %.2f \nunidades de la moneda seleccionada.", cantidad, resultado));
            }
        });
    }

    public void mostrar() {
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        ConversorGUI conversor = new ConversorGUI();
        conversor.mostrar();
    }
}
