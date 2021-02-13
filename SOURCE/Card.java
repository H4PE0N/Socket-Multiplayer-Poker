
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Card implements Serializable
{
  public String suit;
  public String value;

  public Card(String suit, String value)
  {
    this.suit = suit;
    this.value = value;
  }

  public void show()
  {
    System.out.printf("CARD: %s of %s\n", this.value, this.suit);
  }
}
