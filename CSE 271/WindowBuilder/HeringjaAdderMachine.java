import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HeringjaAdderMachine extends JFrame {

    private JPanel contentPane;
    //Counting the current sum
    private int sum;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HeringjaAdderMachine frame = new HeringjaAdderMachine();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public HeringjaAdderMachine() {
        setBackground(Color.ORANGE);
        setTitle("Hering Adder Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("Sum : 0");
        contentPane.add(lblNewLabel, BorderLayout.WEST);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.EAST);
        panel.setLayout(new GridLayout(2, 2, 0, 0));
        
        JButton btnNewButton = new JButton("1");
        btnNewButton.setBackground(Color.CYAN);
        btnNewButton.addActionListener(e -> sum += 1);
        panel.add(btnNewButton);
        
        JButton btnNewButton_2 = new JButton("2");
        btnNewButton_2.setBackground(Color.CYAN);
        btnNewButton_2.addActionListener(e -> sum += 2);
        panel.add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("3");
        btnNewButton_1.setBackground(Color.CYAN);
        btnNewButton_1.addActionListener(e -> sum += 3);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_3 = new JButton("4");
        btnNewButton_3.setBackground(Color.CYAN);
        btnNewButton_3.addActionListener(e -> sum += 4);
        panel.add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("OK");
        btnNewButton_4.addActionListener(e -> lblNewLabel.setText("Sum" + sum));
        contentPane.add(btnNewButton_4, BorderLayout.SOUTH);
    }

}
