package graph;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Map;

public class BuildTree {
	private TreeNode rootNode = new TreeNode();
	private LinkedList<String[]> route = new LinkedList<String[]>();
	private int cnt = 0;
	private Message me = new Message();

	/**
	 * 生成根节点
	 * 
	 * @param nodeName
	 * @return
	 */
	public void initRootNode(String nodeName) {
		rootNode.setNodeName(nodeName);
		rootNode.setLeftChild(null);
		rootNode.setRightChild(null);
	}

	/**
	 * 生成子节点
	 * 
	 * @param nodeName
	 * @return
	 */
	public TreeNode initTreeNode(String nodeName) {
		TreeNode treeNode = new TreeNode();
		treeNode.setNodeName(nodeName);
		treeNode.setLeftChild(null);
		treeNode.setRightChild(null);
		return treeNode;
	}

	/**
	 * 插入节点
	 * 
	 * @param parentTreeNode
	 * @param treeNode
	 * @param direction
	 */
	public void insertNode(String parentNodeName, TreeNode childTreeNode,
			String direction) {
		TreeNode treeNode = new TreeNode();
		treeNode = rootNode;
		insertNodeHelp(treeNode, parentNodeName, childTreeNode, direction);

	}

	public void insertNodeHelp(TreeNode treeNode, String parentNodeName,
			TreeNode childTreeNode, String direction) {
		if (treeNode != null) {
			if (treeNode.getNodeName().equals(parentNodeName)) {
				if (direction.equals("left")) {
					treeNode.setLeftChild(childTreeNode);
				} else {
					treeNode.setRightChild(childTreeNode);
				}
			} else {
				insertNodeHelp(treeNode.getLeftChild(), parentNodeName,
						childTreeNode, direction);
				insertNodeHelp(treeNode.getRightChild(), parentNodeName,
						childTreeNode, direction);
			}
		}
	}

	/**
	 * 初始化数据库连接，并按照ID的顺序从数据库中依次读出数据
	 */
	public void buildTree() {
		String nodeName = null;
		String parent = null;
		String direction = null;

		// 初始化根节点
		initRootNode("0");

		try {
			Connection con = connectSql();
			Statement statement = con.createStatement();
			String sql = "select * from tree ORDER BY id ASC";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				nodeName = rs.getString("name");
				parent = rs.getString("parent");
				direction = rs.getString("direction");
				TreeNode childTreeNode = initTreeNode(nodeName);
				insertNode(parent, childTreeNode, direction);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 遍历树，并记录所有的遍历路径
	 * 
	 * @param args
	 */
	public void traverseTree(TreeNode treeNode, String direction) {
		if (treeNode == null) {
			if (route.size() > 1) {
				wirteResult(route);
			}
		} else if (treeNode.getNodeName().equals("24")) {

		} else {
			String[] nameAndDir = new String[2];
			nameAndDir[0] = treeNode.getNodeName();
			nameAndDir[1] = direction;
			route.add(nameAndDir);
			traverseTree(treeNode.getLeftChild(), "left");
			traverseTree(treeNode.getRightChild(), "right");

			route.removeLast();
		}
	}

	/**
	 * 将结果写入数据库中，同时对结果进行解析
	 * 
	 * @return
	 */
	public void wirteResult(LinkedList<String[]> result) {
		String message = "";
		String re="";
		for (String[] res : result) {
			// System.out.print(res[0]+" ");
			if (Integer.parseInt(res[0]) != 0) {
				re+=res[0]+" ";
				if (res[1].equals("left")) {
					message += ":是," + me.getMessage(Integer.parseInt(res[0]));
				} else {
					message += ":否," + me.getMessage(Integer.parseInt(res[0]));
				}
			}
		}
		// System.out.println();
		message = message.substring(3);
		message += ":否";
		// System.out.println(message);
		String sql = "insert into result(id,result,message)values(?,?,?)";
		Connection con = connectSql();
		try {
			PreparedStatement preStmt = con.prepareStatement(sql);
			preStmt.setInt(1,cnt);
			preStmt.setString(2,re); 
			preStmt.setString(3, message); 
			preStmt.executeUpdate();  
		} catch (SQLException e) {
			e.printStackTrace();
		}

		cnt++;
	}

	/**
	 * 连接数据库
	 * 
	 * @return
	 */
	public Connection connectSql() {
		// 声明Connection对象
		Connection con = null;
		// 驱动程序
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/test";
		// MySQL配置时的用户
		String user = "guochuang";
		// MySQL配置时的密码
		String password = "123456";
		// 加载驱动程序
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.getConnection()方法，连接MySQL数据库
		return con;
	}

	public TreeNode getRootNode() {
		return rootNode;
	}

	public int getCnt() {
		return cnt;
	}

	public static void main(String[] args) {
		BuildTree buildTree = new BuildTree();
		buildTree.buildTree();
		// buildTree.getRootNode().getNodeName();
		buildTree.traverseTree(buildTree.getRootNode(), "left");
		System.out.println(buildTree.getCnt());
	}
}
