import java.util.*;

public class Graph{
	public Node[] nodes;
	public int count;
	public Graph(){
		nodes = new Node[6];
		count = 0;
	}
	public void addNode(Node x){
		if (count < 6){
			nodes[count] = x;
			count++;
		} else {
			System.out.println("Graph is full. Cannot add another node");
		}
	}
	public void addNode(int x){
		if (count < 6){
			nodes[count] = new Node(x);
			count++;
		} else {
			System.out.println("Graph is full. Cannot add another node");
		}
	}
	public void print(){
		for (int i=0;i<count;i++){
			System.out.println(nodes[i]);
		}
	}
	public static boolean hasRoute(Graph graph, Node start, Node end){
		if (start==end) return true;
		for (int i=0;i<graph.count;i++){
			graph.nodes[i].isVisited = false;
		}
		LinkedList<Node> q = new LinkedList<Node>();
		start.isVisited = true;
		q.add(start);
		while(!q.isEmpty()){
			Node u = q.remove();
			if (u==end)return true;
			u.isVisited = true;
			for (int i=0; i<u.adjacent_count;i++){
				Node v = u.adjacent[i];
				if (!v.isVisited){
					q.add(v);
				}
			}
		}
		return false;
	}
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node(0);
		temp[1] = new Node(1);
		temp[2] = new Node(2);
		temp[3] = new Node(3);
		temp[4] = new Node(4);
		temp[5] = new Node(5);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
	public static class Project{
		public String name;
		public ArrayList<Project> dependencies;
		public ArrayList<Project> dependents;
		public Project(String name){
			this.name = name;
			dependencies = new ArrayList<Project>();
			dependents = new ArrayList<Project>();
		}
		public void addDependency(Project a){
			dependencies.add(a);
		}
		public void addDependent(Project a){
			dependents.add(a);
		}
	}
	public static class ProjectGraph{
		private ArrayList<Project> projects;
		public ProjectGraph(){
			projects = new ArrayList<Project>();
		}
		public void addProjects(Project a){
			projects.add(a);
		}
		public ArrayList<Project> getProjects(){
			return projects;
		}
		public void print(){
			for (Project u : projects){
				System.out.println("========PROJECT " + u.name + "========");
				System.out.println("         DEPENDENCIES");
				for (Project a : u.dependencies){
					System.out.println(a.name);
				}
				System.out.println("         DEPENDENTS");
				for (Project b : u.dependents){
					System.out.println(b.name);
				}
			}
		}
	}
	public static ProjectGraph createProjectGraph(String[] projects, String[][] deps){
		HashMap<String, Project> nameToProject = new HashMap<String, Project>();
		for (String name : projects){
			nameToProject.put(name, new Project(name));
		}
		for (int i=0; i<deps.length;i++){
			Project depender = nameToProject.get(deps[i][0]);
			Project depended = nameToProject.get(deps[i][1]);
			depender.addDependency(depended);
			depended.addDependent(depender);
		}
		ProjectGraph finalGraph = new ProjectGraph();
		for (Project comp_proj : nameToProject.values()){
			finalGraph.addProjects(comp_proj);
		}
		return finalGraph;
	}
	public static ArrayList<String> buildOrder(String[] projects, String[][] deps){
		ArrayList<String> finalList = new ArrayList<String>();
		ProjectGraph graph = createProjectGraph(projects, deps);
		LinkedList<Project> q = new LinkedList<Project>();
		for (Project u : graph.getProjects()){
			if (u.dependencies.size()==0){
				q.add(u);
			}
		}
		while (!q.isEmpty()){
			Project u = q.remove();
			finalList.add(u.name);
			for (int i=0; i<u.dependents.size(); i++){
				Project v = u.dependents.get(i);
				v.dependencies.remove(u);
				if (v.dependencies.size()==0){q.add(v);}
			}
		}
		if (finalList.size()!=projects.length) {
			System.out.println("Error: No valid build order");
			return null;
		}
		return finalList;
	}
	public static void main(String[] args){
		// Graph g = createNewGraph();
		// Node[] n = g.nodes;
		// Node start = n[3];
		// Node end = n[5];
		// System.out.println(hasRoute(g, start, end));
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] deps = {{"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}};
		ArrayList<String> test = buildOrder(projects, deps);
		for (int i=0; i<test.size(); i++){
			System.out.print(test.get(i)+"   ");
		}	
	}
}