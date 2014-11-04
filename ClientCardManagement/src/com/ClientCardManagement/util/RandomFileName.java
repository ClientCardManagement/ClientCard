package com.ClientCardManagement.util;

import java.util.Random;

public class RandomFileName {
	private static final int SHUFFLE_THRESHOLD        =    5;
	
	private static void swap(char[] list, int i, int j) {
        char tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
	public static void shuffle(char[] list, Random rnd) {
        int size = list.length;
        if (size < SHUFFLE_THRESHOLD ) {
            for (int i=size; i>1; i--)
                swap(list, i-1, rnd.nextInt(i));
        } else {
        	char[] arr = list;

            // Shuffle array
            for (int i=size; i>1; i--)
                swap(arr, i-1, rnd.nextInt(i));

        }
    }
	public static String getRandomFileName(){
		//26位字符串
		Long currentTime =System.currentTimeMillis();
		
		char[] currentTimeArray = currentTime.toString().toCharArray();
		Random r = new Random();
		shuffle(currentTimeArray,r);
		StringBuffer afterShuffleString = new StringBuffer();
		int N = currentTimeArray.length;
		for(int i = 0; i < N;i++){
			afterShuffleString.append(currentTimeArray[i]);
		}
		return currentTime.toString() + afterShuffleString.toString();
		
	}
	public static void main(String args[]){
		System.out.println(RandomFileName.getRandomFileName());
		
	}
}
