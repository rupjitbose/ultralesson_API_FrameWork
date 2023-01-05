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

}
