package Day16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pointer {

    Integer value;

    public void increase(int inc){
        value = value + inc;
    }
}
