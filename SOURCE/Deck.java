
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Deck implements Serializable
{
  public Deck()
  {
    this.generateDeck();
    this.shuffleCardDeck();
  }

  public ArrayList<Card> deck;

  public String suits[] = {"heart", "clubs", "diamond", "spade"};
  public String values[] = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};

  public void generateDeck()
  {
    this.deck = new ArrayList<>();
    for(String suit : this.suits)
    {
      for(String value : this.values)
      {
        this.deck.add(new Card(suit, value));
      }
    }
  }

  public ArrayList<Card> drawMultipleCards(int amount)
  {
    ArrayList<Card> cards = new ArrayList<Card>();
    for(int index = 0; index < amount; index = index + 1)
    {
      cards.add(this.drawFromDeck());
    }
    return cards;
  }

  public Card drawFromDeck()
  {
    Card card = this.deck.get(0);
    this.deck.remove(0);
    return card;
  }

  public void shuffleCardDeck()
  {
    for(int index = 0; index < this.deck.size(); index = index + 1)
    {
      int randomIndex = (int) (Math.random() * this.deck.size());

      Card temp = this.deck.get(index);
      this.deck.set(index, this.deck.get(randomIndex));
      this.deck.set(randomIndex, temp);
    }
  }
}
