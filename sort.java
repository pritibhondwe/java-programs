 public class sort 
{
    public static void bubbleSort(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-1-i;j++)
            {
            if(arr[j+1]<arr[j])
            {
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
            }
        }
    }
     public static void selectionSort(int arr[],int n)
    {
        for(int i=0;i<n-1;i++)
        {
            int minind=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[minind])
                {
                    minind=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minind];
            arr[minind]=temp;
        }
    }
     public static void insertionSort(int arr[],int n)
    {
        for(int i=1;i<n;i++)
        {
            int key=arr[i],j=i-1;
            while(j>=0&&key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void printArray(int arr[])
    {
        for(int x:arr)
        {
            System.out.println(x);
        }
    }
    public static void main(String[] args)
    {
        int arr[]={6,2,1,3,4,5};
        int n=arr.length;
         bubbleSort(arr,n);
          selectionSort(arr,n);
        insertionSort(arr, n);
        printArray(arr);
        
        
    }
}
 