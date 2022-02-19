#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>

using namespace std;

/*
    LEFT -> 0, -1
    RIGHT -> 0, 1
    UP -> -1, 0
    DOWN -> 1, 0
*/

#define PATH '-'
#define PACMAN 'P'
#define FOOD '.'

typedef tuple<int, int> Position;
typedef vector<Position> Node;
typedef vector<tuple<Position, Node>> NodeInfo;


Position Direction[] = {
                        {-1, 0},    // UP
                        {0, -1},    // LEFT
                        {0, 1},     // RIGHT 
                        {1, 0}      // DOWN   
                       }; 


void dfs( int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, vector <string> grid){
    
    NodeInfo nodeinfo;
    
    Node node;
    Node node_explored;
    Node final_route;
    
    nodeinfo.push_back({{pacman_r, pacman_c}, node});
    while(!nodeinfo.empty()){
        auto current = nodeinfo[nodeinfo.size()-1];
        nodeinfo.pop_back();
        
        auto pos = get<0>(current);
        auto route = get<1>(current);
        
        route.push_back(pos);
        node_explored.push_back(pos);
        
        auto rcur = get<0>(pos);
        auto ccur = get<1>(pos);
        if(rcur == food_r && ccur == food_c){
            final_route = route;
            break;
        }
        
        for(auto direction : Direction){
            auto rnext = rcur + get<0>(direction);
            auto cnext = ccur + get<1>(direction);
            
            if((rnext < 0) || (rnext >= r) || (cnext < 0) || (cnext >= c)) continue;
            if(grid[rnext][cnext] == PATH || grid[rnext][cnext] == FOOD){
                grid[rnext][cnext] = PACMAN;
                nodeinfo.push_back({{rnext, cnext}, route});
            }
        }
    }
    
    cout << node_explored.size() << endl;
    for(auto pos : node_explored){
        auto row = get<0>(pos);
        auto col = get<1>(pos);
        cout << row << " " << col << endl;
    }
    
    cout << final_route.size() - 1<< endl;
    for(auto pos : final_route){
        auto row = get<0>(pos);
        auto col = get<1>(pos);
        cout << row << " " << col << endl;
    }
    
}

int main(void) {

    int r,c, pacman_r, pacman_c, food_r, food_c;
    
    cin >> pacman_r >> pacman_c;
    cin >> food_r >> food_c;
    cin >> r >> c;
    
    vector <string> grid;

    for(int i=0; i<r; i++) {
        string s; cin >> s;
        grid.push_back(s);
    }

    dfs( r, c, pacman_r, pacman_c, food_r, food_c, grid);

    return 0;
}
