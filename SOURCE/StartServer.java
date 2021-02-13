
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class StartServer
{
  public static void main(String[] args) throws Exception
  {
    String roomName = "ThisRoom420";
    int playerAmount = 1;
    int minimumBet = 5;
    int playerCapital = 500;

    Game game = new Game(roomName, playerAmount, playerCapital, minimumBet);


    game.startGame();
  }
}
