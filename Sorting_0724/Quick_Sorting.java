import java.util.Random;
// 2019-07-24
//Quick Sorting 
//100,000,000�� �����ϴµ� �ɸ��ð� �� 20�� (���ึ�� �ణ�� ���̰�����)
//���� ���� �־ ���� ����

public class Quick_Sorting {
// public class ���� �Լ��� ���� �Ҷ��� public static �� �� ����ξ���Ѵ�.
// java�� ��ü�� ������ �̿��ϱ⶧����
// ��ü <= �迭,String,Class ��
// Class�� ��ü�̱� ������ "��ü ����"�� ���� ������ ���ο� �Լ��� ����� �� �� ����
// Class ���Ͽ����� public class�� ���� �ϳ��� ����� ������  �׾ȿ� main���� ����� �ִ�.
// �̶� main�� public static�� �ش��Ѵ�.
// public�� �ٸ� class������ �� class�� ����� ���ִ� ���� �����̴�.
// static�� ���α׷��� �����Ҷ� ó���� ��ü�� �����ϴ°��� static�̶�� �Ѵ�.
// ����  main���� �ִ� class�� ���� Ŭ���� ��ü ������ ���ϱ� ������ Ŭ�������� �Լ��� �����ÿ��� static�� �ٿ�����մϴ�.
	
	public static void Swap(int arr[], int idx1, int idx2)//Swap�Լ�
	{
		int temp = arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=temp;
	}
	public static int Partition(int arr[],int left, int right)// Partition�Լ�
	{
		int pivot = arr[left];
		int low = left+1;
		int high = right;
		
		while(low < high)
		{
			while(pivot > arr[low])
			{
				low++;
				if(low >= right)
					break;
			}
			while((pivot <= arr[high]))
			{
				high--;
				if((high <= left+1))
					break;
			}
			if(low <= high) 
			{
				Swap(arr,low,high);
			}
		}
		if(high != (left+1))
		Swap(arr,left,high);
		else if(pivot >arr[high])
		Swap(arr,left,high);
		
		return high;
	}
	
	public static void QuickSort(int arr[], int left, int right)
	{
		if(left <= right) {
			int pivot = Partition(arr,left,right);
			if(left!=pivot-1)
			QuickSort(arr,left,pivot-1);
			if(pivot+1!=right)
			QuickSort(arr,pivot+1,right);
		}
	}
	
	public static void main(String args[])
	{
		Random random = new Random();
		int arr[] = new int[100000000];
		
		int len = arr.length;
		
		for(int j=0; j<len; j++)
		{
			arr[j]= random.nextInt(100000000)+1;
		}
		
		long beforeTime = System.currentTimeMillis();
		QuickSort(arr,0,len-1);
		long afterTime = System.currentTimeMillis(); 
		
		double secDiffTime = (((double)(afterTime - beforeTime))/1000);
		System.out.println("�ð����� : "+secDiffTime+"(s)");
		
//		for(int i=0; i<len; i++)
//		{
//			System.out.print(arr[i]+" ");
//		}
		System.out.print("Done");
	}
}
