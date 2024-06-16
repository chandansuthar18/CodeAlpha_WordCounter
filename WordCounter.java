package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel wordCountLabel;
    private JLabel creatorLabel;

    public WordCounter() {
        // Set up the frame
        setTitle("Word Counter");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create components
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        wordCountLabel = new JLabel("Word Count: 0");
        creatorLabel = new JLabel("Created by Chandan Kumar, Project by Code Alpha", JLabel.CENTER);

        // Set fonts and colors
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        countButton.setFont(new Font("Arial", Font.BOLD, 16));
        wordCountLabel.setFont(new Font("Arial", Font.BOLD, 18));
        creatorLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        countButton.setBackground(new Color(70, 130, 180)); // Steel blue
        countButton.setForeground(Color.WHITE);
        wordCountLabel.setForeground(new Color(25, 25, 112)); // Midnight blue
        creatorLabel.setForeground(new Color(105, 105, 105)); // Dim gray

        // Add padding and border to text area
        textArea.setBorder(BorderFactory.createCompoundBorder(
                textArea.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Panel for buttons and labels
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(countButton, BorderLayout.CENTER);
        bottomPanel.add(creatorLabel, BorderLayout.SOUTH);

        // Add components to the frame
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(wordCountLabel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounter().setVisible(true);
            }
        });
    }
}
