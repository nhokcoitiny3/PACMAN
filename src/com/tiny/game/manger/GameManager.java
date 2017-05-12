package com.tiny.game.manger;


import com.tiny.game.model.Ghost;
import com.tiny.game.model.MapItem;
import com.tiny.game.model.Pacman;
import com.tiny.game.model.WavPlayer;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    private int heart = 3;
    private int score ;
    private Pacman pacman;
    private ArrayList<Ghost> ghosts;
    private ArrayList<MapItem> mapItems;
    private ArrayList<MapItem> mapBean1;
    private ArrayList<MapItem> mapBean2;
    private Random random;
    private boolean isSuper = false;
    private int countSuper = 0;
    private int fireTimeout = 0;
    private int level = 1;

    public GameManager(int level,int score) {
        this.level=level;
        this.score = score;
        mapItems = new ArrayList<>();
        mapBean1 = new ArrayList<>();
        mapBean2 = new ArrayList<>();
        ghosts = new ArrayList<>();
        random = new Random();
        if (level<4) {
            initializeMap();
        }
        pacman = new Pacman(270, 335, Pacman.UP);
        ghosts.add(new Ghost(240, 275, Ghost.UP, Images.arrImgBlinky));
        ghosts.add(new Ghost(270, 275, Ghost.UP, Images.arrImgClyde));
        ghosts.add(new Ghost(303, 275, Ghost.UP, Images.arrImgInky));

    }

    public void initializeMap() {
        try {
            mapItems.clear();
            mapBean1.clear();
            mapBean2.clear();
            String path = getClass().getResource("/res/data/map"+level+".txt").getPath();
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                for (int j = 0; j < line.length(); j++) {
                    int c = line.charAt(j) - 48;
                    if (c == 0) {
                        continue;
                    }
                    MapItem item = new MapItem(j * MapItem.SIZE, i * MapItem.SIZE, c);

                    if (c == MapItem.BEAN1) {
                        mapBean1.add(item);
                    } else if (c == MapItem.BEAN2) {
                        mapBean2.add(item);
                    } else {
                        mapItems.add(item);
                    }
                }
                i++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawItem(Graphics2D graphics2D) {
        for (int i = 0; i < mapItems.size(); i++) {
            mapItems.get(i).drawMap(graphics2D);
        }
    }

    public void drawMapBean1(Graphics2D graphics2D) {
        for (int i = 0; i < mapBean1.size(); i++) {
            if (checkPacmanCollisionBean()) {
                continue;
            }
            mapBean1.get(i).drawMap(graphics2D);
        }
    }

    public void drawMapBean2(Graphics2D graphics2D) {
        for (int i = 0; i < mapBean2.size(); i++) {
            if (checkPacmanCollisionBean2()) {
                continue;
            }
            mapBean2.get(i).drawMap(graphics2D);
        }
    }

    public void drawPacman(Graphics2D graphics2D) {
        if (pacman.isDead() && heart>0) {
            pacman = new Pacman(270, 335, Pacman.UP);
            heart--;
            pacman.isDead=false;
        } else if (pacman.isDead && heart==0) {
            pacman.drawdie(graphics2D);
            return;
        }
        pacman.draw(graphics2D);

    }

    public void drawGhost(Graphics2D graphics2D) {
        for (int i = 0; i < ghosts.size(); i++) {
            if (checkPacmanvsGhost()) {
                continue;
            }
            if (isSuper==false) {
                ghosts.get(i).draw(graphics2D);
            }else {
                ghosts.get(i).drawIghost(graphics2D);
            }
        }
    }


    public void changePacmanOrentation(int orentation) {
        pacman.setOrentation(orentation);
    }


    public void movePacman() {
        if (checkPacmanCollisionMap()) {
            return;
        }
        if (pacman.isDead()) {
            return;
        }
        if (countSuper!=0) {
            countSuper--;
        }
        if (countSuper == 0)
        {
            isSuper = false;
        }
       ;
        pacman.getOrientation();
        pacman.move();

    }

    public void changeGhostOrientation() {
        if (fireTimeout == 0) {
            for (int i = 0; i < ghosts.size(); i++) {
                int orientation = random.nextInt(4);
                ghosts.get(i).setOrentation(orientation);
            }
            fireTimeout = 1000 + random.nextInt(2000);
        }
        fireTimeout--;
    }

    public boolean checkGhostCollision(Ghost ghost) {

        for (int i = 0; i < mapItems.size(); i++) {
            if (ghost.getRectangle().intersects(mapItems.get(i).getRectangle())) {
                return true;
            }
        }
        return false;
    }

    public void moveGhost() {
        if (!isPacmanDead()) {
            for (int i = 0; i < ghosts.size(); i++) {
                if (checkGhostCollision(ghosts.get(i))) {
                    ghosts.get(i).setOrentation(random.nextInt(4));
                    continue;
                }else
                if (isSuper){
                    for (int j=0;j<ghosts.size();j++){
                        ghosts.get(i).setSpeed(1);
                    }
                }else ghosts.get(i).setSpeed(2);
                ghosts.get(i).move();
            }
        }
    }

    public boolean isPacmanDead() {
        return pacman.isDead();
    }


    private boolean checkPacmanCollisionMap() {
        for (int j = 0; j < mapItems.size(); j++) {
            if (pacman.getRectangle().intersects(mapItems.get(j).getRectangle())) {
                return true;
            }
        }
        return false;
    }


    public boolean checkPacmanCollisionBean() {

        for (int i = 0; i < mapBean1.size(); i++) {
            if (pacman.getRectangle().intersects(mapBean1.get(i).getX() + 10, mapBean1.get(i).getY() + 15, 5, 1)) {
                mapBean1.remove(i);
                score += 10;
                return true;
            }
        }
        return false;
    }

    public boolean checkPacmanCollisionBean2() {
        for (int i = 0; i < mapBean2.size(); i++) {
            if (pacman.getRectangle().intersects(mapBean2.get(i).getX() + 10, mapBean2.get(i).getY() + 15, 5, 1)) {
                isSuper = true;
                countSuper = 1000;
                mapBean2.remove(i);
                score += 50;
                return true;
            }
        }
        return false;
    }


    public boolean checkPacmanvsGhost() {
        for (int i = 0; i < ghosts.size(); i++) {
            if (pacman.getRectangle().intersects(ghosts.get(i).getX() + 10, ghosts.get(i).getY() + 15, 5, 1) && isSuper == true) {
                score += 500;
                ghosts.remove(i);
                return true;
            } else if (pacman.getRectangle().intersects(ghosts.get(i).getX() + 10, ghosts.get(i).getY() + 15, 5, 1) && isSuper == false) {
                pacman.isDead = true;
                return true;
            }
        }
        return false;
    }


    public int getScore() {
        return score;
    }
    public int getHeart() {
        return heart;
    }
    public boolean getSupper() {
        return isSuper;
    }

    public boolean isOver() {
        if (heart == 0) {
            return true;
        }
        return false;
    }
    public int changLevel(){
        if (level==1){
            level=2;
        }else  if (level==2){
            level=3;
        }else if(level==3) {
            level = 4;
        }
        return level;
    }
    public int getLevel(){
        return level;
    }
    public  void bossAutoChangeOrient() {
        for (int i = 0; i < ghosts.size(); i++) {
            int newOrient = random.nextInt(4);
            int precent = random.nextInt(201);
            if (precent > 195) {
                ghosts.get(i).setOrentation(newOrient);
            }
        }
    }

    public ArrayList<MapItem> getMapBean1() {
        return mapBean1;
    }
}


