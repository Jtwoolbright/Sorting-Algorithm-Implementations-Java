// 
//    Coded By: Josh Woolbright
//        Date: 10/3/2019
//
import java.util.Random;

public class Algorithms 
{
	Random rand = new Random();
	
	public void insertionSort(int array[], int low, int high)
	{
		for (int i = low; i <= high; i++)
		{
			int target = array[i];
			int j = i - 1;
			while ( j >= 0 && target < array[j])
			{
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = target;
		}
	}
	
	public void mergeSort(int array[])
	{
		int n = array.length;
		if (n > 1)
		{
			final int uLen = (n / 2);
			final int vLen = (n - uLen);
			int U[] = new int[uLen];
			int V[] = new int[vLen];
			
			int j = uLen;
			int i = 0;
			while (j < array.length)
			{
				if (i < uLen)
				{
					U[i] = array[i];
				}
				V[i] = array[j];
				i++;
				j++;
			}
			mergeSort(U);
			mergeSort(V);
			merge(uLen, vLen, U, V, array);
		}
	}
	
	private void merge(int uLen, int vLen, int U[], int V[], int array[])
	{
		int i = 0, j = 0, k = 0;
		while (i <= uLen - 1 && j <= vLen - 1)
		{
			if (U[i] < V[j])
			{
				array[k] = U[i];
				i++;
			}
			else
			{
				array[k] = V[j];
				j++;
			}
			k++;
		}
		if (i > uLen - 1)
		{
			while (j <= vLen - 1)
			{
				array[k] = V[j];
				j++;
				k++;
			}
		}
		else
		{
			while (i <= uLen - 1)
			{
				array[k] = U[i];
				i++;
				k++;
			}
		}
	}
	
	public void quickSort1(int[] array, int low, int high)
	{
		int pivotpoint;
		if (high > low)
		{
			pivotpoint = partition(array, low, high);
			quickSort1(array, low, pivotpoint - 1);
			quickSort1(array, pivotpoint + 1, high);
		}
		else
			return;
	}
	
	private int partition(int[] array, int low, int high)
	{
		int j = low;
		int pivotitem = array[low];
		int temp;
		
		for (int i = low + 1; i <= high; i++)
		{
			if(array[i] < pivotitem)
			{
				j++;
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}	
		}
		temp = array[low];
		array[low] = array[j];
		array[j] = temp;
		return j;
	}
	
	public void quickSort2(int[] array, int low, int high)
	{
		if (high <= 16)
			insertionSort(array, low, high);
		else
		{
			int pivotpoint;
			if(high > low)
			{
				pivotpoint = partition(array, low, high);
				if ((pivotpoint - 1) <= 16)
					insertionSort(array, low, pivotpoint - 1);
				else
					quickSort2(array, low, pivotpoint - 1);
				
				if ((high - (pivotpoint + 1)) <= 16)
					insertionSort(array, pivotpoint + 1, high);
				else
					quickSort2(array, pivotpoint + 1, high);
			}
		}
	}
	
	public void quickSort3(int[] array, int low, int high)
	{
		int pivotpoint;
		if(high > low)
		{
			if ((high - low) > 16)
			{
				int random = rand.nextInt(high - low) + low;
				int temp = array[low];
				array[low] = array[random];
				array[random] = temp;
			}
			pivotpoint = partition(array, low, high);
			quickSort3(array, low, pivotpoint - 1);
			quickSort3(array, pivotpoint + 1, high);
		}
	}
	
}
