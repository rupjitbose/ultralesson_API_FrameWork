package users.create;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUsersReqBody {

    private String name;
    private String gender;
    private String email;
    private String status;
    public String getName() {
        return name;
    }

    public CreateUsersReqBody(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }
}
