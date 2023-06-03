import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraIMC extends JFrame {
    private JLabel labelPeso, labelAltura, labelResultado;
    private JTextField campoPeso, campoAltura, campoResultado;
    private JButton botaoCalcular;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        labelPeso = new JLabel("Peso (kg):");
        campoPeso = new JTextField();
        labelAltura = new JLabel("Altura (m):");
        campoAltura = new JTextField();
        labelResultado = new JLabel("Resultado:");
        campoResultado = new JTextField();
        campoResultado.setEditable(false);
        botaoCalcular = new JButton("Calcular");

        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        add(labelPeso);
        add(campoPeso);
        add(labelAltura);
        add(campoAltura);
        add(labelResultado);
        add(campoResultado);
        add(new JLabel());
        add(botaoCalcular);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(campoPeso.getText());
            double altura = Double.parseDouble(campoAltura.getText());

            double imc = peso / (altura * altura);
            String categoria;

            if (imc < 18.5) {
                categoria = "Abaixo do peso";
            } else if (imc < 25) {
                categoria = "Peso normal";
            } else if (imc < 30) {
                categoria = "Sobrepeso";
            } else {
                categoria = "Obesidade";
            }

            campoResultado.setText(String.format("%.2f (%s)", imc, categoria));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira valores numéricos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculadoraIMC calculadora = new CalculadoraIMC();
                calculadora.setVisible(true);
            }
        });
    }
}