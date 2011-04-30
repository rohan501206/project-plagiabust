/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

import java.util.ArrayList;
import java.util.LinkedList;
import reportingModule.DiffMatch.Diff;

/**
 *
 * @author user
 */
public class TestMain {






    public static void main(String[] args){
    DiffMatch test2= new DiffMatch();
    System.out.println(test2.match_main("abc12345678901234567890abbc", "abc", 26));

        LinkedList<Diff> a=test2.diff_main("This week I tested the previous week work and debugged. Then I had to do next part. It is about after authentication getting the profile details of the specific user. So I had to connect to the remote web service through the local server. In that case we all have to follow the same protocol that all had been agreed. So I got the WSDL file and created the java stub class to communicate with remote web service. I have done implementing all stuffs in this week. The return object is a JSON. So I got to know about JSON and how to serialize and de-serialize it. Using goggling I got a good idea. So as I expect it’s going fine.","I was provided reading materials on Subversion by project mentors. In addition to that existing projects of subversion visualization were studied. Then I was introduced the JIRA system. 1st iteration of the project was scheduled in the meeting with project mentors. It was to display an image of a repository. Then task breakdown in JIRA was done according to 1st iteration.In that case we all have to follow the same protocol that all had been agreed. So I got the WSDL file and created the java stub class to communicate with remote web service. I have done implementing all stuffs in this week. The return object is a JSON");
        for (int i = 0; i < a.size(); i++)
     System.out.println("list[" + i +"] = " + a.get(i));
    }


}
