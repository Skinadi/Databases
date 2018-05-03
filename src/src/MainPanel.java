/**
 * Created by skinadi on 03.05.18.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener{

    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    private JButton loginButton;
    private JButton signinButton;

    MainFrame parent;
    public MainPanel(MainFrame parent) {
        this.parent = parent;
        loginButton = new JButton("Green");
        signinButton = new JButton("Blue");

        loginButton.addActionListener(this);
        signinButton.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(loginButton);
        add(signinButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == loginButton)
        {
            setBackground(Color.GREEN);
            parent.updatePanel(new LoginPanel());
        }

        else
        if(source == signinButton)
        {
            setBackground(Color.BLUE);
            parent.updatePanel(new SignInPanel());
        }

    }
}