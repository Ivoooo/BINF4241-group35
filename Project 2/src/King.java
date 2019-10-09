public class King extends Figur {
    private types type = types.king;
    private colors color;
    public class colorcheck(color) {
        if(color == 'white'){
            color = colors.white;
        }
        else{ color = colors.black;
        }
    }
}
