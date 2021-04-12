class Solution {
public:
    string reorganizeString(string S) {
        priority_queue <pair <int, char>> pq;
        map <char, int> m;
        int n = S.size();
        for (int i=0;i<n;i++){
            m[S[i]]++;
        }
        map <char, int> :: iterator i = m.begin();
        while (i!=m.end()){
            pq.push({i->second, i->first});
            i++;
        }
        string ans = "";
        while (!pq.empty()){
            pair <int, char> one = pq.top();
            pq.pop();
            if (pq.empty()){
                if (one.first>1)
                    return "";
                ans += one.second;
                return ans;
            }
            pair <int, char> two = pq.top();
            pq.pop();
            ans += one.second;
            ans += two.second;
            one.first--;
            two.first--;
            if (one.first)
                pq.push(one);
            if (two.first)
                pq.push(two);
        }
        return ans;
    }
};
