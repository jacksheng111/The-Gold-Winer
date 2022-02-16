package com.company;

import java.awt.*;


public class beijing {
    static  int count = 0;
    Image bg =Toolkit.getDefaultToolkit().getImage("images/土壤.jpg");
    Image rw =Toolkit.getDefaultToolkit().getImage("images/人物.png");

    void paintSelf(Graphics g){
        g.drawImage(bg,0,0,null);
        g.drawImage(rw,280,100,null);
        draWord(g,30,Color.black,30,150,"积分 ："+count);

    }
    //打印字符串
    public static void draWord(Graphics g,int size,Color color,int x,int y,String str){

        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }
}
