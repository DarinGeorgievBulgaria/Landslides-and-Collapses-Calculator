import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFrame extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JTextField textField;
    private JButton button;
    private JPanel panel;
    private String inputNum;
    NewFrame(){
        this.setTitle("Landslides and collapses");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,300);

        panel = new JPanel();

        textArea = new JTextArea();
        //labelMain.setHorizontalAlignment(JLabel.CENTER);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("SansSerif", Font.PLAIN,20));
        textArea.setPreferredSize(new Dimension(450,200));
        textArea.setAlignmentX(SwingConstants.CENTER);

        textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(150,30));
        textField.setHorizontalAlignment(JTextField.CENTER);

        button = new JButton("Submit");
        button.addActionListener(this);

        panel.add(textArea);
        panel.add(textField);
        panel.add(button);
        this.getContentPane().add(panel);
        this.setVisible(true);

    }
    public JTextArea getTextArea(){
        return textArea;
    }
    public JTextField getTextField(){
        return textField;
    }
    public JButton getButton(){
        return button;
    }
    public String getInputNum(){
        return inputNum;
    }
    public void setInputNum(String inputNum){
        this.inputNum = inputNum;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            inputNum = textField.getText();
            textField.setText("");
        }
    }
}