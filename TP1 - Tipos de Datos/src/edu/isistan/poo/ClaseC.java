package edu.isistan.poo;

public class ClaseC extends ClaseA {
  
  @Override
  public String metodo2(){
         return "ClaseC.metodo2() llama a super "+super.metodo2()+"\n\t también llama: "+this.metodo1();
  }

  @Override
  public String metodo3(){
    return "ClaseC.metodo3()";
  }

}