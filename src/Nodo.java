import javax.swing.tree.DefaultMutableTreeNode;

public class Nodo extends DefaultMutableTreeNode {
    
    private boolean NIzquierdo;
    
    public Nodo (){
        
        this("");
    }
    
    public Nodo (String txt){
        
        super(txt);
        NIzquierdo = true; 
    }
    
    public void setNIzquierdo (boolean Niz){
        
        this.NIzquierdo = Niz;
    }
    
    public boolean getNIzquierdo (){
        
        return this.NIzquierdo;
    }
    
    public Nodo BuscarNodo (boolean Niz){
        
        Nodo nod;
        nod = null;
        
        for (int i = 0; i < getChildCount(); i++){
            
            nod = (Nodo)getChildAt(i);
            
            if (nod.getNIzquierdo() == Niz){
                break;
            }else{
                
                nod = null;
            }
        }
        
        return nod;
    }
    
    public Nodo HijoNizquierdo (){
        
        return BuscarNodo (true);
    }
    
    public Nodo HijoNderecho (){
        
        return BuscarNodo (false);
    }
    
    public boolean AñadirNIz (Nodo nod){
        
        if (HijoNizquierdo () == null){
            
            nod.setNIzquierdo(true);
            add (nod);
            return true;
        }else{
            
            return false;
        }
    }
    
    public boolean AñadirNder (Nodo nod){
        
        if (HijoNderecho () == null){
            
            nod.setNIzquierdo(false);
            add(nod);
            return true;
        }else {
            
            return false;
        }
    }
    
    public String getIndicador (){
        return getUserObject() + " ";
    }
    
    @Override
    public String toString (){
        
        String res = getIndicador();
        
        if (getParent () == null){
            
            return res;
            
        }else{
            if (NIzquierdo){
                return res + "(Iz)"; 
                        
            }else{
                return res + "(De)";
            }
        }
    }
    
}




