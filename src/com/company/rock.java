package com.company;

import java.awt.*;

public class rock extends Object{
    rock(){
        this.x = (int)(Math.random()*700);
        this.y = (int)(Math.random()*220+300);
        this.width = 71;
        this.height = 71;
        this.flag = false;
        this.m = 50;
        this.image = Toolkit.getDefaultToolkit().createImage("images/石头.png");
        this.count = 1;
    }

}
class rockplus extends rock{
    rockplus() {
        this.width = 120;
        this.height = 120;
        this.m = 100;
        this.image = Toolkit.getDefaultToolkit().createImage("images/石头1.png");
        this.count = 2;
    }
}