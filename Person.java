package Match;

import java.util.*;

/**
 * Created by lior on 1/21/2017.
 */

//!!!for me!!! weights and avTests supposed to have the same order. Check!

public class Person{

    //Fields

    //The id of the person
    String id;
    //Boolean variable specifying if it's a man or a woman
    boolean isMan;
    //I can create a hash map of the test name and double (its simple average)
    List<Double> avTests;
    //The weights of the person
    double[] weights;




    //The constructor. Input: boolean var for man or a woman, and map of
    //test name and the actual scores of the test (array of integers)
    public Person (String id, boolean isMan, ArrayList<int[]> results,
                   double[] weights)
            throws Exception{


        // Size of the results (number of tests)
        int numOfTests = results.size();
        //Exception handling
        if (!isOne(weights)){
            throw new Exception("Weights are not sum up to 1 in: " + id);
        }
        if (weights.length != numOfTests){
            throw new Exception("Weights number not equal to tests number in: " + id);
        }

        //Setting the the given id of the person
        this.id = id;

        //Setting the gender of the person
        this.isMan = isMan;

        //Setting the name of the test and mapping it to its simple average
        avTests = new ArrayList<>();
        for (int i = 0; i < numOfTests; i++){
            avTests.add(makeSimpleAverage(results.get(i)));
        }
        //Setting the weights
        this.weights = weights;
    }


    //Helper for calc the simple average of a test
    private double makeSimpleAverage(int[] test){
        double sum = 0.0;
        int length = test.length;
        for (int i = 0; i < length; i++){
            sum += (double)test[i];
        }
        return sum / (double)length;
    }


    //Checking if the weights sum to 1. If yes return true, otherwise false and print the sum
    static boolean isOne(double[] weights222){

        double sum = 0.0;
        for (int i = 0; i < weights222.length; i++){
            sum += weights222[i];
        }

        if (sum > 0.99999 && sum < 1.00001){
            return true;
        }
        return false;
    }



}
