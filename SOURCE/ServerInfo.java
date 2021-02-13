
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ServerInfo implements Serializable
{
  public String roomName;
  public int minimumBet;
  public int playerAmount;
  public int roundPot = 0;
  public Board board = new Board();
  public int roundStage = 0;
  public ArrayList<Player> players = new ArrayList<Player>();
  public String actionPlayer;
  public Deck deck = new Deck();

  public ServerInfo(String roomName, int playerAmount, int minimumBet)
  {
    this.roomName = roomName;
    this.playerAmount = playerAmount;
    this.minimumBet = minimumBet;
  }

  public Player getUsernamePlayer(String username)
  {
    for(Player player : this.players)
    {
      if(player.username.equals(username))
      {
        return player;
      }
    }
    return null;
  }
}
