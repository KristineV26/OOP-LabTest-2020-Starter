package ie.tudublin;

public class Main
{

    public void gant()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Gantt());
    }

    public void attempt()
    {
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new attempt());
    }
    
    public static void main(String[] arg)
    {
        Main main = new Main();
        main.gant();        
        //main.attempt();
    }
}