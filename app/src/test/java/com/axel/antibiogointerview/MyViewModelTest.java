package com.axel.antibiogointerview;
import com.axel.antibiogointerview.viewmodel.MyViewModel;

import org.junit.Test;

import static org.junit.Assert.*;
public class MyViewModelTest {
    private MyViewModel vm = new MyViewModel();

    @Test
    public void test_string_validaion() {
        vm.setSentence("aa");
        //should not be working
        assertNotEquals(true,vm.isSentenceValid());

        vm.setSentence(null);
        assertNotEquals(true,vm.isSentenceValid());

        vm.setSentence("111A");
        assertNotEquals(true,vm.isSentenceValid());

        vm.setSentence(" A111A");
        assertNotEquals(true,vm.isSentenceValid());

        vm.setSentence("@A111A");
        assertNotEquals(true,vm.isSentenceValid());

        vm.setSentence("Bien");
        assertEquals(true,vm.isSentenceValid());
    }

    @Test
    public void test_setter_phrase(){
        assertEquals(vm.getSentence(),"");
        vm.setSentence("test1");
        assertEquals(vm.getSentence(),"test1");
        vm.setSentence(null);
        assertNotEquals(vm.getSentence(),null);
        assertEquals(vm.getSentence(),"test1");
    }

    @Test
    public void test_setter_angle(){
        assertEquals(vm.getAngle(),0);

        vm.setAngle(20);
        assertEquals(vm.getAngle(),20);

        vm.setAngle(380);
        assertEquals(vm.getAngle(),20);

    }
}
