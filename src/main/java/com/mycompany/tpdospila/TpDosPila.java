/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tpdospila;

/**
 *
 * @author martin
 */
public class TpDosPila {
    /*
    Manejo de Errores
    */
    class RepException extends Exception{
    
    public RepException(String mensaje){
        super(mensaje);
        }
    }
    
    /*
    1- Creamos una clase Nodo y declaramos una variable typo int "info" 
    para los datos del nodo y otra del Tipo Nodo para el puntero.    
    */  
    
    class Nodo {
        int info;
        Nodo sig;
    }
    
    /*
    2- Declaramos un variable typo Nodo "raiz" como primer nodo de 
    referencia que apunta a null si la lista esta vacia y en caso 
    contrario accede a el siguiente nodo. 
    */
    
    private Nodo raiz;
    
    public TpDosPila () {
        raiz = null;
    }
    
    /*
    3- Declaramos una variable puntero tipo Nodo "nuevo" y 
    creamos una instancia del objeto Nodo dentro agregando el valor del
    parametro dentro del key "info".
    Checkeamos si la pila esta vacia, si es true apuntamos el puntero de 
    "nuevo" a null y agreamos el nodo nuevo a la raiz conviertiendoce 
    este en el primer nodo.
    Si es false el puntero "nuevo" apunta a raiz (anterior nodo) y agregamos a 
    raiz el nuevo nodo.
    */
    
    public void apilar(int x) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = x;
        if (raiz == null)
        {
            nuevo.sig = null;
            raiz = nuevo;
        }
        else
        {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }
    
    /*
    4- Si la Pila no está vacía guardamos la info en la variable 
    "nodoDesapilado", corremos raiz al siguiente nodo de la pila y el nodo 
    anterior es borrado al no tener referencia y retornamos la información
    del nodo borrado".
    En el caso de que la pila está vacía retornamos -1
    */
    
    public int desapilar (){
        if (raiz != null) {
            int nodoDesapilado = raiz.info;
            raiz = raiz.sig;
            return nodoDesapilado;            
        } else {
            System.out.println("Pila Vacia, no hay elementos para desapilar");
            return -1;
        }
    }
    
    /*
    5- 
    
    */    
    public void verContenido() {
        String mensaje = "La Pila está vacía, no hay elementos que mostar!\n";
        try {
            Nodo contenido = raiz;
            System.out.println("*** Contenido de la Pila ***");
            if (contenido == null) {
                throw new RepException("RepException: " + mensaje);
            } else {  
                do { 
                    System.out.println(contenido.info);
                    contenido = contenido.sig;
                } while (contenido != null);
            }
        }catch(RepException e) {
            System.out.println(e.getMessage());
        }
        
      
       
    }

    public static void main(String[] args) {
        TpDosPila pila1 = new TpDosPila();
        pila1.apilar(10);
        pila1.apilar(40);
        pila1.apilar(3);
        pila1.verContenido();
        System.out.println("Cima de la pila:" + pila1.desapilar());
        pila1.verContenido();        
    }
}
