package game;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

import engine.GamePainter;
import entite.Heros;
import cases.Case;
import cases.CaseMur;

public class LabyrintheManager implements GamePainter{

    private static final int caseSize = 20;
    private Map<Character, LabyrintheObject> objectDic; 
    private Heros heros;
    private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
    private static final int WIDTHCASE = 10;
	private static final int HEIGHTCASE = 10;
    private Case[][] monde = new CaseMur[HEIGHT][WIDTHCASE];
    
    public LabyrintheManager(){
        this.heros = new Heros(100,100,caseSize,caseSize);
        this.objectDic = new HashMap<>();
        this.objectDic.put('0', LabyrintheObject.GROUND);
        this.objectDic.put('1', LabyrintheObject.WALL);
        this.buildMonde("Labyrinthe-M1/JeuTemplate/src/monde/default.txt");
        
    }

    public void draw(BufferedImage im){
        

        for (int x = 0; x < WIDTHCASE; x++) {
            for (int y = 0; y < HEIGHTCASE; y++) {
                monde[x][y].draw(im);
			}
		}

        heros.draw(im);
    }

    public void buildMonde(String source){
        BufferedReader helpReader;
        int y = 0;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
                for (int x = 0; x < ligne.length(); x++) {
                    switch (objectDic.get(ligne.charAt(x))) {
                        case GROUND:
                            //monde[x][y] = new CaseSol(x*caseSize, y*caseSize, caseSize, caseSize);
                            break;
                    
                        case WALL:
                            monde[x][y] = new CaseMur(x*caseSize, y*caseSize, caseSize, caseSize);
                            break;
                    }
                }  
				System.out.println(ligne);
                y++;
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
    }

    @Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

    public Heros getHeros(){
        return this.heros;
    }

}
