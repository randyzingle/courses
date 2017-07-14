package playpen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Benchmarking {
	
	static boolean printArray = false;
	//Your Electronic Filing PIN is 57854.

	public static void main(String[] args) {
		int n = 10;
		Benchmarking bm = new Benchmarking();
		for (int i=1; i<5; i++) {
			n = n * 10;
			double a[] = bm.getDoubleArray(n);
			bm.insertionSort(a);
		}

	}
	
	private double[] getDoubleArray(int n) {
		double[] array = new double[n];
		Random rand = new Random();
		for (int i=0; i<n; i++) {
			array[i] = rand.nextInt(100);
		}
		return array;
	}
	
	private void insertionSort(double[] a) {
		int n = a.length;
		if(printArray)printArray(a);
		int index = 0;
		// insertion sort the array
		long start = System.currentTimeMillis();
		for (int i=0; i<n-1; i++) {
			index = i;
			for (int j=i+1; j>0; j--) {
				if (a[j] > a[index]) break;
				swap(index,j,a);
				index--;
			}
		}
		long end = System.currentTimeMillis();
		System.out.printf("%d, %d%n", n, end-start);
		if(printArray)printArray(a);
	}
	
	private void selectionSort(double[] a) {
		int n = a.length;
		if(printArray)printArray(a);
		// selection sort the array
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if (a[j] < a[i]) swap(i,j,a);
			}
		}
		if(printArray)printArray(a);
	}
	
	private void swap(int i, int j, double[] a) {
		double d = a[i];
		a[i] = a[j];
		a[j] = d;
	}
	
	private void printArray(double array[]) {
		ArrayList<Double> al = new ArrayList<Double>(array.length);
		for (double d : array) {
			al.add(d);
		}
		System.out.println(al);
	}
}
