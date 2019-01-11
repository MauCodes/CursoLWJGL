/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.capitulo2;

import org.lwjgl.input.Keyboard;

/**
 *
 * @author mauro
 */
public class Teclado {
    
    
    public void Actualizar(){
                if(Keyboard.isKeyDown(Keyboard.KEY_W)) System.out.println("Avanza hacia arriva");
        
        while(Keyboard.next()){
            if(Keyboard.isKeyDown(Keyboard.KEY_A)) System.out.println("hacia la izquierda");
            if(Keyboard.isKeyDown(Keyboard.KEY_S)) System.out.println("hacia la sur");
            if(Keyboard.isKeyDown(Keyboard.KEY_D)) System.out.println("hacia la Derecha");
           //board.isKeyDown(Keyboard.KEY_A)) System.out.println("hacia la izquierda");
        }
    }
    
}
