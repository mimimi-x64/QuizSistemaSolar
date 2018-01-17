package com.example.android.quizsistemasolar;

import android.content.Intent;
import android.net.Uri;
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

    private int score;
    private String userAnswer;

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
        RadioButton answer1Ask1 = findViewById(R.id.answer1Ask1);
        boolean bAnswer1Ask1 = answer1Ask1.isChecked( );
        RadioButton answer2Ask1 = findViewById(R.id.answer2Ask1);
        boolean bAnswer2Ask1 = answer2Ask1.isChecked( );
        RadioButton answer3Ask1 = findViewById(R.id.answer3Ask1);
        boolean bAnswer3Ask1 = answer3Ask1.isChecked( );

        if (bAnswer1Ask1) score += 1;
        if (bAnswer2Ask1) score -= 1;
        if (bAnswer3Ask1) score -= 1;

        //Answer for Question 4
        RadioButton answer1Ask4 = findViewById(R.id.answer1Ask4);
        boolean bAnswer1Ask4 = answer1Ask4.isChecked( );
        RadioButton answer2Ask4 = findViewById(R.id.answer2Ask4);
        boolean bAnswer2Ask4 = answer2Ask4.isChecked( );
        RadioButton answer3Ask4 = findViewById(R.id.answer3Ask4);
        boolean bAnswer3Ask4 = answer3Ask4.isChecked( );

        if (bAnswer1Ask4) score += 1;
        if (bAnswer2Ask4) score -= 1;
        if (bAnswer3Ask4) score -= 1;

        //Answer for Question 5
        RadioButton answer1Ask5 = findViewById(R.id.answer1Ask5);
        boolean bAnswer1Ask5 = answer1Ask5.isChecked( );
        RadioButton answer2Ask5 = findViewById(R.id.answer2Ask5);
        boolean bAnswer2Ask5 = answer2Ask5.isChecked( );

        if (bAnswer1Ask5) score += 1;
        if (bAnswer2Ask5) score -= 1;

        //Answer for Question 6
        RadioButton answer1Ask6 = findViewById(R.id.answer1Ask6);
        boolean bAnswer1Ask6 = answer1Ask6.isChecked( );
        RadioButton answer2Ask6 = findViewById(R.id.answer2Ask6);
        boolean bAnswer2Ask6 = answer2Ask6.isChecked( );

        if (bAnswer1Ask6) score += 1;
        if (bAnswer2Ask6) score += 1;
    }

    /**
     * CheckBox Question 2
     */
    public void askCheckBox() {
        CheckBox checkAnswer1 = findViewById(R.id.answer1Ask2);
        CheckBox checkAnswer2 = findViewById(R.id.answer2Ask2);
        CheckBox checkAnswer3 = findViewById(R.id.answer3Ask2);

        boolean checked1 = checkAnswer1.isChecked( );
        boolean checked2 = checkAnswer2.isChecked( );
        boolean checked3 = checkAnswer3.isChecked( );

        if (checked2 && checked3) score += 1;
        if (checked1) score -= 1;
    }

    /**
     * EditBox Question 3
     */
    public void askEditBox() {
        EditText answer = findViewById(R.id.answer1Ask3);
        userAnswer = String.valueOf(answer.getText( ));
            if (userAnswer.equalsIgnoreCase("Láctea") || userAnswer.equalsIgnoreCase("Via Láctea") || userAnswer.equalsIgnoreCase("Via Lactea") || userAnswer.equalsIgnoreCase("Lactea")) score += 1;
            else if (userAnswer.equalsIgnoreCase("")) score += 0;
            else score -= 1;
        }


    public void rate( View view ) {
        // Call and Calc score
        askEditBox( );
        askCheckBox( );
        askRadioButton( );
        // Toast.makeText(this, String.valueOf(score), Toast.LENGTH_SHORT).show( );

        if (score >= 5)
            Toast.makeText(this, getString(R.string.maxScore), Toast.LENGTH_SHORT).show( );
        else if (score == 4)
            Toast.makeText(this, getString(R.string.scoreEquals4), Toast.LENGTH_SHORT).show( );
        else if (score == 3)
            Toast.makeText(this, getString(R.string.scoreEquals3), Toast.LENGTH_SHORT).show( );
        else if (score == 2)
            Toast.makeText(this, getString(R.string.scoreEquals2), Toast.LENGTH_SHORT).show( );
        else if (score == 1)
            Toast.makeText(this, getString(R.string.scoreEquals1), Toast.LENGTH_SHORT).show( );
        else
            Toast.makeText(this, getString(R.string.minScore), Toast.LENGTH_SHORT).show( );
        //Retuns to 0 score value
        score = 0;
    }

    public void noCreator( View view ) {
        Toast.makeText(this, (getString(R.string.noCreator)), Toast.LENGTH_SHORT).show( );

        Uri webpage = Uri.parse("https://www.jw.org/pt/publicacoes/livros/vida-teve-criador/");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager( )) != null) {
            startActivity(intent);
        }
    }
}