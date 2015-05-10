package bomberman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * source: https://www.youtube.com/watch?v=gHh_96Ss1AI
 */
public class GameLoopMultiThread implements Runnable{

    private static final long serialVersionUID = 1L;

    private boolean running = false;

    private Thread thread;

    private static final Logger LOGGER = LoggerFactory.getLogger(GameLoopMultiThread.class);

    //TODO: Guy has this method private
    public synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }


    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1){
                tick();
                updates++;
                delta--;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                LOGGER.debug(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    //everything in game whats updates
    private void tick() {

    }

    //everything in game whats render
    private void render() {

    }
}
