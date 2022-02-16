package com.company;

import java.awt.*;

public class gold extends Object{

    gold(){
        this.x = (int)(Math.random()*700);
        this.y = (int)(Math.random()*220+300);
        this.width = 55;
        this.height = 55;
        this.flag = false;
        this.m = 30;
        this.image = Toolkit.getDefaultToolkit().createImage("images/金元宝.png");
        this.count = 10;
    }
}
class goldmini extends gold{
    goldmini(){
        this.width = 55;
        this.height = 37;
        this.m = 15;
        this.image = Toolkit.getDefaultToolkit().createImage("images/金条.png");
        this.count = 5;
    }
}
