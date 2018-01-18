package Match;


/**
 * Created by lior on 2/15/2017.
 */
public class Couple {

    //Fields
    Person person1;
    Person person2;
    double power; //Quality of the pair (result of multiplication). The probability of the couple to end up together
    boolean happy; //True if the couple will happily ever after

    public Couple (Person person1, Person person2)
            throws Exception{

        this.person1 = person1;
        this.person2 = person2;

        //Setting the power based on the persons
        //The grade of the first person on the second, and the second on the first.
        double grade1 = 0.0;
        double grade2 = 0.0;
        int size = person1.avTests.size();
        for (int i = 0; i < size; i++){
            grade1 += person1.weights[i] * person2.avTests.get(i);
            grade2 += person2.weights[i] * person1.avTests.get(i);
        }

        double maxScore = 7.0 * (double)size; //7 is the highest score for a single test entry

        power = (grade1 * grade2) / maxScore;

        //When initializing, the couple is yet to be happy
        this.happy = false;


    }

    /**
     * A method that checks if a couple is happy or want to move on.
     * Given a number of active couples, use random (temporary thing) method to set it, using
     * the "power" of the couple
     */

    boolean isHappy(){
        double random = Math.random(); //If a the random smaller
        if (random <= power){
            happy = true;
        }
        else{
            happy = false;
        }
        return happy;
    }

    //For testing
    double setFakePower(double d){
        power = d;
        return d;
    }
}
