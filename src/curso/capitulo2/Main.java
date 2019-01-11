/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.capitulo2;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

    
/**
 *
 * @author mauro
 */
public class Main {
    
    public int Ancho = 800;
    public int ALTO = 600;
    
    protected static final boolean VSYNC = true;
    
    protected static final int FPS = 60;
    
    public String Titulo = "Pequeño Juego";
    
    public Teclado teclado;
    protected static boolean GameOver = false;
    
    public void iniciar(){
        try {
            Display.setResizable(true);
            Display.setDisplayMode(new DisplayMode(Ancho,ALTO));
            Display.setVSyncEnabled(VSYNC);
            Display.setTitle(Titulo);
            Display.create();
            
            crear();
            resizable();
            
            GameOver=true;
            
            
        } catch (LWJGLException ex) {
            Logger.getLogger(curso.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(GameOver && !Display.isCloseRequested()){
            resizable();
            entradas();
            teclado.Actualizar();
            Render();
            
            
            Display.sync(FPS);
            Display.update();
        }
        disponse();
        Display.destroy();
    }
    public void entradas(){
        
        if(Mouse.isButtonDown(0)){
            int x = Mouse.getX();
            int y = Mouse.getY();
            
            Display.setTitle(Titulo+" Pos X:"+x+" Pos Y:"+y);
        }
        
        while(Mouse.next()){
            if(Mouse.isButtonDown(1)) System.out.println("Aprete EL Derecho");
            if(Mouse.isButtonDown(2)) System.out.println("aprete el boton de almedio");            
        }
        
        
        
    }
    
    protected void disponse(){
        GameOver = false;
    }
    protected void resizable(){
        GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
    }
    protected void crear(){
        //Desahabilitamos la profundidad
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        
        //Inicializacion de Buffered
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
        //Color RGBA Flotantes ,0,0,0,0
        GL11.glClearColor(0f,0f,0f,0f);
        
        //Recursoss        
        teclado = new Teclado();
    }
    
    //Metodo donde renderizaremos
    protected void Render(){
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new curso.capitulo2.Main().iniciar();
    }    
}

