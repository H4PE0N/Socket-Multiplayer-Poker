
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientStart
{

  public JFrame frame;
  public JPanel panel;
  public String title;

  public static void main(String[] args) throws IOException
  {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("input name: ");
    String name = scanner.nextLine();

    Client client = new Client("localhost", 5555, name);

    String string = client.reciveFromServer();
    System.out.printf("SERVER: %s\n", string);

    // frame = new JFrame();
    // panel = new JPanel();
    // title = "Socket-Multiplayer-Poker"
    //
    // frame.setSize(960, 540);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setTitle(title);
    // frame.add(panel);
    // panel.setLayout(null);
    //
    // try
    // {
    //   connectToServer();
    // }
    // catch (IOException exception)
    // {
    //   exception.printStackTrace();
    // }
    //
    // frame.setVisible(true);
  }
}
