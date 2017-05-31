/* 
 * This programs allows you to see the Birthday Problem/Birthday Paradox
 * in action. It will keep generating 23 birthday's randomly until
 * it generates a group of birthdays that have the a repeating date.
 * This allows you to see how easily two people can share the same birthday.
 *
 * More information on the Birthday Problem: https://en.wikipedia.org/wiki/Birthday_problem 
 * Version: 0.1
 *
 * Created by: Samsore Shams
 */
import java.util.Random;
import java.util.Arrays;

public class BirthdayParadox{
  public static int location1 = 0;
  public static int location2 = 0;

  public static void main(String[] args)
  {
    int numPeople = 23; //change this to change number of people
    boolean noRepeatingBirthday = true; 
    int total = 0;
    int[] people = new int[numPeople];
    
    //Keep generating groups of birthdays until you get one that has a repeating birthday.
    while(noRepeatingBirthday)
    {
      total++;
      people = generate(numPeople); //generate the birthdays of all the people
      noRepeatingBirthday = verifyRepeatingBirthday(people);
      if (noRepeatingBirthday == true)
        System.out.println("No repeating birthday in this group: " + Arrays.toString(people) +"\n");
    }
    
    System.out.println("Birthday's of the " + numPeople + " people: " + Arrays.toString(people));
    System.out.println("Array Location was: " + location1 + " and " + location2);
    System.out.println("Birthday that appears twice : " + people[location1]);
  }
  
  //Generates an array of "numPeople" ammount of birthdays randomly
  public static int[] generate(int numPeople)
  {
    int[] people = new int[numPeople];
    for (int i = 0; i< numPeople; i++)
    {
      Random rand = new Random();
      int randomNum = rand.nextInt((365 - 1) + 1) + 1;
      people[i] = randomNum;
    }
    
    return people;
  }
  
  //Checks if a birthday is repeated.
  public static boolean verifyRepeatingBirthday(int[] people)
  {
    boolean check = false;
    int temp = 0;
    
    for (int i = 0; i < people.length-1 ; i++){
      for (int j = i+1; j < people.length; j++){
        if (people[i] == people[j]){
          location1 = i;
          location2 = j;
          return false;
        }
      }
    }
    return true;
  }
}