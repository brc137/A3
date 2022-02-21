import java.util.*;
import java.io.*;

public class A3
{
  static final int MAX_CAPACITY = 30;

  public static void main(String args[]) throws Exception
  {
    if (args.length < 1)
    {
      System.out.println("java Assignment 3 Requires a filename to use for the input");
      System.exit(0);
    }

    int[] arr = new int[MAX_CAPACITY];
    int count = 0;

    Scanner infile = new Scanner (new File(args[0]));

    while (infile.hasNextInt())
    {
      int newVal = infile.nextInt();
      insertInOrder(arr,count,newVal);
        ++count;
    }

    arr = trimArray(arr, count);
    printArray(arr, count);
  }

  static int[] trimArray(int[] array, int count)
    {
      int[] smaller = new int[count];
      for (int i = 0; i < count ; ++i)
      smaller[i] = array[i];
      return smaller;
    }
//
//
//
  static void printArray(int[] array, int count)
    {
    for (int number : array)
      System.out.print(number + " ");
    System.out.println();
    }

  static void insertInOrder(int[] arr, int count,int newVal)
  {
    int i;

    for (i = count - 1; i >= 0 && newVal < arr[i]; i--)
    {
      arr[i+1] = arr[i];
    }
      arr[i+1] = newVal;
  }
}
