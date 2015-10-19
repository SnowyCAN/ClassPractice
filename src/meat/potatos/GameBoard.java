/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meat.potatos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * A class that represents an 8*8 game board
 * @author rainy
 */
public class GameBoard extends JComponent implements MouseListener{

    private Color[][] grid = new Color[8][8];
    private String message = "you have clicked zero times.";
    private JFrame window;
    private final int TILE_SIZE=70;
    private Coordinate click=null;
    /**
     * creates a brand new empty 8*8 board
     */
    public GameBoard(){
        //set all positions to be null
        for (int row = 0; row < 8; row++)        
            for (int col = 0; col < 8; col++)
                grid[row][col]=null;
        //create the frame to display the board
        window=new JFrame("Game Board");
        //add the frame to the board
        window.add(this);
        //make the window visable
        window.setVisible(true);
        //set the size of the window
        window.setPreferredSize(new Dimension(8*TILE_SIZE+100,8*TILE_SIZE+100));
        window.pack();
        //set the x button
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add the mouse listener
        this.addMouseListener(this);
    }
    
    /**
     * 
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if((row+col)%2==0)
                    g.setColor(Color.white);
                else
                    g.setColor(Color.black);
                //draws a single grid
                g.fillRect(col*TILE_SIZE+TILE_SIZE/4,row*TILE_SIZE+TILE_SIZE/4,TILE_SIZE,TILE_SIZE);
                //draw a piece
                if (grid[row][col]!=null){
                    g.setColor(grid[row][col]);
                    g.fillOval(col*TILE_SIZE+TILE_SIZE/2,row*TILE_SIZE+TILE_SIZE/2,TILE_SIZE/2,TILE_SIZE/2);
                }
            }
        }
        g.setColor(Color.RED);
        g.drawString(message, TILE_SIZE/4,TILE_SIZE*8+TILE_SIZE/2);
    }
/**
 * Place a piece of a specific colour on the board
 * @param col the colum at which to place the piece
 * @param row the row at which to place the piece
 * @param colour the colour to make the piece
 */    
    public void putPiece(int col, int row, Color colour){
        grid[row][col]=colour;
        repaint();
        System.out.println("put piece");
    }
    
/**
 * Removes a piece that is on the board
 * @param col the colum at which to remove the piece
 * @param row the row at which to remove the piece
 */    
    public void removePiece(int col, int row){
        grid[row][col]=null;
        repaint();
    }

/**
 * Removes all pieces from the board
 */
    public void clearBoard(){
        //set all positions to be null
        for (int row = 0; row < 8; row++)         
            for (int col = 0; col < 8; col++)
                grid[row][col]=null;
        repaint();
    }
    
/**
 * displays a message to the board
 * @param theMessage the message to display to the board
 */    
    public void setMessage(String theMessage){
        message= theMessage;
        repaint();
    }
    
    public void printBoard(){
        for (int row = 0; row < 8; row++){ 
            for (int col = 0; col < 8; col++){
                if(grid[row][col]==Color.red)
                    System.out.print("R  ");
                else if(grid[row][col]==Color.BLUE)
                    System.out.print("B  ");
                else if(grid[row][col]==null)
                    System.out.print("_  ");
            }
            System.out.println("");
        }
        System.out.println(message);
        System.out.println("");
    }

    public Coordinate getClick(){
        //whipe out the pervoi
        click=null;
        while(click==null)
        {
            //nothing
            try{
                Thread.sleep(1);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return click;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("here");
        //get x and y of click
        //shift the, so that the top and left boarders are gone
        int x = e.getX() -TILE_SIZE/4;
        int y = e.getY()-TILE_SIZE/4;
        
        //get the row and colum of the click
        int row=x/TILE_SIZE;
        int col=y/TILE_SIZE;
        
        if(row >=0 && row <=7 && col >=0 && col <= 7)
            click=new Coordinate(row,col);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
