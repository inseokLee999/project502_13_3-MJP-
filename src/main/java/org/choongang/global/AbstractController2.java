package org.choongang.global;

import java.util.Scanner;

public abstract class AbstractController2 implements  Controller2{
   protected Scanner sd;
   public AbstractController2(){
       sd = new Scanner(System.in);
   }
    public  void common(){

    }

    public void prompt(){
        System.out.print("메뉴 선택:");
        String menu = sd.nextLine();
        if(menu.equals("q") || menu.equals("equit") || menu.equals("exit")){
            System.exit(0);
        }
       

    }
    public final void run(){
        common();
        show();
        prompt();
    }
}
