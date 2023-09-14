package GUI;

import comp_decomp.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setTitle("Compressor and Decompressor");
        this.setLayout(null);
        this.setSize(800, 500);
        this.getContentPane().setBackground(Color.PINK);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(110, 200, 200, 50);
        compressButton.setBackground(Color.BLACK);
        compressButton.setForeground(Color.WHITE);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(470, 200, 200, 50);
        decompressButton.setBackground(Color.BLACK);
        decompressButton.setForeground(Color.WHITE);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser("C:");
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    compressor.method(file);
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }

        if (actionEvent.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser("C:");
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    decompressor.method(file);
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}
