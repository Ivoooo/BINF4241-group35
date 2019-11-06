public class ChessPieceIterator implements Iterator{
    Figure[][] pieces;
    int position =0;

    public ChessPieceIterator(Figure[][] pieces){
        this.pieces = pieces;
    }
    public Object next(){
        int tmp = position/8;
        Figure piece = pieces[tmp][position%8];
        position = position +1;
        return piece;
    }
    public boolean hasNext() {
        if(position >= pieces.length || pieces[position] == null){
            return false;
        }else{
            return true;
        }
    }

}
