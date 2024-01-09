import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;
    private JLabel paragraphCountLabel;

    public WordCounterApp() {
        setTitle("Word Counter App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //  Here, we need to create components
        textArea = new JTextArea();
        JButton countButton = new JButton("Count Words");
        wordCountLabel = new JLabel("Word Count: ");
        charCountLabel = new JLabel("Character Count: ");
        paragraphCountLabel = new JLabel("Paragraph Count: ");

        // Additionally, the layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add components to the frame
        add(new JScrollPane(textArea));
        add(countButton);
        add(wordCountLabel);
        add(charCountLabel);
        add(paragraphCountLabel);

        // Count button action listener
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }
    private void countWords() {
        String text = textArea.getText();
        int wordCount = text.split("\\s+").length;
        int charCount = text.length();
        int paragraphCount = text.split("\n\n").length;
        // Update labels
        wordCountLabel.setText("Word Count: " + wordCount);
        charCountLabel.setText("Character Count: " + charCount);
        paragraphCountLabel.setText("Paragraph Count: " + paragraphCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordCounterApp app = new WordCounterApp();
                app.setVisible(true);
            }
        });
    }
}
