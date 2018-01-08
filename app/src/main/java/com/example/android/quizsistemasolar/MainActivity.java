package com.example.android.quizsistemasolar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double score = 0;
    String userAnswer;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Radio Questions 1, 4, 5 and 6
     */
    public void askRadioButton() {

        //Answer for Question 1
        RadioButton answer1_ask1 = findViewById(R.id.answer1_ask1);
        boolean banswer1_ask1 = answer1_ask1.isChecked( );
        RadioButton answer2_ask1 = findViewById(R.id.answer2_ask1);
        boolean banswer2_ask1 = answer2_ask1.isChecked( );
        RadioButton answer3_ask1 = findViewById(R.id.answer3_ask1);
        boolean banswer3_ask1 = answer3_ask1.isChecked( );

        if (banswer1_ask1) score += 1;
        if (banswer2_ask1) score -= 1;
        if (banswer3_ask1) score -= 1;

        //Answer for Question 4
        RadioButton answer1_ask4 = findViewById(R.id.answer1_ask4);
        boolean banswer1_ask4 = answer1_ask4.isChecked( );
        RadioButton answer2_ask4 = findViewById(R.id.answer2_ask4);
        boolean banswer2_ask4 = answer2_ask4.isChecked( );
        RadioButton answer3_ask4 = findViewById(R.id.answer3_ask4);
        boolean banswer3_ask4 = answer3_ask4.isChecked( );

        if (banswer1_ask4) score += 1;
        if (banswer2_ask4) score -= 1;
        if (banswer3_ask4) score -= 1;

        //Answer for Question 5
        RadioButton answer1_ask5 = findViewById(R.id.answer1_ask5);
        boolean banswer1_ask5 = answer1_ask5.isChecked( );
        RadioButton answer2_ask5 = findViewById(R.id.answer2_ask5);
        boolean banswer2_ask5 = answer2_ask5.isChecked( );

        if (banswer1_ask5) score += 1;
        if (banswer2_ask5) score -= 1;

        //Answer for Question 6
        RadioButton answer1_ask6 = findViewById(R.id.answer1_ask6);
        boolean banswer1_ask6 = answer1_ask6.isChecked( );
        RadioButton answer2_ask6 = findViewById(R.id.answer2_ask6);
        boolean banswer2_ask6 = answer2_ask6.isChecked( );


        if (banswer1_ask6) score += 1;
        if (banswer2_ask6) score -= 1;

    }

    /**
     * CheckBox Question 2
     */
    public void askCheckBox() {
        CheckBox checkAnswer1 = findViewById(R.id.answer1_ask2);
        CheckBox checkAnswer2 = findViewById(R.id.answer2_ask2);
        CheckBox checkAnswer3 = findViewById(R.id.answer3_ask2);

        boolean checked1 = checkAnswer1.isChecked( );
        boolean checked2 = checkAnswer2.isChecked( );
        boolean checked3 = checkAnswer3.isChecked( );

        if (checked1) score -= 1;
        if (checked2) score += 0.5;
        if (checked3) score += 0.5;

    }

    /**
     * EditBox Question 3
     */
    public void askEditBox() {
        EditText answer = findViewById(R.id.answer1_ask3);
        userAnswer = String.valueOf(answer.getText( ));

        if (userAnswer.equals("Láctea")) {
            score += 1;

        } else if (userAnswer.equals("Via Láctea")) {
            score += 1;

        } else {
            score -= 1;

        }

    }

    public void rate( View view ) {
        // Call and Calc score
        askEditBox( );
        askCheckBox( );
        askRadioButton( );

        if (score > 5.9)
            Toast.makeText(this, (getString(R.string.maxScore)), Toast.LENGTH_SHORT).show( );
        else Toast.makeText(this, (getString(R.string.minScore)), Toast.LENGTH_SHORT).show( );

        //Retuns to 0 score value
        score = 0;
    }

    public void noCreator( View view ) {
        Toast.makeText(this, (getString(R.string.noCreator)), Toast.LENGTH_SHORT).show( );
    }


}

    /**
     *
     *
     * Aqui estão algumas tentativas que eu fiz e não consegui terminar. Não sei por que não deu certo.
     * Se você puder em explicar melhor eu agradeceria muito! hartmnn.p@gmail.com
    * */

/*
    // Primeira Tentativa com base na Documentação Android RadioButton
    // https://developer.android.com/guide/topics/ui/controls/radiobutton.html

    double rating = 0;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void askRadioButton(View view){
        //is checked?
        boolean checked = ((RadioButton)view).isChecked();

        //Do it now!!!!
        switch (view.getId()){

            case R.id.answer1_ask1:
                if (checked) {
                    rating += 1;
                    break;
                }
            case R.id.answer1_ask2:
                if (checked) rating -= 1;
                break;

            case R.id.answer2_ask2:
                if (checked) rating += 0.5;
                break;

            case R.id.answer3_ask2:
                if (checked) rating += 0.5;
                break;

            case R.id.answer1_ask4:
                if (checked) {
                    rating += 1;
                    break;
                }
            case R.id.answer2_ask4:
                if (checked) {
                    rating -= 1;
                    break;
                }
            case R.id.answer3_ask4:
                if (checked) {
                    rating -= 1;
                    break;
                }
            case R.id.answer1_ask5:
                if(checked){
                    rating += 1;
                }
            case R.id.answer2_ask5:
                if (checked) {
                    rating -= 1;
                }
        }
    }

    public void rate( View view ) {
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);

        askRadioButton(radioButton);

        Toast.makeText(this, "Teste pontuação " + rating ), Toast.LENGTH_SHORT).show();
        rating = 0;
    }
}

*/
