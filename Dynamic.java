package Match;

import java.util.ArrayList;

/**
 * Created by lior on 2/15/2017.
 */
public class Dynamic {

    ArrayList<Couple> kLoveBirds = new ArrayList<>();

    /** I will have an array of couples. Given n Couple we need to find the k couples with the most expected successes.
     * There are situations when couples are not active for a certain round because one of the
     * persons is "connecting" with another one. We're going to keep track of that by
     * saving a list of couples that are currently busy.
     */

    //Start will be root of n, since we're sealing for now with even number of groups
    //(lets say man and woman) and the number of couples will always be (group size)**2


    //for me: need to sort the couples before
    //for me: is there a way to mark all couples contain a certain person when
    // when this person is selected??

    /**
     * A recursive method (using dynamic programming). We are going to to get the
     * k couple with the highest overall successes by going through every couple
     * (recursively) and check if the max is with or without him
     * All the parameters: fill!
     *
     * @param couples is the list of single couples
     * @param k       is the number of matches we want to get
     * @param list    is the list of matched couples
     */
    static ListOfCouples match(ArrayList<Couple> couples, int k, ListOfCouples list) {

        //If the couples list is empty or k == 0, we are done
        if (couples.size() == 0 || k == 0) {
            return list;
        }

        //If the number of yet to be chosen couples are greater than the number of couples
        if (k > couples.size()) {
            ListOfCouples emptyList = new ListOfCouples();
            emptyList.setExpected(-100.0);
            return emptyList;
        }

        //Recursion
        else {

            //Skipping the unavailable couples (for me: try to add optimization using modulo)
            Couple currFirstCouple = couples.get(0);
            while (list.isContain(currFirstCouple.person1) || list.isContain(currFirstCouple.person2)) {
                couples.remove(0); //Removing that busy couple

                if (couples.size() == 0) {
                    ListOfCouples emptyList = new ListOfCouples(); //An empty list of couples, for me: is the logic right?
                    emptyList.setExpected(-100.0);
                    return emptyList;
                } else {
                    currFirstCouple = couples.get(0); //New first couple
                }
            }

            ListOfCouples newList = list.cloneIt(); // A clone of the current list of active couples
            newList.addCouple(currFirstCouple); // Adding the current couple to the cloned list
            couples.remove(0);//Removing the first couple -for me: make sure it does that
            ArrayList<Couple> originalCouples = copyCoupleArr(couples); //Making copy of couples for later use

            // Include the current couple
            ListOfCouples included = match(couples, k - 1, newList);
            // Not included
            ListOfCouples notIncluded = match(originalCouples, k, list);

            if (included.es >= notIncluded.es) {
                return included;
            } else {
                return notIncluded;
            }
        }
    }

    //A helper function to copy an ArrayList
    static ArrayList<Couple> copyCoupleArr(ArrayList<Couple> arr) {
        ArrayList<Couple> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            res.add(arr.get(i));
        }
        return res;
    }


    // The new version of match:

    static ListOfCouples match2(ListOfCouples couples) {

        //Initializing a helper method that contains also the initialize listOfCouples that will be the res
        ListOfCouples res = new ListOfCouples();
        return helper(couples, res);
    }

    // The helper method
    static ListOfCouples helper(ListOfCouples couples, ListOfCouples res) {

        // Base case: if the couples list is empty we are done
        if (couples.list.size() == 0) {
            return res;
        }

        // Recursion
        else {

            // Looking for the first available couple in couples
            Couple curr = couples.list.get(0);
            while (res.isContain(curr.person1) || res.isContain(curr.person2)) {
                // Removing the unavailable couple
                couples.list.remove(curr);
                // If we went through all the elements in the list of couples we are done
                if (couples.list.size() == 0){
                    return res;
                }
                else{
                    // Else take the next couple
                    curr = couples.list.get(0);
                }

            }

            // Removing the curr from the couples list and clone the two lists for later use
            couples.list.remove(curr);
            ListOfCouples copyCouples = couples.cloneIt();
            ListOfCouples copyRes = res.cloneIt();

            // Adding the current couple for the path that we take with him included
            copyRes.addCouple(curr);

            // With
            ListOfCouples included = helper(copyCouples, copyRes);
            // Without
            ListOfCouples notIncluded = helper(couples, res);

            // Returning the list with the larger expected success (es)
            if (included.getEs() > notIncluded.getEs()) {
                return included;
            } else {
                return notIncluded;
            }
        }


    }
}
