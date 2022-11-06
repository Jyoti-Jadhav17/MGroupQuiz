package com.miniproject.quiz.java;
// creating POJO class
public class Questions {
  private String Question;
   private String A;
   private String B;
   private String C;
   private String D;
   
    
public Questions(String question,String a, String b, String c, String d) {
	super();
	Question = question;
	this.A = a;
	this.B = b;
	this.C = c;
	this.D = d;
}
public String getQuestion() {
	return Question;
}
public void setQuestion(String question) {
	Question = question;
}
public String getA() {
	return A;
}
public void setA(String a) {
	A = a;
}
public String getB() {
	return B;
}
public void setB(String b) {
	B = b;
}
public String getC() {
	return C;
}
public void setC(String c) {
	C = c;
}
public String getD() {
	return D;
}
public void setD(String d) {
	D = d;
}
@Override
public String toString() {
	return  "Q)"+Question + "\n " +"A)"+ A + "\n " +"B)"+ B + " \n " +"C)"+ C + " \n " +"D)"+ D +"\n" ;
}


   
}
