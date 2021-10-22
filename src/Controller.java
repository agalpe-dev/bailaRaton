import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    private Ui mUi;
    private boolean running=false;
    private Timer mTimer=new Timer();

    public Controller(Ui mUi){
        this.mUi = mUi;
    }

    private class runningTask extends TimerTask{
        @Override
        public void run() {
            int posX,posY;
            Robot mRobot;
            final int GAP=20;

            posX= MouseInfo.getPointerInfo().getLocation().x;
            posY= MouseInfo.getPointerInfo().getLocation().y;

            try {
                mRobot = new Robot();
                mRobot.mouseMove(posX+GAP,posY+GAP);
                Thread.sleep(250);
                mRobot.mouseMove(posX, posY);
                //System.out.println("Move : " + posX + " - " + posY );
            }catch (Exception e){
                if (e instanceof InterruptedException){
                    return;
                }else {
                    e.printStackTrace();
                }
            }
        }
    }

    public void action(String textBox) {
        if (running){
            mUi.setTextButton("Iniciar");
            running=false;
            try {
                mTimer.cancel();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            // Check and get seconds to repeat from textField
            int seconds=getSeconds(textBox);
            seconds = seconds * 1000;
            if (seconds>0) {
                mUi.setTextButton("Parar");
                mTimer.schedule(new runningTask(),0,(long)seconds);
                running = true;
            }
        }
        //System.out.println("Action!! " + running);
    }

    private int getSeconds(String textBox) {
        int n;
        try {
            n = Integer.parseInt(textBox);
        }catch (NumberFormatException e){
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return n;
    }
/*
    private class runningThread implements Runnable{
        @Override
        public void run() {
            int posX,posY;
            Robot mRobot;

            final int GAP=20;
            posX= MouseInfo.getPointerInfo().getLocation().x;
            posY= MouseInfo.getPointerInfo().getLocation().y;

            try {
                mRobot = new Robot();
                mRobot.mouseMove(posX+GAP,posY+GAP);
                Thread.sleep(250);
                mRobot.mouseMove(posX, posY);
            }catch (Exception e){
                if (e instanceof InterruptedException){
                    return;
                }else {
                    e.printStackTrace();
                }
            }
        }
    }
*/
}
