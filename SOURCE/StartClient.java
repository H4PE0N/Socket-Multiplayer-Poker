
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartClient
{
  public static ServerInfo serverInfo;
  public static Client client;

  public static String username;

  public static JFrame window;
  public static JPanel panel;
  public static JTextField nameBox;
  public static JButton button;

  public static void main(String[] args) throws Exception
  {
    StartClient client = new StartClient();
  }

  public StartClient() throws Exception
  {
    client = new Client("127.0.0.1", 5555);
    client.startServerConnection();

    window = new JFrame();
    panel = new JPanel();

    window.setSize(960, 540);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.add(panel);

    panel.setLayout(null);

    nameBox = new JTextField(20);
    nameBox.setBounds(100, 20, 165, 25);
    panel.add(nameBox);

    button = new JButton();
    button.setBounds(10, 80, 80, 25);
    setUpButtonListeners();
    panel.add(button);

    window.setVisible(true);

    serverInfo = client.reciveServerInfo();
    System.out.println(serverInfo.getUsernamePlayer(nameBox.getText()).username);

    //client.closeServerConnection();
  }

  public void setUpButtonListeners() throws Exception
  {
    ActionListener buttonListener1 = new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        try
        {
          client.sendServerString(nameBox.getText());
        }
        catch(Exception exception)
        {
          System.out.println(exception);
        }
      }
    };
    button.addActionListener(buttonListener1);
  }
}
