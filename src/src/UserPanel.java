import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by skinadi on 03.05.18.
 */
public class UserPanel extends JPanel implements ActionListener {

    public static final int HEIGHT = 200;
    public static final int WIDTH = 300;
    MainFrame parent;
    User user;
    List <User> friendList;
    JButton addfriend;
    UserPanel(MainFrame parent,User user)
    {
        this.parent=parent;
        this.user=user;
        getfriends();
        addfriend = new JButton("Add friend");

        addfriend.addActionListener(this);


        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    void getfriends()
    {
        try{
            ConnectionManager.getfriends.setString(1,user.login);
            ResultSet rs = ConnectionManager.getfriends.executeQuery();
            while (rs.next())
            {
                friendList.add(new User(
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("surname")));
            }
        }catch (SQLException s){System.out.println("OJEJ");}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source==addfriend)
        {

        }

    }
}
