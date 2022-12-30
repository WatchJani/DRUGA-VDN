import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static int turns = 0;
    static int STEVILO_POTEZ = 20;
    static int CILJNA_VRIJEDNOST = 1000;
    static JButton SteviloPotez = new JButton(Integer.toString(STEVILO_POTEZ));
    public static void main(String[] args) {



        //frame
        JFrame Frame = new JFrame();
        Frame.setSize(800, 600);
        Frame.setDefaultCloseOperation(3);
        Frame.setTitle("More or less less is more");

        //CiljnaVrednost in število potez
        JPanel nav = new JPanel();
        nav.setLayout(new BorderLayout());

        JButton CiljnaVrednost = new JButton(Integer.toString(CILJNA_VRIJEDNOST) );


        //Style
        CiljnaVrednost.setForeground(Color.WHITE);
        CiljnaVrednost.setBorder(BorderFactory.createEtchedBorder());
        CiljnaVrednost.setBackground(Color.LIGHT_GRAY);
        CiljnaVrednost.setBorderPainted( false );
        CiljnaVrednost.setFocusPainted( false );

        nav.add(SteviloPotez, BorderLayout.EAST);
        nav.add(CiljnaVrednost, BorderLayout.CENTER);
        Frame.add(nav, BorderLayout.NORTH);

        //Game
        int MySum = 0;

        JPanel MyGame = new JPanel();
        MyGame.setLayout(new GridLayout(10, 10));
        JButton Buttons[][] = new JButton[10][10];
        for (int i = 0; i< 10; i++){
            for (int j = 0; j <10; j++){
                int myRandomNumber = (int)(Math.random() * (9 - 1 + 1) + 1 );
                MySum+=myRandomNumber;
                Buttons[i][j] = new JButton(Integer.toString(myRandomNumber));
                Buttons[i][j].setName(i + "" + j);
                Buttons[i][j].setBackground(Color.white);
                MyGame.add(Buttons[i][j]);

                Buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(((JButton) e.getSource()).getText());
                        int i = ((JButton) e.getSource()).getName().charAt(0)-48;
                        int j = ((JButton) e.getSource()).getName().charAt(1)-48;

                        System.out.println(turns);
                        if(turns == 1){
                            Buttons[i][j].setBackground(Color.red); //ZASTO NE BOJI?
                            setEnable(Buttons);
                            STEVILO_POTEZ--;
                            SteviloPotez.setText(Integer.toString(STEVILO_POTEZ));
                            setDefaultColor(Buttons);
                            turns =0;
                        }else{
                            setDisable(Buttons, i, j );
                            Buttons[i][j].setBackground(Color.green);
                            turns++;
                        }
                    }
                });
            }
        }

        //VsotaStevil
        Frame.add(MyGame, BorderLayout.CENTER);
        JButton VsotaStevil = new JButton(Integer.toString(MySum));
        Frame.add(VsotaStevil, BorderLayout.SOUTH);
        Frame.setVisible(true);
    }

    public static void setDefaultColor(JButton Buttons[][]){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Buttons[i][j].setBackground(Color.WHITE);
            }
        }
    }

    public static void setEnable(JButton Buttons[][]){
        try {
            Thread.sleep(1000);  // kasni 5 sekundi
        } catch (InterruptedException e) {

        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Buttons[i][j].setEnabled(true);
            }
        }
    }
    public static void setDisable(JButton Buttons[][], int k, int p){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(i != k && j != p){
                    Buttons[i][j].setEnabled(false);
                    Buttons[i][j].setBackground(Color.gray);
                }
            }
        }
    }
}