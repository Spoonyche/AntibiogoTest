package com.axel.antibiogointerview;
import com.axel.antibiogointerview.viewmodel.MyViewModel;

import org.junit.Test;

import static org.junit.Assert.*;
public class MyViewModelTest {
    private MyViewModel vm = new MyViewModel();
    @Test
    public void test_string_validaion() {
        vm.setPhrase("aa");
        //should not be working
        assertNotEquals(true,vm.isPhraseValid());

        vm.setPhrase(null);
        assertNotEquals(true,vm.isPhraseValid());

        vm.setPhrase("111A");
        assertNotEquals(true,vm.isPhraseValid());

        vm.setPhrase(" A111A");
        assertNotEquals(true,vm.isPhraseValid());

        vm.setPhrase("@A111A");
        assertNotEquals(true,vm.isPhraseValid());

        vm.setPhrase("Bien");
        assertEquals(true,vm.isPhraseValid());



    }

    @Test
    public void test_setter_phrase(){
        assertEquals(vm.getPhrase(),"");
        vm.setPhrase("test1");
        assertEquals(vm.getPhrase(),"test1");
        vm.setPhrase(null);
        assertNotEquals(vm.getPhrase(),null);
        assertEquals(vm.getPhrase(),"test1");
    }

    public void test_setter_angle(){
        assertEquals(vm.getAngle(),0);

        vm.setAngle(20);
        assertEquals(vm.getAngle(),20);

        vm.setAngle(380);
        assertEquals(vm.getAngle(),20);

    }
}
