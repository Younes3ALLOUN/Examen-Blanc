package commands.owner;

import commands.BaseCommand;
import lombok.Getter;

import java.util.Date;

@Getter
public class OwnerUpdateCommand extends BaseCommand<String> {
    private String name;
    private Date dat_naissance;
    private String email;

    public OwnerUpdateCommand(String id, String name, Date datNaissance, String email) {
        super(id);
        this.name = name;
        this.dat_naissance = datNaissance;
        this.email = email;
    }
}
