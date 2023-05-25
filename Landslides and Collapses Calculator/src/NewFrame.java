import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

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

    public void restartProgram(NewFrame frame, String text) throws InterruptedException {
        frame.getTextArea().setText(text);
        for(int i=5; i>-1;i--){
            Thread.sleep(1000);
            frame.getTextArea().append(i+"\n");
        }
        frame.dispose();
        Main.main(null);
    }
    public String getInput() throws InterruptedException {
        while(true){
            if(inputNum != null){
                break;
            }
            else{
                Thread.sleep(500);
                System.out.println("Waiting for input");
            }
        }
        return inputNum;
    }
    public int getRealNum(){
        int returnRealNum;
        while (true){
            try{
                returnRealNum = Integer.parseInt(getInput());
            }catch (InputMismatchException | NumberFormatException | InterruptedException  e){
                System.out.println("Please use a natural number1.");
                JOptionPane.showMessageDialog(this,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                this.setInputNum(null);
                continue;
            }

            if(returnRealNum >= 0){
                this.setInputNum(null);
                break;
            }
            else{
                System.out.println("Please use a natural number.");
                JOptionPane.showMessageDialog(this,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                this.setInputNum(null);
            }
        }
        return returnRealNum;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            inputNum = textField.getText();
            textField.setText("");
        }
    }
}
