package com.javas.patterns.no7.composite.round4;

public class Leaf extends Component {

  private String     data;


  public Leaf() {
  }

  public Leaf(String data) {
    this.data = data;
  }


  @Override
  public void display(int level) {
    String prefix = "";
    for (int i = 0; i < level; i++) {
      prefix += "-";
    }
    System.out.println(prefix + this.data);
  }

}
