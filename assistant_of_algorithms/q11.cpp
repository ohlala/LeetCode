#include<iostream> 
#include<fstream> 
#include<algorithm> 
#include<vector> 
using namespace std;

class Edge {
public:	
	int u, v, weight;
	friend bool operator<(const Edge& E1, const Edge& E2)
	{
		return E1.weight < E2.weight;
	}
};

void Make_Set(vector<int>& vset, int vertices) {
	vset.assign(vertices, 0);
	for (size_t i = 0; i < vertices; i++)
		vset[i] = i;
}

void Union(int& u, int& v) {
	v = u;
}

int Find_Set(vector<int>& vset, int v) {
	while (vset[v] != v)
		v = vset[v];
	return v;
}


void MST_Kruskal(vector<Edge>& graph, int vertices) {
	vector<int> vset;
	Make_Set(vset, vertices);
	vector<Edge> MST;
	int e1, e2, cost = 0;
	for (size_t i = 0; i < vertices; i++)
	{
		e1 = Find_Set(vset, graph[i].u);
		e2 = Find_Set(vset, graph[i].v);
		if (e1 != e2) {
			cost += graph[i].weight;
			MST.push_back(graph[i]);
			Union(vset[e1], vset[e2]);
		}
	}
	cout << "coust: " << cost << endl << "MST:";
	for (size_t i = 0; i < MST.size(); i++)
	{
		cout << "<" << MST[i].u << "," << MST[i].v << ">";
	}
}

int main() {
	int vertices, edges;	
	vector<Edge> graph;
	ifstream input;
	input.open("in.txt");
	input >> vertices >> edges;
	graph.assign(edges, Edge());
	for (size_t i = 0; i < edges; i++)
		input >> graph[i].u >> graph[i].v >> graph[i].weight;
	input.close();
	
	sort(graph.begin(), graph.end());
	MST_Kruskal(graph, edges);

	getchar();
	return 0;
}