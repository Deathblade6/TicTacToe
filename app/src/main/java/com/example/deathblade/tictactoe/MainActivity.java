package com.example.deathblade.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int c=0;
    public int a[][]=new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                a[i][j]=0;
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void appear(View view){
        ImageView iv = findViewById((view).getId());
        TextView tv =findViewById(R.id.textView);
        int l=0,m=0;
        int ctr=0;
        int ans=0;
        int b=0;
        String[] z = {"a","b","c","d","e","f","g","h","i"};
        for (int i=0;i<9;i++){
            if (getResources().getResourceEntryName((view).getId()).equals(z[i])){
                b=i;
                Log.println(Log.DEBUG,"SC",""+b);
            }
        for (i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (b==ctr){
                    l=i;
                    m=j;
                    break;
                }
                ctr+=1;
            }
        }
        if (c%2==0){
            iv.setImageResource(R.drawable.o);
            c+=1;
            a[l][m]=1;
        }
        else {
            iv.setImageResource(R.drawable.x);
            c+=1;
            a[l][m]=2;
        }
        if ((l==1 || m==1) && l!=m){
            ans=check(l,m);
        }
        else{
            ans=check(l,m);
            if (ans==0)
                ans=checkd(l,m);
        }
        if (ans==0){}
        else if (ans==1){
            tv.setText("Player 1 has won");
        }
        else if (ans==2){
            tv.setText("Player 2 has won");
        }
    }}    public int checkd(int l, int m){
        int s1=0,s2=0;
        s1=a[0][0]+a[1][1]+a[2][2];
        s2=a[2][0]+a[1][1]+a[0][2];
        if (s1==3 || s2==3){
            return 1;
        }
        else if (s1==6 || s2==6){
            return 2;
        }
        else
            return 0;
    }
    public int check(int l, int m){
        int s1=0,s2=0;
        for (int i=0;i<3;i++){
            s1+=a[l][i];
            s2+=a[i][m];
        }
        if (s1==3 || s2==3){
            return 1;
        }
        else if (s1==6 || s2==6){
            return 2;
        }
        else
            return 0;
    }
}
