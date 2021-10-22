import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ui extends JFrame {

    private boolean activo=false;
    private Controller controller=new Controller(this);

    JButton mButton;
    JTextField mTextBox;

    public Ui(){
        super("Baila Ratón");
        setSize(225,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // Panel
        JPanel mPanel = new JPanel();

        // Button
        this.mButton=new JButton("Iniciar");

        // Textbox
        this.mTextBox = new JTextField();
        mTextBox.setColumns(4);

        // Label
        JLabel mLabel = new JLabel();
        mLabel.setText("<html>Introduce el intervalo de<br> actualización en segundos.</html>");
        mLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add componets to panel
        mPanel.add(mLabel);
        mPanel.add(mTextBox);
        mPanel.add(mButton);

        // Add panel to frame
        add(mPanel);

        // Show frame
        setVisible(true);

        // Call Controller on click button (pass textbox value)
        mButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.action(mTextBox.getText());
            }
        });
    }

    public void setTextButton(String text){
        mButton.setText(text);
    }

    public void setTextBox(String text){
        mTextBox.setText(text);
    }
}
