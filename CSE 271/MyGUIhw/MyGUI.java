import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyGUI {

    private static JLabel output;
    private static JTextField textField1;
    private static JTextField textField2;
    private static JButton button1;
    private static JButton button2;

    public static void main(String[] args) {
        // creates a frame object
        JFrame frame = new JFrame();

        // set a title for the frame
        frame.setTitle("Loan Payment Calculator");
        // set a size for the frame (width, height)
        frame.setSize(420, 420);

        // exit out of application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // prevent the frame from being resized
        frame.setResizable(false);

        // clear the layout. No Panel
        frame.setLayout(null);

        // defining a new Color object
        Color color = new Color(20, 20, 20);
        frame.getContentPane().setBackground(color);

        // ******* ADDING Label *******
        JLabel label1 = new JLabel();
        // x, y, width, height
        label1.setBounds(10, 20, 100, 20);
        label1.setText("Loan Amount");
        label1.setForeground(new Color(65, 105, 225));

        JLabel label2 = new JLabel();
        label2.setBounds(10, 70, 100, 20);
        label2.setText("Interest Rate");
        label2.setForeground(new Color(65, 105, 225));

        output = new JLabel();
        output.setBounds(140, 220, 220, 50);
        // change the color of the text
        output.setForeground(Color.WHITE);
        output.setText("");

        // ******* ADDING TextField *******
        textField1 = new JTextField();
        textField1.setBounds(150, 10, 150, 40);
        textField1.setText("");

        textField2 = new JTextField();
        textField2.setBounds(150, 60, 150, 40);
        textField2.setText("");

        // ******* ADDING Button *******
        button1 = new JButton();
        button1.setBounds(140, 150, 80, 50);
        button1.setText("print");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(
                        "Your monthly payment is: "
                                + paymentCalc(textField1, textField2));
                button2.setEnabled(true);
                button1.setEnabled(false);
            }

        });

        button2 = new JButton();
        button2.setText("clear");
        button2.setBounds(220, 150, 80, 50);
        button2.setEnabled(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
                button1.setEnabled(true);
                button2.setEnabled(false);
                textField1.setText("");
                textField2.setText("");
            }

        });

        // showing the frame
        frame.setVisible(true);

        // adding the label to the frame
        frame.add(label1);
        frame.add(label2);
        frame.add(output);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(button1);
        frame.add(button2);

    }

    public static String paymentCalc(JTextField loan, JTextField interest) {
        double res = (double) ((Long.parseLong(loan.getText())
                * (1 + (Integer.parseInt(interest.getText()) / 100.0))) / 12);
        return String.format("%.2f", res);
    }

}
