package com.HCL;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        List<Integer> Sequence = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.println("How many integers should the sequence contain: ");
        String length = sc.nextLine();

        Sequence = fillList(Sequence, Integer.parseInt(length));

        System.out.println("\nSequence:");
        System.out.println(Sequence + "\n");

        List<Integer> Subsequence = getLongestIncreasingSubsequence(Sequence);

        System.out.println("Longest Increasing Subsequence:");
        System.out.println(Subsequence);
    }

    public static List<Integer> fillList(List<Integer> input, int length){

        for(int i = 0; i < length; i++){
            input.add( (int)(Math.random()*(99-1+1)) );
        }
        return input;
    }

    public static List<Integer> getLongestIncreasingSubsequence(List<Integer> input){

        List<Integer> SubSequence = new LinkedList<>();

        int indexForLongestSubsequence = 0;
        int lengthOfLongestSubsequence = 0;

        for (int i = 0; i < input.size(); i++){
            int lengthOfSubsequence = 1;
            for (int j = i; j < input.size(); j++){
                if ( j == (input.size()-1) ){
                    break;
                }
                if (input.get(j) > input.get(j+1)){
                    break;
                }
                else{
                    lengthOfSubsequence++;
                }
            }
            if (lengthOfSubsequence > lengthOfLongestSubsequence){
                indexForLongestSubsequence = i;
                lengthOfLongestSubsequence = lengthOfSubsequence;
            }
        }

        for (int i = indexForLongestSubsequence; i < indexForLongestSubsequence+lengthOfLongestSubsequence; i++){
            SubSequence.add(input.get(i));
        }


        return SubSequence;
    }
}
