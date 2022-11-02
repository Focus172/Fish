package entity;

import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.lang.*;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import javax.swing.ImageIcon;

import master.Screen;

public class Entity {

    protected Screen scr;

    public Point pos; // position
    public int velo;
    public BufferedImage eImage; //image of the entity
    //public double size; //1 is the same size as the image file itself; multiplicative scaling
    //public String fileName;

    //public Object model;
    //public ArrayList<Point> locations; //debug
    //public ArrayList<Point> locations2; //debug
    //public int damage; //damage you take when you hit it

    public Entity (int x, int y, Screen screen) { //, String fileName
        pos = new Point(x, y);
        scr = screen;
        //this.size = size;
        //this.model = model;
        //image = loadImage(fileName);
        //this.fileName = fileName;
        //locations = new ArrayList<Point>();
        //locations2 = new ArrayList<Point>();
        //damage = ndamage;
    }

    /*
    public BufferedImage loadImage(String fileName) {

        //loads the image for the player
        System.out.println(fileName);
        try { image = ImageIO.read(new File("images/" + fileName)); System.out.println("good");
        } catch (IOException e) { e.printStackTrace(); System.out.println("bad"); } //System.out.println("Error opening image file: " + exc.getMessage()); }
        return image;

    }
     */

    public void draw(Graphics2D g2, Screen screenRef) { //, ImageObserver observer, double rotation
        //BufferedImage copiedImage = loadImage(fileName);

        g2.setColor(Color.BLACK);
        g2.fillRect(pos.x, pos.y, screenRef.TILE_SIZE, screenRef.TILE_SIZE);


//		double rads = Math.toRadians(-rotation);
//		double sin = Math.abs(Math.sin(rads));
//		double cos = Math.abs(Math.cos(rads));
//		int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
//		int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
//		BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
//		AffineTransform at = new AffineTransform();
//		at.translate(0.5 * w, 0.5 * h);
//		at.rotate(rads);
//		System.out.println(rotation);
//		at.translate(0.5 * (-w), 0.5 * (-h));
//		AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//		rotateOp.filter(image,rotatedImage);
//        g.drawImage(
//            rotatedImage,
//            (int)pos.x-w,
//            (int)pos.y-h,
//            observer
//        );

        /*
        double rads = Math.toRadians(-rotation);
        double sin = Math.abs(Math.sin(rads));
        double cos = Math.abs(Math.cos(rads));
        */
//		int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
//		int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
//		BufferedImage rotatedImage = new BufferedImage(image.getWidth()*4, image.getHeight()*4, image.getType());
//		AffineTransform at = new AffineTransform();
//		at.translate(w * 2, h * 2);
//		at.rotate(rads);
//		at.translate(2 * (-w), 2 * (-h));
//		AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//		rotateOp.filter(image,rotatedImage);


    /*
        g.drawImage(
                rotateImage(copiedImage, rotation),
                (int)(pos.x - (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin)),
                (int)(pos.y - Math.floor(image.getHeight() * cos + image.getWidth() * sin)),
                observer
        );

        //model.draw(g, observer);

        locations.add(new Point((int)pos.x,(int)pos.y));
        int[] xtests = new int[locations.size()];
        int[] ytests = new int[locations.size()];
        for (int i = 0; i < locations.size(); i++) {
            xtests[i] = locations.get(i).x;
            ytests[i] = locations.get(i).y;
        }
        g.drawPolygon(xtests, ytests, xtests.length);

     */
    }

    /*
    public int collision(entity.Entity other) { //
        boolean out = false;
        Point otherPos = other.getPos();
        BufferedImage otherImg = other.getImage();

        return 1;
    }
    */

    public void tick() {
        //do things
        //mostly meant to be overwritten
    }

    /*
    private BufferedImage rotateImage(BufferedImage buffImage, double angle) {
        double radian = Math.toRadians(-angle);
        double sin = Math.abs(Math.sin(radian));
        double cos = Math.abs(Math.cos(radian));

        int width = buffImage.getWidth();
        int height = buffImage.getHeight();

        int nWidth = (int) Math.floor((double) width * cos + (double) height * sin);
        int nHeight = (int) Math.floor((double) height * cos + (double) width * sin);

        BufferedImage rotatedImage = new BufferedImage(nWidth, nHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = rotatedImage.createGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics.translate((nWidth - width) / 2, (nHeight - height) / 2);
        // This is the rotation around the center point - change this line
        graphics.rotate(radian, (double) (width / 2), (double) (height / 2));
        graphics.drawImage(buffImage, 0, 0, null);
        graphics.dispose();

        return rotatedImage;
    }
    */
}
