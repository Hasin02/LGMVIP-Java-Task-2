import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JLabel resultLabel;

    private static final Map<String, Double> EXCHANGE_RATES = new HashMap<>();

    static {
        // Exchange rates based on USD
        EXCHANGE_RATES.put("USD", 1.0);
        EXCHANGE_RATES.put("EUR", 0.85);
        EXCHANGE_RATES.put("JPY", 109.69);
        EXCHANGE_RATES.put("GBP", 0.73);
        EXCHANGE_RATES.put("AUD", 1.35);
        EXCHANGE_RATES.put("CAD", 1.23);
        EXCHANGE_RATES.put("CHF", 0.91);
        EXCHANGE_RATES.put("CNY", 6.45);
        EXCHANGE_RATES.put("SEK", 8.87);
        EXCHANGE_RATES.put("NZD", 1.46);
        EXCHANGE_RATES.put("MXN", 20.15);
        EXCHANGE_RATES.put("SGD", 1.38);
        EXCHANGE_RATES.put("HKD", 7.77);
        EXCHANGE_RATES.put("NOK", 8.95);
        EXCHANGE_RATES.put("KRW", 1158.32);
        EXCHANGE_RATES.put("TRY", 8.68);
        EXCHANGE_RATES.put("RUB", 73.42);
        EXCHANGE_RATES.put("INR", 75.25);
        EXCHANGE_RATES.put("BRL", 5.09);
        EXCHANGE_RATES.put("ZAR", 14.64);
        EXCHANGE_RATES.put("SAR", 3.75);
        EXCHANGE_RATES.put("AED", 3.67);
        EXCHANGE_RATES.put("DKK", 6.32);
        EXCHANGE_RATES.put("PLN", 3.85);
        EXCHANGE_RATES.put("PHP", 50.75);
        EXCHANGE_RATES.put("HUF", 298.76);
        EXCHANGE_RATES.put("CZK", 21.94);
        EXCHANGE_RATES.put("IDR", 14226.88);
        EXCHANGE_RATES.put("ILS", 3.26);
        EXCHANGE_RATES.put("CLP", 812.51);
        EXCHANGE_RATES.put("THB", 31.48);
        EXCHANGE_RATES.put("MYR", 4.18);
        EXCHANGE_RATES.put("RON", 4.10);
        EXCHANGE_RATES.put("COP", 3846.05);
        EXCHANGE_RATES.put("ARS", 106.80);
        EXCHANGE_RATES.put("TWD", 27.78);
        EXCHANGE_RATES.put("VND", 22899.90);
        EXCHANGE_RATES.put("EGP", 15.66);
        EXCHANGE_RATES.put("PKR", 169.96);
        EXCHANGE_RATES.put("IQD", 1459.38);
        EXCHANGE_RATES.put("KWD", 0.30);
        EXCHANGE_RATES.put("QAR", 3.64);
        EXCHANGE_RATES.put("OMR", 0.38);
        EXCHANGE_RATES.put("JOD", 0.71);
        EXCHANGE_RATES.put("BHD", 0.38);
        EXCHANGE_RATES.put("LBP", 1511.99);
        EXCHANGE_RATES.put("BGN", 1.66);
        EXCHANGE_RATES.put("DZD", 135.00);
        EXCHANGE_RATES.put("TND", 2.80);
        EXCHANGE_RATES.put("BYN", 2.62);
        EXCHANGE_RATES.put("PEN", 4.14);
        EXCHANGE_RATES.put("UAH", 26.80);
        EXCHANGE_RATES.put("NGN", 413.50);
        EXCHANGE_RATES.put("UGX", 3522.90);
        EXCHANGE_RATES.put("KES", 112.28);
        EXCHANGE_RATES.put("GHS", 6.05);
        EXCHANGE_RATES.put("XOF", 552.22);
        EXCHANGE_RATES.put("TZS", 2295.23);
        EXCHANGE_RATES.put("DOP", 56.90);
        EXCHANGE_RATES.put("PLN", 3.85);
        EXCHANGE_RATES.put("CUC", 1.00);
        EXCHANGE_RATES.put("BOB", 6.90);
        EXCHANGE_RATES.put("CRC", 619.82);
        EXCHANGE_RATES.put("HNL", 23.91);
        EXCHANGE_RATES.put("PYG", 6727.75);
        EXCHANGE_RATES.put("GTQ", 7.73);
        EXCHANGE_RATES.put("UYU", 44.39);
        EXCHANGE_RATES.put("NIO", 35.17);
        EXCHANGE_RATES.put("BWP", 11.09);
        EXCHANGE_RATES.put("BMD", 1.00);
        EXCHANGE_RATES.put("CUP", 24.00);
        EXCHANGE_RATES.put("GEL", 3.11);
        EXCHANGE_RATES.put("XAF", 555.04);
        EXCHANGE_RATES.put("ISK", 120.83);
        EXCHANGE_RATES.put("NPR", 119.72);
        EXCHANGE_RATES.put("LKR", 200.52);
        EXCHANGE_RATES.put("BND", 1.35);
        EXCHANGE_RATES.put("GMD", 51.60);
        EXCHANGE_RATES.put("ETB", 47.40);
        EXCHANGE_RATES.put("KHR", 4057.25);
        EXCHANGE_RATES.put("HTG", 101.50);
        EXCHANGE_RATES.put("MOP", 8.02);
        EXCHANGE_RATES.put("MKD", 51.39);
        EXCHANGE_RATES.put("ALL", 105.79);
        EXCHANGE_RATES.put("XPF", 102.55);
        EXCHANGE_RATES.put("MUR", 42.65);
        EXCHANGE_RATES.put("NAD", 14.64);
        EXCHANGE_RATES.put("XCD", 2.70);
        EXCHANGE_RATES.put("VUV", 108.53);
        EXCHANGE_RATES.put("AWG", 1.80);
        EXCHANGE_RATES.put("BTN", 74.84);
        EXCHANGE_RATES.put("LAK", 9376.43);
        EXCHANGE_RATES.put("FJD", 2.08);
        EXCHANGE_RATES.put("SRD", 21.33);
        EXCHANGE_RATES.put("SBD", 8.07);
        EXCHANGE_RATES.put("SOS", 578.62);
        EXCHANGE_RATES.put("GYD", 209.31);
        EXCHANGE_RATES.put("BSD", 1.00);
        EXCHANGE_RATES.put("KGS", 85.02);
        EXCHANGE_RATES.put("MGA", 3996.71);
        EXCHANGE_RATES.put("RWF", 1022.83);
        EXCHANGE_RATES.put("TJS", 11.39);
        EXCHANGE_RATES.put("KYD", 0.83);
        EXCHANGE_RATES.put("MVR", 15.45);
        EXCHANGE_RATES.put("CDF", 1985.76);
        EXCHANGE_RATES.put("STD", 21070.42);
        EXCHANGE_RATES.put("SVC", 8.74);
        EXCHANGE_RATES.put("ANG", 1.79);
        EXCHANGE_RATES.put("WST", 2.57);
        EXCHANGE_RATES.put("KPW", 900.00);
        EXCHANGE_RATES.put("DJF", 177.72);
        EXCHANGE_RATES.put("SZL", 14.64);
        EXCHANGE_RATES.put("ERN", 15.00);
        EXCHANGE_RATES.put("FKP", 0.73);
        EXCHANGE_RATES.put("SHP", 0.73);
        EXCHANGE_RATES.put("JMD", 148.30);
        EXCHANGE_RATES.put("KMF", 403.30);
        EXCHANGE_RATES.put("MNT", 2852.22);
    }

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(fromCurrencyLabel, gbc);

        fromCurrencyComboBox = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fromCurrencyComboBox, gbc);

        JLabel toCurrencyLabel = new JLabel("To Currency:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(toCurrencyLabel, gbc);

        toCurrencyComboBox = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(toCurrencyComboBox, gbc);

        JLabel amountLabel = new JLabel("Amount:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(amountLabel, gbc);

        amountTextField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(amountTextField, gbc);

        JButton convertButton = new JButton("Convert");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        convertButton.addActionListener(this);
        add(convertButton, gbc);

        JLabel resultTextLabel = new JLabel("Result:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(resultTextLabel, gbc);

        resultLabel = new JLabel();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(resultLabel, gbc);

        populateCurrencyComboBoxes();
        pack();
    }

    private void populateCurrencyComboBoxes() {
        for (String currency : EXCHANGE_RATES.keySet()) {
            fromCurrencyComboBox.addItem(currency);
            toCurrencyComboBox.addItem(currency);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Convert")) {
            String fromCurrency = fromCurrencyComboBox.getSelectedItem().toString();
            String toCurrency = toCurrencyComboBox.getSelectedItem().toString();
            double amount = Double.parseDouble(amountTextField.getText());

            double fromRate = EXCHANGE_RATES.get(fromCurrency);
            double toRate = EXCHANGE_RATES.get(toCurrency);

            double convertedAmount = amount * (toRate / fromRate);
            resultLabel.setText(String.format("%.2f %s", convertedAmount, toCurrency));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverter converter = new CurrencyConverter();
            converter.setVisible(true);
        });
    }
}
