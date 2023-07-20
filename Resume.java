import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class resume extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextArea educationArea;
    private JTextArea experienceArea;

    public resume() {
        setTitle("Resume Builder");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel educationLabel = new JLabel("Education:");
        educationArea = new JTextArea();

        JLabel experienceLabel = new JLabel("Work Experience:");
        experienceArea = new JTextArea();

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(educationLabel);
        formPanel.add(educationArea);
        formPanel.add(experienceLabel);
        formPanel.add(experienceArea);

        add(formPanel, BorderLayout.CENTER);

        JButton generateButton = new JButton("Generate Resume");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateResume();
            }
        });

        add(generateButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void generateResume() {
        String name = nameField.getText();
        String email = emailField.getText();
        String education = educationArea.getText();
        String experience = experienceArea.getText();

        // Here, you can implement logic to generate the resume using the entered data.
        // For simplicity, let's just display the resume in a new window as a JTextArea.
        JTextArea resumeArea = new JTextArea();
        resumeArea.setText("Resume for " + name + "\n\n" +
                "Contact: " + email + "\n\n" +
                "Education:\n" + education + "\n\n" +
                "Work Experience:\n" + experience);

        JFrame resumeFrame = new JFrame("Generated Resume");
        resumeFrame.setSize(400, 400);
        resumeFrame.setLayout(new BorderLayout());
        resumeFrame.add(resumeArea, BorderLayout.CENTER);
        resumeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new resume();
            }
        });
    }
}

