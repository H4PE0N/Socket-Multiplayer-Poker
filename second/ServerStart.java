
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerStart
{
  public static void main(String[] args) throws IOException
  {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("input room name: ");
    String roomName = scanner.nextLine();

    Server server = new Server(5555, roomName, 1);

    for(Player player : server.players)
    {
      String name = server.reciveFromPlayer(player);
      server.sendToPlayer(player, name);
    }
  }
}
