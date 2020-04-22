package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Task {

    private String task;
    private int start;
    private int end;

    public void setTask(String task)
    {
        this.task = task;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }
    
    public String getTask(String task)
    {
        return task;
    }
    public int getStart(int start)
    {
        return start;
    }

    public int getEnd(int end)
    {
        return end;
    }

    public String toString()
    {
        return task + "\t" + start + "\t" + end;
    }

    public Task(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    public void render(PApplet pa)
    {
        float border = pa.width * 0.5f;
        float leftborder = pa.width * 0.3f;
        //pa.textAlign(PApplet.LEFT, PApplet.CENTER);
        pa.fill(225);
        pa.text(task, pa.width / 2, pa.height / 2);
    }
}