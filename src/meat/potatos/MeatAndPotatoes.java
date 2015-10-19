/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meat.potatos;

import java.awt.Color;

/**
 *
 * @author rainy
 */
public class MeatAndPotatoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int click=0;
        GameBoard board=new GameBoard();
        board.putPiece(2,3,Color.blue);
        board.putPiece(1, 1, Color.red);
        while(true){
            Coordinate c=board.getClick();
            System.out.println("got click");
            int row=c.getRow();
            int col=c.getCol();
            //put a piece where they clicked
            click++;
            board.putPiece(row,col,Color.blue);
            board.setMessage("you have clicked "+click+" times.");
        }

    }
    
}
