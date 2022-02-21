/*
Assignment 3: This assignment is about building an Array that is sorted from its inception.
We have Arrays.Sort that can sort an existing array into order. But to understand how that actually works we need to manually perform a sort operation
An InsertSort will apply sorting logic from the very first value we place into an array.
Lets say we have a series of values to input into an array (4, 13,2, 9,5)
Here is our array: _ _ _ _ _ _
Generally, an insertSort is setup with a for loop. Lets call its counter "i" for simplicity "i" is set to the value of count-1.
Remember what count is, its used to represent the number of values present in an array(since they are rarely totally full)
Count-1 would put us at the actual address of the last populated array element.
Each value as it comes into the array comes in from the right hand side, the first value it encounters we do a compare to
newvalue < array[i] tests last value to see if new value is less than it. Also, we need to make sure i>=0 or we will run off the front of the array!
We can manually figure out the small sample data above will make a sorted array that is 2 4 5 9 13, but how to we get it into that format from what we have?
4 is inserted first, count would be 0 at that time, using the logic test above that for the loop to keep going the newval has to be less than the last item
in the array and "i" has to be more than or equal to 0.
Right now, there are no values in the array to test less than to, since "i" is count-1(0-1) so -1 the loop should fail. What now? Loop failure means you are at an
acceptable address for insertion, the insertion will be done at [i+1], in this case [-1 + 1] or 0. 4 will go to array[0]
4 _ _ _ _ _  ------ 13 is next up
4 13 _ _ _ _ ------- 2 is next
2 4 13 _ _ _ -------- 9 is next
2 4 9 13 _ _ ------- 5 is last
2 4 5 9 13 _
An insertion sort will ONLY work on an array with at least 1 empty place in it, a full array will fail at insertion as i+1 will run off the edge of it.

*/
import java.util.*;
import java.io.*;

public class A3*
{
	static final int MAX_CAPACITY = 30;  // HARDCODED PLENTY BIG. WE'LL DO TRIM AFTER

	public static void main( String args[] ) throws Exception
	{
		//Item 1: Test to make sure a file name was provided to the args[] array. If less than 1 output a message telling user to supply a name
		// for the program to use for input. i.e. java A3 A3input.txt
		if (args.length < 1)
			{
				System.out.println("java A3 Requires a filename to use for the input");
				System.exit(0);
			}
		//Item 2: Declare an int array and use the constant MAX_CAPACITY to set its size. Also, declare a count variable and set to 0
		int arr = new int[MAX_CAPACITY];
		int count = 0;
		//Item 3: Create your scanner object to read from the input file, for the File object use the name supplied by args[0]
		Scanner infile = new Scanner(new file(args [0]));
		//Item 4: The file reading loop
		//Use the scanners .hasNextInt method to control this loop
		// Pull an int value from the file( using .nextInt() works perfectly for this)
		//Call insertInOrder method, note the required arguments it needs when being called insertInOrder(the array,count variable,value pulled in from file)
		// dont forget to increment count
		//End Item 4 Loop
		while (infile.hasNextInt())
				{
					int newVal = infile.nextInt();
					insertInOrder(arr,count,newVal);
						++count;
				}
		//Item 5: Call the trimArray method to get rid of the excess empty values
		arr = trimArray(arr, count);
		//Item 6: call printArray method
		printArray(arr, count);
		}
	} // END MAIN

	// ############################################################################################################

	static int[] trimArray(int[] array, int count)
    {
			int[] trimArray = new int[count];
			for (int = 0; i < count;++1);
			trimArray[i] = array[i];

        //this method will work the same way as downsize did in Lab 6
       return array; // this return will NOT meet A3 requirements, its only here to allow compilation
    }

	static void printArray(int[] array, int count)
    {
        // print each value in the array, insert an empty space between each value
				for (int number: arr)
					System.out.print(number + " ");
					System.out.println();
    }

	static void insertInOrder(int[] arr, int count, int newVal)
	{
		int = i;
		for (int i = count-1; newVal < arr[i] && i >= 0;i--)
		{
			arr[i+1] = arr[i]; // payload
		}
			arr[i+1] = newVal; // insertion

		// create a counter variable for the for loop, a counter declared on the same line as the for will NOT work as it will be limited to only existing in the loop
		// approach insertinorder from the right hand(high side) of the array. count will not work as a starting point as count is the # of values stored
		// we need the address of the last value stored.
		// If the newVal is less than the value being looked at in the array, move that current value to counter+1 position. Move it to the right, then proceed through
		// the array to the left.
		//Be careful NOT to run of the front of the array so also test to make sure counter >=0.
		//The loop is solely moving items out of the inserts way. When the loop reachs a breaking condition, then insert the newVal at the address counter+1.

	}

} // END A3
