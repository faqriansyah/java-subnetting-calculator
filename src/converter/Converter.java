package converter;

import java.util.ArrayList;

public interface Converter {
    public void convert(String p, int target);
    public String getResult(int target);
    public ArrayList<String> getArgument();
}
