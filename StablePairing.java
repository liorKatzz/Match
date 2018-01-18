package Match;

import java.util.*;

/**
 * Created by lior on 1/21/2017.
 */
public class StablePairing {


    /*
    Here we will organise the data in such way that the match method
    could work
     */

    //A method to split the guys and the girls to two lists of strings (the id). Return the two list as a "pair"
    static List[] assignGuysAndGirls(List<Person> personas){
        List[] res = new List[2]; //Array of lists
        List<String> guys = new ArrayList<>();
        List<String> girls = new ArrayList<>();
        for (int i = 0; i < personas.size(); i++){
            Person currPerson = personas.get(i);
            if (currPerson.isMan){
                guys.add(currPerson.id);
            }
            else{
                girls.add(currPerson.id);
            }
        }
        res[0] = guys;
        res[1] = girls;
        return res;
    }

    //Two methods that split the person list to two lists of guys and girls
    static List<Person> guysPersons (List<Person> personas){

        List<Person> res = new LinkedList<>();
        for (int i = 0; i < personas.size(); i++){
            Person currPerson = personas.get(i);
            if (currPerson.isMan){
                res.add(currPerson);
            }
            else{
                continue;
            }
        }
        return res;
    }


//If I want to execute a method from a different class, it has to be static?


    static List<Person> girlsPersons (List<Person> personas){

        List<Person> res = new LinkedList<>();
        for (int i = 0; i < personas.size(); i++){
            Person currPerson = personas.get(i);
            if (!currPerson.isMan){
                res.add(currPerson);
            }
            else{
                continue;
            }
        }
        return res;
    }


    /*Given the list of guys and girls, returns the guys preferences
     in the form of HashMap <String(a guy's id), list<String>(girls id)>
     for me: Need to change to list of persons
     */
    static  Map<String, List<String>> guysPrefers(List<Person> guys, List<Person> girls){

        Map<String, List<String>> res = new HashMap<>();

        //Go through only guys. For each guy, create a TreeMap and insert the girl id and
        //her weighted score (score as key for the sorting).
        for (int i = 0; i < guys.size(); i++){
            Person currGuy = guys.get(i);
            Map<Double, String> orderedGirls = new TreeMap<>();
            for (int j = 0; j < girls.size(); j++){
                Person currGirl = girls.get(j);
                double girlScore = calcScore(currGuy, currGirl);
                orderedGirls.put(girlScore, currGirl.id);
            }
            //Building the ordered list of prefered girls
            List<String> preferedGirlsList = new LinkedList<>(); //In the reverse wanted order
            for (double d : orderedGirls.keySet()){
                preferedGirlsList.add(orderedGirls.get(d));
            }
            Collections.reverse(preferedGirlsList); //Reverse to the wanted order
            res.put(currGuy.id, preferedGirlsList);

        }
        return res;
    }


    /*Given the list of guys and girls, returns the girls preferences
     in the form of HashMap <String(a girl's id), list<String>(guys id)>
     */
    static  Map<String, List<String>> girlsPrefers(List<Person> guys, List<Person> girls){

        Map<String, List<String>> res = new HashMap<>();

        //Go through only girls. For each girl, create a TreeMap and insert the guy's id and
        //his weighted score (score as key for the sorting).
        int size = girls.size();
        for (int i = 0; i < size; i++){
            Person currGirl = girls.get(i);
            Map<Double, String> orderedGuys = new TreeMap<>();
            for (int j = 0; j < size; j++){
                Person currGuy = guys.get(j);
                double guyScore = calcScore(currGirl, currGuy);
                orderedGuys.put(guyScore, currGuy.id);
            }
            //Building the ordered list of prefered guys
            List<String> preferedGuysList = new LinkedList<>(); //In the reverse wanted order
            for (double d : orderedGuys.keySet()){
                preferedGuysList.add(orderedGuys.get(d));
            }
            Collections.reverse(preferedGuysList); //Reverse to the wanted order
            res.put(currGirl.id, preferedGuysList);

        }
        return res;
    }


    //Helper, given two persons, calc the second one score based on the weights of the first
    static double calcScore(Person person1, Person person2){

        double res = 0.0;
        double[] weights = person1.weights;
        for (int i = 0; i < weights.length; i++){
            res += weights[i] * person2.avTests.get(i);
        }

        return res;
    }







