package com.javas.patterns.no6.prototype.round1;

public class Resume implements Cloneable{

  private String name;
  private String birthday;
  private String gender;
  private String address;
  private String school;
  private String company;

  public Resume clone(){
    Resume resume = null;
    try {
      resume = (Resume) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return resume;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  @Override
  public String toString() {
    return "Resume{" +
           "name='" + name + '\'' +
           ", birthday='" + birthday + '\'' +
           ", gender='" + gender + '\'' +
           ", address='" + address + '\'' +
           ", school='" + school + '\'' +
           ", company='" + company + '\'' +
           '}';
  }
}
