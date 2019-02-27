import java.util.Scanner;

public static void main(String[] args) {

  System.out.println("Please input your name.")
  Scanner keyboard = new Scanner(System.in);
  String playerName = keyboard.nextString();

  Player1 = new Player(playerName);

  Enemy1Deck = new Deck();
  for (int i = 1; i <= 4; x++)
  {
    Enemy1Deck.deck.add(new Card("Slash", 1, 6, 0, 0));
    Enemy1Deck.deck.add(new Card("Guard", 1, 0, 5, 0));
    Enemy1Deck.deck.add(new Card("Claw", 1, 3, 3, 0))
  }

  Enemy2Deck = new Deck();
  for (int i = 1; i <= 3; x++)
  {
    Enemy2Deck.deck.add(new Card("Slash", 1, 6, 0, 0));
    Enemy2Deck.deck.add(new Card("Guard", 1, 0, 5, 0));
    Enemy2Deck.deck.add(new Card("Fireball", 2, 13, 0, 0))
    Enemy2Deck.deck.add(new Card("Ice Block", 2, 0, 11, 0))
  }
}
