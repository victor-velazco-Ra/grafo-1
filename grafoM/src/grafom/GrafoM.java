
package grafom;

import java.util.ArrayList;
import java.util.Scanner;

class Arista{
    String nombre;
String inicio;
String fin;
Arista(String n, String i, String f ){
this.nombre=n;
this.inicio=i;
this.fin=f;
}
}
class nodo{
nodo dir_actual;
nodo arriba;
nodo abajo;
nodo derecho;
nodo izquierdo;
String nombre;
nodo(nodo actual,String n, nodo arriba, nodo abajo, nodo izquierda,nodo derecha){
this.nombre=n;
this.dir_actual=actual;
this.arriba=arriba;
this.abajo=abajo;
this.derecho=derecha;
this.izquierdo=izquierda;
}
}
public class GrafoM {
static ArrayList <nodo> listanodos=new ArrayList();
static ArrayList <Arista> listaaristas=new ArrayList();
static Scanner leer=new Scanner(System.in);
void insertarNodos(){
for (int i = 0; i <5; i++) {
nodo nuevo=new nodo(null," ",null,null,null,null);
nuevo.dir_actual=nuevo;
System.out.println("Nombre del Nodo: "+i);
nuevo.nombre=leer.next();
nuevo.arriba=null;
nuevo.abajo=null;
nuevo.derecho=null;
nuevo.izquierdo=null;
listanodos.add(new nodo(nuevo.dir_actual,nuevo.nombre,nuevo.arriba,nuevo.abajo,nuevo.izquierdo,nuevo.derecho));
}//for
}//insertar nodo
void mostrarnodos(){
System.out.println("MOSTRAR NODOS");
for (int i=0;i<listanodos.size();i++){
System.out.println("Nombre: "+listanodos.get(i).nombre);
}
}
nodo nodo1;
void InsertarArista() {
String inicio,fin,nom;
//nodo del centro
nodo1=listanodos.get(0).dir_actual;
//ENLAZAR CON nodo arriba
nodo1.arriba=listanodos.get(1).dir_actual;
listanodos.get(1).dir_actual.abajo=nodo1.dir_actual;
//ENLAZAR CON nodo abajo
nodo1.abajo=listanodos.get(2).dir_actual;
listanodos.get(2).dir_actual.arriba=nodo1.dir_actual;
//ENLAZAR CON nodo izquierdo
nodo1.izquierdo=listanodos.get(3).dir_actual;
listanodos.get(3).dir_actual.derecho=nodo1.dir_actual;
//ENLAZAR CON NODO DERECHO
nodo1.derecho=listanodos.get(4).dir_actual;
listanodos.get(4).dir_actual.izquierdo=nodo1.dir_actual;

//arista 1 arriba
nom=nodo1.nombre+"-"+nodo1.arriba.nombre;
inicio=nodo1.nombre;
fin=nodo1.arriba.nombre;
listaaristas.add(new Arista(nom,inicio,fin));
//arista 2 arriba
nom=nodo1.arriba.nombre+"-"+nodo1.nombre;
inicio=nodo1.arriba.nombre;
fin=nodo1.nombre;
listaaristas.add(new Arista(nom,inicio,fin));

//arista 3 abajo
nom=nodo1.nombre+"-"+nodo1.abajo.nombre;
inicio=nodo1.nombre;
fin=nodo1.abajo.nombre;
listaaristas.add(new Arista(nom,inicio,fin));

//arista 4 izquierdo
nom=nodo1.nombre+"-"+nodo1.izquierdo.nombre;
inicio=nodo1.nombre;
fin=nodo1.izquierdo.nombre;
listaaristas.add(new Arista(nom,inicio,fin));

//arista 5 derecho
nom=nodo1.nombre+"-"+nodo1.derecho.nombre;
inicio=nodo1.nombre;
fin=nodo1.derecho.nombre;
listaaristas.add(new Arista(nom,inicio,fin));
}// void aristas
void mostrarAristas(){
for (int i = 0; i < listaaristas.size(); i++) {
System.out.println("Arista "+(i+1)+" "+listaaristas.get(i).nombre);
System.out.println("Inicio "+listaaristas.get(i).inicio);
System.out.println("fin "+listaaristas.get(i).fin);
System.out.println(" ");
}


}//mostrarAristas
void mostrarGrafo(){
System.out.println(" [ "+nodo1.arriba.nombre+" ]");
System.out.println("[ "+nodo1.izquierdo.nombre+" ] ["+nodo1.nombre+"] ["+nodo1.derecho.nombre+"]");
System.out.println(" ["+nodo1.abajo.nombre+"]");
}
    
    public static void main(String[] args) {
        GrafoM objeto=new GrafoM();
        int opcion=0;
Scanner leer=new Scanner(System.in);
do{
System.out.println("1.-Insertar nodos ");
System.out.println("2.-Mostrar Nodos");
System.out.println("3.-Insertar aristas ");
System.out.println("4.-Mostrar aristas");
System.out.println("5.-Mostrar Grafo");
System.out.println("6.-Salir");
opcion=leer.nextInt();
switch(opcion){
case 1:objeto.insertarNodos();break;
case 2:objeto.mostrarnodos();break;
case 3:objeto.InsertarArista();break;
case 4:objeto.mostrarAristas();break;
case 5:objeto.mostrarGrafo();break;
}
}while(opcion!=5);
}
}
    

