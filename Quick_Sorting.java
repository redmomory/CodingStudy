import java.util.Random;
// 2019-07-24
//Quick Sorting 
//100,000,000를 정렬하는데 걸린시간 약 20초 (실행마다 약간씩 차이가있음)
//같은 숫자 있어도 정렬 가능

public class Quick_Sorting {
// public class 내에 함수를 선언 할때는 public static 을 꼭 적어두어야한다.
// java는 객체에 개념을 이용하기때문임
// 객체 <= 배열,String,Class 등
// Class가 객체이기 때문에 "객체 생성"을 하지 않으면 내부에 함수를 사용할 수 가 없음
// Class 파일에서는 public class를 오직 하나만 만들수 있으며  그안에 main문을 만들수 있다.
// 이때 main은 public static에 해당한다.
// public은 다른 class에서도 이 class를 사용할 수있는 접근 권한이다.
// static은 프로그램이 실행할때 처음에 객체를 생성하는것을 static이라고 한다.
// 따라서  main문이 있는 class는 따로 클래스 객체 생성을 안하기 때문에 클래스에서 함수를 생성시에는 static을 붙여줘야합니다.
	
	public static void Swap(int arr[], int idx1, int idx2)//Swap함수
	{
		int temp = arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=temp;
	}
	public static int Partition(int arr[],int left, int right)// Partition함수
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
		System.out.println("시간차이 : "+secDiffTime+"(s)");
		
//		for(int i=0; i<len; i++)
//		{
//			System.out.print(arr[i]+" ");
//		}
		System.out.print("Done");
	}
}
