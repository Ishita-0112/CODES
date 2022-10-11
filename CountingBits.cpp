#include<iostream>
using namespace std;

// Time Complexity - O(n^2)
// Auxillary Space Complexity - O(1) ,i.e, without taking into account the space tajen by the desired variable (here the array).

void solve(int arr[],int n){
    for(int i=0;i<n;i++){
        int temp=i;
        int count=0;
        while(temp){
            //Checking if the last bit is 1
            if(temp & 1){
                count+=1;
            }
          
            // Right shift operation
            temp=temp>>1;
        }
      
        arr[i]=count;
    }
}

int main(){
    int n;
    cin>>n;

    int *arr = new int[n+1]{0};
    solve(arr,n+1);

    for(int i=0;i<n+1;i++){
        cout<<arr[i]<<" "<<endl;
    }
    return 0;
}
