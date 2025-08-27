//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.awt.geom.Ellipse2D;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Random;
//
///**
// * ChaseGame.java
// *
// * A complete, single-file Java Swing game where you control a player circle and
// * evade AI-driven chasers while collecting stars. Difficulty increases over time
// * (more enemies, faster enemies). Includes pause/resume, restart, levels,
// * power-ups (Shield & SlowMo), basic particle effects, and a simple HUD.
// *
// * Compile:  javac ChaseGame.java
// * Run:      java ChaseGame
// *
// * Controls:
// *  - Move: Arrow Keys or WASD
// *  - Sprint: Left Shift
// *  - Pause/Resume: P
// *  - Restart: R (from Game Over or anytime)
// *  - Toggle Hitboxes/Debug: H
// */
//class ChaseGame extends JFrame {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            ChaseGame frame = new ChaseGame();
//            frame.setVisible(true);
//        });
//    }
//
//    public ChaseGame() {
//        super("Chase Game — Java Swing");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
//        GamePanel panel = new GamePanel(960, 600);
//        setContentPane(panel);
//        pack();
//        setLocationRelativeTo(null);
//    }
//}
//
//class GamePanel extends JPanel implements ActionListener, KeyListener, FocusListener {
//    enum GameState { MENU, RUNNING, PAUSED, GAME_OVER }
//
//    // Core
//    private final int WIDTH;
//    private final int HEIGHT;
//    private final Timer timer;
//    private GameState state = GameState.MENU;
//    private final Random rng = new Random();
//
//    // Player
//    private double px, py;          // position
//    private double vx, vy;          // velocity (for smoother motion)
//    private double speed = 4.0;     // base speed
//    private double sprintMult = 1.6;
//    private double radius = 14;
//
//    // Enemies
//    private static class Enemy {
//        double x, y, speed, radius;
//        Color color;
//        double wobblePhase;
//        Enemy(double x, double y, double speed) {
//            this.x = x; this.y = y; this.speed = speed;
//            this.radius = 12;
//            this.color = new Color(230, 80, 80);
//            this.wobblePhase = Math.random() * Math.PI * 2;
//        }
//        void update(double targetX, double targetY, double dt) {
//            double dx = targetX - x;
//            double dy = targetY - y;
//            double len = Math.hypot(dx, dy);
//            if (len > 0.0001) { dx /= len; dy /= len; }
//            x += dx * speed * dt;
//            y += dy * speed * dt;
//            // subtle wobble to feel alive
//            wobblePhase += dt * 6;
//        }
//    }
//    private final List<Enemy> enemies = new ArrayList<>();
//    private double enemyBaseSpeed = 2.4; // increases over time
//
//    // Collectibles
//    private static class Star {
//        double x, y, r; int ttl; // frames
//        Star(double x, double y) { this.x = x; this.y = y; this.r = 7; this.ttl = 60 * 20; }
//    }
//    private final List<Star> stars = new ArrayList<>();
//
//    // Power-ups
//    private enum PowerType { SHIELD, SLOWMO }
//    private static class PowerUp {
//        double x, y; PowerType type; double r = 10; int ttl; // frames
//        PowerUp(double x, double y, PowerType t) { this.x = x; this.y = y; this.type = t; this.ttl = 60 * 15; }
//    }
//    private final List<PowerUp> powerUps = new ArrayList<>();
//    private boolean shieldActive = false; int shieldTimer = 0; // frames
//    private boolean slowmoActive = false; int slowmoTimer = 0; // frames
//
//    // Particles (simple burst on collect/hit)
//    private static class Particle {
//        double x, y, vx, vy; int life; Color color;
//        Particle(double x, double y, double vx, double vy, int life, Color c) {
//            this.x = x; this.y = y; this.vx = vx; this.vy = vy; this.life = life; this.color = c;
//        }
//    }
//    private final List<Particle> particles = new ArrayList<>();
//
//    // Input
//    private boolean up, down, left, right, sprint;
//
//    // Progress / HUD
//    private int score = 0;
//    private int highScore = 0;
//    private int level = 1;
//    private int frames = 0; // lifetime frames this run
//    private boolean showDebug = false;
//
//    // Fonts
//    private final Font hudFont = new Font("JetBrains Mono", Font.PLAIN, 16);
//    private final Font bigFont = new Font("JetBrains Mono", Font.BOLD, 36);
//    private final Font smallFont = new Font("JetBrains Mono", Font.PLAIN, 12);
//
//    GamePanel(int width, int height) {
//        this.WIDTH = width;
//        this.HEIGHT = height;
//        setPreferredSize(new Dimension(WIDTH, HEIGHT));
//        setBackground(new Color(14, 16, 22));
//        setFocusable(true);
//        addKeyListener(this);
//        addFocusListener(this);
//
//        // 60 FPS timer
//        timer = new Timer(1000 / 60, this);
//        timer.start();
//
//        resetGame();
//    }
//
//    private void resetGame() {
//        px = WIDTH / 2.0; py = HEIGHT / 2.0; vx = vy = 0;
//        score = 0; level = 1; frames = 0;
//        enemies.clear(); stars.clear(); powerUps.clear(); particles.clear();
//        shieldActive = false; slowmoActive = false; shieldTimer = slowmoTimer = 0;
//        enemyBaseSpeed = 2.4;
//
//        // initial enemies
//        for (int i = 0; i < 3; i++) spawnEnemy();
//        // initial stars
//        for (int i = 0; i < 5; i++) spawnStar();
//        // one power-up to start sometimes
//        if (rng.nextBoolean()) spawnPowerUp();
//    }
//
//    private void spawnEnemy() {
//        // spawn on edges
//        int edge = rng.nextInt(4);
//        double x = 0, y = 0;
//        switch (edge) {
//            case 0: x = rng.nextInt(WIDTH); y = -20; break;            // top
//            case 1: x = WIDTH + 20; y = rng.nextInt(HEIGHT); break;    // right
//            case 2: x = rng.nextInt(WIDTH); y = HEIGHT + 20; break;    // bottom
//            case 3: x = -20; y = rng.nextInt(HEIGHT); break;           // left
//        }
//        double s = enemyBaseSpeed + rng.nextDouble() * 1.2 + level * 0.15;
//        enemies.add(new Enemy(x, y, s));
//    }
//
//    private void spawnStar() {
//        double x = 40 + rng.nextInt(WIDTH - 80);
//        double y = 40 + rng.nextInt(HEIGHT - 80);
//        stars.add(new Star(x, y));
//    }
//
//    private void spawnPowerUp() {
//        double x = 40 + rng.nextInt(WIDTH - 80);
//        double y = 40 + rng.nextInt(HEIGHT - 80);
//        PowerType t = rng.nextBoolean() ? PowerType.SHIELD : PowerType.SLOWMO;
//        powerUps.add(new PowerUp(x, y, t));
//    }
//
//    @Override public void actionPerformed(ActionEvent e) {
//        if (state == GameState.RUNNING) {
//            updateGame();
//        }
//        repaint();
//    }
//
//    private void updateGame() {
//        frames++;
//        double dt = slowmoActive ? 0.5 : 1.0; // crude slow motion factor
//
//        // level/difficulty progression
//        if (frames % (60 * 10) == 0) { // every 10 seconds
//            level++;
//            enemyBaseSpeed += 0.15;
//            spawnEnemy();
//            if (rng.nextDouble() < 0.6) spawnPowerUp();
//            if (rng.nextDouble() < 0.9) spawnStar();
//        }
//
//        // Movement input
//        double ax = 0, ay = 0;
//        if (left)  ax -= 1;
//        if (right) ax += 1;
//        if (up)    ay -= 1;
//        if (down)  ay += 1;
//        double len = Math.hypot(ax, ay);
//        if (len > 0) { ax /= len; ay /= len; }
//
//        double moveSpeed = speed * (sprint ? sprintMult : 1.0);
//        vx = ax * moveSpeed;
//        vy = ay * moveSpeed;
//        px += vx * dt;
//        py += vy * dt;
//
//        // clamp to bounds
//        px = Math.max(radius, Math.min(WIDTH - radius, px));
//        py = Math.max(radius, Math.min(HEIGHT - radius, py));
//
//        // Update enemies
//        for (Enemy en : enemies) en.update(px, py, dt);
//
//        // Collisions: enemies
//        for (Enemy en : enemies) {
//            if (dist(px, py, en.x, en.y) <= radius + en.radius) {
//                if (shieldActive) {
//                    makeBurst(en.x, en.y, new Color(180, 220, 255));
//                    // knock enemy back
//                    double dx = en.x - px, dy = en.y - py; double d = Math.max(0.01, Math.hypot(dx, dy)); dx/=d; dy/=d;
//                    en.x += dx * 30; en.y += dy * 30;
//                    shieldActive = false; shieldTimer = 0;
//                } else {
//                    gameOver();
//                    return;
//                }
//            }
//        }
//
//        // Collect stars
//        Iterator<Star> itS = stars.iterator();
//        while (itS.hasNext()) {
//            Star s = itS.next();
//            s.ttl--;
//            if (s.ttl <= 0) { itS.remove(); continue; }
//            if (dist(px, py, s.x, s.y) <= radius + s.r) {
//                score += 10;
//                makeBurst(s.x, s.y, new Color(255, 230, 120));
//                itS.remove();
//                if (rng.nextDouble() < 0.4) spawnStar();
//            }
//        }
//
//        // Collect powerups
//        Iterator<PowerUp> itP = powerUps.iterator();
//        while (itP.hasNext()) {
//            PowerUp p = itP.next();
//            p.ttl--;
//            if (p.ttl <= 0) { itP.remove(); continue; }
//            if (dist(px, py, p.x, p.y) <= radius + p.r) {
//                switch (p.type) {
//                    case SHIELD:
//                        shieldActive = true; shieldTimer = 60 * 7; // 7s
//                        break;
//                    case SLOWMO:
//                        slowmoActive = true; slowmoTimer = 60 * 4; // 4s
//                        break;
//                }
//                makeBurst(p.x, p.y, p.type == PowerType.SHIELD ? new Color(160, 220, 255) : new Color(180, 255, 200));
//                itP.remove();
//            }
//        }
//
//        // Timers
//        if (shieldActive && --shieldTimer <= 0) shieldActive = false;
//        if (slowmoActive && --slowmoTimer <= 0) slowmoActive = false;
//
//        // Particles
//        Iterator<Particle> it = particles.iterator();
//        while (it.hasNext()) {
//            Particle p = it.next();
//            p.x += p.vx; p.y += p.vy; p.life--;
//            // slight fade
//            if (p.life <= 0) it.remove();
//        }
//    }
//
//    private void gameOver() {
//        state = GameState.GAME_OVER;
//        highScore = Math.max(highScore, score);
//        makeBurst(px, py, new Color(255, 120, 120));
//    }
//
//    private double dist(double x1, double y1, double x2, double y2) {
//        return Math.hypot(x1 - x2, y1 - y2);
//    }
//
//    private void makeBurst(double x, double y, Color c) {
//        for (int i = 0; i < 28; i++) {
//            double ang = rng.nextDouble() * Math.PI * 2;
//            double sp = 1 + rng.nextDouble() * 3;
//            particles.add(new Particle(x, y, Math.cos(ang) * sp, Math.sin(ang) * sp, 35 + rng.nextInt(15), c));
//        }
//    }
//
//    @Override protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        // background grid
//        drawBackground(g2);
//
//        switch (state) {
//            case MENU: drawMenu(g2); break;
//            case RUNNING: drawGame(g2); break;
//            case PAUSED: drawGame(g2); drawPauseOverlay(g2); break;
//            case GAME_OVER: drawGame(g2); drawGameOver(g2); break;
//        }
//        g2.dispose();
//    }
//
//    private void drawBackground(Graphics2D g2) {
//        g2.setStroke(new BasicStroke(1f));
//        g2.setColor(new Color(30, 34, 44));
//        int grid = 40;
//        for (int x = 0; x < WIDTH; x += grid) g2.drawLine(x, 0, x, HEIGHT);
//        for (int y = 0; y < HEIGHT; y += grid) g2.drawLine(0, y, WIDTH, y);
//        // subtle vignette
//        Paint old = g2.getPaint();
//        RadialGradientPaint rg = new RadialGradientPaint(new Point(WIDTH/2, HEIGHT/2), (float)(Math.max(WIDTH, HEIGHT) * 0.7),
//                new float[]{0f, 1f}, new Color[]{new Color(0,0,0,0), new Color(0,0,0,100)});
//        g2.setPaint(rg);
//        g2.fillRect(0,0,WIDTH,HEIGHT);
//        g2.setPaint(old);
//    }
//
//    private void drawMenu(Graphics2D g2) {
//        drawHudTop(g2);
//        g2.setFont(bigFont);
//        g2.setColor(Color.WHITE);
//        String title = "CHASE";
//        centerText(g2, title, HEIGHT/2 - 40);
//        g2.setFont(hudFont);
//        centerText(g2, "Move: WASD / Arrows  |  Sprint: Shift", HEIGHT/2 + 10);
//        centerText(g2, "Pause: P  |  Restart: R", HEIGHT/2 + 36);
//        centerText(g2, "Collect stars, avoid red chasers. Power-ups help!", HEIGHT/2 + 62);
//        centerText(g2, "Press ENTER to start", HEIGHT/2 + 100);
//    }
//
//    private void drawGame(Graphics2D g2) {
//        // Stars
//        for (Star s : stars) {
//            float pulse = (float)(0.6 + 0.4 * Math.sin(System.nanoTime() / 1e9 + s.x * 0.1));
//            g2.setColor(new Color(255, 220, 120, (int)(220 * pulse)));
//            g2.fill(new Ellipse2D.Double(s.x - s.r, s.y - s.r, s.r * 2, s.r * 2));
//        }
//        // PowerUps
//        for (PowerUp p : powerUps) {
//            switch (p.type) {
//                case SHIELD: g2.setColor(new Color(150, 210, 255)); break;
//                case SLOWMO: g2.setColor(new Color(160, 255, 200)); break;
//            }
//            g2.fill(new Ellipse2D.Double(p.x - p.r, p.y - p.r, p.r * 2, p.r * 2));
//            g2.setColor(new Color(255,255,255,120));
//            g2.setStroke(new BasicStroke(2f));
//            g2.draw(new Ellipse2D.Double(p.x - p.r - 3, p.y - p.r - 3, (p.r + 3) * 2, (p.r + 3) * 2));
//        }
//        // Particles
//        for (Particle p : particles) {
//            int alpha = Math.max(0, Math.min(255, (int)(255 * (p.life / 50.0))));
//            g2.setColor(new Color(p.color.getRed(), p.color.getGreen(), p.color.getBlue(), alpha));
//            g2.fill(new Ellipse2D.Double(p.x, p.y, 3, 3));
//        }
//        // Enemies
//        for (Enemy en : enemies) {
//            float wob = (float)(Math.sin(en.wobblePhase) * 0.1);
//            double rr = en.radius * (1 + wob);
//            g2.setColor(en.color);
//            g2.fill(new Ellipse2D.Double(en.x - rr, en.y - rr, rr * 2, rr * 2));
//            if (showDebug) {
//                g2.setColor(new Color(255,255,255,100));
//                g2.drawLine((int)en.x, (int)en.y, (int)px, (int)py);
//            }
//        }
//        // Player
//        if (shieldActive) {
//            g2.setColor(new Color(170, 220, 255, 120));
//            g2.fill(new Ellipse2D.Double(px - radius - 6, py - radius - 6, (radius + 6) * 2, (radius + 6) * 2));
//        }
//        g2.setColor(new Color(120, 200, 255));
//        g2.fill(new Ellipse2D.Double(px - radius, py - radius, radius * 2, radius * 2));
//
//        if (showDebug) {
//            g2.setColor(new Color(255,255,255,120));
//            g2.draw(new Ellipse2D.Double(px - radius, py - radius, radius * 2, radius * 2));
//        }
//
//        drawHudTop(g2);
//    }
//
//    private void drawHudTop(Graphics2D g2) {
//        g2.setFont(hudFont);
//        g2.setColor(Color.WHITE);
//        String left = String.format("Score: %d   High: %d", score, highScore);
//        String mid = String.format("Level: %d", level);
//        String right = String.format("State: %s%s", state, slowmoActive ? "  SLOWMO" : (shieldActive ? "  SHIELD" : ""));
//        g2.drawString(left, 16, 24);
//        int midW = g2.getFontMetrics().stringWidth(mid);
//        g2.drawString(mid, (WIDTH - midW) / 2, 24);
//        int rightW = g2.getFontMetrics().stringWidth(right);
//        g2.drawString(right, WIDTH - rightW - 16, 24);
//        // bottom tip
//        g2.setFont(smallFont);
//        g2.setColor(new Color(200, 205, 215));
//        g2.drawString("WASD/Arrows to move • Shift to sprint • P pause • R restart", 16, HEIGHT - 14);
//    }
//
//    private void drawPauseOverlay(Graphics2D g2) {
//        g2.setColor(new Color(0,0,0,140));
//        g2.fillRect(0,0,WIDTH,HEIGHT);
//        g2.setFont(bigFont);
//        g2.setColor(Color.WHITE);
//        centerText(g2, "Paused", HEIGHT/2 - 10);
//        g2.setFont(hudFont);
//        centerText(g2, "Press P to continue", HEIGHT/2 + 28);
//    }
//
//    private void drawGameOver(Graphics2D g2) {
//        g2.setColor(new Color(0,0,0,160));
//        g2.fillRect(0,0,WIDTH,HEIGHT);
//        g2.setFont(bigFont);
//        g2.setColor(Color.WHITE);
//        centerText(g2, "Game Over", HEIGHT/2 - 40);
//        g2.setFont(hudFont);
//        centerText(g2, "Score: " + score + "   High: " + highScore, HEIGHT/2 + 0);
//        centerText(g2, "Press R to restart", HEIGHT/2 + 36);
//    }
//
//    private void centerText(Graphics2D g2, String text, int y) {
//        int w = g2.getFontMetrics().stringWidth(text);
//        g2.drawString(text, (WIDTH - w)/2, y);
//    }
//
//    @Override public void keyPressed(KeyEvent e) {
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_W: case KeyEvent.VK_UP:    up = true; break;
//            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:  down = true; break;
//            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:  left = true; break;
//            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT: right = true; break;
//            case KeyEvent.VK_SHIFT: sprint = true; break;
//            case KeyEvent.VK_ENTER:
//                if (state == GameState.MENU) state = GameState.RUNNING;
//                break;
//            case KeyEvent.VK_P:
//                if (state == GameState.RUNNING) state = GameState.PAUSED;
//                else if (state == GameState.PAUSED) state = GameState.RUNNING;
//                break;
//            case KeyEvent.VK_R:
//                resetGame();
//                state = GameState.RUNNING;
//                break;
//            case KeyEvent.VK_H:
//                showDebug = !showDebug;
//                break;
//        }
//    }
//
//    @Override public void keyReleased(KeyEvent e) {
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_W: case KeyEvent.VK_UP:    up = false; break;
//            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:  down = false; break;
//            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:  left = false; break;
//            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT: right = false; break;
//            case KeyEvent.VK_SHIFT: sprint = false; break;
//        }
//    }
//
//    @Override public void keyTyped(KeyEvent e) {}
//
//    @Override public void focusGained(FocusEvent e) {}
//    @Override public void focusLost(FocusEvent e) {
//        // auto-pause if focus lost while running
//        if (state == GameState.RUNNING) state = GameState.PAUSED;
//    }
//}
