package com.company;

import java.awt.*;

public class Object {
    //坐标
    int x;
    int y;
    //质量
    int m;
    //宽高
    int width;
    int height;
    //标记可移动
    boolean flag;
    //图片
    Image image;
    //积分
    int count;
    //绘制方法
    void paintSelf(Graphics g){
      g.drawImage(image,x,y,null);
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
