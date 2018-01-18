package Match;

import java.util.ArrayList;

/**
 * Created by lior on 2/5/2017.
 */
public class Pair {

    //Fields
    Person person1;
    Person person2;
    double power; //Quality of the pair (result of multiplication). The probability of the couple to end up together
    boolean isExhausted; //True if the pair already tried (or trying) to connect

    public Pair (Person person1, Person person2)
            throws Exception{

        this.person1 = person1;
        this.person2 = person2;

        //Setting the power based on the persons
        //The grade of the first person on the second, and the second on the first.
        double grade1 = 0.0;
        double grade2 = 0.0;
        for (int i = 0; i < person1.avTests.size(); i++){
            grade1 += person1.weights[i] * person2.avTests.get(i);
            grade2 += person2.weights[i] * person1.avTests.get(i);
        }

        power = grade1 * grade2;



    }

  /*  static double match (ArrayList<Couple> couples, int k, ArrayList<String> busyList){

        //Skipping the unavailable couples (for me: try to add optimization using modulo)
        Couple currFirstCouple = couples.get(0);
        while (busyList.contains(currFirstCouple.person1.id) ||
                busyList.contains(currFirstCouple.person2.id)){
            couples.remove(0); //Removing that busy couple

            if (couples.size() == 0){
                return -1.0;
            }
            else{
                currFirstCouple = couples.get(0); //New first couple
            }
        }

        //Base case
        //If k==1, take the most powerful free couple (for me: for now it's always the first one)
        if (k <= couples.size() && k == 1){
            return currFirstCouple.power;
        }
        //If the number of yet to be chosen couples are greater than the number of couples
        else if (k > couples.size()){
            return -1.0;
        }

        //for me: now the recursion begins
        else{
            ArrayList<String> busyUpdatedList = copyStringArr(busyList); //A copy for busyList for changes ahead
            busyUpdatedList.add(currFirstCouple.person1.id);
            busyUpdatedList.add(currFirstCouple.person2.id);
            couples.remove(0);//Removing the first couple -for me: make sure it does that
            ArrayList<Couple> originalCouples = copyCoupleArr(couples); //Making copy of couples for later use



            return Math.max(currFirstCouple.power + match(couples, k - 1, busyUpdatedList),
                    match(originalCouples, k, busyList)); //Possible that couples is changed inside the method?
        }*/

    //Setters
    private void setIsExhausted (boolean isExhausted){
        this.isExhausted = isExhausted;
    }


}
