import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    List <JButton> buttonsList;
    JButton addfriend;
    JButton logout;
    UserPanel(MainFrame parent,User user)
    {
        this.parent=parent;
        this.user=user;
        friendList = new ArrayList<>();
        buttonsList = new ArrayList<>();
        getfriends();
        addfriend = new JButton("Add friend");
        logout = new JButton("Logout");
        addfriend.addActionListener(this);
        logout.addActionListener(this);


        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        create();
        //this.add(logout);
        //this.add(addfriend);

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
                buttonsList.add(new JButton("Rozlicz się z: " + rs.getString("name")));
            }
        }catch (SQLException s){System.out.println("OJEJ");}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source==addfriend)
        {

        }
        else
        if(source==logout)
        {
            friendList.clear();
            buttonsList.clear();
            parent.updatePanel(new LoginPanel(parent));
        }
        else
        for(int i = 0; i<buttonsList.size();i++)
        {
            if(source==buttonsList.get(i)) //users
            {

            }
        }

    }
    public void create()
    {
        JPanel friendspanel = new JPanel();
        friendspanel.setLayout(new GridLayout(buttonsList.size()+1,2));
        JLabel name;
        for(int i = 0; i<buttonsList.size();i++)
        {
            name=new JLabel(friendList.get(i).forname);
            friendspanel.add(name);
            friendspanel.add(buttonsList.get(i));
            buttonsList.get(i).addActionListener(this);
        }
        friendspanel.add(logout);
        friendspanel.add(addfriend);

        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(friendspanel, BorderLayout.CENTER);

        this.add(parentPanel);
    }
}
