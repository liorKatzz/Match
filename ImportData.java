package Match;


import java.io.*;
import java.util.ArrayList;

/**
 * Created by lior on 3/18/2017.
 * Read an excel file that holds data for a Person.
 * We need a person's name (id), the number of tests, the weights,
 * the number of entries for each test and the results for the tests
 * that he took
 */
public class ImportData {


    static Person createPerson (String path) throws Exception{
        ArrayList<int[]> resutls = new ArrayList<>();

        // Initializing the bufferReader
        BufferedReader br = new BufferedReader(new FileReader(path));
        // Saving the name
        String name = br.readLine();
        // Saving the number of tests
        int numOfTests = Integer.parseInt(br.readLine());
        // Saving the weights
        double[] weights = new double[numOfTests];
        for (int i = 0; i < numOfTests; i++){
            weights[i] = Double.parseDouble(br.readLine());
        }
        // Saving the number of entries
        int numOfEntries = Integer.parseInt(br.readLine());
        // Saving the tests results
        for (int i = 0; i < numOfTests; i++){
            int[] result = new int[numOfEntries];
            for (int j = 0; j < numOfEntries; j++){
                result[j] = Integer.parseInt(br.readLine());
            }
            resutls.add(result);
        }
        // Saving the boolean var that states if it's a man or a woman
        boolean isMan = Boolean.parseBoolean(br.readLine());
        // Creating the person and return it
        Person person = new Person(name, isMan, resutls, weights);
        return person;
    }

    public static void main(String[] args) throws Exception {

        Person person = createPerson("C:/Users/lior/Desktop/idc/personData.csv");
        System.out.println(person.id);
        System.out.println(person.weights[3]);
    }
}
