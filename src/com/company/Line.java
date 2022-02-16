package com.company;

import java.awt.*;

public class Line {
    //起点坐标
    int x = 405;
    int y = 170;
    //终点坐标
    int endx;
    int endy;
    //线长
    double length = 100;
    double n = 0;
    //方向
    int dir;
    //状态 0 摇摆 1 抓取 2收回 3 抓取返回
    int state;
//钩爪图片
  Image hook =Toolkit.getDefaultToolkit().getImage("images/钳子.png");
    GameWin frame;

    Line(GameWin frame) {
        this.frame = frame;
    }


    void logic() {
        for (Object obj : this.frame.objectList) {
            if (endx > obj.x && endx < obj.x + obj.width
                    && endy > obj.y && endy < obj.y + obj.height) {
                // System.out.println(1);
                state = 3;
                obj.flag = true;
            }
        }

    }

    void Lines(Graphics g) {
        endx = (int) (x + length * Math.cos(n * Math.PI));
        endy = (int) (y + length * Math.sin(n * Math.PI));
        g.setColor(Color.red);
        g.drawLine(x+1, y+1, endx, endy);
        g.drawLine(x, y, endx, endy);
        g.drawLine(x-1, y-1, endx, endy);
        g.drawImage(hook,endx-36,endy-2,null);
    }

    void paintSelf(Graphics g) {
        logic();
        switch (state) {
            case 0:
                if (n < 0.1) {
                    dir = 1;
                } else if (n > 0.9) {
                    dir = -1;
                }
                n = n + 0.005 * dir;
                Lines(g);
                break;
            case 1:
                if (length < 500) {
                    length += 10;
                    Lines(g);
                } else {
                    state = 2;
                }
                break;
            case 2:
                if (length > 100) {
                    length -= 10;
                    Lines(g);
                } else {
                    state = 0;
                }
                break;

            case 3:
                int m = 1;
                if (length > 100) {

                    length = length - 10;
                    Lines(g);
                    for (Object obj : this.frame.objectList) {
                        if (obj.flag == true) {
                            m = obj.m;
                            obj.x = endx - obj.getWidth() / 2;
                            obj.y = endy;
                            if (length <= 100) {
                                state = 0;
                                obj.x = -200;
                                obj.y = -200;
                                obj.flag = false;
                                //加分
                                beijing.count += obj.count;
                            }
                        }
                    }
                } else {
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

}
