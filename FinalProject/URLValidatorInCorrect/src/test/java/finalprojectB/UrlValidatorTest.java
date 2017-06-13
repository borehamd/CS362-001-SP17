/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }


    //Done by Rebecca Farnham
    public void testManualTest()
    {
        System.out.println("testManualTest Outputs");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        //VALID URLS
        System.out.println(urlVal.isValid("http://www.amazon.com"));
        System.out.println(urlVal.isValid("http://commons.apache.org/proper/commons-validator/"));
        System.out.println(urlVal.isValid("https://github.com/farnhamr/CS362-001-SP17/blob/master/FinalProject/URLValidatorCorrect/src/test/java/finalprojectA/UrlValidatorTest.jav"));

        //INVALID URLS
        System.out.println(urlVal.isValid("http:// www. amazon. com")); //URL contains spaces
        System.out.println(urlVal.isValid("http://www.amazon.")); //URL ends in . instead of .com
        System.out.println(urlVal.isValid("amazon")); //URL is just the word 'amazon'

    }

    //Done by Rebecca Farnham
    //Testing urls that are invalid
    public void testYourFirstPartition()
    {
        System.out.println("testYourFirstPartition Outputs");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        System.out.println(urlVal.isValid("http://"));
        System.out.println(urlVal.isValid("http://0.0.0.0/")); //true: bug?
        System.out.println(urlVal.isValid("http://256.256.256.256/")); //true: bug?
        System.out.println(urlVal.isValid("http://www.bbc.commmmmm/"));
        System.out.println(urlVal.isValid("http://wwwwwww.bbc.com/")); //true: bug?
        System.out.println(urlVal.isValid("http:///////////////www.bbc.com/"));
        System.out.println(urlVal.isValid("http://www.219837593824759<><><>~~~~~~~{}{}{.com/"));
        System.out.println(urlVal.isValid("dghioeuir23oijg://www.bbc.com/")); //true: bug?
        System.out.println(urlVal.isValid("http://www.bbc.com:111111111111/"));
        System.out.println(urlVal.isValid("http://www.bbc.com.usa/"));
    }

    //Done by Rebecca Farnham
    //testing urls that are valid
    public void testYourSecondPartition(){
        System.out.println("testYourSecondPartition Outputs");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        System.out.println(urlVal.isValid("http://www.bbc.com/"));
        System.out.println(urlVal.isValid("http://www.bbc.edu/"));
        System.out.println(urlVal.isValid("http://www.bbc.ac/"));
        System.out.println(urlVal.isValid("http://www.bbc.gov/"));
        System.out.println(urlVal.isValid("http://www.bbc.co/"));
        System.out.println(urlVal.isValid("http://www.bbc.co.uk/")); //false: bug?
        System.out.println(urlVal.isValid("http://www.bbc.co.fr/"));
        System.out.println(urlVal.isValid("http://www.bbc.co:1/"));
        System.out.println(urlVal.isValid("http://www.bbc.co:10000/")); //false: bug?
        System.out.println(urlVal.isValid("https://www.bbc.co/"));
        System.out.println(urlVal.isValid("www.bbc.co/")); //false: bug?
        System.out.println(urlVal.isValid("ie://www.bbc.co/"));
        System.out.println(urlVal.isValid("ftp://www.bbc.co/"));
        System.out.println(urlVal.isValid("http://www.bbcccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc.co/"));
        System.out.println(urlVal.isValid("http://255.255.255.255/"));
        System.out.println(urlVal.isValid("http://1.1.1.1/"));
        System.out.println(urlVal.isValid("http://something.com:80/html/page/2.html?query")); //false: bug?
        System.out.println(urlVal.isValid("http://www.something.com?param=valid")); //false: bug?

    }
   
   
   public void testIsValid()
   {
      String[] schemes={"http","https"};
      UrlValidator validation=new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
      
      
      
      LinkedList<String> ListScheme=new LinkedList<String>();
      LinkedList<String> ListHost=new LinkedList<String>();
      LinkedList<String> ListPort=new LinkedList<String>();
      LinkedList<String> ListPath=new LinkedList<String>();
      LinkedList<String> ListQuery=new LinkedList<String>();

      ListScheme.add("http://");//true
      ListScheme.add("https://");//true
      ListScheme.add("");//true
      int TScheme=ListScheme.size();//number of true values
      ListScheme.add("file:///C:/");//false
      ListScheme.add("http:/");//false
      ListScheme.add("://");//false
      ListScheme.add("hppp://");//false
      int[] schemesum=new int[ListScheme.size()];


      ListHost.add("www.awebsite.com");//true
      ListHost.add("go.com");//true
      ListHost.add("anumber.uk");//true
      ListHost.add("stuff3r.com");//true

      ListHost.add("255.255.255.255");//true
      int THost=ListHost.size();
       ListHost.add("0.0.0.0");//false
      ListHost.add(".aaa");//false
      ListHost.add("");//false
      ListHost.add("racecar.");//false
      ListHost.add("racecar");//false
      int[] hostsum=new int[ListHost.size()];

      ListPort.add(":314");//true
      ListPort.add("");//true
      ListPort.add(":23415");//true
      int TPort=ListPort.size();
      ListPort.add(":-1");//false
      ListPort.add(":A133");//false
      int[] portsum=new int[ListPort.size()];


      ListPath.add("/watch");//true
      ListPath.add("/feed/subscriptions");//true
      ListPath.add("/watch/");//true
      ListPath.add("/$fdsfs");//true
      int TPath=ListPath.size();
      ListPath.add("/#");//false
      ListPath.add("/..");//false
      int[] pathsum=new int[ListPath.size()];

      ListQuery.add("?q=disney+toy+story");
      ListQuery.add("");
      ListQuery.add("?action=edit&dit&mode=up");
      int[] querysum=new int[ListQuery.size()];
      

      for(int scheme=0;scheme<ListScheme.size();scheme++)
	 for(int host=0;host<ListHost.size();host++)
	    for(int port=0;port<ListPort.size();port++)
	       for(int path=0;path<ListPath.size();path++)
		  for(int query=0;query<ListQuery.size();query++){
		     String URL=ListScheme.get(scheme)+ListHost.get(host)+ListPort.get(port)+ListPath.get(path)+ListQuery.get(query);
		     //System.out.print("%i %i %i %i %i", scheme, host, port, path,query);
		     if(scheme<TScheme&&host<THost&&port<TPort&&path<TPath){			
			if(validation.isValid(URL)==false){
			   System.out.println(scheme+" "+ host+" "+port+" "+path+" "+query+" : expected true");
		           schemesum[scheme]++;
			   hostsum[host]++;
			   portsum[port]++;
			   pathsum[path]++;
			   querysum[query]++;
			}}
		     else if(validation.isValid(URL)==true){
			System.out.println(scheme+" "+ host+" "+port+" "+path+" "+query+" : expected false");
		        schemesum[scheme]++;
			hostsum[host]++;
			portsum[port]++;
			pathsum[path]++;
			querysum[query]++;
		     }}
      System.out.println("\n\ncompiled unexpected results\n\n-----------------\n\nschemes\n");
      int permutations=ListScheme.size()*ListHost.size()*ListPort.size()*ListPath.size()*ListQuery.size();
      
      System.out.print(schemesum[0]);
      for(int i=1; i<schemesum.length;i++){
	 System.out.print(", ");
	 System.out.print(schemesum[i]);
      }
      
      for(int i=0;i<schemesum.length;i++){
	 
	 if(schemesum[i]==(permutations/ListScheme.size()))
	    System.out.println(ListScheme.get(i)+" unexpected result for all occurances");
      }
      System.out.println("\n\n-----------------\nhost\n");
      
      System.out.print(hostsum[0]);
      for(int i=1;i<hostsum.length;i++){
	 System.out.print(", ");
	 System.out.print(hostsum[i]);
      }

      for(int i=0;i<hostsum.length;i++){
	 if(hostsum[i]==permutations/ListHost.size())
	    System.out.println(ListHost.get(i)+" unexpected result for all occurances");
      }
      System.out.println("\n\n-----------------\nport\n");
      
      System.out.print(portsum[0]);
      for(int i=1;i<portsum.length;i++){
	 System.out.print(", ");
	 System.out.print(portsum[i]);
      }

      for(int i=0;i<portsum.length;i++){
	 if(portsum[i]==permutations/ListPort.size())
	    System.out.println(ListPort.get(i)+" unexpected result for all occurances");
      }      
      System.out.println("\n\n-----------------\npath\n");
      
      System.out.print(pathsum[0]);
      for(int i=1;i<pathsum.length;i++){
	 System.out.print(", ");
	 System.out.print(pathsum[i]);
      }

      for(int i=0;i<pathsum.length;i++){
	 if(pathsum[i]==permutations/ListPath.size())
	    System.out.println(ListPath.get(i)+" unexpected result for all occurances");
      }
      System.out.println("\n\n-----------------\nquery\n");
      
      System.out.print(querysum[0]);
      for(int i=1;i<querysum.length;i++){
	 System.out.print(", ");
	 System.out.print(querysum[i]);
      }
      
      for(int i=0;i<querysum.length;i++){
	 if(querysum[i]==permutations/ListQuery.size())
	    System.out.println(ListQuery.get(i)+" unexpected result for all occurances");
      }

   }
   
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
