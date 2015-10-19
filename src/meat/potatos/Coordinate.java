package meat.potatos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Coordinate on the Game Board
 * 
 * @author rainy
 */
public class Coordinate {

    private int row;
    private int col;
    
    /**
     * 
     * @param row the row of the coordinate
     * @param col the colum of the coordinate
     */
    public Coordinate(int row, int col){
        this.row=row;
        this.col=col;
        
    }
    
    /**
     * Getter for the row
     * @return the row of the coordinate
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Getter for the colum 
     * @return the colum of the coordinate
     */
    public int getCol(){
        return this.col;
    }
    
    public void setRow(int newRow){
        this.row=newRow;
    }
}
