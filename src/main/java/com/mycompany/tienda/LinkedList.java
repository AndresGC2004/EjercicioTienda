package com.mycompany.tienda;


import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sala4
 */
public class LinkedList<Item> implements Iterable <Item> {
    private Node first;
    private Node last;
    private int count;
    
    private class Node {
        Item item;
        Node next;
    }
    
    public LinkedList(){
        first=null;
        last=null;
        count=0;    
    }
    
    //insertar un dato en una poscion dada
    public void add(Item item, int pos){
        Node current=first;
        if (pos<=count+1) {
            Node newNode=new Node();
            newNode.item=item;
            if (pos==1) {
                newNode.next=first;
                first=newNode;
            }
            else{
                for (int i = 1; i < pos-1; i++) {
                    current=current.next;
                    newNode.next=current.next;
                    current.next=newNode;
                
                }
            }
            if(pos==count+1)
                last=newNode;
            count++;
        }
    }
    
    //insertar un dato al principio
    public void addFirst(Item item){
        add(item,1);
    }
    
    //insertar un dato al final
    public void addLast(Item item){
        add(item,count+1);
    }
    
    //remover el dato de una posicion dada
    public Item remove(int pos){
        Node current = first;
        Item item= null;
        if (pos<=count) {
            if(pos==1){
                item=first.item;
                first=first.next;
                
            }
            else{
                for (int i = 1; i < pos-1; i++) {
                    current=current.next;
                    item=current.next.item;
                    current.next=current.next.next;
                }
            }
            if (pos==count) {
                last=current;
                count--;
            }
        }
        return item;
    }
    
    //remover el primer dato
    public Item removeFirst(){
        return remove(1);
    }
    
    //remover el ultimo dato
    public Item removeLast(){
        return remove(count);
    }
    
    //conocer el tamaño de la lista 
    public int size(){
        return count;
    }
    
    //determinar si la lista esta vacia
    public boolean isEmpty(){
        return first==null;
    }
    
    //remover todos los elementos de la lista
    public void removeAll(){
        first=last=null;
        count=0;
    }
    
    //buscar un elemento en la lista
    public int contains(Item item){
        int pos=1;
        Node current;
        for (current=first;current!=null;current=current.next) {
            if(current.item.equals(item))
                return pos;
            pos++;
        }
        return -1;
    }
    
    //retornar el item de una posicion dada
    public Item get(int pos){
        Node current=first;
        if(pos>=1 && pos<=count){
            for (int i = 1; i < pos; i++){
                current=current.next;
                return current.item;
            }
        }
        return null;
    }
    
    //remover un dato o un item especificado
    public Item remove(Item item){
        int pos;
        pos=contains(item);
        if (pos!=-1) return remove(pos);
        return null;
    }
    
    //reemplaza el item de una posiion dada
    public Item set(Item item, int pos){
        Node current=first;
        Item temp;
        if(pos>=1 && pos<=count){
            for(int i=1;i<pos;i++)
                current=current.next;
            temp=current.item;
            current.item=item;
            return temp;
        }
        return null;
    }
    //convertir la lista en un arreglo
    public Item[] toArray(){
        Item array[]=(Item[])new Object[count];
        int pos=0;
        for (Node current=first; current!=null;current=current.next)
            array[pos++]=current.item;
        return array;
        
    }
    
    
    @Override
    public Iterator<Item> iterator() {
        return new LLIterator();
    }
    private class LLIterator implements Iterator <Item>{
        private Node current=first;
        
        @Override
        public boolean hasNext(){
            return current !=null;
        }
        @Override
        public Item next(){
            Item item = current.item;
            current=current.next;
            return item;
        }
    }
    
}
