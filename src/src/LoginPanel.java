/**
 * Created by skinadi on 03.05.18.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPanel extends JPanel implements ActionListener{

    public static final int HEIGHT = 200;
    public static final int WIDTH = 300;
    private JButton signin;
    private JButton back;

    private JTextField nameField;
    private JPasswordField passField;


    MainFrame parent;
    public LoginPanel(MainFrame parent) {
        this.parent=parent;
        signin = new JButton("Sign in");
        back = new JButton("Back");

        signin.addActionListener(this);
        back.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        create();
        //add(signin);
        //add(back);
    }

    public String getPassword() {
        String password = "";
        char[] pass = passField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }

    public String getname(JTextField field)
    {
        return field.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == signin)
        {
            try{
                ConnectionManager.exist.setString(1,getname(nameField));
                ConnectionManager.exist.setString(2,getPassword());
                ResultSet rs = ConnectionManager.exist.executeQuery();
                if(rs.next())
                {
                    User user = new User(rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("surname"));
                    parent.updatePanel(new UserPanel(parent,user));
                    System.out.println("Logowanie poprawne");
                }
                else
                    System.out.println("Nie udało się zalogować");
            }catch (SQLException s){System.out.print("OJEJ");}
        }

        else
        if(source == back)
        {
            parent.updatePanel(new MainPanel(parent));
        }

    }
    void create()
    {
        JLabel name = new JLabel("Login: ");
        JLabel password = new JLabel("Password: ");
        nameField = new JTextField();
        passField = new JPasswordField();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(name);
        inputPanel.add(nameField);
        inputPanel.add(password);
        inputPanel.add(passField);
        inputPanel.add(back);
        inputPanel.add(signin);

        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);

        this.add(parentPanel);

    }
}