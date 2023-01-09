/* here are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1... You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi... For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1... Prerequisites can also be indirect... If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c... You are also given an array queries where queries[j] = [uj, vj]... For the jth query, you should answer whether course uj is a prerequisite of course vj or not... Return a boolean array answer, where answer[j] is the answer to the jth query...
 * Eg 1: Courses = 2  prerequisites = [[1,0]]                 queries = [[0,1],[1,0]]         Output = [false,true]
 * Eg 2: Courses = 2  prerequisites = [[]]                    queries = [[1,0],[0,1]]         Output = [false,false]
 * Eg 3: Courses = 3  prerequisites = [[1,2],[1,0],[2,0]]     queries = [[1,0],[1,2],[2,1]]   Output = [true,true,false]
 */
import java.util.*;
public class Courses
{
    public List<Boolean> CheckPrerequisites(int[][] query, int[][] pre, int k)
    {
        List<Boolean> check = new ArrayList<Boolean>();    // List of Boolean variables...
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>(k);   // Hashtable created...
        for(int i = 0; i < pre[0].length; i++)
            table.put(pre[0][i], pre[1][i]);      // Adding the pre-requisites to the Hashtable...
        for(int i = 0; i < query[0].length; i++)
        {
            if(table.containsKey(query[0][i]))    // If table has key...
            {
                if(table.get(query[0][i]) == query[1][i])    // If table has the value also...
                    check.add(true);
            }
            else
                check.add(false);
        }
        return check;    // return the updated list of boolean values...
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, k, q;
        System.out.print("Enter number of Courses : ");
        x = sc.nextInt();
        System.out.print("Enter the number of Pre-requisites : ");
        k = sc.nextInt();
        int pre[][] = new int[2][k];
        System.out.print("Enter the number of Queries : ");
        q = sc.nextInt();
        int query[][] = new int[2][q];
        for(int i = 0; i < k; i++)
        {
            System.out.print("Enter the "+(i+1)+" base pre-requisite : ");
            pre[0][i] = sc.nextInt();
            System.out.print("Enter the "+(i+1)+" base post-requisite : ");
            pre[1][i] = sc.nextInt();
        }
        for(int i = 0; i < q; i++)
        {
            System.out.print("Enter the "+(i+1)+" start query : ");
            query[0][i] = sc.nextInt();
            System.out.print("Enter the "+(i+1)+" end query : ");
            query[1][i] = sc.nextInt();
        }
        Courses courses = new Courses();   // Object creation...
        System.out.println("The Boolean Array : "+courses.CheckPrerequisites(query, pre, x));
        sc.close();
    }
}

// Time Complexity  - O(n) time...         n = number of queries...
// Space Complexity - O(n + m) space...    n = number of queries, m = number of prerequisites...

/* DEDUCTIONS :- 
 * 1. Since the prerequisite values can not be more than specified courses and one course can have more than one prerequisite, so we use Hashtable...
 * 2. We then check for every query in the Hashtable by iteration through the query array...
*/