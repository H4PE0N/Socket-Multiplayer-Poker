import java.net.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Server
{
  private static int amount;
  private static ServerSocket server;
  private static Player players[];
  private static int port;
  private static InputStreamReader input;
  private static BufferedReader reader;
  private static PrintWriter writer;

  public static void main(String[] args) throws IOException
  {
    // CREATING THE SERVER AND SETTING UP VARIABLES
    amount = 1;
    port = 5555;
    players = new Player[amount];
    server = new ServerSocket(port);

    // ACCEPTING ALL PLAYERS AND STORE THEM IN ARRAY
    for(int index = 0; index < amount; index = index + 1)
    {
      Player player = new Player();
      player.socket = server.accept();
      players[index] = player;
    }

    // READING PLAYERS NAMES
    for(int index = 0; index < amount; index = index + 1)
    {
      Player player = players[index];
      Socket socket = player.socket;

      input = new InputStreamReader(socket.getInputStream());
      writer = new PrintWriter(socket.getOutputStream());
      reader = new BufferedReader(input);

      String string = reader.readLine();
      System.out.printf("Clients name is %s\n", string);

      writer.printf("Welcome to the server %s\n", string);
      writer.flush();
    }
  }
}

class Player
{
  public Socket socket;
  public String name;
  public String cards;
  public int capital;
}
