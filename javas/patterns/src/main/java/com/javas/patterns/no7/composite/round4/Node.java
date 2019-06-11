package com.javas.patterns.no7.composite.round4;

import java.util.ArrayList;
import java.util.List;

public class Node extends Component {

  private List<Component> childs;

  public Node() {
  }

  public Node(String data) {
    this.data = data;
  }


  public void add(Component child) {
    if (null == childs) {
      childs = new ArrayList<>();
    }
    childs.add(child);
  }

  public void remove(Component child) {
    if (null != childs && childs.contains(child)) {
      childs.remove(child);
    }
  }

  @Override
  public void display(int level) {
    String prefix = "";
    for (int i = 0; i < level; i++) {
      prefix += "-";
    }
    System.out.println(prefix + this.data);
    if (null != childs) {
      for (Component child : childs) {
        child.display(level + 1);
      }
    }
  }

}
