import java.util.*;

public class main02{

  public static void main(String[] args) {
    Scanner user = new Scanner(System.in);
    System.out.println("Please Enter Your Character Name:");
    String name = user.nextLine();

    System.out.println("Name: "+name+"\nRace: "+RaceGen()+"\nClass: "+ClassGen());

    System.out.println("Would you like to roll for abilities? [y/n]");

    int abilityCounter = 1;
    if(user.next().equals("y"))
    {
      System.out.println("What ability would you like to roll for? ");
      while(user.hasNext())
      {

        String ability = user.next();
        System.out.println(ability + " score: " + AbilityGen());
        if(abilityCounter < 7)
        {
          System.out.println("Would you like to roll again? [y/n]");
          if(user.next().equals("n"))
          {
            return;
          }
          else
            System.out.println("What ability would you like to roll for?");
        }
        else
        {
          System.out.println("");
        }



      }
    }
    System.out.println("What ability would you like to roll for? \n");
    String ability = user.next();
    System.out.println(ability + " score: " + AbilityGen());
  }

  public static String ClassGen()
  {
    String[] classList = {"Barbarian","Bard","Cleric","Druid","Fighter","Monk","Paladin","Ranger","Rogue","Sorcerer","Warlock","Wizard"};
    int output = RandomNum(0,11);
    return classList[output];
  }

  public static String RaceGen()
  {
    String[] raceList = {"Dwarf","Elf","Gnome","Orc","Human","Giant","Goblin","Centaur","Ogre"};
    int output = RandomNum(0,8);
    return raceList[output];
  }

  public static int AbilityGen()
  {
    int highestRoll = 0;
    int[] diceRolls = new int[4];
    for(int i=0; i<4; i++)
    {
      diceRolls[i] = RandomNum(1,6);
    }

    int tempChange = 0;
    for(int i=3; i>0; i--)
    {
      if(diceRolls[i]>diceRolls[i-1])
      {
        tempChange=diceRolls[i-1];
        diceRolls[i-1] = diceRolls[i];
        diceRolls[i] = tempChange;
      }
    }

    int abilityScore = 0;
    for(int i=0; i<3; i++)
    {
      abilityScore += diceRolls[i];
    }

    return abilityScore;
  }

  public static int RandomNum(int min, int max)
  {
    return (int)(Math.random() * ((max - min)) + min);
  }
}
