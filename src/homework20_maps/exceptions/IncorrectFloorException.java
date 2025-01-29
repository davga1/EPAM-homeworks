package homework20_maps.exceptions;
// Houses created with numberOfFloor parameter, and sometimes we can Try to add a House which is at 4th floor to a 3-floor building
public class IncorrectFloorException extends RuntimeException {
    public IncorrectFloorException(String message) {
        super(message);
    }
}
