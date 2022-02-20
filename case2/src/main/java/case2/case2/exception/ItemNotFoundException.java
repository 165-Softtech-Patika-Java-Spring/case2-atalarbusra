package case2.case2.exception;

import case2.case2.app.enums.AddErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(AddErrorMessage message) {
        super(message.getMessage());
    }
}
