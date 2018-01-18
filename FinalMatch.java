package Match;

import java.util.ArrayList;

/**
 * Created by lior on 2/19/2017.
 */
public class FinalMatch {

    /**
     * Given a list of couples, match until the list is empty. Every round use match
     * method. Then check for every couple if they're happy. If yes, great, keep them
     * in the happy list. if not, pull that couple out of the busy list and continue
     * (and they're already out of the couples list).
     * In every round, k is reduced by the number of successful couples.
     */

//for me: we start with a k, we can change it using a method given couples calc the k
    public static ArrayList<Couple> finalMatch(ArrayList<Couple> couples, int k,
                                               ArrayList<Couple> happyCouples){


        //Base case, if we already found k happy couples or we went over all the couples
        if (k == 0 || couples.size() == 0){
            return happyCouples;
        }

        // We enter another round
        else{
            ArrayList<Couple> copyCouples = Dynamic.copyCoupleArr(couples);

            // for me: added a copy for happyCouples to see if it solves a problem
            ArrayList<Couple> happyCopy = Dynamic.copyCoupleArr(happyCouples);

            int copyK = k;
            //ArrayList<Couple> cleanList = new ArrayList<>();
            ListOfCouples list = new ListOfCouples();
            //The current match from the given couples
            ArrayList<Couple> copyCouples2 = Dynamic.copyCoupleArr(couples);
            ListOfCouples currentMatch = Dynamic.match(copyCouples2, k, list);
            //The number of happy couples in this round
            int toBeReduced = 0;
            // For each couple remove it from the yet to try couples (couples) and
            // if the couple is happy with the match add to happyCouples list
            // and update the toBeReduced int that we later subtract from k.

            System.out.println("The matched couples are: ");
            for (Couple couple : currentMatch.list){
                System.out.println(couple.person1.id + " and " + couple.person2.id);


                //For each couple that was matched,remove from the yet to try
                copyCouples.remove(couple);
                //The condition for if a couple is happily ever after using the random method
                if (couple.isHappy()){
                    //Removing from the couples list all the couples that contain one of the persons
                    //cleanList = removeNotUsableCouples(couple, cleanList);
                    happyCopy.add(couple); // Add them to the happy couples list
                    toBeReduced++;
                }

            }
            // Creating the clean list
            System.out.println("copy couples size is: " + copyCouples.size());
            System.out.println("happy matches are: " + happyCopy.size());
            ArrayList<Couple> cleanList = removeNotUsableCouples(happyCopy, copyCouples);

            System.out.println("clean list size is: " + cleanList.size());

            return finalMatch(cleanList, copyK - toBeReduced, happyCopy);
        }

    }

    /** A helper method. Given a couple and a list of couples,
    // removing the couples that contain one of the persons in that couple
     */
     static ArrayList<Couple> removeNotUsableCouples(ArrayList<Couple> happyCouples,
                                                            ArrayList<Couple> list){
        int size = list.size();
        ArrayList<Couple> resList = Dynamic.copyCoupleArr(list); //Copy for not damage the for loop


        if (size == 0 || happyCouples.size() == 0){
            return list;
        }

        else{

            for (Couple happyCouple : happyCouples){
                for (int i = 0; i < size; i++){
                    Couple currCouple = list.get(i);
                    Person person1 = currCouple.person1;
                    Person person2 = currCouple.person2;
                    if (person1.id == happyCouple.person1.id || person2.id == happyCouple.person2.id){
                        resList.remove(currCouple);
                    }
                }
            }
        }

         return  resList;

    }

    // New version of finalMatch
    static ListOfCouples finalMatch2(ListOfCouples couples){
        ListOfCouples res = new ListOfCouples();
        return helper(couples, res);
    }

    // A helper method for finalMatch above
    static ListOfCouples helper(ListOfCouples couples, ListOfCouples res) {

        // Clone the couples for later use
        ListOfCouples copyCouples = couples.cloneIt();

        // Base case
        if (couples.list.size() == 0) {
            return res;
        }

        // The recursion
        else {
            // Currently matched couples
            ListOfCouples matched = Dynamic.match2(couples);
            for (Couple currMatch : matched.list) {
                copyCouples.list.remove(currMatch);
                if (currMatch.isHappy()) {
                    res.list.add(currMatch);
                    copyCouples.clear(currMatch);
                }
            }
        }
        return helper(copyCouples, res);
    }
}
