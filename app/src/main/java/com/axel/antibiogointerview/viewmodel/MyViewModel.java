package com.axel.antibiogointerview.viewmodel;

import androidx.lifecycle.ViewModel;


public class MyViewModel extends ViewModel  {


        private String phrase;

        private int angle;

        public String getPhrase() {
            return phrase;
        }

        public int getAngle() {
            return angle;
        }

        public void setPhrase(String value) {
            if (value != null ) phrase = value;
        }
        public void setAngle(int value) {
            angle=value;
        }

        public boolean isPhraseValid(){
            if(phrase.trim().length()==0)
                return false;
            return Character.isUpperCase(phrase.charAt(0));
        }

        public  MyViewModel(){
            this.phrase = "";
            this.angle=0;
        }

}
