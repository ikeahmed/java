package com.me.inherritance.employee;

class Programmer extends Employee implements Trainable{
String[] programmingLanguages;
void writeCode() {}
void accessBaseClassMembers() {
this.name = "Programmer";
  }
}
