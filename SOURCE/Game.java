
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Game
{
  public ServerInfo serverInfo;
  public Server server;
  public int playerCapital;

  public Game(String roomName, int playerAmount, int playerCapital, int minimumBet) throws Exception
  {
    this.serverInfo = new ServerInfo(roomName, playerAmount, minimumBet);
    this.server = new Server(5555);
    this.playerCapital = playerCapital;
  }

  public void acceptPokerPlayers() throws Exception
  {
    for(int index = 0; index < this.serverInfo.playerAmount; index = index + 1)
    {
      String username = this.server.acceptConnectingClient();
      this.serverInfo.players.add(new Player(username, this.playerCapital));
    }
    this.serverInfo.actionPlayer = this.serverInfo.players.get(0).username;
  }

  public void startGame() throws Exception
  {
    this.acceptPokerPlayers();
    this.dealPlayersHand();

    for(Player player : this.serverInfo.players)
    {
      this.server.sendUsernameInformation(player.username, this.serverInfo);
    }
    System.out.println("Press enter to continue");
    try
    {
      System.in.read();
    }
    catch(Exception e)
    {
      
    }
    //this.server.server.close();
  }

  public void dealPlayersHand() throws Exception
  {
    for(Player player : this.serverInfo.players)
    {
      player.hand = this.serverInfo.deck.drawMultipleCards(2);
    }
  }

  // public Game(String roomName, int playerAmount, int bigBlind) throws Exception
  // {
  //   this.info = new Information(roomName, playerAmount, bigBlind);
  //
  //   this.server = new Server("127.0.0.1", 5555);
  //
  //   this.server.startServerSocket();
  //
  //   this.acceptPlayers();
  //
  //   this.getNameFromPlayers();
  // }
  //
  // public void acceptPlayers() throws Exception
  // {
  //   for(int index = 0; index < this.info.playerAmount; index = index + 1)
  //   {
  //     Player player = new Player();
  //     player.socket = server.acceptConnectingClient();
  //     player.playerCapital = 500; // Change later!
  //     this.info.players.add(player);
  //   }
  // }
  //
  // public void getNameFromPlayers() throws Exception
  // {
  //   for(Player player : this.info.players)
  //   {
  //     player.username = this.server.reciveClientString(player.socket);
  //   }
  // }
  //
  // public void sendPlayersInformation() throws Exception
  // {
  //   for(Player player : this.info.players)
  //   {
  //     this.server.sendClientInfo(player.socket, this.info);
  //   }
  // }
}
