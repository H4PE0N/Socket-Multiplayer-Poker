
import java.net.*;
import java.io.*;
import java.util.*;

public class Server
{
  public int amount;
  private int port;
  public String name;

  private ServerSocket server;
  public Player players[];

  private InputStreamReader input;
  private BufferedReader reader;
  private PrintWriter writer;

  public Server(int port, String name, int amount) throws IOException
  {
    this.amount = amount;
    this.port = port;
    this.name = name;

    server = new ServerSocket(port);
    players = acceptConnectingClients();
  }

  public Player[] acceptConnectingClients() throws IOException
  {
    Player players[] = new Player[amount];
    for(int index = 0; index < amount; index = index + 1)
    {
      Player player = new Player();
      player.socket = server.accept();
      players[index] = player;
    }
    return players;
  }

  public String reciveFromPlayer(Player player) throws IOException
  {
    Socket socket = player.socket;
    input = new InputStreamReader(socket.getInputStream());
    reader = new BufferedReader(input);
    return reader.readLine();
  }

  public void sendToPlayer(Player player, String string) throws IOException
  {
    Socket socket = player.socket;
    writer = new PrintWriter(socket.getOutputStream());
    writer.println(string);
    writer.flush();
  }
}
