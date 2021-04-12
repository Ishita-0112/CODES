#include <bits/stdc++.h>
using namespace std;

vector<int> minDiff(int* arr, int n, int p, int q){
  priority_queue<pair<int, int>> maxH;
  
  for(int i = 0; i < n; i++){
    maxH.push({abs(arr[i]-p), arr[i]});
    
    if(maxH.size()>q)
      maxH.pop();
  }
  
  vector<int> res;
  while(!maxH.empty()){
    res.push_back(maxH.top().second);
    maxH.pop();
  }
  
  return res;
}
  
int main(){
  //write your code here
  int t;
  cin >> t;
  
  while(t--){
    int n, p, q;
    cin >> n >> p >> q;
    
    int sectors[n];
    for(int i = 0; i < n; i++)
      cin >> sectors[i];
      
    vector<int> res;
    res = minDiff(sectors, n, p, q);
    
    for(int i = 0; i < res.size(); i++)
      cout << res[i] << " ";
    
    cout << endl;
  }
  return 0;
}
