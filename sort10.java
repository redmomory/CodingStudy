import java.util.Random; // import module.project.class
// module�� ���� ū���� module>project>class
// Random(Class)���ִ� nextInt�Լ��� ����ϱ� ���� import ��Ŵ

//���� ����
//100000�� ���� �����ϴµ� �ɸ� �ð� : 15.546(s)
//���� ���� �־ ���� ����

public class sort10 { // main class
	public static void main(String args[])// cmd ��ɾ� �޴� args �迭�� �Է����� ���� (�ʼ�)
	{
		int mediate =0; // �Ű�ü
		Random random = new Random(); // RandomŬ���� ��ü�� ����
		int arr[] = new int[100000]; 		
		int sort_arr[]= new int[100000]; // ��迭 ��ų �迭�� ����
		
		int len = arr.length; // �迭�� ũ�Ⱑ �����
		
		for(int j=0; j<len; j++)
		{
			arr[j]= random.nextInt(len)+1;//(1~len)�� �ش��ϴ� �����߻�
		}
		for(int j=0; j<len; j++)
		{
			sort_arr[j]=0;
		}
		
		long beforeTime = System.currentTimeMillis();//���� �ð��� ����
		// array�� �����ϴ� ���� ä�� ���� algorithm
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
		long afterTime = System.currentTimeMillis(); //���� �ð�����	
		double secDiffTime = ((double)(afterTime - beforeTime))/1000;//sec�� ǥ���ϱ����ѽ�
		System.out.println("�ð�����: "+secDiffTime+"(s)");//�ɸ��ð� ���
		
		//���� �Ǿ����� Ȯ���ϱ� ���� debug�� drag�ؼ� "  ctrl + / " //����� ���鶧�� �Ȱ����ϸ�˴ϴ�. 
//		for(int i=0; i<len; i++)
//		{
//			System.out.print(sort_arr[i]+" ");
//		}
	}
}
