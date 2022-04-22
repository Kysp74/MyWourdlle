package fr.psyk.wourdlle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout myLayout;
    String motATrouver= "";
    int pcolonnePourLettre ;
    int lignePourLettre = 0;
    int idAUpdate=1;
    int nbLettre = 4;
    int idARecup=1;
    String modeJeu ="";
    boolean hardMode = false;
    String motATester = "" , temps,quelleEtoile;
    int nombreDeMotsATrouver , nombreDeMotEnCours = 1 ;
    TextView mTextView_Seek;
    LinearLayout layoutSelectNbLettre,layoutChrono;
    int premierLettre;
    Button go_training ;
    List<Integer> tableauDesTouchesChangees = new ArrayList<>();
    int serieEnCours;
    boolean motOk;
    boolean updateEssaiok = false;
    ArrayList<Character> lettreOrange = new ArrayList<>();
    ArrayList<Character> lettreVerte = new ArrayList<>();
    int nb;
    private Chronometer chronometer2;
    ImageView etoiles ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        etoiles = findViewById(R.id.game_etoiles);
        recupModeJeu();
        System.out.println("le mode est " + modeJeu + " hardmode: " +hardMode);
        initVarible();

        if (modeJeu.equals("Training")){
            recupSeekBar();
        }
        if (modeJeu.equals("Daily")){
            Toast.makeText(this, "Comming soon !!", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (modeJeu.equals("mots")){
          //  Toast.makeText(this, "Comming soon !!", Toast.LENGTH_SHORT).show();
            generateNblettre();
            lanceLeJeu();
        }








    }

    private void initVarible() {
        if (hardMode) {

            pcolonnePourLettre =0;
            premierLettre = 0;

        }else{
            pcolonnePourLettre = 1;
            premierLettre = 1;
        }
        lignePourLettre = 0;
        idAUpdate = 1;
        motATester = "";


    }

    private void recupSeekBar() {

        mTextView_Seek = findViewById(R.id.game_textView_Seek);
        SeekBar mySeekBar = (SeekBar) findViewById(R.id.game_seekBar);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                mTextView_Seek.setText(String.valueOf(progress));
                String valeur = mTextView_Seek.getText().toString();
                nbLettre = Integer.parseInt(valeur);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        go_training = findViewById(R.id.game_button_go);
        go_training.setOnClickListener(v -> {

            if (lignePourLettre > 0) {

                if (serieEnCours >0 ){
                    serieEnCours = 0;
                }else{
                    serieEnCours = serieEnCours -1;
                }
                MyDatabaseHelper db = new MyDatabaseHelper(this);
                db.updateSerie(nbLettre,serieEnCours,hardMode);
                db.close();
                endGame("perdue");
            }

            deleteinterface();
            lanceLeJeu();
        });
    }

    private void lanceLeJeu() {


        recupMots();
        createTableLayout();
        initClavier();
    }

    private void recupMots() {


        MyDatabaseHelper db = new MyDatabaseHelper(this);
        motATrouver = db.getmot(nbLettre);
        System.out.println("le mots est " + motATrouver);

    }

    private void recupModeJeu() {
        Intent intent = getIntent();

        if (intent != null){

            modeJeu = intent.getStringExtra("Mode");

            if(modeJeu.contains("HM")){
                hardMode = true;
            }
            if(modeJeu.contains("Training")){
                layoutSelectNbLettre = findViewById(R.id.game_train_layout);
                layoutSelectNbLettre.setVisibility(View.VISIBLE);
                layoutChrono = findViewById(R.id.game_chrono_layout);
                layoutChrono.setVisibility(View.INVISIBLE);
                modeJeu = "Training";
                nombreDeMotsATrouver = 1;
            }
            if(modeJeu.contains("Daily")){
                nombreDeMotsATrouver = 1;
                modeJeu = "Daily";
            }if(modeJeu.contains("5")){
                nombreDeMotsATrouver = 5;
                modeJeu = "mots";
                etoiles.setVisibility(View.VISIBLE);
                etoiles.setImageResource(R.drawable.e_0);
            }if(modeJeu.contains("10")){
                nombreDeMotsATrouver = 10;
                modeJeu = "mots";
                etoiles.setVisibility(View.VISIBLE);
                etoiles.setImageResource(R.drawable.e_10_0);
            }


        }

    }

    private void createTableLayout(){



        this.myLayout = findViewById(R.id.myGameLayout);

        TableLayout tableLayout =findViewById(R.id.montableau);
        Context context = this;
        tableLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        TableRow tableRow;
        TextView textView;

        for (int i = 0; i <7; i++) {
            tableRow = new TableRow(getApplicationContext());

            for (int j = 0; j < nbLettre; j++) {


                textView = new TextView(getApplicationContext());
                Context context2 = this;
                textView.setTextColor(ContextCompat.getColor(context2, R.color.white));
                if (j==0 && !hardMode) {

                    textView.setText(motATrouver.substring(0, 1));
                }else{
                    textView.setText("_");
                }

                int numid = (i * 10000) + (j * 100)+1;
                TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT , TableRow.LayoutParams.WRAP_CONTENT);
                tableRowParams.setMargins(2,2,2,2);
                textView.setLayoutParams(tableRowParams);
                textView.setPadding(15, 15,15, 15);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                textView.setId(numid);
                textView.setBackgroundColor(ContextCompat.getColor(context, R.color.bleu));
                textView.setWidth(75);
                textView.setHeight(75);


                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);

        }
        myLayout.removeView(tableLayout);
        myLayout.addView(tableLayout);
        View view = findViewById(R.id.maview);
        myLayout.removeView(view);
        myLayout.addView(view);
        TableLayout clavierLayout = findViewById(R.id.monclavier);
        myLayout.removeView(clavierLayout);
        myLayout.addView(clavierLayout);

        TableLayout clavierEnterLayout = findViewById(R.id.monclavierenter);
        myLayout.removeView(clavierEnterLayout);
        myLayout.addView(clavierEnterLayout);


    }

    private void initClavier(){

        Button B_A  = findViewById(R.id.button_A);
        Button B_B  = findViewById(R.id.button_B);
        Button B_C  = findViewById(R.id.button_C);
        Button B_D  = findViewById(R.id.button_D);
        Button B_E  = findViewById(R.id.button_E);
        Button B_F  = findViewById(R.id.button_F);
        Button B_G  = findViewById(R.id.button_G);
        Button B_H  = findViewById(R.id.button_H);
        Button B_I  = findViewById(R.id.button_I);
        Button B_J  = findViewById(R.id.button_J);
        Button B_K  = findViewById(R.id.button_K);
        Button B_L  = findViewById(R.id.button_L);
        Button B_M  = findViewById(R.id.button_M);
        Button B_N  = findViewById(R.id.button_N);
        Button B_O  = findViewById(R.id.button_O);
        Button B_P  = findViewById(R.id.button_P);
        Button B_Q  = findViewById(R.id.button_Q);
        Button B_R  = findViewById(R.id.button_R);
        Button B_S  = findViewById(R.id.button_S);
        Button B_T  = findViewById(R.id.button_T);
        Button B_U  = findViewById(R.id.button_U);
        Button B_V  = findViewById(R.id.button_V);
        Button B_W  = findViewById(R.id.button_W);
        Button B_X  = findViewById(R.id.button_X);
        Button B_Y  = findViewById(R.id.button_Y);
        Button B_Z  = findViewById(R.id.button_Z);

        B_A.setOnClickListener(this);
        B_B.setOnClickListener(this);
        B_C.setOnClickListener(this);
        B_D.setOnClickListener(this);
        B_E.setOnClickListener(this);
        B_F.setOnClickListener(this);
        B_G.setOnClickListener(this);
        B_H.setOnClickListener(this);
        B_I.setOnClickListener(this);
        B_J.setOnClickListener(this);
        B_K.setOnClickListener(this);
        B_L.setOnClickListener(this);
        B_M.setOnClickListener(this);
        B_N.setOnClickListener(this);
        B_O.setOnClickListener(this);
        B_P.setOnClickListener(this);
        B_Q.setOnClickListener(this);
        B_R.setOnClickListener(this);
        B_S.setOnClickListener(this);
        B_T.setOnClickListener(this);
        B_U.setOnClickListener(this);
        B_V.setOnClickListener(this);
        B_W.setOnClickListener(this);
        B_X.setOnClickListener(this);
        B_Y.setOnClickListener(this);
        B_Z.setOnClickListener(this);

        Button B_Bck = findViewById(R.id.button_Retour);
        Button B_Enter = findViewById(R.id.button_Enter);
        B_Bck.setOnClickListener(this);
        B_Enter.setOnClickListener(this);

    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    private void deleteinterface(){

        TableLayout tableLayout =findViewById(R.id.montableau);

        int count = tableLayout.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = tableLayout.getChildAt(i);
            if (child instanceof TableRow) ((ViewGroup) child).removeAllViews();
        }




        for (int idbutton: tableauDesTouchesChangees) {
            //System.out.println(idbutton);
            Button button = findViewById(idbutton);
            button.setBackgroundTintList(this.getResources().getColorStateList(R.color.black));
           // button.setEnabled(true);
            button.setAlpha(01.00F);

        }


        tableauDesTouchesChangees.removeAll(tableauDesTouchesChangees);
        initVarible();
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        String lettreAppuyer;

        switch (v.getId()){
            case R.id.button_A:
                lettreAppuyer = "A";break;
            case R.id.button_B:
                lettreAppuyer = "B";break;
            case R.id.button_C:
                lettreAppuyer = "C";break;
            case R.id.button_D:
                lettreAppuyer = "D";break;
            case R.id.button_E:
                lettreAppuyer = "E";break;
            case R.id.button_F:
                lettreAppuyer = "F";break;
            case R.id.button_G:
                lettreAppuyer = "G";break;
            case R.id.button_H:
                lettreAppuyer = "H";break;
            case R.id.button_I:
                lettreAppuyer = "I";break;
            case R.id.button_J:
                lettreAppuyer = "J";break;
            case R.id.button_K:
                lettreAppuyer = "K";break;
            case R.id.button_L:
                lettreAppuyer = "L";break;
            case R.id.button_M:
                lettreAppuyer = "M";break;
            case R.id.button_N:
                lettreAppuyer = "N";break;
            case R.id.button_O:
                lettreAppuyer = "O";break;
            case R.id.button_P:
                lettreAppuyer = "P";break;
            case R.id.button_Q:
                lettreAppuyer = "Q";break;
            case R.id.button_R:
                lettreAppuyer = "R";break;
            case R.id.button_S:
                lettreAppuyer = "S";break;
            case R.id.button_T:
                lettreAppuyer = "T";break;
            case R.id.button_U:
                lettreAppuyer = "U";break;
            case R.id.button_V:
                lettreAppuyer = "V";break;
            case R.id.button_W:
                lettreAppuyer = "W";break;
            case R.id.button_X:
                lettreAppuyer = "X";break;
            case R.id.button_Y:
                lettreAppuyer = "Y";break;
            case R.id.button_Z:
                lettreAppuyer = "Z";break;
            case R.id.button_Retour:
                lettreAppuyer = "Bck";
                break;
            case R.id.button_Enter:
                lettreAppuyer = "Enter";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }


        if (lettreAppuyer.length()==1 && pcolonnePourLettre<nbLettre) {
            idAUpdate = 1+ pcolonnePourLettre*100 + lignePourLettre*10000;
            miseAJourTableau(lettreAppuyer, idAUpdate);
            pcolonnePourLettre += 1;
        }

        if (lettreAppuyer.equals("Bck") && pcolonnePourLettre > premierLettre ) {
            idAUpdate = 1+( pcolonnePourLettre - 1)*100 + lignePourLettre*10000;
            miseAJourTableau("_", idAUpdate);
            pcolonnePourLettre -= 1;
        }
        if (lettreAppuyer.equals("Enter")) {
            if (pcolonnePourLettre == nbLettre) {

                    verifmot();

            } else {
                Toast.makeText(this, "Mot incomplet", Toast.LENGTH_SHORT).show();

            }
        }



    }

    private void verifmot()  {

        //analyse du mot
        if (lignePourLettre == 0 && !updateEssaiok){
            MyDatabaseHelper db = new MyDatabaseHelper(this);
            serieEnCours = db.updateEssai(nbLettre,hardMode);
            updateEssaiok = true;
            db.close();

        }


        constructionMot(lignePourLettre);
        MyDatabaseHelper db = new MyDatabaseHelper(this);
      //  motOk = motexiste(motATester);
            motOk = db.motEstPresent(motATester);

        if (motOk == true) {
            lettreVerte.clear();
            lettreOrange.clear();
            if (motATester.equals(motATrouver)) {
                if (serieEnCours > -1) {
                    serieEnCours = serieEnCours + 1;
                }else {
                    serieEnCours = 0;
                }

                db.updateScore(nbLettre, lignePourLettre + 1, serieEnCours,hardMode);
                db.close();
                endGame("gagner");
            }else {
                modicationCouleur(motATester);
                if (hardMode) {
                    pcolonnePourLettre = 0;
                } else {
                    pcolonnePourLettre = 1;
                }

                lignePourLettre = lignePourLettre + 1;
                motATester = "";
            }
            if (lignePourLettre > 6) {
                if (serieEnCours > 0) {
                    serieEnCours = 0;
                } else {
                    serieEnCours = serieEnCours - 1;
                }

                db.updateSerie(nbLettre, serieEnCours,hardMode);
                db.close();
                endGame("perdue");
            }
        }else{
            Toast.makeText(this, "Ce mots n'éxiste pas", Toast.LENGTH_SHORT).show();

        }

    }



    private void modicationCouleur(String motATesterPourCouleur) {

        char[] listeLettreOk = motATrouver.toCharArray();
        char[] listeLettreATester = motATesterPourCouleur.toCharArray();

        ArrayList<Character> arrayListLettreATRouver = new ArrayList<>();
        ArrayList<Character> arrayListLettreATesTer = new ArrayList<>();

        for (char c: listeLettreOk){
            arrayListLettreATRouver.add(c);
        }
       int i = 0;
        for (char d: listeLettreATester) {
            arrayListLettreATesTer.add(d);


            if (arrayListLettreATRouver.get(i) == arrayListLettreATesTer.get(i)) {
                changeCouleur(d, "Vert", i);


            }
            i = i + 1;
        }
        i = 0;
        for (char d: listeLettreATester) {
            if (arrayListLettreATRouver.contains(d) && arrayListLettreATRouver.get(i) != arrayListLettreATesTer.get(i)) {

                changeCouleur(d, "Orange", i);

                // if (arrayListLettreATRouver.indexOf(d) == i){

            }
            i = i + 1;
        }
        i = 0;
        for (char d: listeLettreATester) {
            if (!lettreVerte.contains(d) && !lettreOrange.contains(d)){
                    changeCouleur(d , "Black",i);

                }

            }
        }



    @SuppressLint("UseCompatLoadingForColorStateLists")
    private void changeCouleur(char c, String color, int positioncolonne) {

        int idTableauAchanger ;
        Context context = this;
        idTableauAchanger = 1 + positioncolonne * 100 + lignePourLettre * 10000;
        String quelButton = "button_" +c;
        int quelButtonId = getResources().getIdentifier(quelButton, "id", context.getPackageName());
        TextView textView = findViewById(idTableauAchanger);
        Button button = findViewById(quelButtonId);
        tableauDesTouchesChangees.add(quelButtonId);


            if (color.equals("Orange")){

                //modifier claiver en orange

                nb = 0;

                if (lettreOrange.contains(c) || lettreVerte.contains(c)){
                    nb =  Collections.frequency(lettreOrange,c) +  Collections.frequency(lettreVerte,c);
                    int occurance = countOccurrences(motATrouver,c) ;
                    if (nb < occurance){
                        lettreOrange.add(c);
                        textView.setBackgroundColor(ContextCompat.getColor(context, R.color.orange));
                       if (!lettreVerte.contains(c)) {
                           button.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange));
                       }
                    }

                  //  System.out.println(c + " est en orange et le nombre est " + nb);
                }else{
                    textView.setBackgroundColor(ContextCompat.getColor(context, R.color.orange));
                    lettreOrange.add(c);
                   // System.out.println(c + " est en orange et la lettre est  " + lettreOrange.get(lettreOrange.indexOf(c)));
                    button.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange));
                }

               // System.out.println(c + " est en orange et l'id et " + quelButtonId);

            }
            if (color.equals("Vert")){

                textView.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
                button.setBackgroundTintList(this.getResources().getColorStateList(R.color.green));
                lettreVerte.add(c);
               // System.out.println(c + "est en vert et l'id et " + quelButtonId);
                //modifier claiver en Vert

            }


        if (color.equals("Black")){

            //button.setEnabled(false);
            button.setAlpha(0.25F);
           // System.out.println(c + "n'est pas contenue et l'id et " + quelButtonId);


        }

    }

    private void constructionMot(int quelleLigne) {
        motATester = "";
        for (int j = 0; j < nbLettre; j++) {
            idARecup = 1 + j *100+ quelleLigne *10000;
            TextView textView_analyse = findViewById(idARecup);
            String valeur = textView_analyse.getText().toString();
            motATester = motATester + valeur;



        }


    }

    private void endGame(String resultat) {

        if (resultat.equals("perdue")){
            updateEssaiok = false;
            Toast.makeText(this, "Perdu !! le mot était: " + motATrouver, Toast.LENGTH_LONG).show();
            if (modeJeu.contains("mots")){
                deleteinterface();
                generateNblettre();
                lanceLeJeu();

            }
            if  (modeJeu.contains("Training")) {
                deleteinterface();
                lanceLeJeu();
            }
            if  (modeJeu.contains("Daily")){
                //perdu + blocage
            }
        }
        if (resultat.equals("gagner")){
            updateEssaiok = false;

            if (modeJeu.contains("mots")){

                if (nombreDeMotEnCours < nombreDeMotsATrouver ){

                    if (nombreDeMotsATrouver == 5){
                        quelleEtoile = "e_"+ nombreDeMotEnCours;

                    }
                    if (nombreDeMotsATrouver == 10){
                        quelleEtoile = "e_10_"+ nombreDeMotEnCours;
                    }

                    nombreDeMotEnCours = nombreDeMotEnCours +1;
                   // int quelleEtoileId = getResources().getIdentifier("wourdlle:drawable/" + quelleEtoile, null, null);
                    Resources res = getResources();
                    int resourceId = res.getIdentifier(
                            quelleEtoile, "drawable", getPackageName() );
                    etoiles.setImageResource( resourceId );
                    System.out.println("l'étoile a changer est : "+ quelleEtoile + " et son id est  : "+ resourceId);
                    //etoiles.setImageResource(quelleEtoileId);

                    deleteinterface();
                    generateNblettre();
                    lanceLeJeu();


                }else {
                    finModeMots();

                }

            }else if (modeJeu.contains("Daily")){
                finModeDaily();


            }else if (modeJeu.contains("Training")){
                deleteinterface();
                lanceLeJeu();
            }


        }


    }

    private int generateNblettre() {

        if (nombreDeMotEnCours == 1){
            chronometer2 = findViewById(R.id.chronometer2);
            chronometer2.start();
        }
        System.out.println("le nombre de mots encours est  " + nombreDeMotEnCours);
        List<Integer> listNbLettre = Arrays.asList(4,4,4,4,4,4,12,12,12,11,11,11,10,10,10,10,9,9,9,9,9,9,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,8);
        Collections.shuffle(listNbLettre);
        Random rand = new Random();
        int randomIndex = rand.nextInt(listNbLettre.size());
        nbLettre = listNbLettre.get(randomIndex);
        return nbLettre;

    }

    private void finModeMots() {
        //update des score mot avec temps
        chronometer2.stop();

        String chronoText = chronometer2.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");

        try {
            Date date = dateFormat.parse(chronoText);
           temps = dateFormat.format(date);


        } catch (ParseException e) {
        }
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        db.updateScoreMots(nombreDeMotsATrouver,hardMode,temps);
        db.close();

        Toast.makeText(this, "Bravo tu as gagné  en  "+temps+ "!!", Toast.LENGTH_SHORT).show();
        finish();
    }


    private void finModeDaily() {
        // update score daily avec temps
        // verrouiller le jeux a une fois  - peut etre avec date de realisation dans la bdd
        finish();
    }

    private void miseAJourTableau(String lettre,int idAUpdate) {



        TextView textViewAMettreAJour = findViewById(idAUpdate);
        textViewAMettreAJour.setText(lettre);


    }


    public void updateNombreSerie(){

        MyDatabaseHelper db = new MyDatabaseHelper(this);
        db.updateSerie(nbLettre, serieEnCours,hardMode);
        db.close();
    }
    @Override
    public void onBackPressed() {
        // Here you want to show the user a dialog box
        Context context = this;
        new AlertDialog.Builder(context)
                .setTitle("Retour au menu")
                .setMessage("Es tu sur ??")
                .setPositiveButton("Oui", (dialog, whichButton) -> {
                    // The user wants to leave - so dismiss the dialog and exit
                    if (lignePourLettre == 0 && !updateEssaiok){

                       updateNombreSerie();

                    }
                    finish();
                    dialog.dismiss();
                }).setNegativeButton("Non", (dialog, whichButton) -> {
                    // The user is not sure, so you can exit or just stay
                    dialog.dismiss();
                }).show();

    }

    public static int countOccurrences(String mot, char lettre)
    {
        int count = 0;
        for (int i=0; i < mot.length(); i++)
        {
            if (mot.charAt(i) == lettre)
            {
                count++;
            }
        }
        return count;
    }
}