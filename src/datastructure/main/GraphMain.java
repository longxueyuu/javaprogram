package datastructure.main;

import util.CustomizePrint;
import datastructure.graph.Graph;
import datastructure.node.graphnode.VertexNode;

public class GraphMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �����ڽӾ���
//		Graph graph = new Graph();
//		int[][] g = new int[3][3];
//		graph.adjMatrix(g, 3, 3);
//		for(int i = 0; i < 3; i++)
//		{
//			for(int j = 0; j < 3; j++)
//			{
//				System.out.print(g[i][j] + " ");
//			}
//			System.out.print("\n");
//		}
		
		// �����ڽӱ�
		
		// ͼ�б���Ϣ���飬��һ�б�ʾ�ñߵ�ʼ�㣬�ڶ��б�ʾ�ñߵ��յ㣬�����б�ʾ�ñߵ�Ȩֵ
		int[][] edge = new int[][]{ // �����
				{1,3,2},
				{1,2,10},
				{3,4,2},
				{3,6,11},
				{4,6,6},
				{4,5,4},
				{6,7,3},
				{5,7,7},
				{2,5,1},	
				{3,1,2},
				{2,1,10},
				{4,3,2},
				{6,3,11},
				{6,4,6},
				{5,4,4},
				{7,6,3},
				{7,5,7},
				{5,2,1}		
		};
		edge = new int[][]{ // �����
				{1,2,0},
				{1,3,0},
				{1,5,0},
				{2,3,0},
				{5,4,0},
				{4,3,0},
				{6,7,0},
				{2,1,0},
				{3,1,0},
				{5,1,0},
				{3,2,0},
				{4,5,0},
				{3,4,0},
				{7,6,0}
		};
		
		int VERTEX_NUMBER = 7; // ͼ������Ŀ
		int[] vertexIndegree = new int[]{0, 0, 0, 0, 0, 0, 0}; //������ȣ���������ͼû����ȸ���ڴ˰��������Ϊ0
		CustomizePrint.print2DArray("�߽����Ϣ����", edge);
		Graph graph = new Graph();
		VertexNode[] vertex = new VertexNode[VERTEX_NUMBER];
		graph.adjList(vertex, edge, vertexIndegree);
		graph.printGraph(vertex);
		
		// ����ͼ�ı���
		int[] visited = new int[vertex.length];
		System.out.print("������ȱ���ͼ��");
		graph.travelDFS(vertex, visited);
		System.out.println();
		
		System.out.print("������ȱ���ͼ��");
		graph.travelBFS(vertex, visited);
		System.out.println();
		
		// �������·��
		edge = new int[][]{ // �����
				{1,3,2},
				{1,2,10},
				{3,4,2},
				{3,6,11},
				{4,6,6},
				{4,5,4},
				{6,7,3},
				{5,7,7},
				{2,5,1},	
				{3,1,2},
				{2,1,10},
				{4,3,2},
				{6,3,11},
				{6,4,6},
				{5,4,4},
				{7,6,3},
				{7,5,7},
				{5,2,1}		
		};
		VERTEX_NUMBER = 7; 
		int[][] cost = new int[VERTEX_NUMBER][VERTEX_NUMBER];
		int[][] path = new int[VERTEX_NUMBER][VERTEX_NUMBER];
		int[] dist = new int[VERTEX_NUMBER];
		int startPoint = 7;
		Graph graph2 = new Graph();
		graph2.adjMatrix(cost, edge);
		CustomizePrint.print2DArray("�ڽӾ���", cost);
		graph2.shortestPath(dist, cost, startPoint, path);
		System.out.println("*****************************************************");
		CustomizePrint.printArray("���·��ֵ", dist);
		CustomizePrint.print2DArray("���·������˳��", path);
		System.out.println("*****************************************************");
		
		//����ɾ��ͼ��һ�����
		vertex = graph.deleteVertex(vertex, 1);
		graph.printGraph(vertex);
		System.out.print("������ȱ���ͼ��");
		graph.travelDFS(vertex, visited);
		System.out.println();
		System.out.print("������ȱ���ͼ��");
		graph.travelBFS(vertex, visited);
		System.out.println();
		
		
		// ��������ͼ����������
		VERTEX_NUMBER = 7; // ������Ŀ
		vertexIndegree = new int[]{0, 0, 1, 2, 1, 1, 3};
		edge = new int [][]{ // �����
				{1,3,0},	
				{1,4,0},
				{2,4,0},
				{2,5,0},
				{4,7,0},
				{5,7,0},
				{3,6,0},
				{3,7,0}
				
		};
		
		VERTEX_NUMBER = 15; // ������Ŀ
		vertexIndegree = new int[]{0, 2, 2, 2, 1, 1, 3, 1, 1, 2, 1, 2, 0, 1, 1};
		edge = new int [][]{ // �����
				{1,2,0},	
				{1,3,0},
				{1,4,0},
				{1,10,0},
				{3,6,0},
				
				{3,7,0},
				{3,9,0},
				{3,12,0},
				{4,7,0},
				{4,8,0},
				
				{4,10,0},	
				{8,12,0},
				{10,3,0},
				{10,7,0},
				{10,11,0},
				
				{13,4,0},
				{13,14,0},
				{14,2,0},
				{14,15,0},
				{15,5,0}
				
		};
		int[] topoSortSequence = new int[VERTEX_NUMBER];
		CustomizePrint.print2DArray("�߽����Ϣ����", edge); // ��ӡ����Ϣ
		Graph digraph = new Graph(); 
		VertexNode[] divertex = new VertexNode[VERTEX_NUMBER];
		digraph.adjList(divertex, edge, vertexIndegree); // ����ͼ���ڽӱ�
		digraph.printGraph(divertex);
		System.out.println("����ͼ������������");
		digraph.topologicalSort(divertex,topoSortSequence);
		System.out.println("\n---------------");
		CustomizePrint.printArray("����ͼ����������", topoSortSequence);
		//digraph.printGraph(divertex);
	}

}































