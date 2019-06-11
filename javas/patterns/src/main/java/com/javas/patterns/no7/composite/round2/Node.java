package com.javas.patterns.no7.composite.round2;

import java.util.ArrayList;
import java.util.List;

public class Node {

  private String     data;
  private List<Node> childs;


  public Node() {
  }

  public Node(String data) {
    this.data = data;
  }

  public void addChild(Node child) {
    if (null == childs) {
      childs = new ArrayList<>();
    }
    childs.add(child);
  }

  public void removeChild(Node child) {
    if (null != childs && childs.contains(child)) {
      childs.remove(child);
    }
  }

  public void display(int level) {
    String prefix = "";
    for (int i = 0; i < level; i++) {
      prefix += "-";
    }
    System.out.println(prefix + this.data);
    if (null != childs) {
      for (Node child : childs) {
        child.display(level + 1);
      }
    }
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public List<Node> getChilds() {
    return childs;
  }

  public void setChilds(List<Node> childs) {
    this.childs = childs;
  }

  @Override
  public String toString() {
    return "Node{" + "data='" + data + '\'' + ", childs=" + childs + '}';
  }
}
