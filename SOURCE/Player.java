
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

// System.out.printf("[PLAYER]: \n");

public class Player implements Serializable
{
  public int capital;
  public String username;
  public String role;
  public Action action;
  public ArrayList<Card> hand = new ArrayList<Card>();

  public Player(String username, int capital)
  {
    this.username = username;
    this.capital = capital;
  }

  public int getcapital()
  {
    System.out.printf("[PLAYER]: RETURNING PLAYER CAPITAL: (%d)\n", this.capital);
    return this.capital;
  }

  public void setcapital(int capital)
  {
    this.capital = capital;
    System.out.printf("[PLAYER]: UPDATED PLAYER CAPITAL: (%d)\n", this.capital);
  }





  public String getUsername()
  {
    System.out.printf("[PLAYER]: RETURNING PLAYER USERNAME: (%s)\n", this.username);
    return this.username;
  }

  public void setUsername(String username)
  {
    this.username = username;
    System.out.printf("[PLAYER]: UPDATED PLAYER USERNAME: (%s)\n", this.username);
  }

}
