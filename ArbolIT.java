/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package javaapplication29;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class ArbolIT {
     @Test
    public void test1(){
arbol nuevoarbol =new arbol();
ArrayList<String> textog = new ArrayList<>();
ArrayList<String> otro = new ArrayList<>();
textog.add("house");
textog.add("woman");
textog.add("car");
nuevoarbol.insertar(textog);
assertEquals(textog,nuevoarbol.root.key);
 
 




    }

}