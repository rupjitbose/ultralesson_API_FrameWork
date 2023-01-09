package users.create;
import lombok.Getter;
import java.util.UUID;

@Getter
public class CreateUsersReqBody {
    private String name;
    private String gender;
    private String email;
    private String status;

    public CreateUsersReqBody(Builder builder) {
        this.name=builder.name;
        this.email=builder.email;
        this.gender=builder.gender;
        this.status=builder.status;
    }


    public static class Builder{
        private String name;
        private String gender;
        private String email;
        private String status;

       public Builder(){
           this.name="rupjit";
           this.email= UUID.randomUUID() + "@gmail.com";
           this.gender="male";
           this.status="active";
       }

       public Builder gender(String gender){
           this.gender=gender;
           return this;
       }

        public Builder email(String email){
            this.email=email;
            return this;
        }
        public Builder status(String status){
            this.status=status;
            return this;
        }

       public CreateUsersReqBody build(){
           CreateUsersReqBody createUsersReqBody = new CreateUsersReqBody(this);
           return createUsersReqBody;

       }


    }

}
