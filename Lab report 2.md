# Edwin's Lab Report 2

# Part 1
Code for the searching Engine:
```
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;
    ArrayList<String> string = new ArrayList<String>();
    ArrayList<String> result = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) 
        {
            return String.format("String array: "+ string); 
        } else if (url.getPath().contains("/add")) 
        {
            String[] Par = url.getQuery().split("=");
            if(Par[0].equals("s"))
            {
                string.add(Par[1]);
                return String.format("List added: "+Par[1]+"The array is now "+ string);
            }
        return "Error";  
    } else 
    {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/search")) {
                String[] Par = url.getQuery().split("=");
                if (Par[0].equals("s")) {
                    for(int i=0;i<string.size();i++)
                    {
                        if(string.get(i).indexOf(Par[1])!=-1)
                        {
                            result.add(string.get(i));
                        }
                    }
                    return String.format("The search result of searching which words have "+ Par[1]+" are "+ result);
                }
            }
            return "Error";
        }
    }
}

public class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```
When entering javac Server.java ... remember to change NumberServer.java to SearchEngine.java! Don't make the same mistake like I did.

First move:
The method handleRequest get called. In the first if statement, we let the url getPath() equal to "/", it will show the string inside of the string arraylist. It showed the empty array, becasue we haven't add any string into the string array list yet.
![Image](lab2_1_0.png)

The method handleRequest get called. In the else if statement,we set that when the url getPath() contains "/add" query, we add the second word in the Par array (the first one is "s") into string array list. So in this part "anewstringtoadd" got added into the string[] array list.

![Image](lab2_1_1.png)
The method handleRequest get called. In the else if statement,we set that when the url getPath() contains "/add" query, we add the second word in the Par array (the first one is "s") into string array list. So in this part "pineapple" got added into the string[] array list. So right now the string array list contain both anewstringtoadd and pineapple. 

![Image](lab2_1_2.png)
The method handleRequest get called. In the else if statement,we set that when the url getPath() contains "/add" query, we add the second word in the Par array (the first one is "s") into string array list. So in this part "apple" got added into the string[] array list. So right now the string array list contains anewstringtoadd, pineapple and apple. 

![Image](lab2_1_3.png)

The method handleRequest get called. After the url, in the else if statement, we set that when the url getPath() contains "/search" query. In the for loop, we set that if the word contain the sub string (Par[1]) user provided with indexOf() not equal to -1, it will add it to the string array list and finally print them out.
As we can see, both pineapple and apple contain "app".
![Image](lab2_1_4.png)

# Part 2
# First: Bug in ArrayExample.java (The reversed function):

This is the input I run for reversed function:
![Image](lab2_1.png)

The symptoms and errors got from running with JUnit:
We can see all three inputs failed, and we can see the array always contain zero, and it is different from what we should expect.

First input result:
![Image](lab2_2.png)

Second input result:
![Image](lab2_3.png)

Third input result:
![Image](lab2_4.png)

In the image below, we fixed the bug of the reversed function, we correctly assign the numbers to the newArray not the old array and change "return arr" to "return newArray". The original reversed function is wrong because the original array got assigned to the new array which is automatically set to an empty array, and it returns the original array which is empty, so that's why it always return 0 and not the number expected.  
![Image](lab2_5.png)

After fixing the bugs, all three tests success.
![Image](lab2_6.png)

Conclusion for bug fixing on reversed function, connection between the symptom and the bug: The issue in the function reversed is in the original (no fix) reversed method, it returns the old array(arr), instead of the new array  (newArray). Also, inside the loop, we can see it actually store the value of new array into the old array, which new array is always set to 0. That's the reason why the output are always 0 and didn't meet the expection.

# Second: Bug in ListExample.java (The merge function):

This is the input I tested for the merged function in ListExample.java.
 ![Image](lab2_7.png)

The symptoms and errors got from running with JUnit:
We can see all two inputs failed, and JUnit show that the symtom is "java.;ang.OutOfMemoryError: Java heap space"
 ![Image](lab2_8.png)

In the image below, we fixed the bug of the merge function and it is a simple bug fixed, we change "index+=1" to "index2+=1" in line 44 with the red circle! The original function is wrong becasue we supposed to add list2 into the new array, but it is actually list1 get increased not list2. When index2 didn't get incresed, the while loop will not end so it will casue "java.;ang.OutOfMemoryError: Java heap space". 
 ![Image](lab2_9.png)

 After fixing the bug, we run it with JUnit again and get success for both tested input.
 ![Image](lab2_10.png)

 Conclusion for bug fixing on merge function, connection between the symptom and the bug: The bug of the function is on line 44, in the original (not fix) merge function, it was index1+=1, which should change to index2+=1, because it should add list2 into the new array not list1. As a result, it casues java.;ang.OutOfMemoryError: Java heap space as a symptom.  


