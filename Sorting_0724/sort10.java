import java.util.Random; // import module.project.class
// module이 가장 큰개념 module>project>class
// Random(Class)에있는 nextInt함수를 사용하기 위해 import 시킴

//선택 정렬
//100000에 수를 정렬하는데 걸린 시간 : 15.546(s)
//같은 숫자 있어도 정렬 가능

public class sort10 { // main class
	public static void main(String args[])// cmd 명령어 받는 args 배열을 입력으로 받음 (필수)
	{
		int mediate =0; // 매개체
		Random random = new Random(); // Random클래스 객체를 생성
		int arr[] = new int[100000]; 		
		int sort_arr[]= new int[100000]; // 재배열 시킬 배열을 생성
		
		int len = arr.length; // 배열에 크기가 저장됨
		
		for(int j=0; j<len; j++)
		{
			arr[j]= random.nextInt(len)+1;//(1~len)에 해당하는 난수발생
		}
		for(int j=0; j<len; j++)
		{
			sort_arr[j]=0;
		}
		
		long beforeTime = System.currentTimeMillis();//현재 시간이 저장
		// array에 가장하단 부터 채워 놓는 algorithm
		// example
		// 1 2 3  ---- 0 0 0
		// 1 2 3  ---- 1 0 0
		// 1 2 3  ---- 0 1 0 
		// 1 2 3  ---- 0 0 1 
		// 1 2 3  ---- 2 0 1
		// 1 2 3  ---- 0 2 1
		// 1 2 3  ---- 0 1 2
		// 1 2 3  ---- 3 1 2 
		// 1 2 3  ---- 1 3 2
		// 1 2 3  ---- 1 2 3 
		for(int i=0; i<len; i++)
		{
			sort_arr[0]=arr[i];
			for(int j=1; j<len; j++)
			{
				if(sort_arr[j]<sort_arr[j-1])
				{
					mediate=sort_arr[j];
					sort_arr[j]=sort_arr[j-1];
					sort_arr[j-1]=mediate;
				}
			}
		}
		long afterTime = System.currentTimeMillis(); //현재 시간저장	
		double secDiffTime = ((double)(afterTime - beforeTime))/1000;//sec를 표현하기위한식
		System.out.println("시간차이: "+secDiffTime+"(s)");//걸린시간 출력
		
		//정렬 되었는지 확인하기 위한 debug용 drag해서 "  ctrl + / " //사라짐 만들때도 똑같이하면됩니다. 
//		for(int i=0; i<len; i++)
//		{
//			System.out.print(sort_arr[i]+" ");
//		}
	}
}
