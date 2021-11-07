
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[] {9,8,7,6,5,4,3,2,1};
		int[] arr2=new int[] {1,1,1,1,1,1,1,1,0,2};
		JobFairImpr.doSomething(arr,arr.length);
		System.out.println("FIRST OUTPUT:");
		for(int i=0;i<arr2.length;i++)
			System.out.print(" " +arr2[i]);
		System.out.println();
		System.out.println("SECOND OUTPUT:");
		for(int i=0;i<arr.length;i++)
			System.out.print(" " +arr[i]);
	}

}
