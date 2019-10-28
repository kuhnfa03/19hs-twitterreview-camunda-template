package ch.zhaw.gpi.twitterreview;

import java.util.Optional;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * GetUserInformationDelegate
 */
@Named("getUserInformationAdapter")
public class GetUserInformationDelegate implements JavaDelegate {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String userName = (String) execution.getVariable("anfrageStellenderBenutzer");

        Optional<UserEntity> user = userRepository.findById(userName);

        String fullName;
        if(user.isPresent()){
            fullName = user.get().getFirstName() + " " + user.get().getOfficialName();
        } else {
            fullName = "Mr. X";
        }

        execution.setVariable("fullName", fullName);
    }

    
}