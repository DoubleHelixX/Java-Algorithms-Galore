package pkg;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_Algorithms {
private Scanner scan;
private int selection = 1, arraySize = 2;
private int [] arry;

public Java_Algorithms()
{
scan = new Scanner(System.in);
selectAlgorithm();
}

private void selectAlgorithm() {
arrySizeValidation();
fillArry();
do {
if(selection > 6 || selection <1)
System.err.println("Please select a number from 1-7 only");

System.out.println("Choose Your Algorithm \n 1: MaxFiniteSequence \n 2: LinearSearch"
+ " \n 3: BinarySearch \n 4: BubbleSort \n 5: InsertionSort \n 6: GreedyChangeMaking");
while (!scan.hasNextInt()) {
System.err.println("Error Code: Please press 1, 2, 3, 4, 5, or 6 for an approbiate algorithm above :)");
scan.next();
}
selection=scan.nextInt();
}
while ( selection > 6 || selection < 1);

switch(selection) {
case 1: MaxFiniteSequence();
break;
case 2: LinearSearch();
break;
case 3: BinarySearch();
break;
case 4: BubbleSort();
break;
case 5: InsertionSort();
break;
case 6: GreedyChangeMaking();
break;
default : System.err.println("Something Went Wrong");

}
}

private void arrySizeValidation() {
System.out.println("Select the amount of elements in your list");
do {
if (arraySize <2)
System.err.println("Only positive integers greater than 1 are Allowed");

while (!scan.hasNextInt())
System.out.println("Select the amount of elements in your list");

arraySize=scan.nextInt(); }
while (arraySize <2);
arry = new int [arraySize];
}

private void fillArry()
{
System.out.println("Provide your list of numbers you wish to be used in the algorthm "
+ " \n Hint: you can press control V to paste a copied list of numbers with spaces between them to speed things up");
for (int i =0; i<=arry.length-1; i++) {
while (!scan.hasNextInt()) {
System.out.println("Only Numbers Allowed");
scan.next();
}
arry[i]=scan.nextInt();
}


}
private void Retry()
{
System.out.println("\n Do you want to try the program again ? \n press y for yes or anything else for no");
if(scan.next().equals("y"))
selectAlgorithm();
else {
System.out.println("GoodBye . . . ");
System.exit(0);
}
}
private void MaxFiniteSequence() {
System.out.println("... You have chosen the MaxFiniteSequence");
int max = arry[0];
for (int i =1; i<=arry.length-1; i++)
if (arry[i] > max)
max=arry[i];
System.out.println(" The Biggest Number in your List is " + max);
Retry();
}

private void LinearSearch() {
System.out.println("... You have chosen LinearSearch");
System.out.println("What number do you want to be searched");
int x = scan.nextInt();
boolean exist = false;
for (int i = 0; i <= arry.length-1; i++) {
           if (arry[i] == x) {
          System.out.print(x + " Exist at element " + i + " which is position " + (i+1) + " in your list \n ");
          exist = true;
            }
        }
if (!exist)
System.out.print(x + " Does not Exist within your list ");
    Retry();
}

private void BinarySearch() { // not working cause of index out of bounds array 45678 set size to 5
System.out.println("... You have chosen BinarySearch - Please use a sorted list");
int l = 0, r = arry.length-1, m, location=-1, x;
System.out.println("What number do you want to be searched");
while (!scan.hasNextInt()) {
System.out.println("Only Numbers Allowed");
scan.next();
}
x = scan.nextInt();
while (l <= r) {
             m = l + (r - l) / 2;
             //System.err.println("here");
            if (arry[m] == x) {
            System.out.print(x + " Exist at element " + m + " which is position " + (m+1) + " in your list \n ");
            location = 1;
            break;
            }
            if (arry[m] < x)
                l = m + 1;  
            else
                r = m - 1;
           
        }
if (location == -1)
System.out.print(x + " Does not Exist within your list ");
Retry();

}

private void BubbleSort() {
System.out.println("... You have chosen BubbleSort");
int n = arry.length;
System.out.print("UnSorted Array: ");
for (int i=0; i<n; ++i)
            System.out.print(arry[i] + " ");

        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arry[j] > arry[j+1]) {
                int temp = arry[j];
                arry[j] = arry[j+1];
                arry[j+1] = temp;
                }
        System.out.print("\nSorted Array: ");
        for (int i=0; i<n; ++i)
            System.out.print(arry[i] + " ");
        Retry();
}

private void InsertionSort() {
System.out.println("... You have chosen InsertionSort");
int n = arry.length;

System.out.print("UnSorted Array: ");
for (int i=0; i<n; ++i)
System.out.print(arry[i] + " ");

        for (int i = 1; i < n; ++i) {
            int key = arry[i];
            int j = i - 1;
            while (j >= 0 && arry[j] > key) {
                arry[j + 1] = arry[j];
                j = j - 1;
            }
            arry[j + 1] = key;
        }
       
        System.out.print("\nSorted Array: ");
        for (int i=0; i<n; ++i)
            System.out.print(arry[i] + " ");
        Retry();
}

private void GreedyChangeMaking() {
    int n = arry.length;
    for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arry[j] > arry[j+1]) {
                int temp = arry[j];
                arry[j] = arry[j+1];
                arry[j+1] = temp;
                }
System.out.println("... You have chosen GreedyChangeMaking");
ArrayList<Integer> arrli = new ArrayList<Integer>();
int x=1;
do{
if (x<=0)
System.err.println("Enter an amount that is more than 0.00$ please. ");

System.out.println("What is your dollar amount you want to convert to change? ");
while (!scan.hasNextInt()) {
System.out.println("Only Numbers Allowed");
scan.next();
}
x = scan.nextInt();
}

while (x<=0);

for (int i=arry.length-1; i>=0; i--)
if (x>= arry[i] && arry[i] >=0) {
x-=arry[i];
arrli.add(arry[i]);
i++;
}
else
System.out.println("filtering out negative cents");

System.out.println("Your total amount of coins is " + arrli.size() + " and the contents are " + arrli);
Retry();
}




public static void main(String[] args) {
new Java_Algorithms();

}

}
