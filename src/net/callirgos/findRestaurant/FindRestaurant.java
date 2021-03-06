package net.callirgos.findRestaurant;

import java.util.ArrayList;
import java.util.List;

public class FindRestaurant {
    /*
    * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of
    * favorite restaurants represented by strings.
    * You need to help them find out their common interest with the least list index sum.
    * If there is a choice tie between answers, output all of them with no order requirement.
    * You could assume there always exists an answer.
    * Example 1:
    *   Input:
    *       ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    *       ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
    *   Output:
    *       ["Shogun"]
    *   Explanation: The only restaurant they both like is "Shogun".
    * Example 2:
    *   Input:
    *       ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    *       ["KFC", "Shogun", "Burger King"]
    *   Output:
    *       ["Shogun"]
    *   Explanation: The restaurant they both like and have the least index sum is "Shogun"
    *   with index sum 1 (0+1).
    * Note:
    * The length of both lists will be in the range of [1, 1000].
    * The length of strings in both lists will be in the range of [1, 30].
    * The index is starting from 0 to the list length minus 1.
    * No duplicates in both lists.
    * */
    public String[] findRestaurant(String[] list1, String[] list2) {
        int noteI = 1000;
        int noteJ = 1000;

        List<String> notedRestaurants = new ArrayList<>();

        for(int i = 0; i<list1.length; i++)
        {
            for(int j = 0; j<list2.length; j++)
            {
                if( list1[i].equals(list2[j]) )
                {
                    if((noteI+noteJ) > (i+j) )
                    {
                        notedRestaurants.clear();
                        noteI = i;
                        noteJ = j;
                        notedRestaurants.add(list1[i]);
                    }
                    if((noteI+noteJ) == (i+j) )
                    {
                        noteI = i;
                        noteJ = j;
                        if( !notedRestaurants.contains(list1[i])){
                            notedRestaurants.add(list1[i]);
                        }
                    }
                }
            }
        }

        return notedRestaurants.toArray(new String[notedRestaurants.size()]);
    }
}
