#include <iostream>
#include <string>
using namespace std;


int main() {
    int N = 0, K = 0;
    string str, dummy;
    cin >> N; getline(cin, dummy);
    getline(cin, str);
    cin >> K;
    int len = str.length();
    for (int i = 0; i < len; ++i)
        {
        if (65 <= str[i] && str[i] <= 90)
            str[i] = char(65 + ((str[i] - 65) + K) % 26);
        else if (97 <= str[i] && str[i] <= 122)
            str[i] = char(97 + ((str[i] - 97) + K) % 26);
    }       
    cout << str << endl;
    return 0;
}
