/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
#include<bits/stdc++.h>
using namespace std;

void print(int arr[5][5]) {
    for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }
};

vector<string> get_locations(string& artifacts) {
    vector<string> location;
    string temp;

    for(char c : artifacts) {
        if(c != ',') {
            temp += c;
        } else {
            location.push_back(temp);
        }
    }
    location.push_back(temp);

    return location;
};


vector<string> get_searched_locations(string& searched) {
    vector<string> location;
    string temp;

    for(char c : searched) {
        if(c != ' ') {
            temp += c;
        } else {
            location.push_back(temp);
        }
    }
    location.push_back(temp);

    return location;
};

int main() {
    int n = 5, arr[5][5], treasure_id = 1;
    vector<int> ans (2);
    string artifacts, temp, searched;
    map<int, int> pieces;
    memset(arr, 0, sizeof(arr));

    vector<string> locations, visited;
    visited = {"2B", "2D", "3D", "4D", "4A"};
    locations = {"1B 2C", "2D 4E"};
    // locations = get_locations(artifacts);
    // visited = get_searched_locations(searched);

    for(string location : locations) {
        int start_row = location[0] - '0', start_col = location[1] - 'A';
        int end_row = location[3] - '0', end_col = location[4] - 'A';
        cout << start_row << " " << start_col << endl;
        cout << end_row << " " << end_col << endl;
        for(int i = start_row; i <= end_row; i++) {
            for(int j = start_col; j <= end_col; j++) {
                arr[i][j] = treasure_id;
                pieces[treasure_id]++;
            }
        }

        treasure_id++;
    }
    print(arr);
    for(string check : visited) {
        int row = check[0] - '0', col = check[1] - 'A';
       
        int treasue = arr[row][col];
        if(treasue != 0) {
            pieces[treasue]--;
        }
    }

    for(map<int, int> :: iterator it = pieces.begin(); it != pieces.end(); it++) {
        if(it -> second == 0)
            ans[0]++;
        else
            ans[1]++;
    }

    cout << "Complete treasure: " << ans[0] << "\n";
    cout << "Incomplete treasure: " << ans[1] << "\n";
    return 0;
}
