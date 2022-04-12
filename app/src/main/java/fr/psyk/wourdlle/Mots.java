package fr.psyk.wourdlle;




import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Mots {

    private String mots;



    public void Mots(String mots) {

        this.mots = mots;


    }






    public  String getMots(int nombreLetter) {
        switch (nombreLetter){
            case 4:
                mots = lettres4rand();
                break;
            case 5:
                mots = lettres5rand();
                break;
            case 6:
                mots = lettres6rand();
                break;
            case 7:
                mots = lettres7rand();
                break;
            case 8:
                mots = lettres8rand();
                break;
            case 9:
                mots = lettres9rand();
                break;
            case 10:
                mots = lettres10rand();
                break;
            case 11:
                mots = lettres11rand();
                break;
            case 12:
                mots = lettres12rand();
                break;



        }

        return mots;
    }



    private String lettres4rand() {
        mots4 mot = new mots4();
        Random rand = new Random();
        String randomElement = mot.lettres4.get(rand.nextInt(mot.lettres4.size()));
        return  randomElement;
    }

    private String lettres5rand() {
        mots5 mot = new mots5();
        Random rand = new Random();
        String randomElement = mot.lettres5.get(rand.nextInt(mot.lettres5.size()));
        return  randomElement;
    }
    private String lettres6rand() {
        mots6 mot = new mots6();
        Random rand = new Random();
        String randomElement = mot.lettres6.get(rand.nextInt(mot.lettres6.size()));
        return  randomElement;
    }

    private String lettres7rand() {
        mots7 mot = new mots7();
        Random rand = new Random();
        String randomElement = mot.lettres7.get(rand.nextInt(mot.lettres7.size()));
        return  randomElement;
    }

    private String lettres8rand() {
        mots8 mot = new mots8();
        Random rand = new Random();
        String randomElement = mot.lettres8.get(rand.nextInt(mot.lettres8.size()));
        return  randomElement;
    }

    private String lettres9rand() {
        mots9 mot = new mots9();
        Random rand = new Random();
        String randomElement = mot.lettres9.get(rand.nextInt(mot.lettres9.size()));
        return  randomElement;
    }
    private String lettres10rand() {
        mots10 mot = new mots10();
        Random rand = new Random();
        String randomElement = mot.lettres10.get(rand.nextInt(mot.lettres10.size()));
        return  randomElement;
    }

    private String lettres11rand() {
        mots11 mot = new mots11();
        Random rand = new Random();
        String randomElement = mot.lettres11.get(rand.nextInt(mot.lettres11.size()));
        return  randomElement;
    }
    private String lettres12rand() {
        mots12 mot = new mots12();
        Random rand = new Random();
        String randomElement = mot.lettres12.get(rand.nextInt(mot.lettres12.size()));
        return  randomElement;
    }



}