    static List<String> guys = Arrays.asList(
            new String[]{
                    "abe", "bob", "col", "dan", "ed", "fred", "gav", "hal", "ian", "jon"});
    static List<String> girls = Arrays.asList(
            new String[]{
                    "abi", "bea", "cath", "dee", "eve", "fay", "gay", "hope", "ivy", "jan"});
    static Map<String, List<String>> guyPrefers =
            new HashMap<String, List<String>>(){{
                put("abe",
                        Arrays.asList("abi", "eve", "cath", "ivy", "jan", "dee", "fay",
                                "bea", "hope", "gay"));
                put("bob",
                        Arrays.asList("cath", "hope", "abi", "dee", "eve", "fay", "bea",
                                "jan", "ivy", "gay"));
                put("col",
                        Arrays.asList("hope", "eve", "abi", "dee", "bea", "fay", "ivy",
                                "gay", "cath", "jan"));
                put("dan",
                        Arrays.asList("ivy", "fay", "dee", "gay", "hope", "eve", "jan",
                                "bea", "cath", "abi"));
                put("ed",
                        Arrays.asList("jan", "dee", "bea", "cath", "fay", "eve", "abi",
                                "ivy", "hope", "gay"));
                put("fred",
                        Arrays.asList("bea", "abi", "dee", "gay", "eve", "ivy", "cath",
                                "jan", "hope", "fay"));
                put("gav",
                        Arrays.asList("gay", "eve", "ivy", "bea", "cath", "abi", "dee",
                                "hope", "jan", "fay"));
                put("hal",
                        Arrays.asList("abi", "eve", "hope", "fay", "ivy", "cath", "jan",
                                "bea", "gay", "dee"));
                put("ian",
                        Arrays.asList("hope", "cath", "dee", "gay", "bea", "abi", "fay",
                                "ivy", "jan", "eve"));
                put("jon",
                        Arrays.asList("abi", "fay", "jan", "gay", "eve", "bea", "dee",
                                "cath", "ivy", "hope"));
            }};
    static Map<String, List<String>> girlPrefers =
            new HashMap<String, List<String>>(){{
                put("abi",
                        Arrays.asList("bob", "fred", "jon", "gav", "ian", "abe", "dan",
                                "ed", "col", "hal"));
                put("bea",
                        Arrays.asList("bob", "abe", "col", "fred", "gav", "dan", "ian",
                                "ed", "jon", "hal"));
                put("cath",
                        Arrays.asList("fred", "bob", "ed", "gav", "hal", "col", "ian",
                                "abe", "dan", "jon"));
                put("dee",
                        Arrays.asList("fred", "jon", "col", "abe", "ian", "hal", "gav",
                                "dan", "bob", "ed"));
                put("eve",
                        Arrays.asList("jon", "hal", "fred", "dan", "abe", "gav", "col",
                                "ed", "ian", "bob"));
                put("fay",
                        Arrays.asList("bob", "abe", "ed", "ian", "jon", "dan", "fred",
                                "gav", "col", "hal"));
                put("gay",
                        Arrays.asList("jon", "gav", "hal", "fred", "bob", "abe", "col",
                                "ed", "dan", "ian"));
                put("hope",
                        Arrays.asList("gav", "jon", "bob", "abe", "ian", "dan", "hal",
                                "ed", "col", "fred"));
                put("ivy",
                        Arrays.asList("ian", "col", "hal", "gav", "fred", "bob", "abe",
                                "ed", "jon", "dan"));
                put("jan",
                        Arrays.asList("ed", "hal", "gav", "abe", "bob", "jon", "col",
                                "ian", "fred", "dan"));
            }};


    //--------------------------------------------------------------------------------

    //We will work with the person's id (the id is a string).

    static Map<String, String> match(List<String> guys,
                                             Map<String, List<String>> guyPrefers,
                                             Map<String, List<String>> girlPrefers){
        Map<String, String> engagedTo = new TreeMap<>();
        List<String> freeGuys = new LinkedList<>();
        freeGuys.addAll(guys);
        while(!freeGuys.isEmpty()){
            String thisGuy = freeGuys.remove(0);
            List<String> thisGuyPrefers = guyPrefers.get(thisGuy);
            for(String girl:thisGuyPrefers){
                if(engagedTo.get(girl) == null){//girl is free
                    engagedTo.put(girl, thisGuy);
                    break;
                }else{
                    String otherGuy = engagedTo.get(girl);
                    List<String> thisGirlPrefers = girlPrefers.get(girl);
                    if(thisGirlPrefers.indexOf(thisGuy) <
                            thisGirlPrefers.indexOf(otherGuy)){
                        //this girl prefers this guy to the guy she's engaged to
                        engagedTo.put(girl, thisGuy);
                        freeGuys.add(otherGuy);
                        break;
                    }//else no change...keep looking for this guy
                }
            }
        }
        return engagedTo;
    }

    public static void main(String args[]) {
        System.out.println("Hi!");
    }
}
