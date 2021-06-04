package com.axel.antibiogointerview.viewmodel;

import androidx.lifecycle.ViewModel;


public class MyViewModel extends ViewModel  {


        private String sentence;

        private int angle;

        public String getSentence() {
            return sentence;
        }

        public int getAngle() {
            return angle;
        }

        public void setSentence(String value) {

            if (value != null )
                sentence = value;
        }

        public void setAngle(int value) {

            angle=value;
        }

        public boolean isSentenceValid(){
            if(sentence.trim().length()==0)
                return false;
            return Character.isUpperCase(sentence.charAt(0));
        }

        public  MyViewModel(){
            this.sentence = "";
            this.angle=0;
        }

}
