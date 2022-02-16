package com.company;

import com.sun.javafx.collections.ArrayListenerHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;


public class GameWin extends JFrame {

    List<Object> objectList = new ArrayList<>();//存储金块和石块
    beijing bg = new beijing();
    Line line = new Line(this);

    {
        boolean iec = true;
        for (int i = 0; i < 10; i++) {
            double random = Math.random();
            gold Gold;//存放当前生成物体
            if (random <= 0.5) {
                Gold = new gold();
            } else {
                Gold = new goldmini();
            }

            for (Object obj: objectList) {
                if(Gold.getRec().intersects(obj.getRec())){
                    iec = false;
                }
            }
            if(iec){
                objectList.add(Gold);
            }
            else{iec = true;i--;}
        }
        for (int i = 0; i < 10; i++) {
            double random = Math.random();
            rock Rock;//存放当前生成物体
            if (random <= 0.5) {
                Rock = new rock();
            } else {
                Rock = new rockplus();
            }

            for (Object obj: objectList) {
                if(Rock.getRec().intersects(obj.getRec())){
                    iec = false;
                }
            }

            if(iec){
                objectList.add(Rock);
            }
            else{iec = true;i--;}
        }
    }

    Image newImgae;

    void launch() throws InterruptedException {
        this.setVisible(true);
        this.setSize(784, 594);
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1) {
                    line.state = 1;
                }
            }
        });

        while (true) {
            repaint();
            Thread.sleep(10);
        }
    }

    @Override
    public void paint(Graphics g) {


        newImgae = this.createImage(784, 594);  //新建画布解决窗口闪动问题
        Graphics gImage = newImgae.getGraphics();

        bg.paintSelf(gImage);


        for (Object obj : objectList) {
            obj.paintSelf(gImage);
        }
        line.paintSelf(gImage);
        g.drawImage(newImgae, 0, 0, null);
    }

    public static void main(String[] args) throws InterruptedException {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
