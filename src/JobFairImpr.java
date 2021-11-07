import java.util.Arrays;

class JobFairImpr {
    public static int CS(int[] arr,int ind){		//rekurzivna funkcija za racunanje rekurzivne sume niza do odredjenog indeksa
        if(ind==0)
        return arr[ind];
        else
        {
            return (arr[ind]+ CS(arr,ind-1));
        }
    }
    public static void CSNiz(int[] arr)			//Usluzna funkcija koja ce vrsiti kumulativnu sumu za dati niz
    {
        int[] nniz=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            nniz[i]=CS(arr,i);
        }
        for(int i=0;i<arr.length;i++)
        	if(arr[i]!=0)
        		arr[i]=nniz[i];
    }
    public static int[] unsortedIndexes(int[] arr)
    {
    	int[] copyOfArr=new int[arr.length];
    	for(int i=0;i<arr.length;i++)
    		copyOfArr[i]=arr[i];							//pravimo kopiju originalnog niza
    	int[] arrOfProperIndexes=new int[arr.length];		//ovde cuvamo originalne pozicije tj indekse
    	 for(int i=copyOfArr.length-1;i>=0;i--)
     		arrOfProperIndexes[i]=i;						// originalni raspored indeksa
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=0;j<arr.length;j++)
    		{
    			if(copyOfArr[j]>copyOfArr[i])
    			{
    				int tmp=copyOfArr[i];
    				copyOfArr[i]=copyOfArr[j];				//sortiramo kopirani niz, i u isto vreme i niz indeksa
    				copyOfArr[j]=tmp;
       				int tmp2=arrOfProperIndexes[i];
    				arrOfProperIndexes[i]=arrOfProperIndexes[j];
    				arrOfProperIndexes[j]=tmp2;
    			}
    		}
    	}
    	return arrOfProperIndexes;
    }
static void doSomething(int array[], int size) { // Array contains non-negative integers
    int[] output = new int[size];

    // Find the largest element of the array
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];				//bez i++
    }
    int[] count = new int[max+1];

    // Initialize count array with all zeros.
    // Store the count of each element
    for (int i = 0; i < size; i++) {							//i<size
      count[array[i]]++;										//frekvencija svakog clana 
    }

   CSNiz(count);												//ZAMENJENA SA CS

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
   	int check=0;												//uvodimo checker kako bi proverili da li je element count[j+1] u kumulativnom nizu koji sledi nakon elementa count[j] ima vecu vrednost od count[j]
   	int ctr=0;													//sto bi nam govorilo da se kumulativna frekvencija tog clana uvecala, sto znaci da imamo taj clan u originalnom nizu
    for(int i=0;i<count.length;i++)
    {
    	if((count[i]!=0))										//ako element nije 0, znaci da element postoji u nasem nizu
    	{
    		while(count[i]-check!=0)							// ako se element vise puta pojavljuje u nasem nizu, u niz output cemo ga pakovati x puta, gde je x vrednost count[i]-check
    		{
    		output[ctr++]=i;
    		check++;											//check uvecavamo svaki put kada dodamo novi element, kako bi mogli da proverimo koliko puta trebamo dodati sledeci element
    		}
    	}
    }															//nakon ove funckije imacemo niz output koji je zapravo samo sortiran niz array, zbog cega smo pravili unsortedIndexes funkciju
    int[] arrayOfProperInd=unsortedIndexes(array);				//pravimo niz sortiranih originalnih indeksa
    // Copy elements into original array
    for (int i = 0; i < size; i++) {	
      array[arrayOfProperInd[i]] = output[i];						//pakujemo po originalnom rasporedu nazad u array. arrayOfProperInd ce nam vratiti niz koji nam ukazuje originalne pozicije clanove u nizu
    }																//npr, prvi clan arrayOfProperInd ukazuje na originalnu poziciju prvog clana output niza, itd
  }
}
