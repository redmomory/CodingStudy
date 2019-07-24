
public class FindingMax {
	public static void main(String args[])
	{
		int arr[] = {3,4,5,1,2,6,10,7,8,9};
		int max=0;
		
		for(int i=0; i<10; i++)
		{
			if(max<arr[i])
				max=arr[i];
		}
		System.out.println(max);
	}
}
