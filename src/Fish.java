import javax.swing.*;

////////////////////////////////
//welcome to the code for Feish
//this is a project that I will work on sometimes but is mainly a proof of concept
//if I ever make the game public I may go open source, but first I need to finish it
////////////////////////////////

class Fish {

    //this calls the creation of the window when program is ran
    //fixes some issues with threading by using invokeLater
    public static void main(String[] args) { SwingUtilities.invokeLater(Fish::initWindow); }

    private static void initWindow() {

        JFrame window = new JFrame("Feish");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creates contents of what will be shown
        Screen sc = new Screen();
        window.add(sc);
        window.addKeyListener(sc);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null); //opens in the center of the screen
        window.setVisible(true); //makes visible

    }

}