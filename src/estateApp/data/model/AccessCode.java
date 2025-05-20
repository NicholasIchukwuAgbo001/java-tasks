package estateApp.data.model;

import java.time.LocalDateTime;

public class AccessCode {
    private String  id;
    private String  opt;
    private LocalDateTime optCreationDate = LocalDateTime.now();
    private LocalDateTime optExpiredDate;
    private Visitor visitor;
    private Resident resident;

}
