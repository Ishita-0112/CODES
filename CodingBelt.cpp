/* 
Coding Belt (100 Marks)

A state is divided into R*C cities.The government has launched an initiative to find the cities which are dominated by coders. Each city may or may not have coders residing in it. If the city is dominated by coders, it is marked with 1 else it is marked with 0. Two cities are termed as connected cities if they both are dominated by coders and can be reached by moving vertically, horizontally, or diagonally.

Example:

The given is the state with 3*3 cities and their dominance representation.


City[1, 1] is directly connected to City[1, 2].

City[1, 2] is directly connected to City[1, 1], City[1, 3] and City[2, 3].

City[1, 3] is directly connected to City[1, 2] and City[2, 3].

City[2, 3] is directly connected to City[1, 2] and City[1, 3].

City[3, 1] is not connected to any of the other coder dominant cities.

One or more coder dominant connected cities form the Coding belt. In a belt, there may be coder dominant cities which are not directly connected but can be reached by moving through other dominant cities. It is possible that there are multiple coding belts in the state. 

Example:

The given is the state with 3*3 cities and their dominance representation.


For the given example, there are two coding belts. C1 represents Coding Belt 1 and C2 represents Coding Belt 2.

 


The government wants to find the number of coder dominant cities in the largest coding belt.

The government will give you the credits in the initiative. Can you help the government?

Note: For the given example, there are 4 coder dominant cities in the largest coding belt.

Input Format

The first line of input consists of two space-separated integers, number of rows, R, and number of columns, C.

Next R lines each consist of C space-separated integers.


Constraints
1<= R, C <=10

Output Format
Print the number of coder dominant cities in the largest Coding belt.
*/



#include<bits/stdc++.h>

using namespace std;

int mx=0;

int r,c;

pair<int,int>moved[]={ {-1,-1}, {-1,0} , {-1,1} , {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} };

bool issafe(int x,int y)

{

    if(x>=0&&x<r &&y>=0 &&y<c)

    {

        return true;

    }

    return false;

}

void dfs(int i,int j,int &cnt,vector<vector<int>>&adj,vector<vector<bool>>&vis)

{

    vis[i][j]=true;

    for(int k=0;k<8;k++)

    {

        int n_i=i+moved[k].first;

        int n_j=j+moved[k].second;

        if(issafe(n_i,n_j) && adj[n_i][n_j]==1 && vis[n_i][n_j]==false)

        {

            cnt++;

            dfs(n_i,n_j,cnt,adj,vis);

        }

    }

}

int main()

{

    cin>>r>>c;

    vector<vector<int>>adj(r,vector<int>(c));

    for(int i=0;i<r;i++)

    {

        for(int j=0;j<c;j++)

        {

            cin>>adj[i][j];

        }

    }

    vector<vector<bool>>vis(r,vector<bool>(c,false));

    for(int i=0;i<r;i++)

    {

        for(int j=0;j<c;j++)

        {

            if(vis[i][j]==false && adj[i][j]==1)

            {

                int cnt=1;

                dfs(i,j,cnt,adj,vis);

                mx=max(mx,cnt);

            }

        }

    }

    cout<<mx<<"\n";

}



